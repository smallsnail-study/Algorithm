import java.util.Arrays;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int[] cntArr = new int[2001];
        
        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i] + 1000]++;
        }

        Arrays.sort(cntArr);
        for (int i = 0; i < cntArr.length-1; i++) {
            if (cntArr[i] > 0 && cntArr[i] == cntArr[i+1]) return false;
        }
        return true;
    }
}