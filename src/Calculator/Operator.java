package Calculator;

public enum Operator {
    SUM("+"),
    SUB("-"),
    MULTI("*"),
    DIV("/");

    private String code;

    Operator(String s) {
        this.code = s;
    }

    public String Code(){return this.code;}
}
