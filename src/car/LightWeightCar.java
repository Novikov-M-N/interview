package car;

public class LightWeightCar extends Car implements Moveable{

    // Конструктор, обращающийся к родительскому классу -
    // через него производить первоначальную инициализацию полей автомобиля практичнее,
    // т.к. эти вещи, как правило, определяются единожды при создании автомобиля
    // и крайне редко изменяются в течение его жизненного цикла
    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void open() {
        // Конкретизируем, к какому именно типу автомобиля применён метод,
        // ибо должны же эти методы в разных классах как-то отличаться (необязательно, но так будет логичнее)
        // Аналогично в других методах
        System.out.println("Light weight car is open");
    }

    @Override
    public void move() {
        System.out.println("Light weight car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Light weight car is stopped");
    }
}
