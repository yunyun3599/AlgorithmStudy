package week15;
import java.io.*;
public class _6198_최윤재_옥상정원꾸미기 {

	static int num;
	static int[] building;
	static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		building = new int[num];
		for(int i=0; i<num; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<num; i++) {
			for(int j=i+1; j<num; j++) {
				if (building[i] > building[j]) {
					result++;
				}
				else break;
			}
		}
	System.out.println(result);
	}
}
