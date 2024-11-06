import java.util.ArrayList;
import java.util.List;

/*
Клас Word, який складається з масиву літер типу Letter. Містить наступні методи:
Звичайний конструктор, який складає слово з літер;
Геттер, який повертає масив літер.
 */
public class Word{
    private List<Letter> letters;

    public Word(String word){
        letters = new ArrayList<>();
        for (char c : word.toCharArray())
            letters.add(new Letter(c));
    }

    /*
    Геттер, який повертає слово.
     */
    public List<Letter> getWord(){
        return letters;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters){
            sb.append(letter.getLetter());
        }
        return sb.toString();
    }

}
