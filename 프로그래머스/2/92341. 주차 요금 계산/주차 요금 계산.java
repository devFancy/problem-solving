import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {

        // key: 차랑번호, value: 입장 시간 / parking: 주차장
        Map<Integer, Integer> parking = new HashMap<>();

        // key: 차량번호, value: 누적된 요금 / costs: 요금 정산 (TreeMap()으로 키 (차량번호) 기준 오름차순 정렬)
        Map<Integer, Integer> costs = new TreeMap<>();
        
        // 주차기록 처리하기(time: 시간 / carName: 차량 번호 / carHistory: 내역)
        for(String data : records) {
            String[] record = data.split(" ");
            int time = CalculationTime(record[0]);
            int carName = Integer.parseInt(record[1]);
            String carHistory = record[2];

            if(carHistory.equals("IN")) {
                parking.put(carName, time);
            }

            if(carHistory.equals("OUT")) {
                // 한번 들어왔던 차가 아니라면
                if(!costs.containsKey(carName)) {
                    costs.put(carName, time - parking.get(carName));
                } else {
                    costs.put(carName, costs.get(carName) + time - parking.get(carName));
                }
                parking.remove(carName);
            }
        }
        
        // 아직 출차하지 않은 차 계산
        if(!parking.isEmpty()) {
            for(Integer carName: parking.keySet()) {
                Integer cost = costs.get(carName);
                cost = (cost == null) ? 0 : cost;
                costs.put(carName, cost + (23 * 60 + 59) - parking.get(carName));
            }
        }

        // 출력하기
        int[] answer = new int[costs.size()];
        int stdTime = fees[0];
        int stdPay = fees[1];
        int perTime = fees[2];
        int perPay = fees[3];
        
        int i = 0;
        for(int cost : costs.keySet()) {
            int time = costs.get(cost);

            if(time <= stdTime) {
                time = stdPay;
            } else {
                time = stdPay + (int)Math.ceil((double)(time - stdTime)/perTime) * perPay;
            }
            answer[i] = time;
            i++;
        }
        return answer;
    }
    private int CalculationTime(String time) {
        String[] temp = time.split(":"); // 05:34	
        int hour  = Integer.parseInt(temp[0]) * 60;
        int minutes = Integer.parseInt(temp[1]);
        return hour + minutes;
    }
}