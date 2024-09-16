class Solution {
    int start = 0;
    int end = 0;

    public String longestPalindrome(String s) {
        char arr[] = s.toCharArray();
        getpalindrome(arr, 0);
        return s.substring(start, end + 1);
    }

    public void getpalindrome(char arr[], int i) {
        int left = i;
        int right = i;
        int n = arr.length;
        if (i >= n - 1) {
            return;
        }
        
        while (right < n - 1 && arr[right] == arr[right + 1]) {
            right++;
        }
        i = right;

        while (left > 0 && right < n - 1 && arr[left - 1] == arr[right + 1]) {
            left--;
            right++;
        }

        if (right - left > end - start) {
            start = left;
            end = right;
        }

        getpalindrome(arr, i + 1);
    }
}
