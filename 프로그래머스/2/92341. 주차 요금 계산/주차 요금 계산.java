import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> parking = new HashMap<>();
        Map<Integer, Integer> costs = new TreeMap<>();

        for (String data : records) {
            processParkingRecord(data, parking, costs);
        }

        calculateUnexitedCars(parking, costs);

        return calculateCosts(costs, fees);
    }

    private void processParkingRecord(String data, Map<Integer, Integer> parking, Map<Integer, Integer> costs) {
        String[] record = data.split(" ");
        int time = CalculationTime(record[0]);
        int carName = Integer.parseInt(record[1]);
        String carHistory = record[2];

        if (carHistory.equals("IN")) {
            parking.put(carName, time);
        }

        if (carHistory.equals("OUT")) {
            processCarExit(time, carName, costs, parking);
        }
    }

    private void processCarExit(int time, int carName, Map<Integer, Integer> costs, Map<Integer, Integer> parking) {
        if (!costs.containsKey(carName)) {
            costs.put(carName, time - parking.get(carName));
        } else {
            costs.put(carName, costs.get(carName) + time - parking.get(carName));
        }
        parking.remove(carName);
    }

    private void calculateUnexitedCars(Map<Integer, Integer> parking, Map<Integer, Integer> costs) {
        if (!parking.isEmpty()) {
            for (Integer carName : parking.keySet()) {
                Integer cost = costs.get(carName);
                cost = (cost == null) ? 0 : cost;
                costs.put(carName, cost + (23 * 60 + 59) - parking.get(carName));
            }
        }
    }

    private int[] calculateCosts(Map<Integer, Integer> costs, int[] fees) {
        int[] answer = new int[costs.size()];
        int stdTime = fees[0];
        int stdPay = fees[1];
        int perTime = fees[2];
        int perPay = fees[3];

        int i = 0;
        for (int cost : costs.keySet()) {
            int time = costs.get(cost);

            if (time <= stdTime) {
                time = stdPay;
            } else {
                time = stdPay + (int) Math.ceil((double) (time - stdTime) / perTime) * perPay;
            }
            answer[i] = time;
            i++;
        }
        return answer;
    }

    private int CalculationTime(String time) {
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]) * 60;
        int minutes = Integer.parseInt(temp[1]);
        return hour + minutes;
    }
}
