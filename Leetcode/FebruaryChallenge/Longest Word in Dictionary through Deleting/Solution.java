/*
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.
*/


class Solution {
    
    public String findLongestWord(String s, List<String> d) {
        char[] arr=s.toCharArray();
        Collections.sort(d,(a,b)->a.length()==b.length()?a.compareTo(b):b.length()-a.length());
        
        for(String p:d){
            int itr=0;
            for(int i=0;i<s.length();i++){
                if(p.charAt(itr)==s.charAt(i))
                    itr++;
                if(itr==p.length())
                    return p;
            }
        }
        return "";
    }
}
