package car;

/**
 * Этот интерфейс я бы вообще удалил, передав его функцию интерфейсу Moveable.
 * Подробное объяснение мотивов этого есть в комментарии к интерфейсу Moveable.
 */
public interface Stopable {
    void stop();
}
