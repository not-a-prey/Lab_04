/**
 * Клас Main - головний клас, що складається з виконавчого методу main,
 * де виконується знаходження слів заданої довжини у питальних реченнях у заданому тексті.
 *
 * @author Dmytro Lutsenko
 */
public class Main {
    /**
     * Виконавчий метод, який тестує пошук та виведення слів заданої довжини у заданому тексті.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Довжина слів, які будуть знайдені у питальних реченнях
        int wordLengthy = 6;
        String inputText3 = "";
        String inputText2 = "waffles waffles?";
        //Текст, з яким ми працюємо. Знаходяться саме слова за довжиною, щось на кшталт "a+t" - не є словом і буде виключатись.
        String inputText = """
                But I must explain to you how all this mistaken idea of denouncing pleasure! And praising pain
                was born. And I will give you a complete account of the system, and expound the actual teachings of the
                great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids
                pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure
                rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or
                pursues or desires to obtain pain of itself, because it is pain, but because occasionally
                circumstances occur in which toil and pain can procure him some great pleasure? To take a trivial
                example, which o+f us ever undertakes laborious physical exercise, except to obtain some advantage
                from it? But who has any right to find fa-ult with a man who chooses to enjoy a pleasure that has
                no annoying consequences, or one who avoids a pain that produces -no resultant pleasure?
                Як ти себе почуваєш, батьку? Мені тебе не вистачає дуже, дуже сумую, дуже самотню. Чому я саме плачу,
                коли я тебе згадую? Чому я не можу просто посміхнутись, не пролишви ні одної слізинки? Люблю тебе, тато...""";

        Text text = new Text(inputText);
        TextMethod textMethod = new TextMethod(text, wordLengthy);

        System.out.println("Дія з текстом за варіантом - В усіх питальних реченнях заданого тексту знайти" +
                "та надрукувати без повторень слова заданої довжини.\n");
        System.out.println("Текст:\n" + inputText + "\n");
        System.out.println(textMethod.getWordsGivenLengthInQuestions());
    }
}