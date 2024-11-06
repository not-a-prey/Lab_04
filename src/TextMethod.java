import java.util.HashSet;

/*
Клас TextMethod, який складається з тексту типу Text та довжини слова.
Має метод, який у даному йому тексті шукає та повертає слова заданої довжини у питальних реченнях.
 */
public class TextMethod {
    private Text text;
    private int wordLength;

    public TextMethod(Text text, int wordLength) {
        this.text = text;
        this.wordLength = wordLength;
    }

    /*
    Метод, який спочатку перевіряє чи не пустий текст був заданий. Потім йде перевірка на присутність речень
    (випадки "вафлі вафлі" - не є реченням). Далі йде пошук слів у питальних реченнях,
    які додаються у HashSet та виводяться, якщо вони є, якщо немає - програма про це повідомляє.
     */
    public String getWordsGivenLengthInQuestions(){
        if (text.isNull()){
            return "Текст не заданий";
        }

        if (!text.hasSentences()){
            return "У тексті відсутні розділові знаки для визначення речень.";
        }

        HashSet<String> matchingWords = new HashSet<>();
        for (Sentence sentence : text.getSentences()){
            if (sentence.isQuestion()){
                for (Object e : sentence.getWordsAndPunctuations()){
                    if (e instanceof Word){
                        Word word = (Word) e;
                        if (word.toString().length() == wordLength){
                            matchingWords.add(word.toString());
                        }
                    }
                }
            }
        }
        if (matchingWords.isEmpty()){
            return "Слів із заданою довжиною [" + wordLength + "] у питальних реченнях не знайдено.";
        } else {
            return "Знайдені у питальних реченнях слова із заданою довжиною [" + wordLength + "]: " + matchingWords;
        }
    }
}
