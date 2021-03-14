import arraylist.MyArrayList;
import linkedlist.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Тестирование функционала LinkedList

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

        // Тестирование функционала ArrayList

        // Создаём лист на базе массива
        MyArrayList<String> arrayList1 = new MyArrayList<>(new String[]{"1-1", "1-2", "1-3", "1-4"});
        System.out.println(arrayList1 + " - Лист, созданный на базе массива");

        System.out.println(arrayList1.size() + " - Размер листа");

        System.out.println(arrayList1.isEmpty() + " - Лист не пуст");

        System.out.println(arrayList1.containsAll(new ArrayList<>(Arrays.asList(new String[]{"1-2", "1-4"})))
                + " - лист содержит набор элементов \"1-2\" и \"1-4\"");

        // Cоздаём пустой лист
        MyArrayList<String> arrayList2 = new MyArrayList<>();
        System.out.println(arrayList2 + " - Новый пустой лист");
        System.out.println(arrayList2.isEmpty() + " - Новый лист пуст");

        System.out.println(arrayList1.contains("1-3") + " - Первый лист содержит объект \"1-3\"");
        System.out.println(arrayList1.contains(10) + " - Первый лист не содержит объект 10");

        for (Object o : arrayList1.toArray()) { System.out.print(o + " "); }
        System.out.println("- Массив объектов на базе первого листа");
        for (Object o : arrayList2.toArray()) { System.out.print(o + " "); }
        System.out.println("- Массив объектов на базе второго листа (пустой)");

        System.out.println(arrayList1.get(2) + " - Элемент с индексом 2");

        System.out.println(arrayList1.set(2, "new") + " - Замена элемента с индексом 2");
        System.out.println(arrayList1 + " - Лист после замены элемента с индексом 2");
        System.out.println(arrayList1.set(5, "newnew") + " - Попытка замены элемента с индексом 5 (не сработает)");

        arrayList1.add(2, "insert");
        System.out.println(arrayList1 + " - Лист после вставки нового элемента на место с индексом 2");

        System.out.println(arrayList1.indexOf("1-4") + " - Индекс объекта \"1-4\"");
        System.out.println(arrayList1.indexOf("1-5") + " - Попытка получить индекс объекта \"1-5\"");

        arrayList1.add("1-2");
        System.out.println(arrayList1 + " - Добавляем ещё один объект \"1-2\"");
        System.out.println(arrayList1.lastIndexOf("1-2") + " - Последний индекс объекта \"1-2\"");

        System.out.println(arrayList1.remove(1) + " - Удаляем элемент с индексом 1");
        System.out.println(arrayList1 + " - Лист после удаления элемента с индексом 1");
        System.out.println(arrayList1.remove(5) + " - Попытка удалить элемент с индексом 5");

        System.out.println(arrayList1.remove("1-1") + " - Удаляем элемент \"1-1\"");
        System.out.println(arrayList1 + " - Лист 1 после удаления элемента \"1-1\"");

        arrayList1.clear();
        System.out.println(arrayList1 + " - Лист 1 после очистки");

        System.out.println(arrayList1.getCapacity() + " - Ёмкость листа 1");
        System.out.println(arrayList1.getStorageLimit() + " - Предельная загрузка листа 1");

        // Наглядное отслеживание изменения внутренней структуры листа при добавлении новых элементов
        for (int i = 0; i <20 ; i++) {
            arrayList1.add(String.valueOf(i));
            System.out.println(arrayList1.getCapacity() + " " + arrayList1.getStorageLimit() + " "
                    + arrayList1.size() + " " + arrayList1);
        }

    }
}
