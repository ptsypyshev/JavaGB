// 1. Реализуйте 1 из вариантов класса Cat из предыдущего задания, можно использовать не все придуманные поля и методы.
// Создайте несколько экземпляров этого класса, выведите их в консоль.
// 2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat,
// выводилась его кличка, цвет и возраст (или другие параметры на ваше усмотрение).


package sm06;

public class Task03 {
    public static void main(String[] args) {
        Cat simpleCat0 = new Cat("Vasya", "White", 5);
        Cat simpleCat1 = new Cat("Boris", "Black", 2);
        Cat simpleCat2 = new Cat("Felix", "Multicolor", 3);
        Cat simpleCat3 = new Cat("Vasya", "White", 5);

        System.out.println(simpleCat0);
        System.out.println(simpleCat1);
        System.out.println(simpleCat2);
        System.out.println(simpleCat3);

        System.out.println(simpleCat0 == simpleCat3);
        System.out.println(simpleCat0 == simpleCat1);
        System.out.println(simpleCat0 == simpleCat2);

        System.out.println(simpleCat0.equals(simpleCat3));
        System.out.println(simpleCat0.equals(simpleCat1));
        System.out.println(simpleCat0.equals(simpleCat2));

        System.out.println(simpleCat0.say());
        System.out.println(simpleCat2.eat());
    }
}
