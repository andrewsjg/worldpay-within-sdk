package types

type OrderResponsePaymentResponse struct {

	Type string `json:"type"`
	
	Name string `json:"name"`
	
	ExpiryMonth int32 `json:"expiryMonth"`
	
	ExpiryYear int32 `json:"expiryYear"`
	
	IssueNumber int32 `json:"issueNumber"`
	
	StartMonth int32 `json:"startMonth"`
	
	StartYear int32 `json:"startYear"`
	
	CardType string `json:"cardType"`
	
	MaskedCardNumber string `json:"maskedCardNumber"`
	
	CardSchemeType string `json:"cardSchemeType"`
	
	CardSchemeName string `json:"cardSchemeName"`
	
	CardIssuer string `json:"cardIssuer"`
	
	CountryCode string `json:"countryCode"`
		
	CardClass string `json:"cardClass"`
		
	CardProductTypeDescNonContactless string `json:"cardProductTypeDescNonContactless"`
	
	CardProductTypeDescContactless string `json:"cardProductTypeDescContactless"`
		
	Prepaid string `json:"prepaid"`
}