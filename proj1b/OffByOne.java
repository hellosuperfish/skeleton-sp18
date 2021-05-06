public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        char a = Character.toLowerCase(x);
        char b = Character.toLowerCase(y);
        if (a - b == 1 || b - a == 1) {
            return true;
        }
        return false;
    }
}
