class Solution {
    public char findKthBit(int n, int k) {
        int rev = 0;
        int len = (1 << n) - 1;

        while (k>1) {
            if(k == len/2+1)
            return rev % 2 == 0 ? '1' : '0';

            if(k > len/2) {
                k = len + 1 - k;
                rev++;
            }
            len /= 2;
        }
        return rev % 2 == 0 ? '0' : '1';
    }
}