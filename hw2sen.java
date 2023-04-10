
public class hw2sen {
    public static void main(String[] args) throws Exception{
        String [] arrayData =  lib.ReadLineFromFile("json_info.txt");
        for(int i = 0; i < arrayData.length; i++) {
            System.out.println(Parser_json_string(arrayData[i]));
        }
       
    }
    static StringBuilder Parser_json_string(String line){
        // Дана json строка { { "фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
        // {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}} Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
        //  Студент Иванов получил 5 по предмету Математика. Студент Петрова получил 4 по предмету Информатика.
        // Студент Краснов получил 5 по предмету Физика. Используйте StringBuilder для подготовки ответа
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", "");
        String line4 = line3.replace("[", "");
        String line5 = line4.replace("]", "");
        StringBuilder result = new StringBuilder("");
        String [] arrayData = line5.split(",");
        String [] listName = {"Студент ", " получил ", " по предмету "};
        for (int i =0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            result.append(listName[i]);
            result.append(arrData[1]);
            }
        return result;
    }
}
