﻿using System;
using System.Configuration;
using System.IO;
using Common.Logging;
using Thrift.Protocol;
using Thrift.Transport;

namespace Worldpay.Innovation.WPWithin.AgentManager
{
    /// <summary>
    ///     Manages the configuration of an Thrift RPC Agent.
    /// </summary>
    /// <remarks>
    ///     <para>
    ///         The Thrift RPC Agent manages the communication between producers and consumers.  If the WPWithin SDK is used to
    ///         create separate producers and consumers
    ///         then the communication path is: <code>Consumer -> RPC Agent -> network -> RPC Agent -> Producer</code>.
    ///     </para>
    ///     <para>
    ///         Parameters have hard-coded defaults in this class and these defaults can be overridden in application settings
    ///         (typically in app.config or web.config files), or
    ///         set directly on an instance of this class before passing to
    ///         <see cref="RpcAgentManager.StartThriftRpcAgentProcess()" />.
    ///     </para>
    /// </remarks>
    /// <seealso cref="RpcAgentManager" />
    public class RpcAgentConfiguration
    {
        private static readonly ILog Log = LogManager.GetLogger<RpcAgentConfiguration>();

        /// <summary>
        ///     The application config property name for the full file path to the Thrift RPC Agent.
        /// </summary>
        public static readonly string PathPropertyName = "ThriftRpcAgent.Path";

        /// <summary>
        ///     The application config property name for the host name to bind the Thrift RPC Agent to.
        /// </summary>
        public static readonly string HostProperty = "ThriftRpcAgent.Host";

        /// <summary>
        ///     The default value for the full file path to the Thrift RPC Agent.
        /// </summary>
        public static readonly string HostPropertyDefault = "127.0.0.1";

        /// <summary>
        ///     The application config property name for the port to launch the Thrift RPC Agent on.
        /// </summary>
        public static readonly string PortProperty = "ThriftRpcAgent.Port";

        /// <summary>
        ///     The default value for the port to launch the Thrift RPC Agent on.
        /// </summary>
        public static readonly int PortPropertyDefault = 9091;

        /// <summary>
        ///     The application config property name for the Thrift protocol to use to connect to the Thrift RPC Agent.
        /// </summary>
        public static readonly string ProtocolProperty = "ThriftRpcAgent.Protocol";

        /// <summary>
        ///     The application config property name for specifying the port to listen to callback on (if not set or 0 then
        ///     callbacks are disabled).
        /// </summary>
        public static readonly string CallbackPortProperty = "ThriftRpcAgent.CallbackPort";

        /// <summary>
        ///     The default value for the protocol to use to connect to the Thrift RPC Agent.
        /// </summary>
        public static readonly string ProtocolPropertyDefault = "binary";

        /// <summary>
        ///     The default value for the callback port to use by the Thrift RPC Agent.  Default value of 0 indicates that
        ///     callbacks are disabled.
        /// </summary>
        public static readonly int CallbackPortPropertyDefault = 0;

        private string _rpcAgentPath;
        /// <summary>
        /// Stores override for service host.
        /// </summary>
        private string _serviceHost;

        private int? _servicePort;

        /// <summary>
        ///     Retrieves the RPC Agent host property from application config or provides default value.
        /// </summary>
        public string ServiceHost
        {
            get
            {
                return _serviceHost ?? ConfigurationManager.AppSettings[HostProperty] ?? HostPropertyDefault;
            }
            set { _serviceHost = value; }
        }

        /// <summary>
        ///     Retrieves the RPC Agent protocol property from application config or provides default value.
        /// </summary>
        public string Protocol
            => ConfigurationManager.AppSettings[ProtocolProperty] ?? ProtocolPropertyDefault;

        /// <summary>
        ///     Retrieves the RPC Agent port property from application config or provides default value.
        /// </summary>
        public int ServicePort
        {
            get
            {
                if (_servicePort.HasValue)
                {
                    return _servicePort.Value;
                }
                string portString = ConfigurationManager.AppSettings[PortProperty];
                int port;
                if (portString == null || !int.TryParse(portString, out port))
                {
                    port = PortPropertyDefault;
                }
                return port;
            }
            set { _servicePort = value; }
        }

