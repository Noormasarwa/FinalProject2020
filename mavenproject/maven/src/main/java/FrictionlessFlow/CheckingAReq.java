package FrictionlessFlow;

import java.util.Base64;

import DataToWrite.AReq;
import DataToWrite.ARes;
import DataToWrite.CReq;



public class CheckingAReq {
	
	private  final String[] VisaCard = {"458003","458012","458016","458021","458008","458024","458027","458028","458036"};
	private  final String[] MasterCard = {"518955","532610","552176"};
	public  ARes checkAReq(AReq areq) {
		if(areq == null) {
			return null;
		}
		ARes ares= null;
		
		RandomAlgorithms rn = new RandomAlgorithms();
		String actNumber = areq.getAcctNumber();
		int flag  =0;
		for (String s:VisaCard) {
			if(actNumber.contains(s)) {
				flag = 1 ;
				break ;
			}
		}
		if(flag == 0) {
			for(String s:MasterCard) {
				if(actNumber.contains(s)) {
					flag = 1 ;
					break ;
				}
			}
		}
		if(flag == 1){
			if(Float.parseFloat(areq.getPurchaseAmount()) < 200 && Float.parseFloat(areq.getPurchaseAmount()) > 0){
				ares = new ARes(areq.getThreeDSServerTransID(), rn.randomAlphaNumeric(32), rn.randomAlphaNumeric(36), 
						Base64.getEncoder().encodeToString(rn.randomAlphaNumeric(28).getBytes()), areq.getDsReferenceNumber(), areq.getDsTransID(), 
						"07", "ARes", "2.2.0", "Y");
			}
			else if(Float.parseFloat(areq.getPurchaseAmount()) > 200 && Float.parseFloat(areq.getPurchaseAmount()) < 1000){
				// choosing challenge
				ares = new ARes(areq.getThreeDSServerTransID(), rn.randomAlphaNumeric(32), rn.randomAlphaNumeric(36), 
						Base64.getEncoder().encodeToString(rn.randomAlphaNumeric(28).getBytes()), areq.getDsReferenceNumber(), areq.getDsTransID(), 
						"07", "ARes", "2.2.0", "C");
			}
			else {
				ares = new ARes(areq.getThreeDSServerTransID(), rn.randomAlphaNumeric(32), rn.randomAlphaNumeric(36), 
						Base64.getEncoder().encodeToString(rn.randomAlphaNumeric(28).getBytes()), areq.getDsReferenceNumber(), areq.getDsTransID(), 
						"07", "ARes", "2.2.0", "N", rn.randomNumber());
			}
			return ares;
		}else if(Float.parseFloat(areq.getPurchaseAmount()) < 1000 && Float.parseFloat(areq.getPurchaseAmount()) > 0)  {
			ares = new ARes(areq.getThreeDSServerTransID(), rn.randomAlphaNumeric(32), rn.randomAlphaNumeric(36), 
					Base64.getEncoder().encodeToString(rn.randomAlphaNumeric(28).getBytes()), areq.getDsReferenceNumber(), areq.getDsTransID(), 
					"07", "ARes", "2.2.0", "C");
		}else {
			ares = new ARes(areq.getThreeDSServerTransID(), rn.randomAlphaNumeric(32), rn.randomAlphaNumeric(36), 
					Base64.getEncoder().encodeToString(rn.randomAlphaNumeric(28).getBytes()), areq.getDsReferenceNumber(), areq.getDsTransID(), 
					"07", "ARes", "2.2.0", "N", rn.randomNumber());
		}
		
		return ares;
	}
	public String[] getVisaCard() {
		return VisaCard;
	}
	public String[] getMasterCard() {
		return MasterCard;
	}
	
	public CReq returnCreq(ARes ares) {
		CReq creq = null;
		 if(ares.getTransStatus().equals("C")) {
			 creq = new CReq(ares.getThreeDSServerTransID(), ares.getAcsTransId(),"05", "CReq", "2.2.0");
		 }
		return creq;
	}
}

