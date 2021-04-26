/*
Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.
Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
-It must be greater than the original word
-It must be the smallest word that meets the first condition

The problem-statement can be accessed using following link --->
https://www.hackerrank.com/challenges/bigger-is-greater/
*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char arr[] =w.toCharArray(),temp;
        // replace last min char by right  hand side min char of array
        int pt=0,l=0,min;
        for(int i=arr.length-1;i>=0;i--){
            if(i==0){
                return "no answer";
            }
            if(arr[i]>arr[i-1]){
                pt=i-1;
                l=i;
                break;
            }
        }
        min=pt+1;
        for(int i=w.length()-1;i>l;i--){
            if(arr[min]>arr[i] && arr[pt]<arr[i]){
            min=i;
            }
        }
        temp=arr[pt];
        arr[pt]=arr[min];
        arr[min]=temp;

        Arrays.sort(arr,pt+1,arr.length);
        w=new String(arr);
        return w;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
