import java.io.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] countS = new int[26];
        int[] countT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            countT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int ans = 0;
            ans += Math.abs(countS[i] - countT[i]);
            if (!(ans == 0)) return false;
        }
        return true;
    }
}