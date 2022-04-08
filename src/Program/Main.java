package Program;

import Calculator.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        while (true){
            String text = input.nextLine();

            // Проверка на длину выражения и количество переменных, так же длину оператора.
            var tempExpression = CheckLength(text);

            // Является ли выражение римским или арабским
            boolean arabic = CheckExpressionArabic(tempExpression);
            boolean roman = CheckExpressionRoman(tempExpression);
            Operator operator = GetOperator(tempExpression);

            // Запуск калькулятора определенного типа
            if (arabic){
                int leftOperand = Integer.parseInt(tempExpression[0]);
                int rightOperand = Integer.parseInt(tempExpression[2]);
                int result = Calc.CalculatedArabic(leftOperand, rightOperand, operator);
                System.out.println(result);
            }

            else if (roman){
                var romanNumbs = Calc.GetRomansNumbers(tempExpression);
                var result = Calc.CalculatedRoman(romanNumbs[0], romanNumbs[1], operator);
                System.out.println(result);
            }
            else throw new Exception("Ошибка ввода");
        }

    }

    // Метод проверяет выражение на ошибки, возвращает операторы и операнд в виде строкового массива.
    static String[] CheckLength(String text) throws Exception {
        var temp = text.toLowerCase().split(" ");
        if (temp.length > 3) throw new Exception("Формат математической операции не удовлетворяет заданию - " +
                "два операнда и один оператор (+, -, /, *).");
        if (temp.length < 3) throw new Exception("Строка не является математической операцией.");
        if (temp[1].length() > 1) throw new Exception("Неверный оператор.");

        return temp;
    }

    // Проверим ялвяется ли выражение арабским
    static boolean CheckExpressionArabic(String[] textArr) throws Exception {
        int left;
        int right;

        //Проверка на систему счисления
        int counter = 0;
        for (int i = 0; i < textArr.length; i++) {
            for (var item : RomanSystemNumbs.values()) {
                if (textArr[i].compareTo(item.name()) == 0){
                    counter++;
                }
            }
        }
        if (counter == 1) throw new Exception("Используются одновременно разные системы счисления.");

        //Попытка упаковать строки в целые числа
        try {
            left = Integer.parseInt(textArr[0]);
            right = Integer.parseInt(textArr[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        if (left < 1 || left > 10){
            throw new Exception("Операнды могут быть в диапозоне от 1 до 10 включительно.");
        }
        if (right < 1 || right > 10){
            throw new Exception("Операнды могут быть в диапозоне от 1 до 10 включительно.");
        }
        return true;
    }

    // Метод определяет является ли выражение римским
    static boolean CheckExpressionRoman(String[] textArr) throws Exception {
        int left;
        int right;
        //Проверка разных систем счисления.
        int counter = 0;
        for (int i = 0; i < textArr.length; i++) {
            for (var item : RomanSystemNumbs.values()) {
                if (textArr[i].compareTo(item.name()) == 0)
                    counter++;
            }
        }
        if (counter == 1) throw new Exception("Используются одновременно разные системы счисления.");

        else if (counter == 2) return true;

        else return false;
    }

    // Метод возвращает оператор выражения
    static Operator GetOperator(String[] textArr) throws Exception {
        for (var item : Operator.values()) {
            if (textArr[1].compareTo(item.Code()) == 0)
                return item;
        }
        throw new Exception("Неверный оператор.");
    }
}
