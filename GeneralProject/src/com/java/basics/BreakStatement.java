package com.java.basics;

/**
 * 
 * When the break statement is encountered inside a loop, the loop is immediately terminated and 
 * program control resumes at the next statement following the loop.
 * 
 * in the below example, only values 10,20 will be printed. other values will not be printed since break statement has been
 * encountered when x==30
 *
 */


public class BreakStatement {

	   public static void main(String args[]) {
	      int [] numbers = {10, 20, 30, 40, 50};

	      for(int x : numbers ) {
	         if( x == 30 ) {
		      break;
	         }
	         System.out.print( x );
	         System.out.print("\n");
	      }
	   }
	}