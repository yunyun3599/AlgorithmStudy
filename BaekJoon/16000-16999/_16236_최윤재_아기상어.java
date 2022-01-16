package tmp;
import java.util.*;
public class _16236_최윤재_아기상어 {
    
    static int base_min;
    static int base_cost;
    static int unit_min;
    static int unit_cost;
    static HashMap<String, Integer> car = new HashMap<>();
    static HashMap<String, String> startTime = new HashMap<>();

	public static void main(String[] args) {
//		HashMap<String, ArrayList> warning = new HashMap<>();
//		String user = ".";
//        warning.put(user, new ArrayList<>());
//        System.out.println(362/10);
//        System.out.println(warning.size());
		//solution(new int[]{1, 461, 1, 10}, new String[] {"00:00 1234 IN", "00:01 2345 IN"});
		StringBuilder sb = new StringBuilder();
        int current = 1000000;
        while(current > 0){
            sb.append(current%3);
            current = current/3;
        }
        System.out.println(sb.reverse().toString());
        StringTokenizer st;
        String str = "10000010";
        String[] dd = str.split("0");
        for(int i=0; i<dd.length; i++) {
        	if(!dd[i].equals(""))
        		System.out.println("d"+dd[i]);
        }
        st = new StringTokenizer(str,"0");
        while(st.hasMoreTokens()) System.out.println(st.nextToken());
	}
    
    public static int[] solution(int[] fees, String[] records) {
        base_min = fees[0];
        base_cost = fees[1];
        unit_min = fees[2];
        unit_cost = fees[3];
        
        for(int i=0; i<records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i], " ");
            String time = st.nextToken();
            String carNum = st.nextToken();
            String type = st.nextToken();
            if(type.equals("IN")){
                startTime.put(carNum, time);
            }
            else{
                String inTime = startTime.remove(carNum);
                st = new StringTokenizer(inTime, ":");
                int inHour = Integer.parseInt(st.nextToken());
                int inMin = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(time, ":");
                int outHour = Integer.parseInt(st.nextToken());
                int outMin = Integer.parseInt(st.nextToken());
                int totalMin = outHour*60 + outMin - inHour*60 - inMin;
                if(car.containsKey(carNum)){
                    car.put(carNum, car.get(carNum)+totalMin);
                }
                else{
                    car.put(carNum, totalMin);
                }
            }
        }
        for(String key : startTime.keySet()){
            String inTime = startTime.remove(key);
            System.out.println(key);
            StringTokenizer st = new StringTokenizer(inTime, ":");
            int inHour = Integer.parseInt(st.nextToken());
            int inMin = Integer.parseInt(st.nextToken());
            int outHour = 23;
            int outMin = 59;
            int totalMin = outHour*60 + outMin - inHour*60 - inMin;
            if(car.containsKey(key)){
                car.put(key, car.get(key)+totalMin);
            }
            else{
                car.put(key, totalMin);
            }
        }
        int answer[] = new int[car.size()];
        int idx = -1;
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>(car);
        Iterator<String> keyIterator = tm.keySet().iterator();
        while(keyIterator.hasNext()){
            idx++;
            String carnum = keyIterator.next();
            int totalMin = tm.get(carnum);
            int totalCost = 0;
            if(totalMin <= base_min){
                totalCost = base_cost;
                answer[idx] = totalCost;
                continue;
            }
            totalCost += base_cost;
            int restMin = totalMin - base_min;
            if (restMin%unit_min == 0){
                totalCost += (restMin/unit_min) * unit_cost;
                answer[idx] = totalCost;
                continue;
            }
            else{
                totalCost += (restMin/unit_min+1) * (unit_cost);
                answer[idx] = totalCost;
            }
        }
        return answer;
    }
}
