package request;

import calculate.Calculate;
import calculate.RomanCalculateImpl;
import convert.RomanArabicConvert;

public class Request {
    private Calculate calculate;
    private int a;
    private int b;
    private Actions action;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Actions getAction() {
        return action;
    }

    public Request(int a, int b, Actions action, Calculate calculate) {
        this.a = a;
        this.b = b;
        this.action = action;
        this.calculate = calculate;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    public String calculate(){
        int result = calculate.calculate(a, b, action);
        if(calculate instanceof RomanCalculateImpl) {
            return RomanArabicConvert.arabicToRoman(result);
        }
        return "" + result;
    }
}
