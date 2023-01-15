class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        List<Integer[]>[] charToWords = new List[26];
         for (int i = 0; i < 26; i++) charToWords[i] = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = word.charAt(0);
            charToWords[c - 'a'].add(new Integer[]{i, 1});
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer[]> wordList = charToWords[c - 'a'];
            charToWords[c - 'a'] = new ArrayList<>();
            for (Integer[] x : wordList) {
                int wordIndex = x[0], indexInWord = x[1];
                if (indexInWord == words[wordIndex].length()) {
                    count++;
                } else {
                    charToWords[words[wordIndex].charAt(indexInWord) - 'a'].add(new Integer[]{wordIndex, indexInWord + 1});
                }
            }
        }
        return count;
}
}