package pac.main;


import com.google.gson.Gson;

import java.io.*;

public class App
{
    public static void main( String[] args ){

        // Создание объекта
        Person person = new Person("Max", "Popov", 25);
        // Использование метода toString()
        System.out.println(person); // pac.main.Person@6e2c634b[age=25,firstName=Max,lastName=Popov]

        // Создадим еще два объекта для проверки метода equals()
        Person person1 = new Person("Max", "Popov", 25);
        Person person2 = new Person("Max", "Popov", 24);
        System.out.println(person.equals(person1)); // true
        System.out.println(person.equals(person2)); // false

        // Использование метода hashCode для разных объектов
        System.out.println(person.hashCode());  // 81048586
        System.out.println(person1.hashCode()); // 81048586
        System.out.println(person2.hashCode()); // 81047217


        Gson gson = new Gson();
        // Сериализация объекта в файл test.json
        try {
            FileWriter fileWriter = new FileWriter("test.json");
            fileWriter.write(gson.toJson(person));
            fileWriter.flush(); // содержимое файла: {"firstName":"Max","lastName":"Popov","age":25}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Десериализация объекта из файла test.json
        try {
            FileReader fileReader = new FileReader("test.json");
            Person person3 = gson.fromJson(fileReader, Person.class);
            System.out.println(person3); // pac.main.Person@5a39699c[age=25,firstName=Max,lastName=Popov]
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
