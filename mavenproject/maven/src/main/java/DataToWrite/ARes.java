package DataToWrite;

public class ARes {
	private String threeDSServerTransID;
	//private String acsChallengeMandated; //challenge
	private String acsReferenceNumber; // we can put whatever we want here (EMV) id for each AReq and Ares 
	private String acsTransId;
	//private String acsURL;  //challenge
	//private String authenticationType; //challenge
	private String authenticationValue; //must be 20bytes base 64-encoded
	private String dsReferenceNumber; // taken from areq
	private String dsTransId; //taken from areq
	private String eci; // value = '07'
	private String messageType; //ARes
	private String messageVersion;
	private String transStatus;// declined or accepted 
	private String transStatusReason;// if Areq is declined there are list  reasons for decline in the emv .
	
	//public ARes() {}
	public ARes() {};
	public ARes(String threeDSServerTransID, String acsReferenceNumber, String acsTransId, String authenticationValue,
			String dsReferenceNumber, String dsTransId, String eci,String messageType, String messageVersion,
			String transStatus, String transStatusReason)
	{
		this.setThreeDSServerTransID(threeDSServerTransID);
		this.setAcsReferenceNumber(acsReferenceNumber);
		this.setAcsTransId(acsTransId);
		this.setAuthenticationValue(authenticationValue);
		this.setDsReferenceNumber(dsReferenceNumber);
		this.setDsTransId(dsTransId);
		this.setEci(eci);
		this.setMessageType(messageType);
		this.setMessageVersion(messageVersion);
		this.setTransStatus(transStatus);
		this.setTransStatusReason(transStatusReason);
	}
	public ARes(String threeDSServerTransID, String acsReferenceNumber, String acsTransId, String authenticationValue,
			String dsReferenceNumber, String dsTransId, String eci,String messageType, String messageVersion,
			String transStatus)
	{
		this.setThreeDSServerTransID(threeDSServerTransID);
		this.setAcsReferenceNumber(acsReferenceNumber);
		this.setAcsTransId(acsTransId);
		this.setAuthenticationValue(authenticationValue);
		this.setDsReferenceNumber(dsReferenceNumber);
		this.setDsTransId(dsTransId);
		this.setEci(eci);
		this.setMessageType(messageType);
		this.setMessageVersion(messageVersion);
		this.setTransStatus(transStatus);
		//this.setTransStatusReason(transStatusReason);
	}
	public String getThreeDSServerTransID() {
		return threeDSServerTransID;
	}
	public void setThreeDSServerTransID(String threeDSServerTransID) {
		this.threeDSServerTransID = threeDSServerTransID;
	}
	public String getAcsReferenceNumber() {
		return acsReferenceNumber;
	}
	public void setAcsReferenceNumber(String acsReferenceNumber) {
		this.acsReferenceNumber = acsReferenceNumber;
	}
	public String getAcsTransId() {
		return acsTransId;
	}
	public void setAcsTransId(String acsTransId) {
		this.acsTransId = acsTransId;
	}
	public String getAuthenticationValue() {
		return authenticationValue;
	}
	public void setAuthenticationValue(String authenticationValue) {
		this.authenticationValue = authenticationValue;
	}
	public String getDsReferenceNumber() {
		return dsReferenceNumber;
	}
	public void setDsReferenceNumber(String dsReferenceNumber) {
		this.dsReferenceNumber = dsReferenceNumber;
	}
	public String getDsTransId() {
		return dsTransId;
	}
	public void setDsTransId(String dsTransId) {
		this.dsTransId = dsTransId;
	}
	public String getEci() {
		return eci;
	}
	public void setEci(String eci) {
		this.eci = eci;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageVersion() {
		return messageVersion;
	}
	public void setMessageVersion(String messageVersion) {
		this.messageVersion = messageVersion;
	}
	public String getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
	public String getTransStatusReason() {
		return transStatusReason;
	}
	public void setTransStatusReason(String transStatusReason) {
		this.transStatusReason = transStatusReason;
	}
	@Override
	public String toString() {
		return "ARes \n[threeDSServerTransID=" + threeDSServerTransID + "\n, acsReferenceNumber=" + acsReferenceNumber
				+ "\n, acsTransId=" + acsTransId + "\n, authenticationValue=" + authenticationValue + "\n, dsReferenceNumber="
				+ dsReferenceNumber + "\n, dsTransId=" + dsTransId + "\n, eci=" + eci + "\n, messageType=" + messageType
				+ "\n, messageVersion=" + messageVersion + "\n, transStatus=" + transStatus + "\n, transStatusReason="
				+ transStatusReason + "]\n";
	}


}
