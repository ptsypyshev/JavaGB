// Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе).
// Т.к. списка сотрудников на платформе не оказалось, воспользовался генератором https://randomus.ru/
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

package hw05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task02 {
    public static void main(String[] args) {
        showRepeatedNames(employees);
    }

    /**
    * Shows repeated names with its count in desc order
    * @param  employees     the list of employees
    */
    public static void showRepeatedNames(List<String> employees) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String employee : employees) {
            String empName = employee.split(" ")[0];
            if (countMap.containsKey(empName)) {
                countMap.put(empName, countMap.get(empName) + 1);
            } else {
                countMap.put(empName, 1);
            }
        }
        removeUniqueNames(countMap);
        List<Map.Entry<String, Integer>> lst = new ArrayList<>(countMap.entrySet());
        lst.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        System.out.println(lst);
    }

    /**
    * Removes repeated names from employees countMap
    * @param  countMap     the map of employees with names counter
    */
    public static void removeUniqueNames(Map<String, Integer> countMap) {
        countMap.entrySet().removeIf(entry -> entry.getValue() == 1);
    }

    // Mock data: employees list
    public static List<String> employees = new ArrayList<>(Arrays.asList(
        "Степан Макаров",
        "Эмин Никонов",
        "Тимофей Лаврентьев",
        "Матвей Соколов",
        "Марк Владимиров",
        "Тимофей Киреев",
        "Андрей Скворцов",
        "Кирилл Котов",
        "Егор Овсянников",
        "Максим Мухин",
        "Захар Кузнецов",
        "Дмитрий Исаев",
        "Андрей Гаврилов",
        "Владислав Головин",
        "Иван Зимин",
        "Али Чернов",
        "Лев Григорьев",
        "Тимофей Константинов",
        "Александр Гончаров",
        "Александр Борисов",
        "Макар Воробьев",
        "Фёдор Федотов",
        "Никита Николаев",
        "Александр Волков",
        "Тимофей Исаев",
        "Мирон Румянцев",
        "Лев Егоров",
        "Лев Высоцкий",
        "Тимофей Агафонов",
        "Фёдор Софронов",
        "Дамир Карпов",
        "Савелий Антонов",
        "Сергей Сергеев",
        "Арсений Емельянов",
        "Алексей Филиппов",
        "Даниил Королев",
        "Фёдор Шаповалов",
        "Дмитрий Горбунов",
        "Семён Муравьев",
        "Андрей Попов",
        "Александр Галкин",
        "Александр Никольский",
        "Михаил Власов",
        "Адам Алексеев",
        "Денис Парфенов",
        "Кирилл Дмитриев",
        "Евгений Павлов",
        "Андрей Смирнов",
        "Илья Ковалев",
        "Семён Фирсов",
        "Вячеслав Ларионов",
        "Денис Максимов",
        "Иван Степанов",
        "Глеб Парфенов",
        "Богдан Чернышев",
        "Владислав Степанов",
        "Михаил Михайлов",
        "Александр Иванов",
        "Ибрагим Волков",
        "Дмитрий Морозов",
        "Эмин Наумов",
        "Лука Богомолов",
        "Дмитрий Судаков",
        "Михаил Макаров",
        "Арсений Тихонов",
        "Владислав Соболев",
        "Артём Воробьев",
        "Павел Высоцкий",
        "Михаил Рогов",
        "Тимур Мельников",
        "Лев Бондарев",
        "Михаил Зубков",
        "Роман Коротков",
        "Евгений Макеев",
        "Арсений Баранов",
        "Владимир Ермилов",
        "Георгий Владимиров",
        "Марк Плотников",
        "Максим Николаев",
        "Михаил Воробьев",
        "Тимур Алексеев",
        "Даниил Новиков",
        "Иван Любимов",
        "Артемий Павлов",
        "Сергей Казаков",
        "Арсений Соколов",
        "Сергей Семенов",
        "Николай Куликов",
        "Егор Королев",
        "Демьян Акимов",
        "Марк Тихонов",
        "Сергей Макаров",
        "Максим Федосеев",
        "Владислав Марков",
        "Артём Сергеев",
        "Александр Артамонов",
        "Степан Тарасов",
        "Александр Королев",
        "Матвей Симонов",
        "Михаил Абрамов"
    ));
}
