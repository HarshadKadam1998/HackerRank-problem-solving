/*
3D Surface Area:
The problem-statement can be accessed using following link --->
https://www.hackerrank.com/challenges/3d-surface-area
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
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
    // Write your code here
    
    //calculcate height and weight of 3D surafce  area
    int H=A.size();
    int W=A.get(0).size();
    int i=0,j=0;
    
    // create temporary list for avoiding negative value of surface 
    // for  this we will be havinng 0 at outer row and outer column of matrix
    int tlist[][]=new int[H+2][W+2];
    
    for(i=0;i<H+2;i++){
        for(j=0;j<W+2;j++){
        tlist[i][j]=0;
    }
    }

    for(i=1;i<H+1;i++){
        for(j=1;j<W+1;j++){
        tlist[i][j]=A.get(i-1).get(j-1);
    }
    }  
    
    //calculate surface area of top and bottom of toy      
    int ans = 2*H*W;
    
    //calculate surface area of all other 4 sites
    for(i=1;i<H+1;i++){
        for(j=1;j<W+1;j++){
            if  (tlist[i][j]>tlist[i-1][j])
                ans+=tlist[i][j]-tlist[i-1][j];
            if  (tlist[i][j]>tlist[i+1][j]) 
                ans+=tlist[i][j]-tlist[i+1][j];
            if  (tlist[i][j]>tlist[i][j-1]) 
                ans+=tlist[i][j]-tlist[i][j-1]; 
            if  (tlist[i][j]>tlist[i][j+1]) 
                ans+=tlist[i][j]-tlist[i][j+1];     }
    }

    return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
