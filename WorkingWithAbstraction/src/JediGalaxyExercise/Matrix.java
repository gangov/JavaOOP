package JediGalaxyExercise;

public class Matrix {
    private int row;
    private int col;
    private int[][] matrix;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrix = new int[row][col];
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int returnNumber(int row, int col) {
        return this.matrix[row][col];
    }

    public void setMatrix(int row, int col) {
        this.matrix[row][col] = 0;
    }

    public void fillTheMatrix() {
        int value = 0;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
