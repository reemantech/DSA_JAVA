package arrays;

import java.util.Scanner;

public class ContainerWIthMostWater {
	static int ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ans =0;
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int height[] = new int[n];
		for(int i=0;i<n;i++) {
			height[i] = sc.nextInt();
		}
		containerWithMostWater(height);
		
		System.out.println(ans);
	}
	public static void containerWithMostWater(int arr[]) {
		int l = 0, r = arr.length-1;
		
		// arr[i] = height, length = r-l+1 , water = length*min(arr[l],arr[r]) 
		
		while(l<r) {
			int area = Math.min(arr[l], arr[r])* (r-l);
			ans = Math.max(area,ans);
			if(arr[l]<= arr[r]) {
				
				l++;
			}else {
				r--;
			}
		}
 		
	}
}