        private int? _callbackPort;

        /// <summary>
        ///     Specifying the port to listen to callback on (if null/not set then callbacks are disabled).  0 indicates no
        ///     callbacks required.
        /// </summary>
        public int CallbackPort
        {
            get
            {
                if (_callbackPort.HasValue)
                {
                    return _callbackPort.Value;
                }
                string portString = ConfigurationManager.AppSettings[CallbackPortProperty];
                int port;
                if (portString == null || !int.TryParse(portString, out port))
                {
                    return CallbackPortPropertyDefault;
                }
                return port;
            }
            set { _callbackPort = value; }
        }


        /// <summary>
        ///     Retrieves the property RPC Agent Path (<see cref="PathPropertyName" />) from the application configuration,
        ///     or attempts to work it out by searching up from the current directory, looking for
        ///     <code>applications/rpc-agent/rpc-agent.exe</code>.
        /// </summary>
        public string Path
        {
            get
            {
                if (_rpcAgentPath != null)
                {
                    return _rpcAgentPath;
                }
                string agentPath = ConfigurationManager.AppSettings[PathPropertyName];
                if (agentPath == null)
                {
                    DirectoryInfo parent = new DirectoryInfo(".");
                    Log.InfoFormat(
                        "No {0} property found in application configuration, searching for it relative to {1}",
                        PathPropertyName, parent.FullName);
                    const string sdkDir = "worldpay-within-sdk";
                    while (parent != null && !parent.Name.Equals(sdkDir))
                    {
                        parent = parent.Parent;
                    }
                    if (parent == null)
                    {
                        throw new Exception(
                            $"Unable to locate {sdkDir} override with property {PathPropertyName} property in App.config");
                    }
                    _rpcAgentPath =
                        new FileInfo(string.Join(System.IO.Path.DirectorySeparatorChar.ToString(), parent.FullName,
                            "applications",
                            "rpc-agent",
                            "rpc-agent.exe")).FullName;
                }
                return _rpcAgentPath;
            }
        }


        /// <summary>
        ///     If true, a secure transport will be used by the RPC Agent.
        /// </summary>
        public bool Secure { get; set; }

        /// <summary>
        ///     The full path to the log file that the RPC Agent will write to.  If null, no log file will be written.
        /// </summary>
        public FileInfo LogFile { get; set; }

        /// <summary>
        ///     The logging level that the launched RPC Agent will output.  Valid values are shown in the list below.
        ///     <list type="bullet">
        ///         <item>
        ///             <term>
        ///                 <code>panic</code>
        ///             </term>
        ///         </item>
        ///         <item>
        ///             <term>
        ///                 <code>fatal</code>
        ///             </term>
        ///         </item>
        ///         <item>
        ///             <term>
        ///                 <code>error</code>
        ///             </term>
        ///         </item>
        ///         <item>
        ///             <term>
        ///                 <code>warn</code>
        ///             </term>
        ///         </item>
        ///         <item>
        ///             <term>
        ///                 <code>info</code>
        ///             </term>
        ///         </item>
        ///         <item>
        ///             <term>
        ///                 <code>debug</code>
        ///             </term>
        ///         </item>
        ///     </list>
        /// </summary>
        public string LogLevel { get; set; }

        /// <summary>
        ///     Whether transmission is framed or not.
        /// </summary>
        /// <remarks>
        ///     See <a href="http://thrift-tutorial.readthedocs.io/en/latest/thrift-stack.html">the Thrift documentation</a>
        ///     for more information.
        /// </remarks>
        public bool Framed { get; set; }

        /// <summary>
        ///     Configuration file that the Thrift RPC Agent should load its configuration from.
        /// </summary>
        public FileInfo ConfigFile { get; set; }

        /// <summary>
        ///     Whether tranmission is buffered or not.
        /// </summary>
        /// <remarks>See <a href="https://thrift.apache.org/docs/concepts">the Thrift documentation</a> for more information.</remarks>
        public bool Buffered { get; set; }

