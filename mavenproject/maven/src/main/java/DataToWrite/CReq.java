package DataToWrite;

public class CReq {
	private String threeDSServerTransID;
	private String acsTransId;
	private String challengeWindowSize;
	private String messageType; //CReq
	private String messageVersion;
	
	
	
	public CReq() {};
	public CReq(String threeDSServerTransID, String acsTransId, 
			String challengeWindowSize, String messageType, String messageVersion) 
	{
		this.setThreeDSServerTransID(threeDSServerTransID);
		this.setAcsTransId(acsTransId);
		this.setChallengeWindowSize(challengeWindowSize);
		this.setMessageType(messageType);
		this.setMessageVersion(messageVersion);
	}
	
	public String getThreeDSServerTransID() {
		return threeDSServerTransID;
	}
	public void setThreeDSServerTransID(String threeDSServerTransID) {
		this.threeDSServerTransID = threeDSServerTransID;
	}
	public String getAcsTransId() {
		return acsTransId;
	}
	public void setAcsTransId(String acsTransId) {
		this.acsTransId = acsTransId;
	}
	public String getChallengeWindowSize() {
		return challengeWindowSize;
	}
	public void setChallengeWindowSize(String challengeWindowSize) {
		this.challengeWindowSize = challengeWindowSize;
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
	@Override
	public String toString() {
		return "CReq [threeDSServerTransID=" + threeDSServerTransID + ", acsTransId=" + acsTransId
				+ ", challengeWindowSize=" + challengeWindowSize + ", messageType=" + messageType + ", messageVersion="
				+ messageVersion + "]";
	}
	
}

