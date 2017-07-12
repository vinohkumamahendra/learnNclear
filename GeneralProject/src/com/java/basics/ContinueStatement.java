package com.java.basics;



public class ContinueStatement {

	   public static void main(String args[]) {
	      int [] numbers = {10, 20, 30, 40, 50};

	      for(int x : numbers ) {
	         if( x == 30 ) {
	          /**
	           * whenever this condition gets satisfied (when the program flow reaches continue statement), it automatically
	           * jumps to for(int x : numbers) line ie., iteration line. so when x ==30, value will not be printed. 
	           */
		      continue;
	         }
	         System.out.print( x );
	         System.out.print("\n");
	      }
	   }
	}

