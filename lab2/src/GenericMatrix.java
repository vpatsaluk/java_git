public class GenericMatrix<T>{

    public T[][] genericMatrix;

    Class<T> type;

    GenericMatrix(Class<T> dataType, int cols, int rows){
        this.genericMatrix = (T[][]) java.lang.reflect.Array.newInstance(dataType, rows, cols);
    }

    public void matrixShow(){
        for(int i = 0; i < this.genericMatrix.length; i++){
            for(int j = 0; j < this.genericMatrix[i].length; j++){
                System.out.print(this.genericMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void matrixFilling(int col, int row,T object){
        this.genericMatrix[row][col] = object;
    }

    public void matrixGetRow(int row){
        for(int i = 0; i < this.genericMatrix.length; i++)
            System.out.print(this.genericMatrix[row][i] + " ");
    }

    public void matrixGetCol(int col){
        for(int i = 0; i < this.genericMatrix[0].length; i++)
            System.out.println(this.genericMatrix[i][col]);
    }

    public void matrixGetElement(int col, int row){
        System.out.println(this.genericMatrix[row][col]);
    }

    public void matrixGetSize(){
        System.out.println(this.genericMatrix.length + "x" + this.genericMatrix[0].length);
    }
}
