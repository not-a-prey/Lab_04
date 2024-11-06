/*
Клас PunctuationMark, що складається з геттеру та звичайного конструктора та
поля punctuation типу char, який відповідає за розділові знаки.
 */
public class PunctuationMark{
    private char punctuation;

    public PunctuationMark(char punctuation){
        this.punctuation = punctuation;
    }

    /*
    Геттер, який повертає розділовий знак.
     */
    public char getPunctuation(){
        return punctuation;
    }

    @Override
    public String toString(){
        return String.valueOf(punctuation);
    }
}
