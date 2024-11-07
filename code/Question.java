import java.util.Map;

public class Question {
    private String questionText;
    private Map<String, String> options;
    private String correctAnswer;

    public Question(String questionText, Map<String, String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
