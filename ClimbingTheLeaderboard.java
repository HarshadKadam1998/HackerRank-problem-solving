/*
An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense Ranking, so its leaderboard works like this:
The player with the highest score is ranked number 1 on the leaderboard.
Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.

The problem-statement can be accessed using following link --->

https://www.hackerrank.com/challenges/climbing-the-leaderboard

*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
      /*  int temp[][]=new int[scores.length+1][2];
        int rank[]=new int[alice.length];
        int t=0;

        for(int i=0;i<alice.length;i++)
        {
            for(int j=0;j<scores.length;j++)
            {
              temp[j][0]= scores[j];
              temp[j][1]=1;
            }
              temp[scores.length][0]= alice[t];//
              temp[scores.length][1]=1;          
            
            int tempVar;
            for (int k = 0; k < temp.length; k++) 
            {
                for (int l = k + 1; l < temp.length; l++) 
                {
                    if (temp[k][0] < temp[l][0]) 
                    {
                    tempVar = temp[l][0];
                    temp[k][0] = temp[l][0];
                    temp[l][0] = tempVar;
                    }
                }
            }
  
            for(int s=0;s<temp.length-1;s++)
            {

                if(temp[s][0]==temp[s+1][0])
                {
                    temp[s+1][1]=temp[s][1];
                }
                else
                {
                    temp[s+1][1]=temp[s][1]+1;
                }

            }

        for(int s=0;s<temp.length;s++)
            {
                if(alice[t]==temp[s][0])
                {
                    rank[t]=temp[s][1];
                    t++;
                    break;
                }

            }

        }

    return rank;*/

    int rank[]=new int[scores.length];
    int res[]=new int[alice.length];

    rank[0]=1;
    for(int i=1;i<scores.length;i++){
        if(scores[i]==scores[i-1]){
            rank[i]=rank[i-1] ;
        }
        else{
            rank[i]=rank[i-1]+1 ;
        }

    }

    for(int i=0;i<alice.length;i++){
        int aliceScore=alice[i];
        if(aliceScore>scores[0]){
            res[i]=1;
        }
        else if(aliceScore<scores[scores.length-1]){
            res[i]=rank[rank.length-1]+1;
        }
        else{
            int index=findRank(scores,aliceScore);
            res[i]=rank[index];
        }

    }
    return res;
    }

    static int findRank(int scores [],int aliceScore){

        int l=0,r=scores.length-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(scores[mid]==aliceScore){
                return mid;
            }
            if(scores[mid]<aliceScore && scores[mid-1]>aliceScore){
                return mid;
            }
            if(scores[mid]>aliceScore && scores[mid+1]<aliceScore){
                return mid+1;
            }            
             if(scores[mid]>aliceScore){
                l=mid+1;
            }           
            if(scores[mid]<aliceScore){
                r=mid-1;
            }
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
