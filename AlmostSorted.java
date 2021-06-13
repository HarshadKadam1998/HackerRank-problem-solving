/*
Almost Sorted:
The problem-statement can be accessed using following link --->
https://www.hackerrank.com/challenges/almost-sorted
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
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
    // Write your code here
    //create sorted copy of array list for comparison purpose
    List<Integer> sortedArr=new ArrayList<Integer>();
    sortedArr.addAll(arr);
    Collections.sort(sortedArr);
    int l=0,r=0;

    //check if arraylist is already sorted or not
    if(sortedArr.equals(arr)==true){
        System.out.println("yes");
        return;
    }
    
    //find left and right index for swap and reverse operation
    for(int i=0;i<arr.size()-1;i++){
        if(arr.get(i)>arr.get(i+1)){
            l=i;
            break;
        }
    }
    for(int i=arr.size()-1;i>=0;i--){
        if(arr.get(i)<arr.get(i-1)){
            r=i;
            break;
        }
    }

    //create temporary array list for operation purpose
    List<Integer> tempArr=new ArrayList<Integer>();
    tempArr.addAll(arr); 
       
    // perform swap operaion
    Collections.swap(tempArr,l,r);
    if(sortedArr.equals(tempArr)==true){
        System.out.println("yes");
        System.out.println("swap "+(l+1)+" "+(r+1));
        return;
    }

    // perform reverse operaion  on sublist
    tempArr.clear();
    tempArr.addAll(arr); 
    int t=l;   
    for(int i=r;i>=l;i--){
        tempArr.set(t++,arr.get(i));
    }
    if(sortedArr.equals(tempArr)==true){
        System.out.println("yes");
        System.out.println("reverse "+(l+1)+" "+(r+1));
        return;
    }
    
    System.out.println("no");      
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}

