package TesttForDataToWrite;

import DataToWrite.AReq;
import DataToWrite.ARes;


import java.util.Base64;

public class Test1 {
	public Test1(){
		
	}
	
	
	
	public  AReq returningAReqObject(){
		AReq aReq = new AReq();
		aReq.setThreeDSCompInd("a");
		aReq.setThreeDSRequestorAuthenticationInd("80");
		aReq.setThreeDSRequestorID("amrohabibisthebest");
		aReq.setThreeDSRequestorName("amrohabib");
		aReq.setThreeDSRequestorURL("http://www.anyURL.come/myprojectatfintech");
		aReq.setThreeDSServerRefNumber("1212212");
		aReq.setThreeDSServerTransID("522924425");
		aReq.setThreeDSServerURL("http://www.anyURL2.come/myprojectatfintech");
		aReq.setAcquirerBIN("1234");
		aReq.setAcquirerMerchantID("9876");
		aReq.setAcctNumber("53261023");
		aReq.setBrowserAcceptHeader("http://www.anyURL.come/myprojectatfintech");
		aReq.setBrowserJavascriptEnabled(true);
		aReq.setBrowserLanguage("Language");
		aReq.setBrowserUserAgent("useragentupto2048");
		aReq.setDeviceChannel("02");
		aReq.setDsReferenceNumber("32568");
		aReq.setDsTransID("1231912389");
		aReq.setDsURL("aanyweb.com");
		aReq.setMcc("0202");
		aReq.setMerchantCountryCode("033");
		aReq.setMerchantName("iso8583");
		aReq.setMessageCategor("01");
		aReq.setMessageType("AREQ");
		aReq.setMessageVersion("5-8c");
		aReq.setNotificationURL("any.com");
		aReq.setPurchaseAmount("123.45");
		aReq.setPurchaseCurrency("USD");
		aReq.setPurchaseDate("19970113223517");
		aReq.setPurchaseExponent("2");
		aReq.setHomePhone("0527800589");
	return aReq;
	}
	public  ARes returningAResObject(){
		ARes aRes = new ARes();
		aRes.setAuthenticationValue("123456789amrohabib123456789!");
		byte[] decodedBytes = Base64.getDecoder().decode(aRes.getAuthenticationValue());
		String decodedString = new String(decodedBytes);
		System.out.println(decodedString);
		return aRes;
	}
	
	
	public AReq AReqCreator(String bin, String merchantId, String AcctNumber,
			String dsRefernceNumber, String dstransId, 
			String Amount, String Currency,String PurchaseDate,String phone) {
		AReq areq = returningAReqObject();
		areq.setAcquirerBIN(bin);
		areq.setAcquirerMerchantID(merchantId);
		areq.setAcctNumber(AcctNumber);
		areq.setDsReferenceNumber(dsRefernceNumber);
		areq.setDsTransID(dstransId);
		areq.setPurchaseAmount(Amount);
		areq.setPurchaseCurrency(Currency);
		areq.setPurchaseDate(PurchaseDate);
		areq.setHomePhone(phone);
		
		return areq;
		
	}

}