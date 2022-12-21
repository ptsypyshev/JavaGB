// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

package hw05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Task01 {
    public static void main(String[] args) {
        System.out.println("--- Adding items to phonebook ---");
        Add("Ivanov", "123");
        Add("Ivanov", "1234567890");
        Add("Sidorov", "222");
        ShowEntry("Ivanov");
        ShowEntry("Petrov");
        ShowEntry("Sidorov");
        System.out.println("--- Removing items from phonebook ---");
        Remove("Ivanov", "123");
        Remove("Sidorov", "222");
        ShowEntry("Ivanov");
        ShowEntry("Petrov");
        ShowEntry("Sidorov");
    }

    // Map phoneBook to store data
    public static Map<String, LinkedList<String>> phoneBook = new HashMap<>();

    /**
    * Adds a record with name and its phone number to phonebook  
    * @param  name          the name of person
    * @param  phoneNumber   the phone number of person
    */
    public static void Add(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            LinkedList<String> numbers = new LinkedList<String>();
            numbers.add(phoneNumber);
            phoneBook.put(name, numbers);
        }
    }

    /**
    * Removes a record with name and its phone number from phonebook
    * @param  name          the name of person
    * @param  phoneNumber   the phone number of person
    */
    public static void Remove(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).remove(phoneNumber);
        }
    }

    /**
    * Searches all phone numbers of person
    * @param  name          the name of person
    *
    * @return               the LinkedList with phone numbers or null if name is not found
    */
    public static LinkedList<String> SearchPhoneNumbers(String name) {
        if (!phoneBook.containsKey(name)) return null;
        return phoneBook.get(name);
    }

    /**
    * Shows all phone numbers of person
    * @param  name          the name of person
    */
    public static void ShowEntry(String name) {
        LinkedList<String> phoneNumbers = SearchPhoneNumbers(name);
        if (phoneNumbers == null) {
            System.out.printf("%s is absent in phonebook.\n", name);
        } else if (phoneNumbers.size() == 0) {
            System.out.printf("%s has no phone numbers.\n", name);
        } else {
            System.out.printf("%s has phones: %s\n", name, String.join(", ", phoneNumbers));;
        }        
    }
}
