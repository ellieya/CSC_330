package edu.cuny.csi.csc330.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;;

public class RoundingClient {

	public RoundingClient() {
		
	}
	
    public static void main(String[] args) {
    	
    	BigDecimal value = new BigDecimal("2.3");
    	value = value.setScale(0, RoundingMode.UP);
    	
    	BigDecimal secondValue = new BigDecimal("4.343467828907809432");
    	secondValue = secondValue.setScale(2, RoundingMode.DOWN);
    	
    	System.out.println("Value1 " +  value + " / Value2 " + secondValue);

    }
	
	
}
