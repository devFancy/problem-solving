class Solution {
    public String solution(int[] food) {
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            int share = food[i] / 2;
            builder.append(String.valueOf(i).repeat(share));
        }
        String answer = builder + "0";
        return answer + builder.reverse();
    }
}