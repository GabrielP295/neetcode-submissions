class Solution {
    /*
    Input: two strings s and t
    Output: shortest substring of s where every char from t is present
    - t can include duplicates
    - the output will be guranteed to have a single unique output(no ties)
    - If all chars in t aren't all present in s, then return ""

    Approach:
    - If t.length > s.length then return ""
    - HashMap for constant lookup time -> HashMap<Character, Integer(frequency of char)>
    - First populate hashmap with all chars in t tracking frequency
    - Iterate through s, and check against our map at every char
    - Sliding window, and once a possible substring is found we stop the left side, and continue
    moving right by 1
    - For every char from t found in s, decrement frequency in hashmap, then check if every value
    in the map is equal to zero -> valid substring
    - Once a valid substring is found, add to a validSubstrings array
    - If a value that's trying to be decremented is at 0, and all other values at 0 as well, then
    new valid substring
    */
    public String minWindow(String s, String t) {
       
    }
}
