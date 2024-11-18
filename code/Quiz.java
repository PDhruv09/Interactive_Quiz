import java.util.HashMap;

public class Quiz {
    DoubleLinkedList questions;
    HashMap<String, String> answerMap;

    public Quiz() {
        questions = new DoubleLinkedList();
        answerMap = new HashMap<>();
    }

    public void addQuestion(Question question) {
        questions.addQuestion(question);
        answerMap.put(question.getQuestion(), question.getCorrectAnswer());
    }

    public Question getNextQuestion() {
        return questions.getNext();
    }

    public Question getPreviousQuestion() {
        return questions.getPrevious();
    }

    public Question getCurrentQuestion() {
        return questions.getCurrent();
    }

    public boolean validateAnswer(String question, String userAnswer) {
        return answerMap.containsKey(question) && answerMap.get(question).equals(userAnswer);
    }
}
