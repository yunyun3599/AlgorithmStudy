package week3;
import java.util.*;
public class Yoonjae_1449 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int tape= sc. nextInt();
		int result = 0;
		
		int arr[] = new int[num];
		
		for (int i=0; i<num;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		float cover=0;
		if(num>0) {
			cover=arr[0]-0.5f;
			result++;
		}
		
		for(int i=1; i<num ; i++) {
			if (arr[i]+0.5<=cover+tape) continue;
			else {
				if (cover+tape<arr[i]-0.5f) {
					result++;
					cover=arr[i]-0.5f;
				}
				else {
					result++;
					cover=cover+tape;
				}
				if(cover+tape>=1000) break;
			}
		}
		System.out.println(result);
	}

}
