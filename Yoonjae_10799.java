package week2;
import java.util.*;

public class Yoonjae_10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		
		int count=0;
		int pipe=0;
		
		for(int i=0; i<input.length;i++) {
			if(input[i]=='('&&input[i+1]==')') {
				count+=pipe;
				i++;
			}
			else if(input[i]=='(') {
				pipe++;
				count++;
			}
			else {
				pipe--;
			}
		}
	System.out.println(count);
	}

}