        /// <summary>
        ///     Buffer size for tranmission.
        /// </summary>
        /// <remarks>Null indicates no value (no default, will be decided by the agent itself).</remarks>
        public int BufferSize { get; set; }

        internal string ToCommandLineArguments()
        {
            return string.Join(" ", // TODO Tidy this up so non-specified arguments don't leave an extra space
                FormatArgument(ArgNameBuffer, BufferSize),
                FormatArgument(ArgNameBuffered, Buffered),
                FormatArgument(ArgNameCallbackPort, CallbackPort),
                FormatArgument(ArgNameConfigFile, ConfigFile),
                FormatArgument(ArgNameFramed, Framed),
                FormatArgument(ArgNameLogLevel, LogLevel),
                FormatArgument(ArgNameLogFile, LogFile),
                FormatArgument(ArgNameSecure, Secure),
                FormatArgument(ArgNameHost, ServiceHost),
                FormatArgument(ArgNamePort, ServicePort),
                FormatArgument(ArgNameProtocol, Protocol)
                );
        }

        private string FormatArgument(string argumentName, object argumentValue)
        {
            if (
                (argumentValue == null) 
                || (argumentValue is bool && (!(bool)argumentValue))
                || (argumentValue is int && ((int)argumentValue==0))
               )
            {
                return null;
            }

            string argVal = argumentValue.ToString();
            if (argVal.Contains(" "))
            {
                argVal = $@"""{argVal}""";
            }
            return $"-{argumentName} {argVal}";
        }

        #region RPC Agent command line arguments, taken from the Go source for Rpc-Agent.exe

        private const string ArgNameConfigFile = "configfile";
        private const string ArgNameLogLevel = "loglevel";
        private const string ArgNameLogFile = "logfile";
        private const string ArgNameProtocol = "protocol";
        private const string ArgNameFramed = "framed";
        private const string ArgNameBuffered = "buffered";
        private const string ArgNameHost = "host";
        private const string ArgNamePort = "port";
        private const string ArgNameSecure = "secure";
        private const string ArgNameBuffer = "buffer";
        private const string ArgNameCallbackPort = "callbackport";

        #endregion


        /// <summary>
        /// Creates a Thrift protocol object, using the class as described in <see cref="Protocol"/>.
        /// </summary>
        /// <param name="transport">The transport that the protocol will be wrapped around.  Must not be null.</param>
        /// <returns>A TProtocol object.  If the value for <see cref="Protocol"/> is invalid then <see cref="TBinaryProtocol"/> is used.</returns>
        public TProtocol GetThriftProtcol(TTransport transport)
        {
            TProtocol protocol;
            switch (Protocol)
            {
                case "compact":
                    protocol = new TCompactProtocol(transport);
                    break;
                case "json":
                    protocol = new TJSONProtocol(transport);
                    break;
//                case "binary":
                default:
                    protocol = new TBinaryProtocol(transport);
                    break;
            }

            return protocol;
        }

        public TServerTransport GetThriftServerTransport()
        {
            TServerTransport transport;
            switch (Transport)
            {
                case "namedpipe":
                    transport = new TNamedPipeServerTransport(NamedPipeName);
                    break;
                default:
                    transport = new TServerSocket(CallbackPort);
                    break;
            }
            return transport;
        }

        public TTransport GetThriftTransport()
        {
            TTransport transport;
            switch (Transport)
            {
                case "namedpipe":
                    transport = new TNamedPipeClientTransport(ServiceHost, NamedPipeName);
                    break;
//                case "socket":
                default:
                    transport = new TSocket(ServiceHost, ServicePort);
                    break;
            }

            if (Framed)
            {
                transport = new TFramedTransport(transport);
            }

            if (Buffered)
            {
                transport = new TBufferedTransport((TStreamTransport)transport, BufferSize);
            }

            return transport;
        }

        public string NamedPipeName { get; set; } = "thrift-agent";

        public string Transport { get; set; } = "socket";
    }
}
