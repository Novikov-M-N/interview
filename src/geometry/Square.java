package geometry;

public class Square extends Figure{
    private int sideLength; // Собственное свойство только квадрата - длина стороны

    public Square(int x, int y, int sideLength, String color) {
        super(x, y, color);
        this.sideLength = sideLength;
    }

    @Override
    public void draw() {
        System.out.println("Отрисовка на экране квадрата с цветом " + color
                + ", координатами левого нижнего угла " + x + ", " + y
                + " и длиной стороны " + sideLength);
    }

    @Override
    public void erase() {
        System.out.println("Стирание с экрана квадрата с цветом " + color
                + ", координатами левого нижнего угла " + x + ", " + y
                + " и длиной стороны " + sideLength);
    }

    @Override
    public float getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public float getArea() {
        return sideLength * sideLength;
    }

    // Пример какой-нибудь функции, присущей только данному типу фигур
    public void tilt() {
        System.out.println("Теперь я ромб");
    }
}
