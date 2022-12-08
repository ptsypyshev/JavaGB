package sm01;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

/**
 * hw1
 */
public class hw1 {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now) + " Hello World!");  
    }    
}