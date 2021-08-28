package request;

import java.util.Arrays;

public enum Actions {
    PLUS("+"),
    MINUS("-"),
    DIV("/"),
    MULTIPLY("*"),
    ;

    private String action;

    Actions(String action) {
        this.action = action;
    }
    
    public static Actions getAction(String action) {
        return Arrays.stream(Actions.values())
                .filter(it -> it.action.equals(action))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("неизвестный оператор"));
    }

}
