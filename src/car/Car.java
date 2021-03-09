package car;

/**
 * В класс имеет смысл добавить конструктор, т.к. двигатель, цвет и название определяются сразу
 * при создании машины и редко меняются в течение её жизненного цикла.
 */
public abstract class Car {
    private Engine engine; // Делаем полностью приватным, т.к. в наследниках не используется
    private String color;
    private String name;

    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    // Данный метод нужно сделать публичным, т.к. машину требуется запускать кому-то извне (ключ, брелок, кнопка),
    // а не только самой машине (автозапуск).
    public void start() {
        // Функция запуска машины, по логике, должна запускать двигатель
        engine.start();
        System.out.println("Car starting");
    }

    public abstract void open(); // Делаем доступным снаружи, т.к. открывать машину должна мочь не только сама машина

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
