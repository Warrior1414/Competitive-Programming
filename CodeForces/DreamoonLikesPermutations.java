/*
B. Dreamoon Likes Permutations
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
The sequence of m integers is called the permutation if it contains all integers from 1 to m exactly once. The number m is called the length of the permutation.

Dreamoon has two permutations p1 and p2 of non-zero lengths l1 and l2.

Now Dreamoon concatenates these two permutations into another sequence a of length l1+l2. First l1 elements of a is the permutation p1 and next l2 elements of a is the permutation p2.

You are given the sequence a, and you need to find two permutations p1 and p2. If there are several possible ways to restore them, you should find all of them. (Note that it is also possible that there will be no ways.)

Input
The first line contains an integer t (1≤t≤10000) denoting the number of test cases in the input.

Each test case contains two lines. The first line contains one integer n (2≤n≤200000): the length of a. The second line contains n integers a1,a2,…,an (1≤ai≤n−1).

The total sum of n is less than 200000.

Output
For each test case, the first line of output should contain one integer k: the number of ways to divide a into permutations p1 and p2.

Each of the next k lines should contain two integers l1 and l2 (1≤l1,l2≤n,l1+l2=n), denoting, that it is possible to divide a into two permutations of length l1 and l2 (p1 is the first l1 elements of a, and p2 is the last l2 elements of a). You can print solutions in any order.

Example
inputCopy
6
5
1 4 3 2 1
6
2 4 1 3 2 1
4
2 1 1 3
4
1 3 3 1
12
2 1 3 4 5 6 7 8 9 1 10 2
3
1 1 1
outputCopy
2
1 4
4 1
1
4 2
0
0
1
2 10
0
Note
In the first example, two possible ways to divide a into permutations are {1}+{4,3,2,1} and {1,4,3,2}+{1}.

In the second example, the only way to divide a into permutations is {2,4,1,3}+{2,1}.

In the third example, there are no possible ways.
*/


import java.util.*;
public class Main {
    public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);
           int t=sc.nextInt();
        
            while(t-->0){
                int n=sc.nextInt();
                int[] arr=new int[n];
                
                for(int i=0;i<n;i++)
                    arr[i]=sc.nextInt();
                boolean[] leftArr=new boolean[n];
                boolean[] rightArr=new boolean[n];
                int max=Integer.MIN_VALUE;
                Set<Integer> dup=new HashSet();
                for(int i=0;i<n;i++){
                     if(!dup.add(arr[i]))
                        break;
                    max=Math.max(arr[i],max);
                    if(i+1==max)
                        leftArr[i]=true;   
                }
                dup.clear();
                max=Integer.MIN_VALUE;
                for(int i=n-1;i>=0;i--){
                    if(!dup.add(arr[i]))
                        break;
                    max=Math.max(arr[i],max);
                    if(n-i==max)
                        rightArr[i]=true;  
                }
                int res=0;
                for(int i=0;i<n-1;i++){
                    if(leftArr[i] && rightArr[i+1])
                        res++;
                }
               System.out.println(res);
                for(int i=0;i<n-1;i++){
                    if(leftArr[i] && rightArr[i+1])
                        System.out.println((i+1)+" "+(n-i-1));
                }
          }
    }
}
