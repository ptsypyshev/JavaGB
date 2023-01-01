package hw06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task03 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in, "UTF-8");        
        Set<Laptop> laptops = Task02.getLaptopSet(100);
        Map<Integer, String> filters = new HashMap<>();
        addFilters(iScanner, filters);

        Set<Laptop> filteredLaptops = filter(laptops, filters);
        Task02.printLaptops(filteredLaptops);
        System.out.printf("Всего выбрано %d из %d.\n", filteredLaptops.size(), laptops.size());

        iScanner.close();
    }
    
    /** Adds a filter to the Map of filters.
    * @param iScanner   a Scanner object (used to read from console)
    * @param filters    a map of filters
    */
    private static void addFilters(Scanner iScanner, Map<Integer, String> filters) {
        String isAddFilter;
        while (true) {
            System.out.print(askAddFilter);
            isAddFilter = iScanner.next();
            if (!isAddFilter.equals("a")) return;
            int filterType = getFilterType(iScanner);
            String filterValue = getFilterValue(iScanner);
            filters.put(filterType, filterValue);
        }
    }    

    /** Gets a filter type from user's input.
    * @param iScanner   a Scanner object (used to read from console)
    * @return           a filter type
    */
    public static int getFilterType(Scanner iScanner) {
        System.out.print(askFilterMsg);
        boolean isInt = iScanner.hasNextInt();
        while(!isInt) {
            System.out.print("Неправильный ввод. Повторите попытку: ");
            iScanner.next();
            isInt = iScanner.hasNextInt();
        }
        int filterType = iScanner.nextInt();
        while (filterType < 1 || filterType > 6) {
            System.out.print("Неправильный ввод. Повторите попытку: ");
            filterType = iScanner.nextInt();
        }
        return filterType;
    }

    /** Gets a filter value from user's input.
    * @param iScanner   a Scanner object (used to read from console)
    * @return           a filter value
    */
    private static String getFilterValue(Scanner iScanner) {
        System.out.print(askFilterValueMsg);
        return iScanner.next();
    }

    /** Filters some Laptop objects from original set due to the map of filters.
    * @param laptops    a set of Laptop Objects
    * @param filters    a map of filters
    * @return           a filtered set of Laptop Objects
    */
    public static Set<Laptop> filter(Set<Laptop> laptops, Map<Integer, String> filters) {
        if (filters.size() == 0) return laptops;

        Set<Laptop> result = new HashSet<>(laptops);
        for (Map.Entry<Integer, String> entry : filters.entrySet()) {
            int filterType = entry.getKey();
            String filterValue = entry.getValue();
            try {
                switch (filterType) {
                    case 1:
                        for (Laptop laptop : laptops) {
                            if (!laptop.hasCpuVendor(filterValue)) {
                                result.remove(laptop);
                            }
                        }                
                        break;
                    case 2:
                        int cores = Integer.parseInt(filterValue);
                        for (Laptop laptop : laptops) {
                            if (!laptop.hasMoreOrEqualsCores(cores)) {
                                result.remove(laptop);
                            }
                        }
                        break;
                    case 3:
                        int minRAM = Integer.parseInt(filterValue);
                        for (Laptop laptop : laptops) {
                            if (!laptop.hasMoreOrEqualsRAM(minRAM)) {
                                result.remove(laptop);
                            }
                        }  
                    case 4:
                        int minDiskSize = Integer.parseInt(filterValue);
                        for (Laptop laptop : laptops) {
                            if (!laptop.hasMoreOrEqualsDiskSize(minDiskSize)) {
                                result.remove(laptop);
                            }
                        }  
                        break;
                    case 5:
                        for (Laptop laptop : laptops) {
                            if (!laptop.hasOS(filterValue)) {
                                result.remove(laptop);
                            }
                        }  
                        break;
                    case 6:
                        double maxPrice = Double.parseDouble(filterValue);
                        for (Laptop laptop : laptops) {
                            if (!laptop.cheaperThenMaxPrice(maxPrice)) {
                                result.remove(laptop);
                            }
                        }  
                        break;
                    default:
                        System.out.println("Bad filter type");
                }
            } catch (NumberFormatException e) {
                System.out.printf("Cannot parse value %s to integer\n", e);
                continue;
            }            
        }
        
        return result;        
    }

    public static final String askFilterMsg = """
    Введите цифру, соответствующую необходимому критерию:
    - 1 - ЦПУ вендор (AMD, Intel)
    - 2 - Количество ядер (не менее)
    - 3 - Объем ОЗУ (не менее)
    - 4 - Объем Диска (не менее)
    - 5 - Операционная система (NoOS, FreeDOS, Linux, Windows)
    - 6 - Цена (не дороже)
    Ваш выбор:  """;

    public static final String askFilterValueMsg = "Введите значение фильтра: ";
    public static final String askAddFilter = "Если хотите добавить фильтр, введите 'a' или другое значение для вывода списка ноутбуков: ";
}
