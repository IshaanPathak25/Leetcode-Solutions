class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int rev = 0;
        if(x >= 0){
            while(x != 0){
                rev = (rev * 10) + (x % 10);
                x = x / 10;
            }
            if(rev == original){
                return true;
            }
            return false;
        }
        return false;
    }
}
