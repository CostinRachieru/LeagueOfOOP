package hero;

public class Coordinates {
    private int line;
    private int row;

    public Coordinates() {
        line = -1;
        row = -1;
    }
    public Coordinates(int line, int row) {
        this.line = line;
        this.row = row;
    }

    public int getLine() {
        return line;
    }

    public int getRow() {
        return row;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
