package com.wildcodeschool.festivalorleansjoue.utils;

public class MathUtils {
	
	public static float priceRound(double price) {		
		return (float)(Math.round(price * 100)) / 100;
	}
	
	public static float registrationCost(double tablesQuantity, double tablePrice, double saleOptionPrice ) {
		float registrationCost = (float)(tablesQuantity * tablePrice - (float)((int)(tablesQuantity / 4)) * tablePrice + saleOptionPrice);
		return (float)(Math.round(registrationCost * 100)) / 100;
	}

}
 