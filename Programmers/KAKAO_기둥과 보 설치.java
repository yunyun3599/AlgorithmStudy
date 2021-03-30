import java.util.*;
class Solution {
    
    static ArrayList<Frame> list = new ArrayList<>();
    
    public int[][] solution(int n, int[][] build_frame) {
        //[x, y, a, b]
        //x,y는 좌표
        //a가 0이면 기둥 1이면 보
        //b가 0이면 삭제 1이면 설치
        
        for(int i=0; i<build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
        
            if(b==0){
                list.remove(new Frame(x,y,a));
                if(!isDelete(x , y)) list.add(new Frame(x, y, a));
            }
            else{
                if(a==0){
                    if(isMakeColumn(x,y)) list.add(new Frame(x,y,a));
                }
                else{
                    if(isMakeBeam(x,y)) list.add(new Frame(x,y,a));
                }
            }
        }
        
        int[][] result = new int[list.size()][3];
        
        int i=0;
        for(Frame frame : list){
            result[i][0] = frame.x;
            result[i][1] = frame.y;
            result[i][2] = frame.type;
            i++;
        }
        Arrays.sort(result, (o1, o2) -> {
            if(o1[0] == o2[0]){
                if(o1[1] == o2[1]){
                    return o1[2]-o2[2];
                }
                else {
                    return o1[1] - o2[1];
                }
            }
            else return o1[0]-o2[0];
        });
        
        return result;
    }
    
    public boolean isMakeColumn(int x, int y){
        if(y==0 || list.contains(new Frame(x, y-1, 0)) || list.contains(new Frame(x-1, y, 1)) || list.contains(new Frame(x, y, 1)))
            return true;
        else return false;
    }
    
    public boolean isMakeBeam(int x, int y){
        if(list.contains(new Frame(x, y-1, 0)) || list.contains(new Frame(x+1, y-1, 0)) || (list.contains(new Frame(x-1, y, 1)) && list.contains(new Frame(x+1, y, 1)))) return true;
        else return false;
    }
    
    
    public boolean isDelete(int x, int y){
        for(Frame frame : list){
            if(frame.type==0){
                if(!isMakeColumn(frame.x,frame.y)) return false;
            }
            else if(!isMakeBeam(frame.x, frame.y)) return false;
        }
        return true;
    }
}

class Frame{
    int x;
    int y;
    int type;
    Frame(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Frame frame = (Frame)obj;
        if(x==frame.x && y==frame.y && type == frame.type) return true;
        else return false;
    }
}