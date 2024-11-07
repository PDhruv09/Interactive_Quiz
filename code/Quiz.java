import java.util.HashMap;
import java.util.Map;

public class Quiz {
    private DoublyLinkedList<Question> questions;
    private int score;

    public Quiz() {
        questions = new DoublyLinkedList<>();
        score = 0;
    }

    public void addQuestion(String questionText, Map<String, String> options, String correctAnswer) {
        questions.add(new Question(questionText, options, correctAnswer));
    }

    // Rest of the Quiz class remains the same
}
