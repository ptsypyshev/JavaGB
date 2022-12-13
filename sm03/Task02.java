package sm03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

public class Task02 {
    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<String>(Arrays.asList("Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун", "Плутон"));
        ArrayList<String> planetsMore = new ArrayList<String>(20);
        for (int i = 0; i < 20; i++) {
            planetsMore.add(planets.get(new Random().nextInt(9)));

        }
        System.out.println(planets);
        System.out.println(planetsMore);
        HashMap<String, Integer> planetsMap = new HashMap<String, Integer>();
        for (String planet : planetsMore) {
            if (planetsMap.get(planet) == null) {
                planetsMap.put(planet, 1);
            } else {
                planetsMap.put(planet, planetsMap.get(planet) + 1);
            }
        }
        for (Entry<String, Integer> elem : planetsMap.entrySet()) {
            System.out.println(elem);
        }
        for (Entry<String, Integer> elem : planetsMap.entrySet()) {
            if ((int)elem.getValue() > 1) {
                while (planetsMore.contains(elem.getKey())) {
                    planetsMore.remove(elem.getKey());
                }
            };
        }
        System.out.println(planetsMore);
    }
}
