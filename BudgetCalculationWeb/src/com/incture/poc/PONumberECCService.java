package com.incture.poc;

import java.util.Random;

public class PONumberECCService {

	/**
	 * This method return a six digit random number
	 */
	public int fetchPONumber() {
//		int poNumber = 0;
//		Random randomGenerator = ;
//	    for (int idx = 1; idx <= 50; ++idx){
//	       poNumber = randomGenerator.nextInt(1000);
//	       System.out.println("Generated : " + poNumber);
//	    }
//		return poNumber;
		return new Random().nextInt(1000) % 1000000;
	}
}