package BroadView;

import java.util.Arrays;

public class ex17_bigDataOperation {
    public static void main(String[] args){
        PrintToMaxOfDigits(3);
    }
    public static void PrintToMaxOfDigits(int n){
        if (n<=0)
            return;
        char[] number = new char[n];
        for (int i=0;i<number.length;i++)
            number[i]='0';
        while (!Increment(number))
            PrintNumber(number);
    }
    public static boolean Increment(char[] number){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i=nLength-1;i>=0;i--){
            int nSum = number[i]-'0'+nTakeOver;
            if (i==nLength-1)
                nSum++;
            if (nSum>=10){
                if (i==0)
                    isOverflow=true;
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char)(nSum+'0');
                }
            }
            else {
                number[i] = (char)(nSum+'0');
                break;
            }
        }
        return isOverflow;
    }
    public static void PrintNumber(char[] number){
        boolean isBegining = true;
        int nLength = number.length;
        for (int i=0;i<nLength;i++){
            if (isBegining && number[i]!='0')
                isBegining=false;
            if (!isBegining)
                System.out.print(number[i]);
        }
        System.out.println();
    }
}

