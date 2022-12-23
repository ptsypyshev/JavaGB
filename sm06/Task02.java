// 1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое является
// а) информационной системой ветеринарной клиники
// б) архивом выставки котов
// в) информационной системой Театра кошек Ю. Д. Куклачёва
// Можно записать в текстовом виде, не обязательно реализовывать в java.

// Кот_вет_клиника
// Поля:
//     id
//     birthdate
//     breed
//     name
//     owner
//     injectionsList
//     diagnose

// Кот_выставка
//     Поля:
//         id
//         birthdate
//         name
//         owner
//         dimensions
//         skills
//         winList

// Кот_Куклачёв
//     Поля:
//         id
//         name
//         birthdate
//         breed
//         dimensions
//         skills


package sm06;

public class Task02 {
    public static void main(String[] args) {

        Cat simpleCat = new Cat("Vasya", "White", 5);
        CatClinic illCat = new CatClinic("Boris", "Black", 2);
        CatExhibition ExhCat = new CatExhibition("Felix", "Multicolor", 3);
        CatKuklachyov KuklCat = new CatKuklachyov("Vasya", "White", 5);

        System.out.println(simpleCat);
        System.out.println(illCat);
        System.out.println(ExhCat);
        System.out.println(KuklCat);    
    }
}
