package sm06;

import java.util.Objects;

public class Cat {
    public static int counter = 0;

    public int id;
    public int age;
    public String color;
    public String name;

    public Cat(String name, String color, int age) {
        this.id = counter++;
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Кот №%d: Кличка %s, Цвет %s, Возраст %d лет", this.id, this.name, this.color, this.age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cat) {
            return this.name.equals(((Cat) obj).name) && this.color.equals(((Cat) obj).color) && this.age == ((Cat) obj).age;
        }
        return false;        
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.color, this.age);
        // return Objects.hash(this.id, this.name, this.color, this.age);
    }

    public String say() {
        return "Meow";
    }

    public String eat() {
        return "Where is my mouse?!!!";
    }
}


