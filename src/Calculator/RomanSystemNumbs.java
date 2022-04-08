package Calculator;

public enum RomanSystemNumbs {
    i(1),
    ii(2),
    iii(3),
    iv(4),
    v(5),
    vi(6),
    vii(7),
    viii(8),
    ix(9),
    x(10),
    l(50),
    c(100),
    d(500),
    m(1000);

    private int code;

    RomanSystemNumbs(int i) {
        this.code = i;
    }

    public int Code(){
        return this.code;
    }
}
