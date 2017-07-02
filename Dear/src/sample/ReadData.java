package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter");
		String read = br.readLine();
		int input1 =  Integer.valueOf(read);
		System.out.println("Enter");
		int input2 =  Integer.valueOf(br.readLine());
		int sum = input1 + input2;
		
		System.out.println("sum of inp1 & inp2 is  " + String.valueOf(input1 + input2));
	}
}

