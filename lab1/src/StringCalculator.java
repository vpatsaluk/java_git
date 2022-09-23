import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StringCalculator {

    int add(String numbers){
        if(numbers.isEmpty()) return 0;

        if(numbers.contains("\\n") || numbers.contains(",")){
            numbers = numbers.replace("\\n", "\n");

            List<String> delimitersArray = new ArrayList<>();

            if(numbers.startsWith("//")){
                String[] numbersParts = numbers.split("\n");

                numbersParts[0] = numbersParts[0].substring(2);

                int index_in = 0;
                int index_out = 0;
                for(int i = 0; i < numbersParts[0].length(); i++){
                    if((numbersParts[0].charAt(i) == '[' && i == 0) || (numbersParts[0].charAt(i - 1) != '[' && numbersParts[0].charAt(i) == '['))
                        index_in = i + 1;

                    else if((numbersParts[0].charAt(i) == ']' && i == numbersParts[0].length() - 1) || (numbersParts[0].charAt(i) == ']' && numbersParts[0].charAt(i + 1) != ']')){
                        index_out = i - 1;
                        delimitersArray.add(numbersParts[0].substring(index_in, index_out + 1));
                    }
                }

                numbers = numbers.substring(numbers.indexOf("\n") + 1);
            }

            delimitersArray.add(",");
            delimitersArray.add("\n");

            List<String> delimitersToCheck = new ArrayList<>();

            String tempDel = "";
            for(int i = 0; i < numbers.length(); i++){
                if(!Character.toString(numbers.charAt(i)).equals("-")) {
                    if (!isNumeric(Character.toString(numbers.charAt(i))))
                        tempDel = tempDel.concat(Character.toString(numbers.charAt(i)));

                    if (isNumeric(Character.toString(numbers.charAt(i))) || i == numbers.length() - 1) {
                        delimitersToCheck.add(tempDel);
                        tempDel = "";
                    }
                }
            }

            for(int i = 0; i < delimitersToCheck.size(); i++){
                if(!delimitersArray.contains(delimitersToCheck.get(i)) && !delimitersToCheck.get(i).equals("")){
                    throw new IllegalArgumentException("Помилка: Два роздільника підряд або неіснуючий роздільник");
                }
            }

            List<String> numbersArray = new ArrayList<>();

            while(!numbers.isEmpty()){
                for(int i = 0; i < delimitersArray.size(); i++){
                    String[] temp = numbers.split("\\Q" + delimitersArray.get(i) + "\\E");
                    if(isNumeric(temp[0])){
                        numbersArray.add(temp[0]);
                        if(temp[0].length() + delimitersArray.get(i).length() <= numbers.length())
                            numbers = numbers.substring(temp[0].length() + delimitersArray.get(i).length());
                        else
                            numbers = "";
                    }
                }
            }

            int sum = 0;
            List<Integer> negativeNumbers = new ArrayList<>();
            for(int i = 0; i < numbersArray.size(); i++){
                if (Integer.parseInt(numbersArray.get(i)) < 0)
                    negativeNumbers.add(Integer.parseInt(numbersArray.get(i)));
                if (Integer.parseInt(numbersArray.get(i)) <= 1000)
                    sum += Integer.parseInt(numbersArray.get(i));
            }

            if(negativeNumbers.isEmpty()) return sum;

            else{
                throw new IllegalArgumentException("Недозволені від'ємні числа: " + negativeNumbers);
            }
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