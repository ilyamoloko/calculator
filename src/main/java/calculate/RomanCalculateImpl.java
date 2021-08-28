package calculate;

public class RomanCalculateImpl implements Calculate {
    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int div(int a, int b) {
        int res = a / b;
        if (res > 0) {
            return res;
        }
        throw new NumberFormatException("У римлянев нет отрицательных чисел");
    }

    @Override
    public int minus(int a, int b) {
        int res = a - b;
        if (res > 0) {
            return res;
        }
        throw new NumberFormatException("У римлянев нет отрицательных чисел");
    }

    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }
}
