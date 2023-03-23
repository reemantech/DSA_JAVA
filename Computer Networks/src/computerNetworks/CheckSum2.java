package computerNetworks;

import java.util.Scanner;

public class CheckSum2 {

	private static String checkSum(String data, int len) {

//		considering data to be 16 bits long and checksum length is of 4 bits

		String chkSum = "";
		int subunitLen = len / 4;
		int arr[][] = new int[subunitLen + 1][4];
		int pt = 0;
		for (int i = 0; i < subunitLen; i++) {
			for (int k = 0; k < 4; k++) {
				arr[i][k] = Character.getNumericValue(data.charAt(pt));
				pt++;
			}
		}
		int carry = 0;

		pt = 3;
		int row=1;
		for( ;row<arr.length;row++) {
			for (int j = 3; j >= 0; j--) {
				int i=row-1;
				int sum=Integer.parseInt(Integer.toBinaryString(arr[i][j]+ arr[row][j] + carry));
				arr[row][j]= sum%10;
				carry= sum/10;
			}
			while(carry>0) {
				for (int j = 3; j >= 0; j--) {
					
					int sum=Integer.parseInt(Integer.toBinaryString(arr[row][j] + carry));
					arr[row][j]= sum%10;
					carry= sum/10;
					if(carry==0) {
						break;
					}
				}
			}
		}
		
		
		for (int i = 0; i < 4; i++) {
			if (arr[subunitLen - 1][i] == 0) {
				chkSum += '1';
			} else {
				chkSum += '0';
			}

		}

		return chkSum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String data = scan.nextLine();
		int len = data.length();

		String chkSum = checkSum(data, len);
		String newData = chkSum + data;

		System.out.println("Dataword generated at senders side=" + newData);

		System.out.println("Enter the received data: ");

		String recieved = scan.nextLine();

		String newCheckSum = checkSum(recieved, recieved.length());
		if (newCheckSum.equals("0000")) {
			System.out.println("data matched");
		} else {
			System.out.println("error occured");
		}

	}

}
