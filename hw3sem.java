import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hw3sem {
    public static void main(String[] args) {
        //ex1(); /* Пусть дан произвольный список целых чисел, удалить из него четные числа */
        ex2(); /* Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. Collections.max() */
    }

    static void ex1() {
        /* Пусть дан произвольный список целых чисел, удалить из него четные числа */
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(10));
        }
        System.out.println(numbers);
        List<Integer> chetno = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                chetno.add(numbers.get(i));
                numbers.remove(i);
            }
        }
        System.out.println("Список нечетных: " + numbers);
        System.out.println("Список четных: " + chetno);
    }

    static void ex2() {
        /*
        Задан целочисленный список ArrayList. Найти минимальное, максимальное и
        среднее арифметическое из этого списка. Collections.max()
        */
        Random rnd = new Random();
        ArrayList<Integer> arrlst = new ArrayList<Integer>();
        for (int i=0;i<10;i++){
            arrlst.add(rnd.nextInt(10)+2);
        }
        System.out.println(arrlst.toString());
        int max = arrlst.get(0);
        int min = arrlst.get(0);
        int sum = 0;
        for(int i=0;i<arrlst.size();i++){
            if (arrlst.get(i)>max) max = arrlst.get(i);
            if (arrlst.get(i)<min) min = arrlst.get(i);
            sum=sum+arrlst.get(i);
        }
        System.out.printf("Максимальный элемент: %d\n",max);
        System.out.printf("Минимальный элемент: %d\n",min);
        System.out.printf("Среднее арифметическое: %.1f\n",((float)sum/arrlst.size()));
    }
}
