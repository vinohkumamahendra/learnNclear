package com.selenium.basics;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListImplementation {

	public static void main(String[] args) {
/**		String[] array1 = new String[3];
		array1[0]="pintu";
		array1[1]="neha";
		array1[2]="uma";
		System.out.println("DATA IN CLASSICAL ARRAY ");
		for(int i=0;i<3;i++){
			System.out.println(array1[i]);
			
		}*/
		
		
		ArrayList<String> array2 = new ArrayList<String>();
		array2.add("nadi");
		array2.add("shikha");
		array2.add("pratik");
		array2.add("shikha");
		System.out.println("DATA IN  ARRAY LIST\n");
		for(String names:array2){
			System.out.println(names);
			
		}
		
		array2.get(2);
		
		HashSet<String> array3 = new HashSet<String>();
		array3.add("Nihar");
		array3.add("sundar");
		array3.add("gopi");
		array3.add("Nihar");
		System.out.println("DATA IN  HASH SET \n");
		for(String names:array3){
			System.out.println(names);
			
		}

		
		
		
		
/**		array2.remove("nadi");
		System.out.println("DATA IN DYNAMIC ARRAY AFTER REMOVING NADI \n");
		for(String names:array2){
			System.out.println(names);
			
		}*/
		
		

	}

}
