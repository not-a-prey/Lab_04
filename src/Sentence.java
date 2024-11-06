import java.util.ArrayList;
import java.util.List;

/**
 * Клас Sentence, який складається з масиву слів типу Words та розділових знаків PunctuationMark.
 * Складається з наступних методів: конструктор класу;
 * геттер, який повертає масив слів та розділових знаків;
 * метод isSentence - який перевіряє речення на те, що воно є реченням, а не масивом символів;
 * метод isQuestion - який перевіряє чи є речення питальним.
 *
 * @author Dmytro Lutsenko
 */
public class Sentence{
    private List<Object> wordsAndPunctuations;
    final String allPunctuations = ",:;.?!";

    /**
     * Конструктор класу Sentence.
     *
     * @param sentence речення, яке розбивається на слова та слова разом з розділовим знаком по пробілах,
     *                 потім додається у масив як слово або розділовий знак
     */
    public Sentence(String sentence){
        wordsAndPunctuations = new ArrayList<>();
        String[] elements = sentence.split("\\s+");  //розбиваємо речення на слова та слова із розділовими знаками по пробілах

        for(String element : elements){
            //Йде перевірка чи є після слова розділовий знак. Якщо є -> записується спочатку слово,
            //потім і розділовий знак, якщо немає -> записується тільки слово
            if (allPunctuations.contains(element.substring(element.length()-1))){
                wordsAndPunctuations.add(new Word(element.substring(0,element.length()-1)));
                wordsAndPunctuations.add(new PunctuationMark(element.toCharArray()[element.length()-1]));
            } else{
                wordsAndPunctuations.add(new Word(element));
            }
        }
    }

    /**
     * Геттер, який повертає слова та розділові знаки.
     *
     * @return масив слів та розділових знаків
     */
    public List<Object> getWordsAndPunctuations(){
        return wordsAndPunctuations;
    }

    /**
     * Метод, який робить перевірку чи є речення питальним.
     *
     * @return true - якщо речення питальне, false - якщо ні.
     */
    public boolean isQuestion(){
        if (!wordsAndPunctuations.isEmpty() && wordsAndPunctuations.get(wordsAndPunctuations.size() - 1) instanceof PunctuationMark){
            PunctuationMark lastPunctuation = (PunctuationMark) wordsAndPunctuations.get(wordsAndPunctuations.size() - 1);
            return lastPunctuation.getPunctuation() == '?';
        }
        return false;
    }

    /**
     * Метод, який робить перевірку чи є це речення саме реченням, а не масивом літер та пробілів.
     *
     * @return true - якщо у речення закінчується на крапку (.), знак питання (?) або оклику (!),
     * false - у інших випадках.
     * Наприклад, [вафлі вафлі] - не є реченням, але [вафлі вафлі?] - є реченням.
     */
    public static boolean isSentence(String sentence){
        if (sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!")){
            return true;
        }
        return false;
    }

    /**
     * Перевизначений метод toString() для зручнішого виводу слів та розділових знаків (речення).
     *
     * @return речення у відформатованому вигляді.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Object wordOrPunctuation : wordsAndPunctuations){
            if (wordOrPunctuation instanceof Word){
                sb.append(wordOrPunctuation.toString()).append(" ");
            } else if (wordOrPunctuation instanceof PunctuationMark){
                sb.append(wordOrPunctuation.toString());
            }
        }
        return sb.toString();
    }
}
