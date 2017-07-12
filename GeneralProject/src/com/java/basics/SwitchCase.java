package com.java.basics;

public class SwitchCase {
	
/**
    SWITCH CASE RULES AND WORKING PRIMCIPLE
    
	The variable used in a switch statement can only be integers, convertable integers (byte, short, char), strings and enums.

	You can have any number of case statements within a switch. Each case is followed by the value to be compared to and a colon.

	The value for a case must be the same data type as the variable in the switch and it must be a constant or a literal.

	When the variable being switched on is equal to a case, the statements following that case will execute until a break statement is reached.

	When a break statement is reached, the switch terminates, and the flow of control jumps to the next line following the switch statement.

	Not every case needs to contain a break. If no break appears, the flow of control will fall through to subsequent cases until a break is reached.

	A switch statement can have an optional default case, which must appear at the end of the switch. The default case can be used for performing a task when none of the cases is true. No break is needed in the default case.	

	**/
	
	public static void main(String[] args) {
	
	int month = 1;
	String monthString=null;
	
	switch (month) {
		
		case 1: monthString = "January";
		System.out.println("hi");
		break;
		
		case 2: monthString = "February";
		break;
		
		case 3: monthString = "March";
		break;
		
		case 4: monthString = "April";
		break;
		
		case 5: monthString = "May";
		break;
		
		case 6: monthString = "June";
		break;
		
		case 7: monthString = "July";
		break;
		
		case 8: monthString = "August";
		break;
		
		case 9: monthString = "September";
		break;
		
		case 10: monthString = "October";
		break;
	
	}
	
	System.out.println("the value stored in month "+monthString);
	
	}
}