class Solution {

    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> bannedWordsSet = new HashSet<>(
                bannedWords.length + bannedWords.length / 3 + 1);
        for (String bannedWord : bannedWords) {
            bannedWordsSet.add(bannedWord);
        }
        int count = 0;
        for (String word : message) {
            if (bannedWordsSet.contains(word)) {
                count++;
                if (count == 2) {
                    return true;
                }
            }
        }
        return false;
    }

}
