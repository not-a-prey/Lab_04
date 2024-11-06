import java.util.ArrayList;
import java.util.List;

/**
 * Клас Text, який складається з масиву речень типу Sentence. У конструкторі класу йде перевірка на
 * які речення ми отримали - пусті, просто символи або повноцінні речення.
 * Складається з геттеру; методу isNull, що повертає пустий або ні текст;
 * методу hasSentences, який повертає чи є хоча б одне цілісне речення.
 *
 * @author Dmytro Lutsenko
 */
public class Text {
    private List<Sentence> sentences;
    private boolean isNull;
    private boolean hasSentences;

    /**
     * Конструктор класу Text.
     *
     * @param text - текст, який буде розділений у масив речень.
     */
    public Text(String text) {
        sentences = new ArrayList<>();
        //Перевірка чи пустий текст був отриманий
        if (text == null || text.trim().isEmpty()) {
            isNull = true;
            hasSentences = false;
            return;
        }

        text = text.replaceAll("[\\t\\s]+", " ");
        String[] sentencesStrings = text.split("(?<=[.!?])\\s*");
        //Перевірка чи є речення у тексті
        if (!Sentence.isSentence(sentencesStrings[0])) {
            hasSentences = false;
            return;
        }

        for (String sentenceString : sentencesStrings) {
            sentences.add(new Sentence(sentenceString));
        }
        hasSentences = true;
    }

    /**
     * Геттер, який повертає усі речення.
     *
     * @return масив речень
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Метод, який повертає чи є текст пустим.
     *
     * @return чи є текст пустим
     */
    public boolean isNull() {
        return isNull;
    }

    /**
     * Метод, який повертає чи є речення у тексті.
     *
     * @return чи є реченням саме реченням, а не масивом символів
     */
    public boolean hasSentences() {
        return hasSentences;
    }

    /**
     * Перевизначений метод toString() для зручнішого виводу речень (тексту).
     *
     * @return текст у відформатованому вигляді.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString()).append(" ");
        }
        return sb.toString();
    }
}
