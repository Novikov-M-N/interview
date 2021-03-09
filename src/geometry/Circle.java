package geometry;

public class Circle extends Figure{
    private int radius; // Собственное свойство только круга - радиус

    public Circle(int x, int y, int radius, String color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Отрисовка на экране круга с цветом " + color + ", координатами центра " + x + ", " + y
                + " и радиусом " + radius);
    }

    @Override
    public void erase() {
        System.out.println("Стирание с экрана круга с цветом " + color + ", координатами центра " + x + ", " + y
                + " и радиусом " + radius);
    }

    @Override
    public float getPerimeter() {
        return 2*(float)Math.PI*radius;
    }

    @Override
    public float getArea() {
        return (float)Math.PI*radius*radius;
    }

    // Пример какой-нибудь функции, присущей только данному типу фигур
    public void rotate(int angle) {
        System.out.println("Ничего не изменилось");
    }
}
