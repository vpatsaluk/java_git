import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {

    int add(String numbers){
        if(numbers.isEmpty()) return 0;

        if(numbers.contains("\\n") || numbers.contains(",")) {
            numbers = numbers.replace("\\n", "\n");

            List<String> delimitersArray = new ArrayList<>();

            if (numbers.startsWith("//")) {
                numbers = numbers.substring(2);

                String[] temp1 = numbers.split("]\n");

                String delimiterPart = numbers.substring(0, temp1[0].length() + 1);

                int index_in = 0;
                int index_out = 0;
                for (int i = 0; i < delimiterPart.length(); i++) {
                    if ((delimiterPart.charAt(i) == '[' && i == 0) || (delimiterPart.charAt(i - 1) != '[' && delimiterPart.charAt(i) == '['))
                        index_in = i + 1;

                    else if ((delimiterPart.charAt(i) == ']' && i == delimiterPart.length() - 1) || (delimiterPart.charAt(i) == ']' && delimiterPart.charAt(i + 1) != ']')) {
                        index_out = i - 1;
                        delimitersArray.add(delimiterPart.substring(index_in, index_out + 1));
                    }
                }
                numbers = temp1[1];
            }

            delimitersArray.add(",");
            delimitersArray.add("\n");

            for (int i = 0; i < delimitersArray.size() - 1; ++i) {
                for (int j = 0; j < delimitersArray.size() - i - 1; ++j) {
                    if (delimitersArray.get(j + 1).length() > delimitersArray.get(j).length()) {
                        String swap = delimitersArray.get(j + 1);
                        delimitersArray.set(j + 1, delimitersArray.get(j));
                        delimitersArray.set(j, swap);
                    }
                }
            }

            for (int i = 0; i < delimitersArray.size(); i++) {
                numbers = numbers.replaceAll("\\Q" + delimitersArray.get(i) + "\\E", ",");
            }

            if (numbers.contains(",,"))
                throw new IllegalArgumentException("Помилка: Два дільники підряд або невідомий дільник");

            String[] numbersArray = numbers.split(",");

            int sum = 0;
            List<String> negativeNumbers = new ArrayList<>();

            for (int i = 0; i < numbersArray.length; i++) {;
                if (isNumeric(numbersArray[i])){
                    if (Integer.parseInt(numbersArray[i]) < 1001)
                        sum += Integer.parseInt(numbersArray[i]);
                    if (Integer.parseInt(numbersArray[i]) < 0)
                        negativeNumbers.add(numbersArray[i]);

                }
                else
                    throw new IllegalArgumentException("Помилка: Два дільники підряд або невідомий дільник");
            }

            if (!negativeNumbers.isEmpty())
                throw new IllegalArgumentException("Недозволені від'ємні числа: " + negativeNumbers);

            return sum;
        }

        if(Integer.parseInt(numbers) < 0)
            throw new IllegalArgumentException("Недозволені від'ємні числа: " + numbers);
        if(Integer.parseInt(numbers) > 1000) return 0;

        return Integer.parseInt(numbers);
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
}

class MainClass{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть рядок:");
        String inputNumbers = sc.nextLine();

        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.add(inputNumbers));
    }
}