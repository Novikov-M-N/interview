package geometry;

public abstract class Figure {
    // Набор свойств, присущих любым фигурам
    protected int x;
    protected int y;
    protected String color;

    // Конструктор только с параметрами, т.к. фигура без координат и без цвета не имеет смысла
    protected Figure(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Пример, как можно было бы реализовать перемещение фигуры на новое место на экране,
    // чтобы оно было универсальным для любого наследного типа фигур
    public void move(int newX, int newY) {
        this.erase(); // Стираем старую фигуру
        this.x = newX; // Задаём новые координаты
        this.y = newY;
        draw(); // Рисуем фигуру в новом месте
    }

    public abstract void draw();
    public abstract void erase();
    public abstract float getPerimeter();
    public abstract float getArea();
}