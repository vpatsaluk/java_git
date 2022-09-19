import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

    @Test
    public void returnZeroForEmptyString(){
        assertThat(StringCalculator.add(""), is(0));
    }

    @Test
    public void returnSingleNumberForSingleNumber(){
        assertThat(StringCalculator.add("1"), is(1));
    }

    @Test
    public void returnSumOfTwoNumbersDelimitedByComma(){
        assertThat(StringCalculator.add("1,2"), is(3));
    }

    @Test
    public void returnSumOfMoreThanTwoNumbersDelimitedByComma(){
        assertThat(StringCalculator.add("1,2,3,4"), is(10));
    }

    @Test
    public void returnSumOfNumbersDelimitedByComaOrNewLine(){
        assertThat(StringCalculator.add("1\n2,3"), is(6));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnExceptionMessageOfNumbersDelimitedByComaAndNewLineAtTheSameTime(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Використання коми та нової строки як розділювача одночасно");

        StringCalculator.add("1,\n");
    }

    @Test
    public void returnSumOfNumbersDelimitedBySpecialDelimiter(){
        assertThat(StringCalculator.add("//;\n1;2;3;3"), is(9));
    }



    @Test
    public void returnExceptionMessageOfNegativeNumber(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Недозволені від'ємні числа - -3");

        StringCalculator.add("-3");
    }

   @Test
    public void returnExceptionMessageOfNegativeNumbers(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Недозволені від'ємні числа - -3, -2, -10");

        StringCalculator.add("//;\n-3;-2;1;-10");
    }


    @Test
    public void returnSumOnlyOfCorrectNumbers(){
        assertThat(StringCalculator.add("1001\n2,3"), is(5));
        assertThat(StringCalculator.add("//!\n1!2003!5"), is(6));
        assertThat(StringCalculator.add("1002"), is(0));
    }


    @Test
    public void returnSumOfNumbersDelimitedBySpecialDelimiterWithRandomSize(){
        assertThat(StringCalculator.add("//[?]\n1?2?3??4"), is(10));
    }

    @Test
    public void returnSumOfNumbersDelimitedByManyDelimitersWithRandomSize(){
        assertThat(StringCalculator.add("//[*][%]\n1*2%3"), is(6));
    }
}
