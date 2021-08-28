import calculate.ArabianCalculateImpl;
import calculate.Calculate;
import calculate.RomanCalculateImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class CalculateTest {

    private static Supplier<Stream<Integer>> zeroToTen = () -> Stream.iterate(0, it -> it + 1).limit(11);
    private static Supplier<Stream<String>> romeZeroToTen = () -> Stream.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    private static Supplier<Stream<String>> actions = () -> Stream.of(" + ", " - ", " * ", " / ");

    static Stream<String> dataArabian() {
        return zeroToTen.get().flatMap(a -> zeroToTen.get()
                .flatMap(b -> actions.get().map(action -> "" + a + action + b)))
                ;
    }

    static Stream<Pair> dataNumperArabian() {
        return zeroToTen.get().flatMap(a -> zeroToTen.get()
                .map(b -> new Pair(a, b)))
                ;
    }

    static Stream<Integer> dataArabianZeroToTen() {
        return zeroToTen.get();
    }

    static Stream<String> dataRome() {
        return romeZeroToTen.get().flatMap(a -> romeZeroToTen.get()
                .flatMap(b -> actions.get().map(action -> "" + a + action + b)))
                ;
    }

    /**
     * @param input Проверка действий всех арабских чисел
     */
    @ParameterizedTest
    @MethodSource("dataArabian")
    public void testAllArabianCalc(String input) {

        String result = App.calculate(input);

        System.out.println(input + " = " + result);
    }

    /**
     * @param input Проверка действий всех арабских чисел
     */
    @ParameterizedTest
    @MethodSource("dataRome")
    public void testAllRomeCalc(String input) {

        String result = App.calculate(input);

        System.out.println(input + " = " + result);
    }


    /**
     * @param input Проверка сложения арабских чисел
     */
    @ParameterizedTest
    @MethodSource("dataNumperArabian")
    public void testArabianCalcPlus(Pair input) {
        Calculate calculate = new ArabianCalculateImpl();

        int res = calculate.plus(input.a, input.b);

        System.out.println(input.toString() + ", sum = " + res);
        assert res == input.a + input.b;
    }

    @ParameterizedTest
    @MethodSource("dataNumperArabian")
    public void testArabianCalcDiv(Pair input) {
        Calculate calculate = new ArabianCalculateImpl();
        if (input.b == 0) return;

        int res = calculate.div(input.a, input.b);

        System.out.println(input.toString() + ", sum = " + res);
    }

    @ParameterizedTest
    @MethodSource("dataArabianZeroToTen")
    public void testArabianCalcDivByZero(Integer a) {
        Calculate calculate = new ArabianCalculateImpl();

        try {
            calculate.div(a, 0);
        } catch (ArithmeticException e) {
            assert true;
            return;
        }
        assert false;
    }

    @ParameterizedTest
    @MethodSource("dataNumperArabian")
    public void testArabianCalcMinus(Pair input) {
        Calculate calculate = new ArabianCalculateImpl();

        int res = calculate.minus(input.a, input.b);

        System.out.println(input.toString() + ", sum = " + res);
        assert res == input.a - input.b;
    }

    @ParameterizedTest
    @MethodSource("dataNumperArabian")
    public void testRomanCalcCorretMinus(Pair input) {
        Calculate calculate = new RomanCalculateImpl();
        if (input.b >= input.a) return;

        int res = calculate.minus(input.a, input.b);

        System.out.println(input.toString() + ", sum = " + res);
        assert res == input.a - input.b;
    }

    @ParameterizedTest
    @MethodSource("dataNumperArabian")
    public void testArabianCalcmultiplication
            (Pair input) {
        Calculate calculate = new ArabianCalculateImpl();

        int res = calculate.multiplication
                (input.a, input.b);

        System.out.println(input.toString() + ", sum = " + res);
        assert res == input.a - input.b;
    }

    @ParameterizedTest
    @MethodSource("dataNumperArabian")
    public void testRomanCalcInorret(Pair input) {
        Calculate calculate = new RomanCalculateImpl();
        if (input.b < input.a) return;

        try {
            calculate.minus(input.a, input.b);
        } catch (NumberFormatException e) {
            assert true;
            return;
        }
        assert false;
    }


}