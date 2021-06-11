/*
Absolute Permutation:
The problem-statement can be accessed using following link --->
https://www.hackerrank.com/challenges/absolute-permutation
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
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static List<Integer> absolutePermutation(int n, int k) {
    // Write your code here
    int i=1;
    ArrayList<Integer> r=new ArrayList<Integer>(); 
    ArrayList<Integer> t=new ArrayList<Integer>();
    for (i=1;i<n+1;i++){
        r.add(i);
        t.add(0);      
    }
    
     // if absolute difference is zero it means same list needs to be returned.
    if(k==0)
    return r;
    // if absolute permutation is not possible then -1 needs to be returned.
    if(n%(2*k)!=0){
        t.clear();
        t.add(-1);
        return t;
    } 
    // make absolute permutation using given difference k. 
    //consider array n[ 1 to 12 ] and case I: k=2 ,case II: k=3 
      
    //case | [1 2 3 4 5 6 7 8 9 10 11 12]
    //k=2  | [3 4 1 2 7 8 5 6 11 12 9 10]
    //k=3  | [4 5 6 1 2 3 10 11 12 7 8 9]
    for (i=1;i<n+1;i++){
        if(t.get(i-1)==0){
        t.set(i-1,i+k);
        t.set(i+k-1,i);            
        }

    }  
    return t;                     
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
