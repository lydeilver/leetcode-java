package com.lydeliver.algorithm;

/**
 * @ClassName NumberToString
 * @Author jonathan
 * @Date 2018/11/6 11:56 AM
 * @Version 1.0
 * @Description TODO
 */
public class NumberToString {
    static String [] digits = {"one","two","three","four","five","six","seven","eight","night"};

    static String [] teens={"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

    static String[] tens={"ten","twenty","thirty","forty","fifty","sixty","seventy","ninety"};

    static String [] bigs={"","thousand","million","billion"};

    public String numsToString100(int num) {
        StringBuffer res = new StringBuffer();

        if (num % 100 > 0) {
            res.append(digits[num/100-1]).append(" hundred ").append(" and ");
            num=num%100;
        }
        if (num > 19) {
            res.append(tens[num/10-1]).append(" ").append(digits[num%10-1]);
        } else if (num > 10) {
            res.append(teens[num%10-1]);
        } else if (num == 10) {
            res.append(tens[0]);
        } else{
            res.append(digits[num-1]);
        }
        return res.toString();
    }

    public String numToString(int num) {
        if (num == 0) {
            return "zero";
        } else if (num < 0) {
            return "Negative" + numToString(-1 * num);
        }

        int count=0;
        String str = "";
        while (num > 0) {
            if (num % 1000 > 0) {
                str = numsToString100(num % 1000) +" "+bigs[count]+" "+ str;
                count++;
                num/=1000;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        NumberToString numberToString = new NumberToString();
        System.out.println(numberToString.numToString(129834667));
    }
}
