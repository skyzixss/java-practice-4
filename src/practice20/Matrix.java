package practice20;
import java.util.Arrays;
public class Matrix<T extends Number> {
    private final Number[][] data;
    public Matrix(T[][] values) {
        if (values == null || values.length == 0 || values[0] == null || values[0].length == 0)
            throw new IllegalArgumentException("Матрица пуста");
        int cols = values[0].length; data = new Number[values.length][cols];
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null || values[i].length != cols) throw new IllegalArgumentException("Матрица должна быть прямоугольной");
            for (int j = 0; j < cols; j++) data[i][j] = java.util.Objects.requireNonNull(values[i][j]);
        }
    }
    public int rows() { return data.length; }
    public int columns() { return data[0].length; }
    public double get(int row, int col) { return data[row][col].doubleValue(); }
    public Matrix<Double> add(Matrix<? extends Number> other) { return combine(other, 1); }
    public Matrix<Double> subtract(Matrix<? extends Number> other) { return combine(other, -1); }
    private Matrix<Double> combine(Matrix<? extends Number> other, int sign) {
        if (rows() != other.rows() || columns() != other.columns()) throw new IllegalArgumentException("Размеры не совпадают");
        Double[][] result = new Double[rows()][columns()];
        for (int i=0;i<rows();i++) for(int j=0;j<columns();j++) result[i][j]=get(i,j)+sign*other.get(i,j);
        return new Matrix<>(result);
    }
    public Matrix<Double> multiply(Matrix<? extends Number> other) {
        if (columns() != other.rows()) throw new IllegalArgumentException("Несовместимые размеры");
        Double[][] result = new Double[rows()][other.columns()];
        for(int i=0;i<rows();i++) for(int j=0;j<other.columns();j++) {
            double sum=0; for(int k=0;k<columns();k++) sum += get(i,k)*other.get(k,j); result[i][j]=sum;
        }
        return new Matrix<>(result);
    }
    public Matrix<Double> transpose() {
        Double[][] result = new Double[columns()][rows()];
        for(int i=0;i<rows();i++) for(int j=0;j<columns();j++) result[j][i]=get(i,j);
        return new Matrix<>(result);
    }
    public String toString() { return Arrays.deepToString(data); }
}
