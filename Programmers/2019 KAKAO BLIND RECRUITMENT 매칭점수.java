import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.LinkedList;

class Solution {
    
    static double[][] score;//[페이지인덱스][0]=기본점수, [페이지인덱스][1]=링크점수
    static String[] link;   //자신의 링크 string
    static int[] outgoing;  //외부 링크 개수
    static LinkedList<String>[] outgoingLink;   //외부 링크 주소
    static int answer = 0;	//최종 결과
    static double maxval = 0;	//가장 큰 점수값(int하면 틀림.... 나도 알고 싶지 않았지)
    
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        score = new double[pages.length][2];   //기본점수, 매칭점수
        link = new String[pages.length];
        outgoing = new int[pages.length];
        outgoingLink = new LinkedList[pages.length]; 
        for(int i=0; i<pages.length; i++){
            String page = pages[i];
            int default_score = 0;
            page = page.toLowerCase();
            //////////////////////////////////////////기본 점수 찾기
            int loc = page.indexOf(word);	//찾는 word의 첫 character index
            while(loc!=-1){
                char split1 = page.charAt(loc-1);	//해당 word의 앞뒤 문자가 알파벳이면 안됨
                char split2 = page.charAt(loc+word.length());
                if(!Character.isLowerCase(split1) && !Character.isLowerCase(split2))  //앞뒤 구분자가 영문이 아닐 경우만 기본 점수 1 증가
                    default_score++;
                loc = page.indexOf(word, loc+1);	//방금전 찾은 word의 뒷부분부터 재탐색
            }
            score[i][0] = default_score;	//해당 페이지의 기본 점수 세팅
            ///////////////////////////////////////////자신의 url 찾기
            Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(\\S+)\"/>");	//정규표현식 이용. \S+하면 공백 제외 모든 문자열
            Matcher matcher = pattern.matcher(page);	//위에서 저장한 pattern과 일치하는 부분 찾음
            while(matcher.find()){
                String tmp = matcher.group(1);	//group(1)이면 (\\S+)로 구해진 값만 찾게 됨. group()이면 <meta~~ />까지 전부 찾음
                link[i] = tmp;	//자신의 링크값 위에서 구한 문자열로 저장
            }
            //////////////////////////////////////////////////////////외부 링크 찾기
            outgoingLink[i] = new LinkedList<>();	//외부 링크를 LinkedList를 이용해 저장
            int outgoingnum=0;	//외부 링크 개수
            pattern = Pattern.compile("<a href=\"https://(\\S+)\">");	//정규표현식 이용
            matcher = pattern.matcher(page);
            while(matcher.find()){	//외부 링크들 LinkedList에 add
                String tmp = matcher.group(1);
                outgoingLink[i].add(tmp);
                outgoingnum++;
            }
            outgoing[i] = outgoingnum;	//외부링크 개수 저장
        }
        //////////////////////////////////////////정보 세팅 완료
        for(int i=0; i<pages.length; i++){
            double linkScore = 0;	//링크 점수
            try{
                linkScore = score[i][0]/outgoing[i];	//자신의 기본 점수에 외부 링크 개수 나눔
            }
            catch(Exception e) {
                linkScore = 0;
            }
            for(String incoming : outgoingLink[i]){	//각 외부 링크에 대해 해당 페이지에 링크 점수 더해줌
                for(int j=0; j<pages.length; j++){
                    if(link[j].equals(incoming)){
                        score[j][1] += linkScore;
                        break;
                    }
                }
                
            }
        }
        /////////////////////////////////////////// 링크 점수 계산 완료
        for(int i=0; i<pages.length; i++){	//최대 점수를 갖는 페이지 찾기
            if(score[i][0] + score[i][1] > maxval){
                maxval = score[i][0]+score[i][1];
                answer = i;
            }
        }
    return answer;
    }
}