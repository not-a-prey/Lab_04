import java.util.ArrayList;
import java.util.List;

/**
 * Клас Word, який складається з масиву літер типу Letter. Містить наступні методи:
 * Звичайний конструктор, який складає слово з літер;
 * Геттер, який повертає масив літер.
 *
 * @author Dmytro Lutsenko
 */
public class Word{
    private List<Letter> letters;

    /**
     * Конструктор класу Word.
     *
     * @param word слово, яке буде розділений у масив літер.
     */
    public Word(String word){
        letters = new ArrayList<>();
        for (char c : word.toCharArray())
            letters.add(new Letter(c));
    }

    /**
     * Геттер, який повертає слово.
     *
     * @return масив літер
     */
    public List<Letter> getWord(){
        return letters;
    }

    /**
     * Перевизначений метод toString() для зручнішого виводу літер (слова).
     *
     * @return слово у відформатованому вигляді.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters){
            sb.append(letter.getLetter());
        }
        return sb.toString();
    }

}
