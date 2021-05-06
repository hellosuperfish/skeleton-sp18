public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    //iterative method
    /*
    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Palindrome P = new Palindrome();
        Deque<Character> pDeck = P.wordToDeque(word);
        int wordLength = pDeck.size();
        for (int i = 0; i < wordLength / 2; i++) {
            if (pDeck.get(i) != pDeck.get(wordLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }

     */

    //recursive method
    public boolean isPalindrome(String word) {
        Palindrome P = new Palindrome();
        Deque<Character> pDeck = P.wordToDeque(word);
        return isPalindromeHelper(pDeck);
    }

    private boolean isPalindromeHelper(Deque<Character> D) {
        if (D.size() == 0 || D.size() == 1) {
            return true;
        } else {
            return ((D.removeFirst() == D.removeLast()) && isPalindromeHelper(D));
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Palindrome P = new Palindrome();
        Deque<Character> pDeck = P.wordToDeque(word);
        int wordLength = pDeck.size();
        while (pDeck.size() > 1) {
            if (!cc.equalChars(pDeck.removeFirst(), pDeck.removeLast())) {
                return false;
            }
        }
        return true;
    }


}
