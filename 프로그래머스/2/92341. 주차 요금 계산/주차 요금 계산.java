import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> inTime = new HashMap<>();
        HashMap<String, Integer> totalTime = new HashMap<>();

        for(int i = 0; i < records.length; i++){
            
        }
        
        for (String record : records) {
            String[] info = record.split(" ");

            int time = getMinute(info[0]);
            String carNumber = info[1];
            String type = info[2];

            if (type.equals("IN")) {
                inTime.put(carNumber, time);
            } else {
                int parkedTime = time - inTime.get(carNumber);

                if (totalTime.containsKey(carNumber)) {
                    totalTime.put(carNumber, totalTime.get(carNumber) + parkedTime);
                } else {
                    totalTime.put(carNumber, parkedTime);
                }

                inTime.remove(carNumber);
            }
        }

        for (String carNumber : inTime.keySet()) {
            int parkedTime = 23 * 60 + 59 - inTime.get(carNumber);

            if (totalTime.containsKey(carNumber)) {
                totalTime.put(carNumber, totalTime.get(carNumber) + parkedTime);
            } else {
                totalTime.put(carNumber, parkedTime);
            }
        }

        ArrayList<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            int time = totalTime.get(cars.get(i));

            if (time <= fees[0]) {
                answer[i] = fees[1];
            } else {
                int extraTime = time - fees[0];
                int extraFee = (extraTime + fees[2] - 1) / fees[2] * fees[3];

                answer[i] = fees[1] + extraFee;
            }
        }

        return answer;
    }

    static int getMinute(String time) {
        String[] temp = time.split(":");

        int hour = Integer.parseInt(temp[0]);
        int minute = Integer.parseInt(temp[1]);

        return hour * 60 + minute;
    }
}