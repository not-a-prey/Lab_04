/**
 * Клас PunctuationMark, що складається з геттеру та звичайного конструктора та
 * поля punctuation типу char, який відповідає за розділові знаки.
 *
 * @author Dmytro Lutsenko
 */
public class PunctuationMark{
    private char punctuation;

    /**
     * Конструктор класу PunctuationMark.
     *
     * @param punctuation розділовий знак
     */
    public PunctuationMark(char punctuation){
        this.punctuation = punctuation;
    }

    /**
     * Геттер, який повертає розділовий знак.
     *
     * @return розділовий знак типу char
     */
    public char getPunctuation(){
        return punctuation;
    }

    /**
     * Перевизначений метод toString() для зручнішого виводу розділового знаку.
     *
     * @return розділовий знак у відформатованому вигляді.
     */
    @Override
    public String toString(){
        return String.valueOf(punctuation);
    }
}
