import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите выражение с числами от 1 до 10: ");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println(calc(expression));
    }

    public static String calc(String calc) {
        Converter conv = new Converter();
        String[] operators = {"+", "-", "*", "/"};
        String[] currentOperator = {" \\+ ", " - ", " \\* ", " / "};
        String operation = calc;
        int opIndex = -1;
        for (int i = 0; i < operators.length; i++) {
            if (operation.contains(operators[i])) {
                opIndex = i;
                break;
            }
        }

        if (opIndex == -1) {
            return "Неправильно введена операция"; //System.out.println("Неправильно введена операция.");
        }

        String[] split = operation.split(currentOperator[opIndex]);

        if (conv.isRoman(split[0]) == conv.isRoman(split[1])) {
            int a, b;
            boolean isRoman = conv.isRoman(split[0]);
            if (isRoman) {
                a = conv.romanToInt(split[0]);
                b = conv.romanToInt(split[1]);
            } else {
                a = Integer.parseInt(split[0]);
                b = Integer.parseInt(split[1]);
            }

            int result;
            switch (operators[opIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if ((a > 10 || a <= 0) || (b > 10 || b <= 0)) {
                return "Введите числа от 1 до 10!"; //System.out.println("Введите числа от 1 до 10!");
            } else {
                if (isRoman) {
                    if (result > 0) {
                        return "Результат операции: " + conv.intToRoman(result); //System.out.println("Результат операции: " + conv.intToRoman(result));
                    } else {
                        return "Ошибка. В римской системе нет отрицательных чисел";
                    }
                } else {
                    return "Результат операции: " + result; //System.out.println(result);
                }
            }
        } else {
            return "Введены числа разных форматов"; //System.out.println("Введены числа разных форматов");
        }

    }
}
