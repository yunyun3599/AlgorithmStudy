import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.LinkedList;

class Solution {
    
    static double[][] score;//[�������ε���][0]=�⺻����, [�������ε���][1]=��ũ����
    static String[] link;   //�ڽ��� ��ũ string
    static int[] outgoing;  //�ܺ� ��ũ ����
    static LinkedList<String>[] outgoingLink;   //�ܺ� ��ũ �ּ�
    static int answer = 0;	//���� ���
    static double maxval = 0;	//���� ū ������(int�ϸ� Ʋ��.... ���� �˰� ���� �ʾ���)
    
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        score = new double[pages.length][2];   //�⺻����, ��Ī����
        link = new String[pages.length];
        outgoing = new int[pages.length];
        outgoingLink = new LinkedList[pages.length]; 
        for(int i=0; i<pages.length; i++){
            String page = pages[i];
            int default_score = 0;
            page = page.toLowerCase();
            //////////////////////////////////////////�⺻ ���� ã��
            int loc = page.indexOf(word);	//ã�� word�� ù character index
            while(loc!=-1){
                char split1 = page.charAt(loc-1);	//�ش� word�� �յ� ���ڰ� ���ĺ��̸� �ȵ�
                char split2 = page.charAt(loc+word.length());
                if(!Character.isLowerCase(split1) && !Character.isLowerCase(split2))  //�յ� �����ڰ� ������ �ƴ� ��츸 �⺻ ���� 1 ����
                    default_score++;
                loc = page.indexOf(word, loc+1);	//����� ã�� word�� �޺κк��� ��Ž��
            }
            score[i][0] = default_score;	//�ش� �������� �⺻ ���� ����
            ///////////////////////////////////////////�ڽ��� url ã��
            Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(\\S+)\"/>");	//����ǥ���� �̿�. \S+�ϸ� ���� ���� ��� ���ڿ�
            Matcher matcher = pattern.matcher(page);	//������ ������ pattern�� ��ġ�ϴ� �κ� ã��
            while(matcher.find()){
                String tmp = matcher.group(1);	//group(1)�̸� (\\S+)�� ������ ���� ã�� ��. group()�̸� <meta~~ />���� ���� ã��
                link[i] = tmp;	//�ڽ��� ��ũ�� ������ ���� ���ڿ��� ����
            }
            //////////////////////////////////////////////////////////�ܺ� ��ũ ã��
            outgoingLink[i] = new LinkedList<>();	//�ܺ� ��ũ�� LinkedList�� �̿��� ����
            int outgoingnum=0;	//�ܺ� ��ũ ����
            pattern = Pattern.compile("<a href=\"https://(\\S+)\">");	//����ǥ���� �̿�
            matcher = pattern.matcher(page);
            while(matcher.find()){	//�ܺ� ��ũ�� LinkedList�� add
                String tmp = matcher.group(1);
                outgoingLink[i].add(tmp);
                outgoingnum++;
            }
            outgoing[i] = outgoingnum;	//�ܺθ�ũ ���� ����
        }
        //////////////////////////////////////////���� ���� �Ϸ�
        for(int i=0; i<pages.length; i++){
            double linkScore = 0;	//��ũ ����
            try{
                linkScore = score[i][0]/outgoing[i];	//�ڽ��� �⺻ ������ �ܺ� ��ũ ���� ����
            }
            catch(Exception e) {
                linkScore = 0;
            }
            for(String incoming : outgoingLink[i]){	//�� �ܺ� ��ũ�� ���� �ش� �������� ��ũ ���� ������
                for(int j=0; j<pages.length; j++){
                    if(link[j].equals(incoming)){
                        score[j][1] += linkScore;
                        break;
                    }
                }
                
            }
        }
        /////////////////////////////////////////// ��ũ ���� ��� �Ϸ�
        for(int i=0; i<pages.length; i++){	//�ִ� ������ ���� ������ ã��
            if(score[i][0] + score[i][1] > maxval){
                maxval = score[i][0]+score[i][1];
                answer = i;
            }
        }
    return answer;
    }
}