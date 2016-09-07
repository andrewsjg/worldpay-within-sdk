/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.worldpay.innovation.wpwithin.rpc.types;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-09-07")
public class ServiceMessage implements org.apache.thrift.TBase<ServiceMessage, ServiceMessage._Fields>, java.io.Serializable, Cloneable, Comparable<ServiceMessage> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ServiceMessage");

  private static final org.apache.thrift.protocol.TField DEVICE_DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceDescription", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField HOSTNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("hostname", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PORT_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("portNumber", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField SERVER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("serverId", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField URL_PREFIX_FIELD_DESC = new org.apache.thrift.protocol.TField("urlPrefix", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ServiceMessageStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ServiceMessageTupleSchemeFactory());
  }

  public String deviceDescription; // required
  public String hostname; // required
  public int portNumber; // required
  public String serverId; // required
  public String urlPrefix; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DEVICE_DESCRIPTION((short)1, "deviceDescription"),
    HOSTNAME((short)2, "hostname"),
    PORT_NUMBER((short)3, "portNumber"),
    SERVER_ID((short)4, "serverId"),
    URL_PREFIX((short)5, "urlPrefix");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DEVICE_DESCRIPTION
          return DEVICE_DESCRIPTION;
        case 2: // HOSTNAME
          return HOSTNAME;
        case 3: // PORT_NUMBER
          return PORT_NUMBER;
        case 4: // SERVER_ID
          return SERVER_ID;
        case 5: // URL_PREFIX
          return URL_PREFIX;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PORTNUMBER_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DEVICE_DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("deviceDescription", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HOSTNAME, new org.apache.thrift.meta_data.FieldMetaData("hostname", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PORT_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("portNumber", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SERVER_ID, new org.apache.thrift.meta_data.FieldMetaData("serverId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.URL_PREFIX, new org.apache.thrift.meta_data.FieldMetaData("urlPrefix", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ServiceMessage.class, metaDataMap);
  }

  public ServiceMessage() {
  }

  public ServiceMessage(
    String deviceDescription,
    String hostname,
    int portNumber,
    String serverId,
    String urlPrefix)
  {
    this();
    this.deviceDescription = deviceDescription;
    this.hostname = hostname;
    this.portNumber = portNumber;
    setPortNumberIsSet(true);
    this.serverId = serverId;
    this.urlPrefix = urlPrefix;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ServiceMessage(ServiceMessage other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetDeviceDescription()) {
      this.deviceDescription = other.deviceDescription;
    }
    if (other.isSetHostname()) {
      this.hostname = other.hostname;
    }
    this.portNumber = other.portNumber;
    if (other.isSetServerId()) {
      this.serverId = other.serverId;
    }
    if (other.isSetUrlPrefix()) {
      this.urlPrefix = other.urlPrefix;
    }
  }

  public ServiceMessage deepCopy() {
    return new ServiceMessage(this);
  }

  @Override
  public void clear() {
    this.deviceDescription = null;
    this.hostname = null;
    setPortNumberIsSet(false);
    this.portNumber = 0;
    this.serverId = null;
    this.urlPrefix = null;
  }

  public String getDeviceDescription() {
    return this.deviceDescription;
  }

  public ServiceMessage setDeviceDescription(String deviceDescription) {
    this.deviceDescription = deviceDescription;
    return this;
  }

  public void unsetDeviceDescription() {
    this.deviceDescription = null;
  }

  /** Returns true if field deviceDescription is set (has been assigned a value) and false otherwise */
  public boolean isSetDeviceDescription() {
    return this.deviceDescription != null;
  }

  public void setDeviceDescriptionIsSet(boolean value) {
    if (!value) {
      this.deviceDescription = null;
    }
  }

  public String getHostname() {
    return this.hostname;
  }

  public ServiceMessage setHostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

  public void unsetHostname() {
    this.hostname = null;
  }

  /** Returns true if field hostname is set (has been assigned a value) and false otherwise */
  public boolean isSetHostname() {
    return this.hostname != null;
  }

  public void setHostnameIsSet(boolean value) {
    if (!value) {
      this.hostname = null;
    }
  }

  public int getPortNumber() {
    return this.portNumber;
  }

  public ServiceMessage setPortNumber(int portNumber) {
    this.portNumber = portNumber;
    setPortNumberIsSet(true);
    return this;
  }

  public void unsetPortNumber() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PORTNUMBER_ISSET_ID);
  }

  /** Returns true if field portNumber is set (has been assigned a value) and false otherwise */
  public boolean isSetPortNumber() {
    return EncodingUtils.testBit(__isset_bitfield, __PORTNUMBER_ISSET_ID);
  }

  public void setPortNumberIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PORTNUMBER_ISSET_ID, value);
  }

  public String getServerId() {
    return this.serverId;
  }

  public ServiceMessage setServerId(String serverId) {
    this.serverId = serverId;
    return this;
  }

  public void unsetServerId() {
    this.serverId = null;
  }

  /** Returns true if field serverId is set (has been assigned a value) and false otherwise */
  public boolean isSetServerId() {
    return this.serverId != null;
  }

  public void setServerIdIsSet(boolean value) {
    if (!value) {
      this.serverId = null;
    }
  }

  public String getUrlPrefix() {
    return this.urlPrefix;
  }

  public ServiceMessage setUrlPrefix(String urlPrefix) {
    this.urlPrefix = urlPrefix;
    return this;
  }

  public void unsetUrlPrefix() {
    this.urlPrefix = null;
  }

  /** Returns true if field urlPrefix is set (has been assigned a value) and false otherwise */
  public boolean isSetUrlPrefix() {
    return this.urlPrefix != null;
  }

  public void setUrlPrefixIsSet(boolean value) {
    if (!value) {
      this.urlPrefix = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DEVICE_DESCRIPTION:
      if (value == null) {
        unsetDeviceDescription();
      } else {
        setDeviceDescription((String)value);
      }
      break;

    case HOSTNAME:
      if (value == null) {
        unsetHostname();
      } else {
        setHostname((String)value);
      }
      break;

    case PORT_NUMBER:
      if (value == null) {
        unsetPortNumber();
      } else {
        setPortNumber((Integer)value);
      }
      break;

    case SERVER_ID:
      if (value == null) {
        unsetServerId();
      } else {
        setServerId((String)value);
      }
      break;

    case URL_PREFIX:
      if (value == null) {
        unsetUrlPrefix();
      } else {
        setUrlPrefix((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DEVICE_DESCRIPTION:
      return getDeviceDescription();

    case HOSTNAME:
      return getHostname();

    case PORT_NUMBER:
      return getPortNumber();

    case SERVER_ID:
      return getServerId();

    case URL_PREFIX:
      return getUrlPrefix();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DEVICE_DESCRIPTION:
      return isSetDeviceDescription();
    case HOSTNAME:
      return isSetHostname();
    case PORT_NUMBER:
      return isSetPortNumber();
    case SERVER_ID:
      return isSetServerId();
    case URL_PREFIX:
      return isSetUrlPrefix();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ServiceMessage)
      return this.equals((ServiceMessage)that);
    return false;
  }

  public boolean equals(ServiceMessage that) {
    if (that == null)
      return false;

    boolean this_present_deviceDescription = true && this.isSetDeviceDescription();
    boolean that_present_deviceDescription = true && that.isSetDeviceDescription();
    if (this_present_deviceDescription || that_present_deviceDescription) {
      if (!(this_present_deviceDescription && that_present_deviceDescription))
        return false;
      if (!this.deviceDescription.equals(that.deviceDescription))
        return false;
    }

    boolean this_present_hostname = true && this.isSetHostname();
    boolean that_present_hostname = true && that.isSetHostname();
    if (this_present_hostname || that_present_hostname) {
      if (!(this_present_hostname && that_present_hostname))
        return false;
      if (!this.hostname.equals(that.hostname))
        return false;
    }

    boolean this_present_portNumber = true;
    boolean that_present_portNumber = true;
    if (this_present_portNumber || that_present_portNumber) {
      if (!(this_present_portNumber && that_present_portNumber))
        return false;
      if (this.portNumber != that.portNumber)
        return false;
    }

    boolean this_present_serverId = true && this.isSetServerId();
    boolean that_present_serverId = true && that.isSetServerId();
    if (this_present_serverId || that_present_serverId) {
      if (!(this_present_serverId && that_present_serverId))
        return false;
      if (!this.serverId.equals(that.serverId))
        return false;
    }

    boolean this_present_urlPrefix = true && this.isSetUrlPrefix();
    boolean that_present_urlPrefix = true && that.isSetUrlPrefix();
    if (this_present_urlPrefix || that_present_urlPrefix) {
      if (!(this_present_urlPrefix && that_present_urlPrefix))
        return false;
      if (!this.urlPrefix.equals(that.urlPrefix))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_deviceDescription = true && (isSetDeviceDescription());
    list.add(present_deviceDescription);
    if (present_deviceDescription)
      list.add(deviceDescription);

    boolean present_hostname = true && (isSetHostname());
    list.add(present_hostname);
    if (present_hostname)
      list.add(hostname);

    boolean present_portNumber = true;
    list.add(present_portNumber);
    if (present_portNumber)
      list.add(portNumber);

    boolean present_serverId = true && (isSetServerId());
    list.add(present_serverId);
    if (present_serverId)
      list.add(serverId);

    boolean present_urlPrefix = true && (isSetUrlPrefix());
    list.add(present_urlPrefix);
    if (present_urlPrefix)
      list.add(urlPrefix);

    return list.hashCode();
  }

  @Override
  public int compareTo(ServiceMessage other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDeviceDescription()).compareTo(other.isSetDeviceDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceDescription, other.deviceDescription);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHostname()).compareTo(other.isSetHostname());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHostname()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hostname, other.hostname);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPortNumber()).compareTo(other.isSetPortNumber());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPortNumber()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.portNumber, other.portNumber);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetServerId()).compareTo(other.isSetServerId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetServerId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serverId, other.serverId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUrlPrefix()).compareTo(other.isSetUrlPrefix());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUrlPrefix()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.urlPrefix, other.urlPrefix);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ServiceMessage(");
    boolean first = true;

    sb.append("deviceDescription:");
    if (this.deviceDescription == null) {
      sb.append("null");
    } else {
      sb.append(this.deviceDescription);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("hostname:");
    if (this.hostname == null) {
      sb.append("null");
    } else {
      sb.append(this.hostname);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("portNumber:");
    sb.append(this.portNumber);
    first = false;
    if (!first) sb.append(", ");
    sb.append("serverId:");
    if (this.serverId == null) {
      sb.append("null");
    } else {
      sb.append(this.serverId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("urlPrefix:");
    if (this.urlPrefix == null) {
      sb.append("null");
    } else {
      sb.append(this.urlPrefix);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ServiceMessageStandardSchemeFactory implements SchemeFactory {
    public ServiceMessageStandardScheme getScheme() {
      return new ServiceMessageStandardScheme();
    }
  }

  private static class ServiceMessageStandardScheme extends StandardScheme<ServiceMessage> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ServiceMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DEVICE_DESCRIPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.deviceDescription = iprot.readString();
              struct.setDeviceDescriptionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HOSTNAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.hostname = iprot.readString();
              struct.setHostnameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PORT_NUMBER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.portNumber = iprot.readI32();
              struct.setPortNumberIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SERVER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.serverId = iprot.readString();
              struct.setServerIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // URL_PREFIX
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.urlPrefix = iprot.readString();
              struct.setUrlPrefixIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ServiceMessage struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.deviceDescription != null) {
        oprot.writeFieldBegin(DEVICE_DESCRIPTION_FIELD_DESC);
        oprot.writeString(struct.deviceDescription);
        oprot.writeFieldEnd();
      }
      if (struct.hostname != null) {
        oprot.writeFieldBegin(HOSTNAME_FIELD_DESC);
        oprot.writeString(struct.hostname);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PORT_NUMBER_FIELD_DESC);
      oprot.writeI32(struct.portNumber);
      oprot.writeFieldEnd();
      if (struct.serverId != null) {
        oprot.writeFieldBegin(SERVER_ID_FIELD_DESC);
        oprot.writeString(struct.serverId);
        oprot.writeFieldEnd();
      }
      if (struct.urlPrefix != null) {
        oprot.writeFieldBegin(URL_PREFIX_FIELD_DESC);
        oprot.writeString(struct.urlPrefix);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ServiceMessageTupleSchemeFactory implements SchemeFactory {
    public ServiceMessageTupleScheme getScheme() {
      return new ServiceMessageTupleScheme();
    }
  }

  private static class ServiceMessageTupleScheme extends TupleScheme<ServiceMessage> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ServiceMessage struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetDeviceDescription()) {
        optionals.set(0);
      }
      if (struct.isSetHostname()) {
        optionals.set(1);
      }
      if (struct.isSetPortNumber()) {
        optionals.set(2);
      }
      if (struct.isSetServerId()) {
        optionals.set(3);
      }
      if (struct.isSetUrlPrefix()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetDeviceDescription()) {
        oprot.writeString(struct.deviceDescription);
      }
      if (struct.isSetHostname()) {
        oprot.writeString(struct.hostname);
      }
      if (struct.isSetPortNumber()) {
        oprot.writeI32(struct.portNumber);
      }
      if (struct.isSetServerId()) {
        oprot.writeString(struct.serverId);
      }
      if (struct.isSetUrlPrefix()) {
        oprot.writeString(struct.urlPrefix);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ServiceMessage struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.deviceDescription = iprot.readString();
        struct.setDeviceDescriptionIsSet(true);
      }
      if (incoming.get(1)) {
        struct.hostname = iprot.readString();
        struct.setHostnameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.portNumber = iprot.readI32();
        struct.setPortNumberIsSet(true);
      }
      if (incoming.get(3)) {
        struct.serverId = iprot.readString();
        struct.setServerIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.urlPrefix = iprot.readString();
        struct.setUrlPrefixIsSet(true);
      }
    }
  }

}

