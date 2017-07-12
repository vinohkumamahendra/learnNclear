package com.java.basics;

public class IF {

	public static void main(String[] args) {
		
		String bankName="HDFC";
		String customerType="p";
		if(bankName=="HDFC"){
			System.out.println("ROi is 8%");
			if(customerType=="prime"){
				System.out.println("you have pre approved loan of 5lakhs");
			}
			else{
				System.out.println("please upgrade urself ads prime customer");
			}
		}
		else if (bankName=="ICICI"){
			System.out.println("ROi is 9%");
		}
		else if (bankName=="SBI")
		{
			System.out.println("ROI is 6%");
		}
		else{
			System.out.println("invalid bank name");
		}
		
		

	}

}
