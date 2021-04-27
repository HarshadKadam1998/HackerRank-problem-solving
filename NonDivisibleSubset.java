/*
Given a set of distinct integers, print the size of a maximal subset of s where the sum of any 2 numbers in s' is not evenly divisible by k.

The problem-statement can be accessed using following link --->
https://www.hackerrank.com/challenges/non-divisible-subset/problem
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
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    int arr[]=new int[k],ans=0;

    for (Integer i: s){
        arr[i.intValue()%k]++;
    } 
    if(arr[0]>0)
    {
    ans++;
    }
    for(int i=1;i<k;i++){
        if(arr[i]==0)
        continue;
        if((i+i)==k){
        ans++;
        }
        else{
            if(arr[i]<arr[k-i]){
                ans+=arr[k-i];
                }
                else{
                ans+=arr[i];                          
            }
            arr[i]=0;
            arr[k-i]=0;
        }
    }
    /*
    5 1
1 2 3 4 5
    */
return ans;
}
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
