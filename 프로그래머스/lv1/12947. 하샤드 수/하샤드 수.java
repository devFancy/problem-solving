class Solution {
    public boolean solution(int num) {
        String[] temp = String.valueOf(num).split("");

        int sum = 0;
        for (String s : temp) {
            sum += Integer.parseInt(s);
        }

        if (num % sum == 0) {
                return true;
        } else {
          return false;
        }
    }
}