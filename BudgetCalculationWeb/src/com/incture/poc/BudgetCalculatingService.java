package com.incture.poc;

public class BudgetCalculatingService {

	public String validateWithinBudget(Integer availableBudget, Integer calculatedAmount) {
		
		if (calculatedAmount <= availableBudget) {
			return "Total amount is within allocated budget";
		} else {
			return "Total amount has exceeded the allocated budget";
		}
	}
}
