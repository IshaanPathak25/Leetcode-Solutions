class Solution {
    public int longestSquareStreak(int[] nums) {
        int maxNum = 0;
        for (int num : nums)  if (num > maxNum)  maxNum = num;
        
        boolean[] used = new boolean[maxNum + 1];
        for (int num : nums)  used[num] = true;
        
        int squareLimit = (int)Math.ceil(Math.sqrt(maxNum + 1));
        int maxStreak = -1;
        for (int i = 2; i < squareLimit; i++) {
            if (used[i] && used[i * i]) {
                int curStreak = 2;
                int curVal = i * i;
                while (curVal <= squareLimit && used[curVal * curVal]) {
                    curStreak++;
                    curVal *= curVal;
                }
                if (curStreak > maxStreak)  maxStreak = curStreak;
            }
        }
        
        return maxStreak;
    }
}
