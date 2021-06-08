/*
Append and Delete:
The problem-statement can be accessed using following link --->
https://www.hackerrank.com/challenges/append-and-delete/problem
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
    if ((s.length()+ t.length())<k){
        return "Yes"; 
    }
    
    int ans =0;
    int i=0,tmp=0,flag=0;
    int n=Math.min(s.length(),t.length());
    while(i<n){
        if (s.charAt(i)!=t.charAt(i)){
            tmp=i;
            while(i<s.length())
            {
                ans++;
                i++;
            }
            i=tmp;
            while(i<t.length())
            {
                ans++;
                i++;
                flag=1;
            }
            break;
            
        }
        
        i++;
    }
    
    if( flag!=1)
    if(i==n){
            tmp=i;
            while(i<s.length())
            {
                ans++;
                i++;
            }
            i=tmp;
            while(i<t.length())
            {
                ans++;
                i++;
            }       
    }


    if(ans<=k){
        if((k-ans)%2==0){
            return "Yes";
        }else{
            return "No";
        }
    }else{
        return "No";
    }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
