/*
An English text needs to be encrypted using the following encryption scheme.
First, the spaces are removed from the text. Let  be the length of this text.
Then, characters are written into a grid, whose rows and columns have the following constraints:


The problem-statement can be accessed using following link --->
https://www.hackerrank.com/challenges/encryption
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        //remove spaces from line
        s=s.replace(" ","");
        String ans="";
        int t=0;

        //calculate number of rows and columns 
        int r=(int)Math.sqrt(s.length());
        int c=r+1;
        if(r*r==s.length())
        c=r;
        if(r*c<s.length()){
          r++;
        if(r*c<s.length()){
          c++;
        }
        }
        //create array of characters 
        char [][]arr=new char[r][c];
       A: for(int i=0;i<r;i++){
        B:    for(int j=0;j<c;j++){
                if(s.length()==t)
                break A;
                arr[i][j]=s.charAt(t);
                t++;
            }
        }
        t=0;
        //print it column wise after adding spaces 
       A: for(int i=0;i<c;i++){
        B:    for(int j=0;j<r;j++){
                if(arr[j][i]=='\u0000')
                continue;
                if(s.length()==t)
                break A;
                ans+=arr[j][i];
                t++;
            }
            ans+=" ";
        }        
    return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
