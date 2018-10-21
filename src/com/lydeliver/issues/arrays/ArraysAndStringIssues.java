package com.lydeliver.issues.arrays;

import java.util.Arrays;

/**
 * @ClassName ArraysAndStringIssues
 * @Author jonathan
 * @Date 2018/10/15 2:47 PM
 * @Version 1.0
 * @Description 数组和字符串问题
 *
 * 程序员面试金典 （第五版）
 */
public class ArraysAndStringIssues {


    /**
     * 确定字符串所有字符都不相同
     * @param str
     * @return
     */
    public boolean vaild(String str){

        if (str.length() == 0) {
            return true;
        }
        char [] cStr = str.toCharArray();
        Arrays.sort(cStr);

        for(int i=1;i<cStr.length;i++){
            if(cStr[i-1] == cStr[i]){
                return false;
            }
        }
        return true;
    }


    public boolean vaild2(String str){

        if(str.length()>256)
            return false;

        //注意不可用封装类型Boolean创建，否则会使数组初始化都为null
        boolean [] flag = new boolean[256];

        for(int i=0;i<str.length();i++){
            if(flag[str.charAt(i)]){
                return false;
            }else{
                flag[str.charAt(i)] = true;
            }
        }

        return true;
    }


    /**
     * 变位词问题
     * @param s
     * @param t
     * @return
     */
    public boolean permutation(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        return sort(s).equals(t);

    }

    /**
     * 空格替换'%20' 问题
     * @param str
     * @return
     */
    public String instead(String str){
        char [] result = new char[str.length()];
        str=str.trim();
        int j=0;
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);
            if(tmp == ' '){
                result[j++] = '%';
                result[j++] = '2';
                result[j++] = '0';
            }else{
                result[j++]=  tmp;
            }
        }
        return new String(result);
    }


    private String sort(String str){
        char [] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    /**
     * 压缩字符串 aabccccaaa变成a2b1c5a3
     * @param str
     * @return
     */
    public String compressBad(String str){
        StringBuffer sb = new StringBuffer();
        int k=1;
        char ch=str.charAt(0);

        for(int i=1;i<str.length();i++){
            if(ch!=str.charAt(i)){
                sb.append(ch).append(k);
                k=1;
                ch=str.charAt(i);
            }else{
                k++;
            }
        }

        sb.append(ch).append(k);

        if(sb.toString().length() == str.length())
            return str;
        return sb.toString();
    }


    /**
     * N*N 矩阵旋转
     * @param param
     * @param n
     */

    public void rotate(int [][] param ,int n) {


        for (int i = 0; i < n / 2; i++) {
            int first = i;
            int last = n - 1 - i;
            for (int j = first; j < last; j++) {
                int offset = j - first;
                int top = param[first][j];

                param[first][j] = param[last - offset][first];

                param[last - offset][first] = param[last][last - offset];

                param[last][last - offset] = param[j][last];

                param[j][last] = top;

            }

        }

    }


    /**
     * 如果MN的矩阵 某个元素为0，则所在的行或者列清0
     * 只需要记录哪行哪列为0即可，第二次遍历的时候在把他们变成0
     * @param matrix
     */
    public void setZeros(int [][] matrix){

        boolean [] rows = new boolean[matrix.length];
        boolean [] colums = new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows[i]=true;
                    colums[j]=true;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rows[i] || colums[j]){
                    matrix[i][j]=0;
                }
            }
        }


    }



    public static void main(String[] args) {
        ArraysAndStringIssues a = new ArraysAndStringIssues();
        System.out.println(a.compressBad("aabbccdd"));



    }
}
