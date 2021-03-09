import car.Car;
import car.Engine;
import car.LightWeightCar;
import car.Lorry;
import geometry.Circle;
import geometry.Figure;
import geometry.Square;
import geometry.Triangle;
import person.Person;
import person.PersonBuilder;
import utils.Autodrome;

public class Main {
    public static void main(String[] args) {
        // Задание 1 - билдер для класса Person
        PersonBuilder personBuilder = new PersonBuilder();

        // Объект со всеми полями, заданными через билдер
        personBuilder.setFirstName("Иван")
                .setLastName("иванов")
                .setMiddleName("Иванович")
                .setCountry("Российская Федерация")
                .setAddress("Новосибирск, Забалуева, 51, кв. 425")
                .setPhone("+71234567890")
                .setAge(42)
                .setGender("Мужской");
        Person person1 = null;
        try {
            person1= personBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(person1);

        // Объект с не заданными через билдер полями, которые билдер заполняет самостоятельно
        personBuilder.setFirstName("Пётр")
                .setLastName("Петров")
                .setAge(35)
                .setGender("Мужской");
        Person person2 = null;
        try {
            person2 = personBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(person2);

        // Объект с не заданными через билдер обязательными полями - выбрасывает исключение,
        // объект класса Person не создаётся (остаётся null)
        Person person3 = null;
        try {
            person3 = personBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(person3);

        // Задание 2 - починить автозавод
        LightWeightCar privateCar = new LightWeightCar(new Engine(136, "21029"), "серый", "Lada");
        Lorry workingCar = new Lorry(new Engine(428, "OM 457LA"), "синий", "KAMAZ");

        Autodrome autodrome = new Autodrome();
        autodrome.test(privateCar);
        autodrome.test(workingCar);

        // Задание 3 - полиморфизм геометрических фигур

        // Создаём фигуры через общий родительский класс и тестируем методы
        Figure circle = new Circle(5,5,5,"красный");
        circle.draw();
        circle.move(10,10);
        System.out.println("Периметр: " + circle.getPerimeter());
        System.out.println("Площадь: " + circle.getArea());
        // Для получения доступа к уникальным методам класса-наследника,
        // жёстко указываем, что обращаемся именно к классу-наследнику
        // Хотя, фактически он таковым и является, программа видит его, как экземпляр класса-родителя,
        // т.к. именно в таком виде он был создан
        ((Circle) circle).rotate(180);
        circle.erase();

        // Аналогично другие фигуры
        Figure square = new Square(5,5,5,"жёлтый");
        square.draw();
        square.move(10,10);
        System.out.println("Периметр: " + square.getPerimeter());
        System.out.println("Площадь: " + square.getArea());
        ((Square) square).tilt();
        square.erase();

        Figure triangle = new Triangle(5,5,5,10, 10, 10, "зелёный");
        triangle.draw();
        triangle.move(10,10);
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Площадь: " + triangle.getArea());
        ((Triangle) triangle).reflect();
        triangle.erase();
    }
}
