package week2;

import java.util.*;

public class Yoonjae_2630 {
	static int white, blue;
	static int arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc. nextInt();
		
		arr = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		check(0,n,0,n);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void check(int xstart, int xend, int ystart, int yend) {
		int standard=arr[xstart][ystart];
		for (int i=xstart; i<xend;i++) {
			for(int j=ystart; j<yend;j++) {
				if (arr[i][j]==standard) continue; 
				else {
					check(xstart, (xstart+xend)/2, ystart, (ystart+yend)/2);
					check((xstart+xend)/2, xend, ystart, (ystart+yend)/2);
					check(xstart, (xstart+xend)/2, (ystart+yend)/2, yend);
					check((xstart+xend)/2, xend, (ystart+yend)/2, yend);
					return;
				}
			}
		}
		if (arr[xstart][ystart]==1) blue++;
		else white++;
	}
}
