package linkedlist;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyLinkedList<T> implements List<T> {
    private Container<T> first; // Ссылка на контейнер, содержащий первый элемент листа
    private Container<T> last; // Ссылка на контейнер, содержащий последний элемент листа
    private int size; // Общее количество контейнеров в листе. Оно же общее количество элементов в листе

    // Конструктор пустого листа
    public MyLinkedList() {
        this.size = 0;
    }

    // Конструктор листа на базе коллекции
    public MyLinkedList(Collection<? extends T> collection) {
        this.size = 0;
        for (T element : collection) {
            this.add(element);
        }
    }

    // Добавление элемента в начло листа
    public void addFirst(T element) {
        if (size == 0) {
            first = new Container<>(element);
            last = first;
            size = 1;
        } else {
            Container newContainer = new Container(element);
            newContainer.setNext(first);
            first.setPrevious(newContainer);
            first = newContainer;
            size++;
        }
    }

    // Добавление элемента в конец листа
    public void addLast(T element) {
        if (size == 0) {
            first = new Container<>(element);
            last = first;
            size = 1;
        } else {
            Container newContainer = new Container(element);
            newContainer.setPrevious(last);
            last.setNext(newContainer);
            last = newContainer;
            size++;
        }
    }

    // Получение первого элемента листа
    public T peekFirst() {
        if (size == 0) { return null; }
        return first.getPayload();
    }

    // Получение последнего элемента листа
    public T peekLast() {
        if (size == 0) { return null; }
        return last.getPayload();
    }

    // Получение первого элемента с последующим его удалением
    public T poolFirst() {
        if (size == 0) { return null; }
        T result = first.getPayload();
        remove(first);
        return result;
    }

    // Получение последнего элемента с последущим его удалением
    public T poolLast() {
        if (size == 0) { return null; }
        T result = last.getPayload();
        remove(last);
        return result;
    }

    // Получение размера листа (общего количества элементов в листе)
    @Override
    public int size() {
        return size;
    }

    // Проверка, пуст ли лист
    @Override
    public boolean isEmpty() {
        if (size == 0) { return true; }
        return false;
    }

    // Проверка, содержит ли лист какой-либо элемент
    @Override
    public boolean contains(Object o) {
        if(size == 0) { return false; }
        Container<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.getPayload().equals(o)) { return true; }
            current = current.getNext();
        }
        return false;
    }

    // Метод не реализован
    @Override
    public Iterator<T> iterator() {

        return null;
    }

    // Метод не реализован
    @Override
    public void forEach(Consumer<? super T> action) {

    }

    // Генерация массива объектов на базе листа
    @Override
    public Object[] toArray() {
        if (size == 0) { return new Object[0]; }
        Object[] result = new Object[size];
        Container current = first;
        for (int i = 0; i < size; i++) {
            result[i] = current.getPayload();
            current = current.getNext();
        }
        return result;
    }

    // Метод не реализован
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    // Метод не реализован
    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return null;
    }

    // Добавление элемента в лист - то же самое, что добавление элемента в конец листа
    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    // Удаление объекта из листа
    @Override
    public boolean remove(Object o) {
        if (size == 0) { return false; }
        Container current = first;
        for (int i = 0; i < size; i++) {
            if (current.getPayload().equals(o)) {
                remove(current);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Метод не реализован
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    // Метод не реализован
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    // Метод не реализован
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    // Метод не реализован
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    // Метод не реализован
    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    // Метод не реализован
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    // Метод не реализован
    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    // Метод не реализован
    @Override
    public void sort(Comparator<? super T> c) {

    }

    // Очистка листа
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    // Получение элемента по индексу
    @Override
    public T get(int index) {
        if (size == 0 || index >= size) { return null; }
        Container<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getPayload();
    }

    // Установка элемента по индексу
    @Override
    public T set(int index, T element) {
        if (size == 0 || index >= size) { return null; }
        Container<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setPayload(element);
        return element;
    }

    // Вставка нового элемента на место с индексом index
    @Override
    public void add(int index, T element) {
        if (index > size) { return; } // Элемент с индексом больше размера быть не может
        if (size == 0 && index == 0) { // В случае, если лист пустой
            first = new Container<>(element);
            last = first;
            size = 1;
        }
        Container<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        insertBefore(current, new Container(element));
    }

    // Удаление элемента по индексу
    @Override
    public T remove(int index) {
        if (size == 0 || index >= size) { return null; }
        Container<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        remove(current);
        return current.getPayload();
    }

    // Получение индекса элемента
    @Override
    public int indexOf(Object o) {
        Container current = first;
        for (int i = 0; i < size; i++) {
            if (current.getPayload().equals(o)) { return i; }
            current = current.getNext();
        }
        return -1;
    }

    // Получение последнего индекса элемента, совпадающего с заданным
    @Override
    public int lastIndexOf(Object o) {
        int result = -1;
        Container current = first;
        for (int i = 0; i < size; i++) {
            if (current.getPayload().equals(o)) { result = i; }
            current = current.getNext();
        }
        return result;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyLinkedList([");
        if (size != 0) {
            Container current = first;
            for (int i = 0; i < size; i++) {
                sb.append(current.getPayload().toString());
                if (i < size -1) { sb.append(", "); }
                current = current.getNext();
            }
        }
        sb.append("])");
        return sb.toString();
    }

    // Внутренняя служебная функция исключения контейнера из списка
    private void remove(Container container) {
        if (size == 1) {// Если удаляем единственный элемент списка, то это равнозначно очистке списка
            clear();
            return;
        }
        if (container != first && container != last) {
            container.getNext().setPrevious(container.getPrevious());
            container.getPrevious().setNext(container.getNext());
        }
        if (container == first) {
            first = container.getNext();
            container.getNext().setPrevious(null);
        }
        if (container == last) {
            last = container.getPrevious();
            container.getPrevious().setNext(null);
        }
        size--;
    }

    // Внутренняя служебная функция вставки контейнера в список перед заданным контейнером
    private void insertBefore(Container existingContainer, Container newContainer) {
        if (existingContainer == first) {
            first = newContainer;
            System.out.println("flag");
        }

        newContainer.setPrevious(existingContainer.getPrevious());
        existingContainer.getPrevious().setNext(newContainer);
        newContainer.setNext(existingContainer);
        existingContainer.setPrevious(newContainer);

        size++;
    }
}
