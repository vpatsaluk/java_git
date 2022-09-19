import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String numbers){
        if(numbers.isEmpty()) return 0;
        else{
            if(numbers.startsWith("//")){
                String delimiter;
                int newLineIndex = numbers.indexOf("\n");

                ArrayList<String> numbersArrayList = new ArrayList<>();
                ArrayList<String> negativeNumbersArray = new ArrayList<>();
                ArrayList<String> delimitersList = new ArrayList<>();

                String[] numbersStringArray = {"0"};

                String delimiterPart = numbers.substring(2, newLineIndex);
                char[] delimiterArray = delimiterPart.toCharArray();
                String del = "";

                for(int i = 0; i < delimiterArray.length; i++){
                    if(delimiterArray[i] == ']'){
                        delimitersList.add(del);
                        del = "";
                    }
                    if(delimiterArray[i] != '[' && delimiterArray[i] != ']')
                        del = del.concat(Character.toString(delimiterArray[i]));

                }

                String[] delArray = new String[delimitersList.size()];
                delimitersList.toArray(delArray);

                System.out.println(delimitersList);

                if(numbers.charAt(newLineIndex - 1) == ']'){
                    delimiter = numbers.substring(newLineIndex - 2, newLineIndex - 1);

                    numbers = numbers.substring(newLineIndex + 1);

                    int delimiterInd;
                    int minDelInd = delArray.length + 1;

                    while(!numbers.isEmpty()){

                        for(int i = 0; i < delArray.length; i++){
                            if(numbers.contains(delArray[i])){
                                if(minDelInd > numbers.indexOf(delArray[i])) minDelInd = numbers.indexOf(delArray[i]);
                            }
                            if(i == delArray.length - 1){
                                if(minDelInd != 0) numbersArrayList.add(numbers.substring(0, minDelInd));
                            }
                            else if(i == delArray.length - 1 && numbers.contains(numbers.charAt())){

                            }
                        }

                        if(numbers.contains()){
                            delimiterInd = numbers.indexOf(delimiter);
                            if(delimiterInd != 0) numbersArrayList.add(numbers.substring(0, delimiterInd));
                        }
                        else{
                            numbersArrayList.add(numbers);
                            break;
                        }
                        numbers = numbers.substring(delimiterInd + 1);

                    }

                    numbersStringArray = new String[numbersArrayList.size()];
                    numbersArrayList.toArray(numbersStringArray);

                }
                else {
                    delimiter = numbers.substring(newLineIndex - 1, newLineIndex);

                    numbers = numbers.substring(newLineIndex + 1);

                    numbersStringArray = numbers.split(delimiter);
                }

                int sum = 0;

                for(int i = 0; i < numbersStringArray.length; i++){
                    if(Integer.parseInt(numbersStringArray[i]) < 0){
                        negativeNumbersArray.add(numbersStringArray[i]);
                    }

                    if(Integer.parseInt(numbersStringArray[i]) >= 0 && Integer.parseInt(numbersStringArray[i]) <= 1000){
                        sum += Integer.parseInt(numbersStringArray[i]);
                    }
                }

                if(negativeNumbersArray.isEmpty()) return sum;
                else{
                    throw  new IllegalArgumentException("Недозволені від'ємні числа - " + negativeNumbersArray.stream().map(Object::toString).collect(Collectors.joining(", ")));
                }
            }

            else if(numbers.contains(",\n") || numbers.contains("\n,")){
                throw new IllegalArgumentException("Використання коми та нової строки як розділювача одночасно");
            }

            else if(numbers.contains(",") || numbers.contains("\n")){

                String[] numbersStringArray = numbers.split(",|\n");

                int sum = 0;

                ArrayList<String> negativeNumbersArray = new ArrayList<>();

                for(int i = 0; i < numbersStringArray.length; i++){
                    if(Integer.parseInt(numbersStringArray[i]) < 0){
                        negativeNumbersArray.add(numbersStringArray[i]);
                    }

                    if(Integer.parseInt(numbersStringArray[i]) >= 0 && Integer.parseInt(numbersStringArray[i]) <= 1000){
                        sum += Integer.parseInt(numbersStringArray[i]);
                    }
                }

                if(negativeNumbersArray.isEmpty()) return sum;
                else{
                    throw  new IllegalArgumentException("Недозволені від'ємні числа - " + negativeNumbersArray.stream().map(Object::toString).collect(Collectors.joining(", ")));
                }
            }

            else{
                if(Integer.parseInt(numbers) < 0){
                   throw  new IllegalArgumentException("Недозволені від'ємні числа - " + numbers);
                }

                if(Integer.parseInt(numbers) >= 0 && Integer.parseInt(numbers) <= 1000){
                    return Integer.parseInt(numbers);
                }
                else return 0;
            }
        }
    }

}
