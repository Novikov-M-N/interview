package counter;

public class Counter{
    private Integer counter = 0;

    public void increment(int number) { // Выводит в консоль номер потока и значение счётчика
        counter++;
        System.out.println(number + " - " + counter);
    }
}
