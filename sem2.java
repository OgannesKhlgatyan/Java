import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sem2 {
    public static void main(String[] args) {
        /*
         * char c1 = 'a';
         * char c2 = 'b';
         * int n = 1000;
         * System.out.println(ex0(c1, c2, n));
         */

        /*
         * String s = "aaaabbbcdd";
         * System.out.println(ex1(s));
         */

        /*
         * String s = "потоп";
         * System.out.println(ex2(s));
         */

        String s = "text" + "\n";
        int n = 100;
        ex3(s, n);
    }

    static String ex0(char c1, char c2, int n) {
        /*
         * Дано четное число N (>0) и символы c1 и c2.
         * Написать метод, который вернет строку длины N, которая состоит из
         * чередующихся символов c1 и c2, начиная с c1.
         * Ответ: c1c2c1…c2 (всего N символов)
         */
        if (n <= 0 || n % 2 == 1) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            stringBuilder.append(c1);
            stringBuilder.append(c2);
        }
        return stringBuilder.toString(); // возвращаем текстовое предоставление abababab...
    }

    static String ex1(String s) {
        /*
         * Напишите метод, который сжимает строку.
         * Пример: вход aaaabbbcdd.
         * Результат: a4b3cd2
         */
        int count = 1; // начинаем со 2-го поэтому count = 1, а не 0
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < s.length(); i++) { // считаем со следующего
            if (s.charAt(i) == s.charAt(i - 1)) {
                count += 1;
            } else {
                stringBuilder.append(s.charAt(i - 1));

                if (count != 1) {
                    stringBuilder.append(count);
                }
                count = 1;
            }
        }
        stringBuilder.append(s.charAt(s.length() - 1));
        if (count != 1) {
            stringBuilder.append(count);
        }
        return stringBuilder.toString();
    }

    static boolean ex2(String s1) {
        /*
         * Напишите метод, который принимает на вход строку (String) и определяет
         * является ли строка палиндромом (возвращает boolean значение).
         * Полиндром - Слово или фраза, которые одинаково читаются слева направо и
         * справа налево.
         */
        for (int i = 0; i < s1.length() / 2; i++) {
            if (s1.charAt(i) != s1.charAt(s1.length() - 1 - i)) {
            }
            return true;
        }
        return false;
    }

    static void ex3(String s, int n) {
        /*
         * Напишите метод, который составит строку,
         * состоящую из 100 повторений слова TEST и метод, который запишет эту строку в
         * простой текстовый файл,
         * обработайте исключения.
         */
        String file_Path = "text.txt";
        String s1 = repeat_string(s, n);
        wrtite_to_file(s1, file_Path);

    }

    static String repeat_string(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    static void wrtite_to_file(String s, String file_Path) {
        // проверка создания файла (через метод File)
        // File file = new File(file_Path);
        // if (!file.exists()) {
        // try {
        // file.createNewFile();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // }
        try {
            Logger logger = Logger.getAnonymousLogger();
            FileHandler fileHandler = new FileHandler("log.txt", true);
            logger.addHandler(fileHandler);
            try (FileWriter writer = new FileWriter(file_Path, false)) {
                writer.write(s);
                writer.flush();
                logger.log(Level.INFO, "the record has already been created");
            } catch (Exception e) {
                e.printStackTrace();
                logger.log(Level.WARNING, e.getMessage());
            }
            fileHandler.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
