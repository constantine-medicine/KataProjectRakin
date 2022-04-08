package Calculator;

public class Calc {

    // Метод возвращет решение математического выражения в арабском счислении.
    public static int CalculatedArabic(int x, int y, Operator operator) throws Exception {
        switch (operator.Code()) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
        }
        throw new Exception("Неверный оператор.");
    }

    // Метод возвращает решение математического выражения в римском счислении
    public static String CalculatedRoman(RomanSystemNumbs x, RomanSystemNumbs y, Operator operator) throws Exception {
        switch (operator.Code()) {
            case "+":
                return RomanParseInt(x.Code() + y.Code());
            case "-":
                return RomanParseInt(x.Code() - y.Code());
            case "*":
                return RomanParseInt(x.Code() * y.Code());
            case "/":
                return RomanParseInt(x.Code() / y.Code());
        }
        throw new Exception("Неверный оператор.");
    }

    // Метод приводит целое число к Римскому
    private static String RomanParseInt(int num) throws Exception {
        // Проверка на ноль
        if (num <= 0) throw new Exception("В римской системе счисления нет нуля!");

        int step = 1;
        String result = "";

        while (num > 0){
            int flag = RomanSystemNumbs.values()[RomanSystemNumbs.values().length - step].Code();

            if (flag > num) step += 1;
            else {
                num -= flag;
                result += RomanSystemNumbs.values()[RomanSystemNumbs.values().length - step];
            }
        }
        return result.toUpperCase();
    }

    // Метод достает два операнда из выражения
    public static RomanSystemNumbs[] GetRomansNumbers(String[] textArr) throws Exception {
        RomanSystemNumbs[] result = new RomanSystemNumbs[2];

        for (var item : RomanSystemNumbs.values()) {
            if (textArr[0].compareTo(item.name()) == 0)
                result[0] = item;
            if (textArr[2].compareTo(item.name()) == 0)
                result[1] = item;
        }
        //Проверка на большие числа
        if (result[0].Code() > 10 || result[0].Code() < 1 ||
            result[1].Code() > 10 || result[1].Code() < 1){
            throw new Exception("Операнды могу быть в диапозоне от 1 до 10 включительно.");
        }

        return result;
    }

}
