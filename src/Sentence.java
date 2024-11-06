import java.util.ArrayList;
import java.util.List;

/*
Клас Sentence, який складається з масиву слів типу Words та розділових знаків PunctuationMark.
Складається з наступних методів: конструктор класу;
геттер, який повертає масив слів та розділових знаків;
метод isSentence - який перевіряє речення на те, що воно є реченням, а не масивом символів;
метод isQuestion - який перевіряє чи є речення питальним.
 */
public class Sentence{
    private List<Object> wordsAndPunctuations;
    final String allPunctuations = ",:;.?!";

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

    /*
    Геттер, який повертає слова та розділові знаки.
     */
    public List<Object> getWordsAndPunctuations(){
        return wordsAndPunctuations;
    }

    /*
    Метод, який робить перевірку чи є речення питальним та повертає true, якщо воно таким є, false - якщо ні.
     */
    public boolean isQuestion(){
        if (!wordsAndPunctuations.isEmpty() && wordsAndPunctuations.get(wordsAndPunctuations.size() - 1) instanceof PunctuationMark){
            PunctuationMark lastPunctuation = (PunctuationMark) wordsAndPunctuations.get(wordsAndPunctuations.size() - 1);
            return lastPunctuation.getPunctuation() == '?';
        }
        return false;
    }

    /*
    Метод, який робить перевірку чи є це речення саме реченням, а не масивом літер та пробілів.
     */
    public static boolean isSentence(String sentence){
        if (sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!")){
            return true;
        }
        return false;
    }



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
