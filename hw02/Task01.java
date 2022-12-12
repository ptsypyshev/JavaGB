package hw02;

import java.io.Reader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task01 {
    /**
    * Returns Filter string for SQL query. 
    *
    * @param  filePath  the path to JSON-file with query filter information
    * @return           the filter string after JSON-file parsing
    */
    public static String getFilter(String filePath) throws IOException, ParseException{
        StringBuilder stringBuilder = new StringBuilder("");
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(filePath);
		Object parsedObj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) parsedObj;
        for (Object key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            if (!(value == null || value.equals("null"))) {
                String fmt = stringBuilder.length() > 0 ? " AND %s = %s" : "%s = %s";
                stringBuilder.append(String.format(fmt, key, value));
            }            
        }
        reader.close();
		return stringBuilder.toString();
    }

    /**
    * Returns SQL query from students table. 
    *
    * @param  filePath  the path to JSON-file with query filter information
    * @return           the result query
    */
    public static String getQuery(String filePath) {
        String qStringSimple = "SELECT * FROM students;";
        String qString = "SELECT * FROM students WHERE %s;";

        try {
            String filter = getFilter(filePath);
            if (filter.length() > 0) return String.format(qString, filter);
        } catch (Exception e) {
            System.out.printf("catched an exception: %s\n", e);
        }
        return qStringSimple;        
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите путь до файла JSON: ");
        String filePath = iScanner.nextLine();
        System.out.printf("Итоговый запрос: %s", getQuery(filePath));
        iScanner.close();
    }
}
