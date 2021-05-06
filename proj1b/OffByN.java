public class OffByN implements CharacterComparator {

    int offBy;

    public OffByN(int N) {
        this.offBy = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == offBy || y - x == offBy){
            return true;
        }
        return false;
    }


}
