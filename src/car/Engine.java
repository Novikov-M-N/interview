package car;

/**
 * В класс "автомобиль" включен объект класса "двигатель", но в исходном коде такой класс отсутствует.
 * Создаём объект класса "двигетель", который содержит данные о мощности и наименовании двигателя
 * и простейшие методы запуска и остановки. Геттеры и сеттеры отсутствуют, т.к. в рамках данной работы излишни.
 */
public class Engine {
    private final int power; // Свап не предусмотрен
    private final String title; // Наименование конкретной модели двигателя остаётся неизменным
    private boolean isRun;

    public Engine(int power, String title) {
        this.title = title;
        this.power = power;
        this.isRun = false;
    }

    public void start() {
        if (isRun) {
            System.out.println("Кхххррррсссссь!");
        } else {
            isRun = true;
            System.out.println("Вррррррррррррр!");
        }
    }

    public void stop() {
        if (isRun) {
            isRun = false;
            System.out.println("Фррр... Двигетель заглушен");
        }
    }


}
