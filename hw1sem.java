import java.util.Scanner;

/**
 * Вычислить n-ое треугольного число (сумма чисел от 1 до n)
 */
public class hw1sem {

    public static void main(String[] args) {
        // ex0();
        // ex1(1, 1000); // от 1 до 1000 (но можно и свой вариант)
        ex2();
    }

    /* ex0 */
    static void ex0() {
        System.out.println("Введите n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println("Треугольное число = " + recursion(n) + "\n");
    }

    public static int recursion(int num) {
        if (num == 1) {
            return 1;
        }
        return recursion(num - 1) + num;
    }

    /* ex1 */
    static void ex1(int xMin, int xMax) {
        while (xMin <= xMax) {
            if (simple(xMin)) {
                System.out.println("i = " + xMin);
            }
            xMin++;
        }
    }

    // Функция проверки простого числа (true)
    static boolean simple(int num) {
        for (int x = 2; x < num; x++) {
            if (num % x == 0) {
                return false;
            }
        }
        return true;
    }

    static void ex2() {
        double result = 0;
        Scanner scaner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double first_number = scaner.nextDouble();
        System.out.println("Введите операцию (+, -, /, *): ");
        char operation = scaner.next().charAt(0);
        System.out.println("Введите второе число: ");
        double second_number = scaner.nextDouble();
        scaner.close();
       
        switch (operation) {
            case '-':
                result = first_number - second_number;
                break;
            case '+':
                result = first_number + second_number;
                break;
            case '*':
                result = first_number * second_number;
                break;
            case '/':
                result = first_number / second_number;
                break;
            default:
                System.out.println("Ошибка корректности запроса!");
                break;
        }
        System.out.println(first_number + " " + operation + " " + second_number + " = " + result);
    }
}