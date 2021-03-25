package week12;
import java.io.*;
import java.util.*;
public class _6487_������_�������Ǳ������� {

	static int testcase = 0;													//�׽�Ʈ ���̽� ����
	static StringBuilder result = new StringBuilder();							//��� ������ StringBuilder
	static float gradient1, gradient2, y_intercept1, y_intercept2;				//�Լ��� ����, y����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int[] x = new int[4];
			int[] y = new int[4];
			for(int j=0; j<4; j++) {
				x[j] = Integer.parseInt(st.nextToken());
				y[j] = Integer.parseInt(st.nextToken());
			}
			//////////////////////////////////////////////////////////////////////�Է�
			boolean vertical1 = false, vertical2 = false;						//x�࿡ ������ ����� ��� vertical������ true�� �ٲ���
			//ù��° �Լ�
			if(y[0] == y[1]) {													//y���� ���� �� (x�࿡ ����)
				gradient1 = 0;													//���� 0
				y_intercept1 = y[0];											//y������ �Էµ� y��
			}
			else {						
				if(x[0] == x[1]) {												//x�࿡ ������ ���
					vertical1=true;
				}
				else {															//x�࿡ ������ ���൵ �ƴ� ���
					gradient1 = (float)(y[1]-y[0]) / (x[1]-x[0]);				//����
					y_intercept1 = (float)y[0] - gradient1 * x[0];				//y����
				}
			}
			//�ι�° �Լ�
			if(y[2] == y[3]) {													//x�࿡ ������ ���
				gradient2 = 0;													//���� 0
				y_intercept2 = y[2];											//y���� y����
			}
			else {				
				if(x[2] == x[3]) {												//x�࿡ ������ ���
					vertical2 = true;
				}
				else {															//x�࿡ ������ ���൵ �ƴ� ���
					gradient2 = (float)(y[3]-y[2]) / (x[3]-x[2]);				//����
					y_intercept2 = (float)y[2] - gradient2 * x[2];				//y����
				}
			}
			
			
			if (vertical1 && vertical2){										//�� �Լ��� ��� x�࿡ ������ ���
				if (x[0] == x[2] ) {
					result.append("LINE\n");
				}
				else result.append("NONE\n");									//NONE
				continue;
			}
			else if (vertical1) {												//1�� �Լ��� x�࿡ ������ ���
				float x_value = (float)x[0];	
				float y_value = gradient2 * x[0] + y_intercept2;				//�ش� x���� ���� y�� ����
				result.append(String.format("POINT %.2f %.2f\n", x_value, y_value));
				continue;
			}
				
			else if (vertical2) {												//2���Լ��� x�࿡ ������ ���
				float x_value = (float)x[2];
				float y_value = gradient1 * x[2] + y_intercept1;
				result.append(String.format("POINT %.2f %.2f\n", x_value, y_value));
				continue;
			}
																			
			if (gradient1 == gradient2) {										//�� �Լ��� ���Ⱑ ���� ���
				if (y_intercept1 == y_intercept2) result.append("LINE\n");		//LINE
				else result.append("NONE\n");									//NONE
			}
			else {																//�� �Լ��� ���Ⱑ �ٸ� ���
				float x_point = (y_intercept2 - y_intercept1) / (gradient1 - gradient2);
				float y_point = gradient1 * x_point + y_intercept1;
				result.append(String.format("POINT %.2f %.2f\n", x_point, y_point));
			}
		}
		System.out.println(result);
	}
}
