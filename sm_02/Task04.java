package sm_02;

import java.io.File;
import java.io.FileWriter;

public class Task04 {
    public static String Test100() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 100; i++) {
            stringBuilder.append("Test");
        }
        return stringBuilder.toString();
    }

    public static void WriteStringToFile(String s, String filepath) throws Exception {
        File f = new File(filepath);
        FileWriter fw = new FileWriter(f);
        fw.write(s);
        fw.flush();
        fw.close();
    }

    public static void main(String[] args) {
        try {
            WriteStringToFile(Test100(), "result.txt");
        } catch (Exception e) {
            System.out.printf("Exception: %s", e);
        }
    }
}
