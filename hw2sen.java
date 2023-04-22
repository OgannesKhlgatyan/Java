import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class hw2sen {
    public static void main(String[] args) throws Exception {
        
        String [] arrayData =  lib.ReadLineFromFile("json_info.txt");
        for(int i = 0; i < arrayData.length; i++) {
            System.out.println(PrintLine(arrayData[i]));
        }    
        Logger logger = Logger.getLogger(hw2sen.class.getName());
        FileHandler fh = new FileHandler("hw2logs.txt");
        logger.addHandler(fh);

        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        logger.log(Level.INFO, "Записали лог об успешном выполнении программы.");
    }

    public static StringBuilder PrintLine(String line) {
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