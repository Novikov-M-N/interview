package arraylist;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyArrayList<T> implements List<T> {
    private static final int MIN_STORAGE_CAPACITY = 10;
    private static final int MIN_STORAGE_LIMIT = 7;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Object[] storage; // Настоящий массив - хранилище объектов
    private int elementsCount; // Количество хранимых объектов
    private int storageCapacity; // Ёмкость массива хранилища объектов
    private int storageLimit; // Количество хранимых объектов, при достижении которого массив хранилище расширяется
    private float loadFactor; // Соотношение между storageLimit и ёмкостью хранилища

    // Задание ёмкости массива хранилища
    public void setCapacity(int capacity) throws Exception {
        if (capacity < elementsCount) { throw new Exception("Capacity can't be less then count of contains objects");}
        if (capacity < MIN_STORAGE_CAPACITY) { capacity = MIN_STORAGE_CAPACITY; }
        this.storageCapacity = capacity;
        storageLimitUpdate();
    }

    // Задание нового фактора загрузки
    public void setLoadFactor(float loadFactor) throws Exception {
        if (loadFactor > 1 || loadFactor <= 0) { throw new Exception("Load factor must be > 0 and <= 1"); }
        this.loadFactor = loadFactor;
        storageLimitUpdate();
    }

    // Для тестирования
    public int getCapacity() { return storageCapacity; }
    public int getStorageLimit() { return storageLimit; }

    public MyArrayList(int storageCapacity, float loadFactor) throws Exception {
        if (loadFactor > 1 || loadFactor <= 0) { throw new Exception("Load factor must be > 0 and <= 1"); }
        this.storageCapacity = storageCapacity;
        this.loadFactor = loadFactor;
        this.elementsCount = 0;
        storageLimitUpdate();
        this.storage = new Object[storageCapacity];
    }

    public MyArrayList(int storageCapacity) {
        try {
            new MyArrayList(storageCapacity, DEFAULT_LOAD_FACTOR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MyArrayList() {
        try {
            new MyArrayList<>(MIN_STORAGE_CAPACITY, DEFAULT_LOAD_FACTOR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MyArrayList(T[] inputArray) {
        this.elementsCount = inputArray.length;
        this.storageCapacity = (int)((float)this.elementsCount / DEFAULT_LOAD_FACTOR);
        if (this.storageCapacity < MIN_STORAGE_CAPACITY) { this.storageCapacity = MIN_STORAGE_CAPACITY; }
        this.storageLimit = this.elementsCount + 1;
        if (this.storageLimit < MIN_STORAGE_LIMIT) { this.storageLimit = MIN_STORAGE_LIMIT; }
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.storage = new Object[this.storageCapacity];
        System.arraycopy(inputArray, 0 ,this.storage, 0, this.elementsCount);
    }

    // Внутренняя служебная функция приведения содержимого к типу листа
    private T cast(Object o) { return (T)o; }

    // Внутренняя служебная функция расширения ёмкости массива хранилища объектов
    private void expand() {
        storageCapacity *= 2;
        storageLimitUpdate();
        Object[] newStorage = new Object[storageCapacity];
        System.arraycopy(storage, 0, newStorage, 0, elementsCount);
        storage = newStorage;

    }

    // Внутренняя служебная функция пересчёта предельного количества элементов до расширения хранилища
    private void storageLimitUpdate() {
        storageLimit = (int)((float)storageCapacity * loadFactor);
    }

    // Возвращает размер листа - количество фактически хранящихся элементов
    @Override
    public int size() {
        return elementsCount;
    }

    // Проверка, пустой ли лист
    @Override
    public boolean isEmpty() {
        if (elementsCount == 0) { return true; }
        return false;
    }

    // Проверка, содержит ли лист заданный объект
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < elementsCount; i++) {
            if (storage[i].equals(o)) { return true; }
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
        Object[] result = new Object[this.elementsCount];
        if (this.elementsCount > 0) { System.arraycopy(this.storage, 0, result, 0, this.elementsCount); }
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

    // Добавление нового элемента в лист
    @Override
    public boolean add(T t) {
        if (elementsCount +1 >= storageLimit) {
            expand();
        }
        storage[elementsCount] = t;
        elementsCount++;
        return true;
    }

    // Удаление объекта из листа
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < elementsCount; i++) {
            if (storage[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    // Проверка, содержил ли лист каждый элемент коллекции
    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.isEmpty()  || this.elementsCount == 0) { return false; }
        boolean isContains;
        for(Object element : c) {
            isContains = false;
            for (int i = 0; i < elementsCount; i++) {
                if (storage[i] == element) {
                    isContains = true;
                    break;
                }
            }
            if (!isContains) { return false; }
        }
        return true;
    }

    //Метод не реализован
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
        this.elementsCount = 0;
        this.storageLimit = 7;
        this.storageCapacity = 10;
        this.storage = new Object[10];
    }

    // Получение элемента по индексу
    @Override
    public T get(int index) {
        if (index >= elementsCount || index < 0) { return null; }
        return cast(storage[index]);
    }

    // Замена элемента с заданным индексом
    @Override
    public T set(int index, T element) {
        if (index >= elementsCount || index < 0) { return null; }
        storage[index] = element;
        return element;
    }

    // Добавление элемента на место с заданным индексом
    @Override
    public void add(int index, T element) {
        if (index > elementsCount || index < 0) { return; } // Разрешено добавлять элемент в лист на место сразу за последним элементом
        if (index == elementsCount) {
            add(element);
        } else {
            if (elementsCount + 1 >= storageLimit) {
                expand();
            }
            System.arraycopy(storage, index, storage, index + 1, elementsCount - index);
            storage[index] = element;
            elementsCount++;
        }
    }

    // Удаление элемента по индексу
    @Override
    public T remove(int index) {
        if (index >= elementsCount || index < 0) { return null; }
        elementsCount--;
        T result = cast(storage[index]);
        if (index == elementsCount) {
            storage[index] = null;
        } else {
            System.arraycopy(storage, index + 1, storage, index, elementsCount - index);
        }
        return result;
    }

    // Получение индекса объекта
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elementsCount; i++) {
            if (storage[i].equals(o)) { return i; }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int result = -1;
        for (int i = 0; i < elementsCount; i++) {
            if (storage[i].equals(o)) { result = i; }
        }
        return result;
    }

    // Метод не реализован
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    // Метод не реализован
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    // Метод не реализован
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    // Метод не реализован
    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    // Метод не реализован
    @Override
    public Stream<T> stream() {
        return null;
    }

    // Метод не реализован
    @Override
    public Stream<T> parallelStream() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArrayList([");
        for (int i = 0; i < elementsCount; i++) {
            sb.append(storage[i]);
            if (i < elementsCount - 1) { sb.append(", "); }
        }
        sb.append("])");
        return sb.toString();
    }
}
