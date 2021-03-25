package FrictionlessFlow;

import java.util.Random;

public class RandomAlgorithms {
	private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final String[] Reasons = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"};
	
	public RandomAlgorithms(){};
	
	 public String randomNumber() {
	      Random rand = new Random(); //instance of random class
	        //generate random values from 0-25
	      int int_random = rand.nextInt(25);
	      String reason = Reasons[int_random];
		return reason; 
 }
	
	public String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}
		return builder.toString();
	}

}
