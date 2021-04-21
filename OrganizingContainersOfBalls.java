/*
David has several containers, each with a number of balls in it. He has just enough containers to sort each type of ball he has into its own container. David wants to sort the balls using his sort method.
David wants to perform some number of swap operations such that:
-Each container contains only balls of the same type.
-No two balls of the same type are located in different containers.

The problem-statement can be accessed using following link --->
https://www.hackerrank.com/challenges/organizing-containers-of-balls
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int[]containerCapacity=new int[container.length];
        int[]typeValue=new int[container.length];

        for(int i=0;i<container.length;i++){
            int capacity=0,type=0;
            for(int j=0;j<container.length;j++)
            {
                capacity=capacity+container[i][j];
                type=type+container[j][i];
            }
            containerCapacity[i]=capacity;
            typeValue[i]=type;

        }

        Arrays.sort(containerCapacity);
        Arrays.sort(typeValue);

        for(int i=0;i<container.length;i++)
        if(containerCapacity[i]!=typeValue[i])
            return "Impossible";

    return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
