package geometry;

public class Triangle extends Figure{
    // Собственные свойства только треугольника - координаты двух других вершин
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public Triangle(int x, int y, int x2, int y2, int x3, int y3, String color) {
        super(x, y, color);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void draw() {
        System.out.println("Отрисовка на экране треугольника с цветом " + color
                + ", координатами первой вершины " + x + ", " + y
                + ", второй вершины " + x2 + ", " + y2 + ", третьей вершины " + x3 + ", " + y3);
    }

    @Override
    public void erase() {
        System.out.println("Стирание с экрана треугольника с цветом " + color
                + ", координатами первой вершины " + x + ", " + y
                + ", второй вершины " + x2 + ", " + y2 + ", третьей вершины " + x3 + ", " + y3);
    }

    @Override
    // Для треугольника при перемещении нужно пересчитать координаты всех вершин
    public void move(int newX, int newY) {
        int dx = newX - x;
        int dy = newY - y;
        erase();
        this.x = newX;
        this.y = newY;
        this.x2 += dx;
        this.y2 += dy;
        this.x3 += dx;
        this.y3 += dy;
        draw();
    }

    // Внутренняя служебная функция вычисления длины стороны по координатам вершин
    private float sideLength(int x1, int y1, int x2, int y2) {
        return (float)Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }

    @Override
    public float getPerimeter() {
        float side1Length = sideLength(x,y,x2,y2);
        float side2Length = sideLength(x2,y2,x3,y3);
        float side3Length = sideLength(x3,y3,x,y);
        return side1Length + side2Length + side3Length;
    }

    @Override
    public float getArea() {
        float halfPerimeter = getPerimeter()/2;
        float sideA = sideLength(x,y,x2,y2);
        float sideB = sideLength(x2,y2,x3,y3);
        float sideC = sideLength(x3,y3,x,y);
        return  (float)Math.sqrt(halfPerimeter*(halfPerimeter - sideA)*(halfPerimeter - sideB)*(halfPerimeter - sideC));
    }

    // Пример какой-нибудь функции, присущей только данному типу фигур
    public void reflect() {
        System.out.println("Теперь я вверх ногами");
    }
}
