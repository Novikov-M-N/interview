import linkedlist.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создание пустого линкед листа
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        System.out.println(linkedList + "  - Создание пустого линкед листа");

        System.out.println(linkedList.isEmpty() + " - Лист пустой");

        // Заполнение линкед листа элементами
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        System.out.println(linkedList + " - Линкед лист после заполнения элементами");

        //Тест функций класса MyLinkedList
        linkedList.addFirst("0");
        System.out.println(linkedList + " - После добавления элемента в начало");

        linkedList.addLast("4");
        System.out.println(linkedList + " - После добавления элемента в конец");

        System.out.println(linkedList.peekFirst() + " - Запрос первого элемента");

        System.out.println(linkedList.peekLast() + " - Запрос последнего элемента");

        System.out.println(linkedList.poolFirst() + " - Запрос первого элемента с удалением");
        System.out.println(linkedList + " - После удаления первого элемента");

        System.out.println(linkedList.poolLast() + " - Запрос последнего элемента с удалением");
        System.out.println(linkedList + " - После удаления последнего элемента");

        System.out.println(linkedList.size() + " - Размер листа");

        System.out.println(linkedList.isEmpty() + " - Лист не пустой");

        System.out.println(linkedList.contains("2") + " - Лист содержит элемент \"2\"");
        System.out.println(linkedList.contains("4") + " - Лист не содержит элемент \"4\"");

        System.out.println("Массив, полученный из листа:");
        for (Object o : linkedList.toArray()) {
            System.out.print(o + " ");
        }
        System.out.println();

        linkedList.add("5");
        System.out.println(linkedList + " - После добавления элемента");

        System.out.println(linkedList.remove("2") + " - Элемент \"2\" успешно удалён");
        System.out.println(linkedList + " - Лист после удаления элемента");
        System.out.println(linkedList.remove("6") + " - Элемент \"6\" удалить нельзя, его в листе нет");
        System.out.println(linkedList + " - Лист не изменился, т.к. ничего не удалилось");

        System.out.println(linkedList.get(1) + " - Элемент с индексом 1");
        System.out.println(linkedList.get(3) + " - Попытка получить элемент с индексом 3");

        System.out.println(linkedList.set(2, "6") + " - Установка объекта \"6\" на место элемента с индексом 2");
        System.out.println(linkedList + " - Лист после устновки объекта \"6\" на место элемента с индексом 2");
        System.out.println(linkedList.set(5, "7") + " - Попытка установить элемент на не существующий индекс");

        linkedList.add(1, "8");
        System.out.println(linkedList + " - Лист после вставки элемента на место с индексом 1");

        System.out.println(linkedList.indexOf("3") + " - Индекс элемента \"3\"");
        System.out.println(linkedList.indexOf("9") + " - Индекс элемента \"9\" отсутствует");

        linkedList.add(3, "8");
        System.out.println(linkedList + " - лист имеет два одинаковых элемента");
        System.out.println(linkedList.lastIndexOf("8") + " - Последний индекс элемента \"8\"");

        List<String> list = new ArrayList<>(Arrays.asList("11", "12", "13", "14", "15"));
        MyLinkedList<String> linkedListFromCollection = new MyLinkedList<>(list);
        System.out.println(linkedListFromCollection + " - лист, созданный на базе коллекции");
    }
}
