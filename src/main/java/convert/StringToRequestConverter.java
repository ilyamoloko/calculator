package convert;

import calculate.ArabianCalculateImpl;
import calculate.Calculate;
import calculate.RomanCalculateImpl;
import request.Actions;
import request.Request;

public class StringToRequestConverter {

    public Request toRequest(String request) {
        String[] data = request.trim().split("\\s");
        if(data.length > 3) {
            throw new IllegalArgumentException("Неверный формат примера");
        }

        //Получение операции
        Actions action = Actions.getAction(data[1]);

        //Получени типа калькулятора и пары чисел
        int a, b;
        Calculate calculate;
        try {
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[2]);
            calculate = new ArabianCalculateImpl();
        } catch (Exception e) {
            //если не получилось распарсить арабское число не получилось
            //парсим как римские числа
            a = RomanArabicConvert.romanToArabic(data[0]);
            b = RomanArabicConvert.romanToArabic(data[2]);
            calculate = new RomanCalculateImpl();
        }


        return new Request(a, b, action, calculate);
    }

}
