package hw02;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task03 {
    public static final String LAST_NAME_KEY = "фамилия";
    public static final String MARK_KEY = "оценка";
    public static final String SUBJECT_KEY = "предмет";

    /**
    * Returns JSONArray if can read and parse JSON-file.
    *
    * @param  filePath  the path to JSON-file with students information
    * @return           the JSONArray after JSON-file parsing
    */
    public static JSONArray parseToJSONArray(String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(filePath, StandardCharsets.UTF_8);
        Object parsedObj = parser.parse(reader);        
        reader.close();
        return (JSONArray) parsedObj;
    }

    /**
    * Returns String with student's performance.
    *
    * @param  filePath  the path to JSON-file with students information
    * @return           the student's performance
    */
    public static String printFromJSON(String filePath) {
        JSONArray jsonArray;
        try {
            jsonArray = parseToJSONArray(filePath);
        } catch (Exception e) {
            System.out.printf("Get an error during parsing file: %s", e);
            return "No students was parsed...";
        }

        StringBuilder stringBuilder = new StringBuilder("");
        Iterator<?> objectIterator =  jsonArray.iterator();
        while (objectIterator.hasNext()) {
            JSONObject studentObject = (JSONObject) objectIterator.next();
            String lastName = studentObject.get(LAST_NAME_KEY).toString();
            String markValue = studentObject.get(MARK_KEY).toString();
            String subjectName = studentObject.get(SUBJECT_KEY).toString();
            String fmt = "Студент %s получил %s по предмету %s.\n";
            stringBuilder.append(String.format(fmt, lastName, markValue, subjectName));
        }
        return stringBuilder.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(printFromJSON("task03.json"));
    }
}
