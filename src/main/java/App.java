import convert.StringToRequestConverter;
import request.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите 2 числа через пробел");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String result = calculate(input);

        System.out.println(result);
    }

    public static String calculate(String input) {
        StringToRequestConverter converter = new StringToRequestConverter();
        Request request = converter.toRequest(input);
        return request.calculate();
    }

}
