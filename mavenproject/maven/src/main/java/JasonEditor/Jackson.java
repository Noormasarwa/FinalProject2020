package JasonEditor;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DataToWrite.AReq;
import DataToWrite.ARes;
import DataToWrite.CReq;

public class Jackson {
	
   private String mes;
   
   public Jackson() {
	   setMes(null);
   }

   public String fromCReqToJson(CReq creq) {
	   setMes(null);
	   ObjectMapper mapper = new ObjectMapper();
	   try{
	        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(creq);
	      
	      }
	      catch (JsonParseException e) { 
	    	  setMes(e.toString());
	    	  return null;
	      }
	      catch (JsonMappingException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
	      catch (IOException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
	   }
   
   public String fromAReqToJson(AReq areq) {
	   setMes(null);
	   ObjectMapper mapper = new ObjectMapper();
	   try{
	        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(areq);
	      
	      }
	      catch (JsonParseException e) { 
	    	  setMes(e.toString());
	    	  return null;
	      }
	      catch (JsonMappingException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
	      catch (IOException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
	   }
   
   public AReq fromJasonToAReqObject(String jsonString) {
	   setMes(null);
	   ObjectMapper mapper = new ObjectMapper();
	
	   try{
		   AReq areq = mapper.readValue(jsonString, AReq.class);
	       return areq;
	      }
	      catch (JsonParseException e) { 
	    	  setMes(e.toString());
	    	  return null;
	      }
	      catch (JsonMappingException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
	      catch (IOException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
   }
   
   public String fromAResToJson(ARes ares) {
	   setMes(null);
	   ObjectMapper mapper = new ObjectMapper();
	   try{
	        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ares);
	      
	      }
	      catch (JsonParseException e) { 
	    	  setMes(e.toString());
	    	  return null;
	      }
	      catch (JsonMappingException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
	      catch (IOException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
	   }
   
   public ARes fromJasonToAresObject(String jsonString) {
	   setMes(null);
	   ObjectMapper mapper = new ObjectMapper();
	
	   try{
		   ARes ares = mapper.readValue(jsonString, ARes.class);
	       return ares;
	      }
	      catch (JsonParseException e) { 
	    	  setMes(e.toString());
	    	  return null;
	      }
	      catch (JsonMappingException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
	      catch (IOException e) { 
	    	 setMes(e.toString());
	    	 return null;
	      }
   }

	public String getMes() {
		return mes;
	   }
	
	public void setMes(String mes) {
		this.mes = mes;
	   }
}
	