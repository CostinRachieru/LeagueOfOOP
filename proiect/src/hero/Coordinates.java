package hero;

public final class Coordinates {
    private int line;
    private int row;

    public Coordinates() {
        line = -1;
        row = -1;
    }
    public Coordinates(final int line, final int row) {
        this.line = line;
        this.row = row;
    }

    public int getLine() {
        return line;
    }

    public int getRow() {
        return row;
    }

    public void setLine(final int line) {
        this.line = line;
    }

    public void setRow(final int row) {
        this.row = row;
    }
}
