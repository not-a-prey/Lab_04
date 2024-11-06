/*
Клас Letter, що складається з геттеру та звичайного конструктора та поля letter типу char, який відповідає за літери.
 */
public class Letter{
    private char letter;

    public Letter(char letter){
        this.letter = letter;
    }

    /*
    Геттер, який повертає літеру.
     */
    public char getLetter(){
        return letter;
    }

    @Override
    public String toString(){
        return String.valueOf(letter);
    }
}
