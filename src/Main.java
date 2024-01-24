import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
        Дан List<Person>. Каждый Person имеет имя и возраст.
        Написать метод который сформирует Map<Person,String>, где ключ это Person, значение Имя
         */
        List<Person> personList1 = List.of(new Person("Джек",16),
                                            new Person("Мико",15),
                                            new Person("Раф",12));
        Map<Person,String> map1 = new HashMap<>();
        System.out.println("Дз 1.   " + mapWithNames(personList1,map1));

        /*
        Дан List<Person>. Каждый Person имеет имя и возраст. Реализовать несколько Comparator<Person> : по имени (по алфавиту), по длине имени, по возрасту.
        Каждый компаратор реализовать используя анонимный класс и используя лямбда-выражение. Проверить, вызывая метод sort
         */

        List<Person> personList2 = new ArrayList<>(List.of(new Person("Джек",16),
                new Person("Мико",15),
                new Person("Раф",12),
                new Person("Ретчет",27),
                new Person("Оптимус",26)));

        compare(personList2);
        /*
         Дан List<Person>. Каждый Person имеет имя и возраст. Написать метод который сформирует Map<Integer, List<Person> >,
         где ключ это возраст, значение список людей этого возраста
         */

        System.out.println("Дз 3.   " + mapWithAge(personList2));

    }
    public static Map<Person,String> mapWithNames(List<Person> personList, Map<Person,String> map){
        for (Person person : personList){
            map.put(person,person.getName());
        }
        return map;
    }
    public static void compare(List<Person> personList2){
        personList2.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println("Дз 2,1.   " + personList2);

        personList2.sort((p1, p2) -> Integer.compare(p1.getName().length(),p2.getName().length()));         //Начинаем с меньшего
        System.out.println("Дз 2,2.   " + personList2);

        personList2.sort((p1, p2) -> p1.getAge()-p2.getAge());
        System.out.println("Дз 2,3.   " + personList2);
    }
    public static Map<Integer,Person> mapWithAge(List<Person> personList2){
        Map<Integer,Person> map2 = new HashMap<>();
        for (Person person : personList2){
            map2.put(person.getAge(),person);
        }
        return map2;
    }
}