import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class sem3 {
    public static void main(String[] args) {
        // ex();
        // ex1();
       // ex2();
       ex3();
    }

    public static void ex() {
        /*
         * Заполнить список десятью случайными числами.
         * Отсортировать список методом sort() и вывести его на экран.
         */
        List<Integer> array = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array.add(random.nextInt(10) + 2);
        }
        System.out.println(array);
        Collections.sort(array);
        System.out.println(array);
    }

    public static void ex1() {
        /*
         * Создать список типа ArrayList
         * Поместить в него как строки, так и целые числа.
         * Пройти по списку, найти и удалить целые числа.
         */
        List<Object> list1 = new ArrayList<>();
        list1.add("stroka1");
        list1.add("stroka2");
        list1.add(3);
        list1.add(6);
        list1.add("stroka1");
        list1.add("stroka2");
        list1.add(4.1);
        list1.add(6);

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) instanceof Number) {
                list1.remove(i);
                i--;
            }
        }
        System.out.println(list1);
    }

    public static void ex2() {
        /*
         * Каталог товаров книжного магазина сохранен в виде двумерного списка
         * List<ArrayList<String>> так,
         * что на 0й позиции каждого внутреннего списка содержится название жанра, а на
         * остальных позициях - названия книг.
         * Напишите метод для заполнения данной структуры.
         */
        List<List<String>> shop = new ArrayList<>();
        addBook(shop, "Roman", "Voina i mir");
        addBook(shop, "Fantastica", "Garri Potter");
        addBook(shop, "Fantastica", "Vlastelin kollec");
        addBook(shop, "Roman", "Mumu");

        System.out.println(shop);
    }

    static void addBook(List<List<String>> shop, String genre, String bookName) {
        for (List<String> item : shop) {
            if (item.get(0).equals(genre)) {
                item.add(bookName);
                return;
            }
        }
        List<String> list = new ArrayList<>();
        list.add(genre);
        list.add(bookName);
        shop.add(list);
    }

    public static void ex3() {
        /*
         * Заполнить список названиями планет Солненчной системы в произвольном порядке
         * с повторениями
         * Вывести название каждой планеты и количество его повторений в списке
         */
        List<String> planets = List.of("Mars", "Venera", "Zemlya", "Upiter", "Uran", "Neptun",
                "Pluton", "Mercuriy", "Saturn");
        List<String> listPlanets = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            listPlanets.add(planets.get((int)(Math.random() * planets.size())));
        }
        System.out.println(listPlanets);
        for (String planet: planets) {
            int count = 0;
            for(String item: listPlanets){
                if (planet.equals(item)) {
                    count++;
                }
            }
            System.out.println(planet + ": " + count);
        }
    }
}
