package NowCoder;

public class Vivo_3_productPhone {
    public static void main(String[] args){
        System.out.println(solution(11));
    }
    public static int solution (int n) {
        int sum = 0;
        int daySum = 0;
        int day = 1;
        while(daySum<n){
            sum += day*day;
            daySum += day;
            day++;
        }
        int diarDay = daySum-n;
        sum -= diarDay*(day-1);
        return sum;
    }
}
