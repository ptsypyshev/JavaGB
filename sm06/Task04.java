// 1. Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>. 
// Поместите в него некоторое количество объектов.
// 2. Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество. 
// Убедитесь, что все они сохранились во множество.
// 3. Создайте метод public boolean equals(Object o)
// Пропишите в нём логику сравнения котов по параметрам, хранимым в полях.
// То есть, метод должен возвращать true, только если значения во всех полях сравниваемых объектов равны.
// 4. Создайте метод public int hashCode()
// который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать Objects.hash(...))
// 5. Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.
package sm06;

import java.util.HashSet;
import java.util.Set;

public class Task04 {
    public static void main(String[] args) {
        Set<Cat> uniqueCats = new HashSet<Cat>();
    
        Cat simpleCat0 = new Cat("Vasya", "White", 5);
        Cat simpleCat1 = new Cat("Boris", "Black", 2);
        Cat simpleCat2 = new Cat("Felix", "Multicolor", 3);
        Cat simpleCat3 = new Cat("Vasya", "White", 5);
        Cat simpleCat4 = simpleCat2;

        uniqueCats.add(simpleCat0);
        uniqueCats.add(simpleCat1);
        uniqueCats.add(simpleCat2);
        uniqueCats.add(simpleCat3);
        uniqueCats.add(simpleCat4);

        System.out.println(simpleCat0.equals(simpleCat3));
        System.out.println(simpleCat0.equals(simpleCat1));
        System.out.println(simpleCat0.equals(simpleCat2));
        System.out.println(simpleCat4.equals(simpleCat2));
        

        System.out.println(uniqueCats);
        System.out.printf("Всего котов в сете: %d\n", uniqueCats.size());
    }  
}
