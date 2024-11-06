/**
 * Клас Letter, що складається з геттеру та звичайного конструктора та поля letter типу char, який відповідає за літери.
 *
 * @author Dmytro Lutsenko
 */
public class Letter{
    private char letter;

    /**
     * Конструктор класу Letter.
     *
     * @param letter літера
     */
    public Letter(char letter){
        this.letter = letter;
    }

    /**
     * Геттер, який повертає літеру.
     *
     * @return літера типу char
     */
    public char getLetter(){
        return letter;
    }

    /**
     * Перевизначений метод toString() для зручнішого виводу літери.
     *
     * @return літера у відформатованому вигляді.
     */
    @Override
    public String toString(){
        return String.valueOf(letter);
    }
}
