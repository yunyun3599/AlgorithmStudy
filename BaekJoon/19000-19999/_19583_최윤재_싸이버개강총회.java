package tmp;
import java.util.*;
import java.io.*;
public class _19583_������_���̹�������ȸ {

	static String start;	//���۽ð�
	static String end;		//������ �ð�
	static String streaming_end;	//��Ʈ���� ������ �ð�
	static HashSet<String> people = new HashSet<>();	//������ �л��� �־�δ� �ؽ���
	static int result;	//�⼮ ������ �ο���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = st.nextToken();	
		end = st.nextToken();
		streaming_end = st.nextToken();
		//////////////////////////////////////////////////�Է�
		String input = "";
		while((input = br.readLine()) != null ) {	//�Է��� �ִ� ���� �ݺ�
			st = new StringTokenizer(input, " ");
			String time = st.nextToken();	//ä�ýð�
			String id = st.nextToken();		//ä�� ���̵�
			if(time.compareTo(start) <= 0) people.add(id);	//���� ���� �ð� �̳��� �ؽ��ʿ� ����
			else if(time.compareTo(end)>=0 && time.compareTo(streaming_end)<=0) {	//���۽ð��� ������ ȸ���� ���� ���ð��� �����Ǵ��� Ȯ��
				if(people.contains(id)) {
					result++;
					people.remove(id);
				}
			}
		}
		System.out.println(result);
	}

}
