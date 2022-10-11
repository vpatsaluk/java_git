import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MatrixClass {
    float[][] matrix;
    float[] rowMatrix;

    public MatrixClass(){
        matrix = new float[0][0];
    }

    public MatrixClass(int rows, int cols){
        matrix = new float[rows][cols];
    }

    public MatrixClass(float[][] matrixToCopy){
        this.matrix = new float[matrixToCopy.length][matrixToCopy[0].length];

        for(int i = 0; i < this.matrix.length; i++){
            for(int j = 0; j < this.matrix[i].length; j++){
                this.matrix[i][j] = matrixToCopy[i][j];
            }
        }
    }


    public void matrixShow(){
        for(int i = 0; i < this.matrix.length; i++){
            for(int j = 0; j < this.matrix[i].length; j++){
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void matrixFilling(int mode){
        Scanner sc = new Scanner(System.in);
        String elementToFill;
        boolean incorrectElementToFill;
        if(this.matrix.length != 0 && this.matrix[0].length != 0){
            System.out.print("\n");
            switch (mode){
                case 1:
                    for(int i = 0; i < this.matrix.length; i++){
                        for(int j = 0; j < this.matrix[i].length; j++){
                            do {
                                System.out.print("Введіть елемент [" + i + "]" + "[" + j + "] = ");
                                elementToFill = sc.nextLine();
                                if (isNumericFloat(elementToFill)) {
                                    this.matrix[i][j] = Float.parseFloat(elementToFill);
                                    incorrectElementToFill = false;
                                }
                                else {
                                    System.out.println("[-] Некоректний формат введення елементу [" + i + "]" + "[" + j + "]. Введіть його ще раз");
                                    incorrectElementToFill = true;
                                }
                            }while (incorrectElementToFill);
                        }
                    }
                    break;
                case 2:
                    String[] arrayForLine;
                    System.out.println("\n[!] Порядкове введення матриці\n" +
                            "Вводьте матрицю порядково (пробіли між елементами), кількість елементів в одному рядку -> " + this.matrix[0].length);
                    for(int i = 0; i < this.matrix.length; i++){
                        boolean continueFilling = false;
                        do {
                            System.out.print("Введіть рядок [" + i + "] ->");
                            arrayForLine = sc.nextLine().split(" ");
                            if (arrayForLine.length != matrix[i].length) {
                                System.out.println("[-] Введена неправильна кількість елементів. Потрібно ввести -> " + this.matrix[0].length + " елементів");
                                continueFilling = true;
                            }
                            else{
                                for(int j = 0; j < arrayForLine.length; j++){
                                    if(!isNumericFloat(arrayForLine[j])){
                                        System.out.println("[-] Рядок містить некоректний елемент. Введіть рядок ще раз");
                                        continueFilling = true;
                                        break;
                                    }
                                    else continueFilling = false;
                                }

                                if(!continueFilling){
                                    for(int j = 0; j < this.matrix[i].length; j++){
                                        this.matrix[i][j] = Float.parseFloat(arrayForLine[j]);
                                    }
                                }
                            }
                        }while (continueFilling);
                    }
                    break;
                case 3:
                    Random random = new Random();

                    System.out.println("[!] Генерація елементів для матриці розміром " + this.matrix.length + "x" + this.matrix[0].length);

                    for(int i = 0; i < this.matrix.length; i++){
                        for(int j = 0; j < this.matrix[i].length; j++){
                            this.matrix[i][j] = random.nextFloat(100);
                        }
                    }

                    break;
            }
        }
        else System.out.println("\n[-] Матриця розміром 0х0 пуста. Її неможливо заповнити");
    }

    public void matrixGetRow(int row){
        if(this.matrix.length != 0 && this.matrix[0].length != 0){
            if(0 <= row && row <= this.matrix.length - 1){
                System.out.print("Рядок " + row + "-ий -> ");
                for(int i = 0; i < this.matrix[row].length; i++){
                    System.out.print(this.matrix[row][i] + " ");
                }
                System.out.println("\n\n[+] Рядок отримано");
            }
            else System.out.println("\n[-] Обрано некоректний номер рядка. Оберіть рядок на проміжку 0 <= рядок < " + this.matrix.length);
        }
        else System.out.println("\n[-] Матриця розміром 0х0 пуста. Неможливо отримати рядок");
    }

    public void matrixGetCol(int col){
        if(this.matrix.length != 0 && this.matrix[0].length != 0){
            if(0 <= col && col <= this.matrix[0].length - 1){
                System.out.print("Стовпець " + col + "-ий ->\n");
                for(int i = 0; i < matrix.length; i++){
                    System.out.println(this.matrix[i][col]);
                }
                System.out.println("\n[+] Стовпець отримано");
            }
            else System.out.println("\n[-] Обрано некоректний номер рядка. Оберіть рядок на проміжку 0 <= стовпець < " + this.matrix[0].length);
        }
        else System.out.println("\n[-] Матриця розміром 0х0 пуста. Неможливо отримати стовпець");
    }

    public void matrixGetElement(int col, int row){
        if(this.matrix.length != 0 && this.matrix[0].length != 0){
            if((0 <= col && col <= this.matrix[0].length - 1) && (0 <= row && row <= this.matrix.length - 1)){
                System.out.print("Елемент [" + col + "]" + "[" + row + "]" + "-> ");
                System.out.println(this.matrix[col][row]);
                System.out.println("\n[+] Елемент отримано");
            }
            else System.out.println("\n[-] Обрано некоректний номер елемента. Оберіть елемент на проміжку 0 <= рядок < " + this.matrix.length + " 0 <= стовпець < " + this.matrix[0].length);
        }
        else System.out.println("\n[-] Матриця розміром 0х0 пуста. Неможливо отримати елемент");
    }

    public void rowMatrix(int length){
        if(0 < length){
            Random random = new Random();
            rowMatrix = new float[length];
            for(int i = 0; i < length; i++)
                this.rowMatrix[i] = random.nextFloat(100);

            showRowMatrix(this.rowMatrix);
        }
        else System.out.println("\n[-] Обрано некоректний розмір матриці-строки. Оберіть розмір на проміжку 0 < length");
    }

    public void showRowMatrix(float[] rowMatrixToShow){
        System.out.println();
        for(int i = 0; i < rowMatrixToShow.length; i++)
            System.out.print(rowMatrixToShow[i] + " ");
    }

    public void matrixAdding(float[][] matrixToAdd, float[] matrixToAddRow, int mode){
        if(mode == 1) {
            if(this.matrix.length != 0 && this.matrix[0].length != 0) {
                if (matrixToAdd.length != this.matrix.length || matrixToAdd[0].length != this.matrix[0].length)
                    System.out.println("\n[-] Неможливо додати матриці різних розмірів");
                else {
                    for (int i = 0; i < this.matrix.length; i++)
                        for (int j = 0; j < this.matrix[i].length; j++)
                            this.matrix[i][j] += matrixToAdd[i][j];

                    System.out.println("\n[+] Матриці було успішно додано. Переглянути результат у розділі \"2.Переглянути матрицю\"");
                }
            }
            else System.out.println("\n[-] Матриця розміром 0х0 пуста. Неможливо додати матриці");
        }
        else{
            if(matrixToAddRow.length != this.rowMatrix.length)
                System.out.println("\n[-] Неможливо додати матриці різних розмірів");
            else{
                for(int i = 0; i < this.rowMatrix.length; i++)
                    this.rowMatrix[i] += matrixToAddRow[i];

                showRowMatrix(this.rowMatrix);

                System.out.println("\n\n[+] Матриці було успішно додано");
            }
        }
    }

    public void matrixScalar(float scalar, int mode){
        if(mode == 1){
            if(this.matrix.length != 0 && this.matrix[0].length != 0){
                for(int i = 0; i < this.matrix.length; i++){
                    for(int j = 0; j < this.matrix[i].length; j++)
                        this.matrix[i][j] *= scalar;
                }

                System.out.println("\n[+] Матрицю було успішно помножено на скаляр. Переглянути результат у розділі \"2.Переглянути матрицю\"");
            }
            else System.out.println("\n[-] Матриця розміром 0х0 пуста. Неможливо помножити на скаляр");
        }
        else{
            for(int i = 0; i < this.rowMatrix.length; i++)
                this.rowMatrix[i] *= scalar;

            showRowMatrix(this.rowMatrix);

            System.out.println("\n\n[+] Матрицю було успішно помножено на скаляр");
        }
    }

    public int[] matrixGetSize(){
        if(matrix.length == 0) return new int[]{0, 0};
        return new int[]{matrix.length, matrix[0].length};
    }

    public int matrixHashCode(){
        return Arrays.hashCode(this.matrix);
    }

    public float[][] getMatrix(){
        return this.matrix;
    }

    public void matrixEquals(Object matrixToEqual){
        if(matrixToEqual.getClass() != this.getClass())
            System.out.println("\n[-] Матриці не є однаковими");
        else{
            boolean continueCheck = true;

            MatrixClass matrixToEqualMut = (MatrixClass) matrixToEqual;
            if(matrixToEqualMut.getMatrix().length != this.matrix.length || matrixToEqualMut.getMatrix()[0].length != this.matrix[0].length)
                System.out.println("\n[-] Матриці не є однаковими");
            else{
                for(int i = 0; i < this.matrix.length; i++){
                    if(continueCheck) {
                        for (int j = 0; j < this.matrix[i].length; j++) {
                            if (matrixToEqualMut.getMatrix()[i][j] != this.matrix[i][j]) {
                                System.out.println("\n[-] Матриці не є однаковими");
                                continueCheck = false;
                                break;
                            }
                        }
                    }
                }

                if(continueCheck) System.out.println("\n[+] Матриці є однаковими");
            }
        }

    }

    public static boolean isNumericFloat(String str){
        try{
            Float.parseFloat(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

}
