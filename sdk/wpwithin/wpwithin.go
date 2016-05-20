package wpwithin
import (
"innovation.worldpay.com/worldpay-within-sdk/sdk/wpwithin/domain"
	"innovation.worldpay.com/worldpay-within-sdk/sdk/wpwithin/hce"
	"innovation.worldpay.com/worldpay-within-sdk/sdk/wpwithin/hte"
	"innovation.worldpay.com/worldpay-within-sdk/sdk/wpwithin/servicediscovery"
	"innovation.worldpay.com/worldpay-within-sdk/sdk/wpwithin/utils"
)

const (

	BCAST_STEP_SLEEP = 5000
	HTE_PORT = 8980
	SVC_URL_PREFIX = "/services"
	UUID_FILE_PATH = "uuid.txt"
)

type WPWithin interface {

	AddService(service domain.Service) error
	RemoveService(service domain.Service) error
	SetHTECredentials(hteCredentials hte.HTECredential) error
	SetHCECardCredential(hceCardCredential hce.HCECardCredential) error
	SetHCEClientCredential(hceClientCredential hce.HCEClientCredential) error
	InitConsumer() error
	InitProducer() error
	GetDevice() domain.Device
	StartSvcBroadcast(timeoutMillis int)
	StopSvcBroadcast()
	ScanServices() []domain.Service
	GetSvcPrices(svc domain.Service) []domain.Price
	SelectSvc(svc domain.Service) domain.PaymentRequest
	MakePayment(payRequest domain.PaymentRequest) domain.PaymentResponse
}

func Initialise(name, description string) (WPWithin, error) {

	// Device

	var deviceGUID string
	var err error

	if b, _ := utils.FileExists(UUID_FILE_PATH); b {

		deviceGUID, err = utils.ReadLocalUUID(UUID_FILE_PATH)
	} else {

		deviceGUID, err = utils.NewUUID()

		utils.WriteString(UUID_FILE_PATH, deviceGUID, true)
	}

	if err != nil {

		return domain.Device{}, err
	}

	deviceAddress, err := utils.ExternalIPv4()

	if err != nil {

		return domain.Device{}, err
	}

	device, err := domain.NewDevice(name, description, deviceGUID, deviceAddress, SVC_URL_PREFIX)

	if err != nil {

		return domain.Device{}, err
	}

	// Service broadcaster

	svcBroadcaster, err := servicediscovery.NewBroadcaster(device.IPv4Address, HTE_PORT, BCAST_STEP_SLEEP)

	if err != nil {

		return device, err
	}

	device.SvcBroadcaster = svcBroadcaster

	// Service scanner

	svcScanner, err := servicediscovery.NewScanner()

	if err != nil {

		return device, err
	}

	device.SvcScanner = svcScanner

	return device, nil
}