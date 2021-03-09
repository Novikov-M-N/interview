package car;

/**
 * От интерфейса нельзя наследоваться, его можно только реализовывать
 * Убираем лишний интерфейс Stopable, функцию которого передали интерфейсу Moveable
 */
public class Lorry extends Car implements Moveable{

    // Конструктор, обращающийся к родительскому классу -
    // через него производить первоначальную инициализацию полей автомобиля практичнее,
    // т.к. эти вещи, как правило, определяются единожды при создании автомобиля
    // и крайне редко изменяются в течение его жизненного цикла
    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move(){
        // Конкретизируем, к какому именно типу автомобиля применён метод,
        // ибо должны же эти методы в разных классах как-то отличаться (необязательно, но так будет логичнее)
        // Аналогично в других методах
        System.out.println("Lorry is moving");
    }

    @Override
    public void stop(){
        System.out.println("Lorry is stop");
    }

    @Override
    public void open() {
        System.out.println("Lorry is open");
    }
}
