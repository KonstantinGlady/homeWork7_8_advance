package lesson3.test;

public class Test {

    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Макс", "111222");
        phonebook.add("Олег", "111333");
        phonebook.add("Витя", "111444");
        phonebook.add("Рома", "111555");
        phonebook.add("Ника", "111666");
        phonebook.add("Ника", "111777");

        phonebook.get("Макс");
        phonebook.get("Олег");
        phonebook.get("Ника");
    }
}
