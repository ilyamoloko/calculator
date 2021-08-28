package calculate;

import request.Actions;

public interface Calculate {

    /**
     * @param a первое число
     * @param b второе число
     * @return сумму чисел
     */
    int plus(int a, int b);

    /**
     * @param a первое число
     * @param b второе число
     * @return разделенное числа
     */
    int div(int a, int b);

    /**
     * @param a первое число
     * @param b второе число
     * @return разность чисел
     */
    int minus(int a, int b);

    /**
     * @param a первое число
     * @param b второе число
     * @return умножение чисел
     */
    int multiplication(int a, int b);

    default int calculate(int a, int b, Actions actions) {
        switch (actions) {
            case PLUS:
                return plus(a, b);
            case MINUS:
                return minus(a, b);
            case DIV:
                return div(a, b);
            case MULTIPLY:
                return multiplication(a, b);
            default:
                throw new IllegalArgumentException("неизвестный оператор");
        }
    }
}
