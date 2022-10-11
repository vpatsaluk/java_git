import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MatrixClass matrix = new MatrixClass();

        boolean matrixExists = false;
        boolean matrixRowExists = false;

        do{

            System.out.println("\n" +
                    "-*-*-*-*-*-*-*-*-*-*-*-\n" +
                    "Головне Меню:");
            System.out.print("1. Створити матрицю\n" +
                    "2. Переглянути матрицю\n" +
                    "3. Заповнити матрицю значеннями\n" +
                    "4. Отримати заданий рядок\n" +
                    "5. Отримати заданий стовпчик\n" +
                    "6. Отримати заданий елемент\n" +
                    "7. Отримати розмірність матриці\n" +
                    "8. Отримати хеш-код матриці\n" +
                    "9. Створити матрицю-строку, заповнену випадковими значеннями\n" +
                    "10. Додавання матриць\n" +
                    "11. Множення матриці на скаляр\n" +
                    "12. Вихід з програми\n" +
                    ">>> ");

            String userChoice = sc.nextLine();

            if(isNumeric(userChoice)) {

                String userInputMatrixCols;
                String userInputMatrixRows;

                switch (Integer.parseInt(userChoice)) {
                    case 1:
                        System.out.print("\n[!] Створення Матриці\n" +
                                "Введіть кількість рядків матриці: ");
                        userInputMatrixRows = sc.nextLine();

                        System.out.print("Введіть кількість стовпців матриці: ");

                        userInputMatrixCols = sc.nextLine();

                        if(isNumeric(userInputMatrixRows) && isNumeric(userInputMatrixCols)){
                            matrix = new MatrixClass(Integer.parseInt(userInputMatrixRows), Integer.parseInt(userInputMatrixCols));
                            System.out.println("\n[+] Матрицю розміром " + userInputMatrixRows + "x" + userInputMatrixCols + " було успішно створено");
                            matrixExists = true;
                        }
                        else{
                            System.out.println("\n[-] Матрицю не було створено: некоректні данні розміру");
                            matrixExists = false;
                        }
                        break;
                    case 2:
                        if(matrixExists) {
                            System.out.println("\n[!] Перегляд матриці\n");
                            matrix.matrixShow();
                        }
                        else System.out.println("\n[-] Матрицю неможливо переглянути. Її не було створено");

                        break;
                    case 3:
                        if(matrixExists) {

                            boolean continueFilling = true;

                            do {
                                System.out.print("\n[!] Заповнення матриці\n\n" +
                                        "Оберіть бажаний спосіб заповнення матриці:\n" +
                                        "1. Заповнити вручну поелементно\n" +
                                        "2. Заповнити вручну порядково\n" +
                                        "3. Заповнити матрицю згенерованими елементами\n" +
                                        "4. Вийти з заповнення матриці\n" +
                                        ">>> ");

                                String matrixFillingMode = sc.nextLine();

                                if(isNumeric(matrixFillingMode)){
                                    int matrixFillingModeInteger = Integer.parseInt(matrixFillingMode);
                                    if(1 <= matrixFillingModeInteger && matrixFillingModeInteger <= 4){
                                        if(matrixFillingModeInteger == 4) continueFilling = false;
                                        else{
                                            matrix.matrixFilling(matrixFillingModeInteger);
                                            continueFilling = false;
                                            System.out.println("\n[+] Матрицю було успішно заповнено");
                                        }
                                    }

                                }

                                else System.out.println("[-] Обрано некоректний номер. Повторіть спробу ще раз");

                            } while (continueFilling);
                        }

                        else System.out.println("\n[-] Матрицю неможливо заповнити. Її не було створено");

                        break;
                    case 4:
                        if(matrixExists) {
                            String userLine;

                            System.out.println("\n[!] Отримати заданий рядок\n");

                            do {
                                System.out.print("Введіть рядок(від 0 до n) який бажаєте отримати -> ");

                                userLine = sc.nextLine();
                                if (isNumeric(userLine)) {
                                    matrix.matrixGetRow(Integer.parseInt(userLine));
                                    break;
                                }
                                else System.out.println("\n[-] Обрано некоректний номер рядка. Повторіть спробу ще раз\n");
                            } while (true);
                        }
                        else System.out.println("\n[-] Обрати номер рядка неможливо. Матрицю не було створено");

                        break;
                    case 5:
                        if(matrixExists) {
                            String userCol;

                            System.out.println("\n[!] Отримати заданий стовпець\n");

                            do {
                                System.out.print("Введіть стовпець(від 0 до n) який бажаєте отримати -> ");

                                userCol = sc.nextLine();
                                if (isNumeric(userCol)) {
                                    matrix.matrixGetCol(Integer.parseInt(userCol));
                                    break;
                                }
                                else System.out.println("\n[-] Обрано некоректний номер стовпця. Повторіть спробу ще раз\n");
                            } while (true);
                        }
                        else System.out.println("\n[-] Обрати номер стовпця неможливо. Матрицю не було створено");
                        break;
                    case 6:
                        if(matrixExists){
                            String userRow;
                            String userCol;

                            System.out.println("\n[!] Отримати заданий елемент\n");

                            do {
                                System.out.print("Введіть стовпець(від 0 до n) який бажаєте отримати -> ");

                                userCol = sc.nextLine();

                                System.out.print("Введіть рядок(від 0 до n) який бажаєте отримати -> ");

                                userRow = sc.nextLine();
                                if (isNumeric(userRow) && isNumeric(userCol)) {
                                    matrix.matrixGetElement(Integer.parseInt(userCol), Integer.parseInt(userRow));
                                    break;
                                }
                                else System.out.println("\n[-] Обрано некоректний номер рядка чи стовпця елемента. Повторіть спробу ще раз\n");

                            } while (true);
                        }
                        else System.out.println("\n[-] Обрати елемент неможливо. Матрицю не було створено");
                        break;
                    case 7:
                        if(matrixExists){
                            int[] matrixSize = matrix.matrixGetSize();
                            System.out.println("\n[!] Отримати розмірність матриці\n");

                            System.out.println("Матриця розмірністю " + matrixSize[0] + "x" + matrixSize[1]);

                            System.out.println("\n[+] Розмірність матриці отримано");
                        }
                        else System.out.println("\n[-] Отримати розмірність матриці неможливо. Матрицю не було створено");
                        break;
                    case 8:
                        if(matrixExists){
                            System.out.println("\n[!] Отримати хеш-код матриці\n");
                            System.out.println("Хеш-код матриці -> " + matrix.matrixHashCode());
                            System.out.println("\n[+] Хеш-код матриці отримано");
                        }
                        else System.out.println("\n[-] Отримати розмірність матриці неможливо. Матрицю не було створено");
                        break;
                    case 9:
                        String rowMatrixSize;

                        System.out.println("\n[!] Створити матрицю-строку, заповнену випадковими значеннями\n");
                        do {
                            System.out.print("Введіть довжину матриці-строки >>> ");

                            rowMatrixSize = sc.nextLine();

                            if(!isNumeric(rowMatrixSize)) System.out.println("\n[-] Введено некоректний розмір матриці-строки. Повторіть спробу ще раз\n");

                        }while(!isNumeric(rowMatrixSize));

                        matrix.rowMatrix(Integer.parseInt(rowMatrixSize));

                        matrixRowExists = true;

                        System.out.println("\n[+] Матрицю-строку було успішно створено");

                        break;
                    case 10:
                        float[][] matrixToTest1 = {{(float) -2.3, 4, 53}, {-43, (float) 4.65, 32}};
                        float[][] matrixToTest2 = {{(float) -0.4, (float)15.2, 8}, {12, 34, -14}, {-1, -2, 3}};
                        float[] matrixToTest3 = {1, 2, 3, 4};

                        if(matrixExists || matrixRowExists){

                            String userChoiceAdding;
                            int addingMode = 0;

                            System.out.println("\n[!] Додавання матриць\n");
                            do {
                                System.out.print("Оберіть до якої матриці бажаєте виконати додавання:\n" +
                                        "1. Матриця\n" +
                                        "2. Матриця-строка\n" +
                                        ">>> ");
                                userChoiceAdding = sc.nextLine();

                                if(!isNumeric(userChoiceAdding) || (isNumeric(userChoiceAdding) && (Integer.parseInt(userChoiceAdding) > 2 || Integer.parseInt(userChoiceAdding) < 1)))
                                    System.out.println("\n[-] Обрано некоректний номер. Спробуйте ще раз\n");
                                else addingMode = Integer.parseInt(userChoiceAdding);
                            }while (!isNumeric(userChoiceAdding));

                            if(addingMode == 1 && matrixExists) {
                                float[] arrayEmpty = {};
                                matrix.matrixAdding(matrixToTest1, arrayEmpty, addingMode);
                            }
                            else if(addingMode == 2 && matrixRowExists){
                                float[][] arrayEmpty = {};
                                matrix.matrixAdding(arrayEmpty, matrixToTest3, addingMode);
                            }
                            else System.out.println("\n[-] Матрицю не було створено. Додавання матриць є неможливим");
                        }
                        else System.out.println("\n[-] Матрицю не було створено. Додавання матриць є неможливим");

                        break;
                    case 11:
                        if(matrixExists || matrixRowExists){
                            String scalar;
                            String userChoiceScalar;
                            int scalarMode = 0;

                            System.out.println("\n[!] Множення матриці на скаляр\n");

                            do {
                                System.out.print("Оберіть яку матрицю бажаєте помножити на скаляр:\n" +
                                        "1. Матриця\n" +
                                        "2. Матриця-строка\n" +
                                        ">>> ");
                                userChoiceScalar = sc.nextLine();

                                if(!isNumeric(userChoiceScalar) || (isNumeric(userChoiceScalar) && (Integer.parseInt(userChoiceScalar) > 2 || Integer.parseInt(userChoiceScalar) < 1)))
                                    System.out.println("\n[-] Обрано некоректний номер. Спробуйте ще раз\n");
                                else scalarMode = Integer.parseInt(userChoiceScalar);
                            }while (!isNumeric(userChoiceScalar));

                            do{
                                System.out.print("\nВведіть скаляр, на який буде помножено матрицю >>> ");

                                scalar = sc.nextLine();

                                if(!isNumericFloat(scalar))
                                    System.out.println("\n\n[-] Скаляр введено некоректно. Спробуйте ще раз");

                            }while (!isNumericFloat(scalar));

                            if(scalarMode == 1 && matrixExists) matrix.matrixScalar(Float.parseFloat(scalar), scalarMode);
                            else if(scalarMode == 2 && matrixRowExists) matrix.matrixScalar(Float.parseFloat(scalar), scalarMode);
                            else System.out.println("\n[-] Матрицю не було створено. Множення матриці на скаляр є неможливим");
                        }
                        else System.out.println("\n[-] Матрицю не було створено. Додавання матриць є неможливим");

                        break;
                    case 12:
                        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-\n" +
                                "[+] Роботу програми завершено");
                        return;
                    default:
                        System.out.println("[-] Обрано некоректний номер. Повторіть спробу ще раз");
                }

            }
            else System.out.println("[-] Обрано некоректний номер. Повторіть спробу ще раз");

        }   while (true);

//        MatrixClass matrix = new MatrixClass(3, 3);
//        matrix.matrixFilling(2);
//        MatrixClass matrixToTest = new MatrixClass(matrix.getMatrix());
//
//        matrix.matrixShow();
//
//        System.out.println();
//        matrixToTest.matrixShow();


//        MatrixClass matrix = new MatrixClass(3, 3);
//        matrix.matrixShow();
//        matrix.matrixFilling(2);
//        MatrixClass matrixToTest = new MatrixClass(3, 3);
//        matrixToTest.matrixShow();
//        matrixToTest.matrixFilling(2);
//        matrix.matrixEquals(matrixToTest);

//        GenericMatrix<Float> matrix = new GenericMatrix<Float>(Float.class, 2, 2);
//        matrix.matrixShow();
//        matrix.matrixFilling(0, 0 , 1F);
//        matrix.matrixFilling(0, 1, 2F);
//        matrix.matrixFilling(1, 0, 3F);
//        matrix.matrixFilling(1, 1, 4F);
//        matrix.matrixShow();
//        matrix.matrixGetElement(0, 1);
//        matrix.matrixGetRow(1);
//        System.out.println();
//        matrix.matrixGetCol(0);
    }

    public static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
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
