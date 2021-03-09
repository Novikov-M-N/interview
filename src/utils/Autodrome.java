package utils;

import car.Car;
import car.Moveable;

/**
 * Полигон для испытаний классов машин, чтобы не тащить всё это в мэйн класс.
 */
public class Autodrome {
    public <T extends Car & Moveable> void test(T car) {
        System.out.println("Испытания автомобиля \"" + car.getName() + "\"...");
        car.open();
        car.start();
        car.move();
        car.stop();
        System.out.println("Испытания успешно завершены");
    }
}
