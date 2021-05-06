public class MostPalindromeByN {
    public static void main(String[] args) {
        MostPalindromeByN mpbn = new MostPalindromeByN();
        int mostPalindromeN = mpbn.countPalindromeBy();
        String longest = mpbn.longestPalindrome();
        System.out.println("For the N of " + mostPalindromeN + ", there is"
                + " most palindromes in English");
        System.out.println("the longest offByN palindrome is " + longest);


    }

    public int countPalindromeBy() {
        int mostCount = 0;
        int mostByN = 0;

        for (int i = 0; i < 26; i++) {
            int count = 0;
            OffByN obn = new OffByN(i);

            In in = new In("../library-sp18/data/words.txt");
            Palindrome palindrome = new Palindrome();

            while (!in.isEmpty()) {
                String word = in.readString();
                if (palindrome.isPalindrome(word, obn)) {
                    count += 1;
                }
            }
            if (count > mostCount) {
                mostCount = count;
                mostByN = i;
            }
        }

        return mostByN;
    }

    public String longestPalindrome() {
        int longestLength = 0;
        String longestWord = null;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (palindrome.isPalindrome(word)) {
                if (longestWord == null || longestLength < word.length()) {
                    longestWord = word;
                    longestLength = word.length();
                }
            }
        }

        return longestWord;
    }

}
