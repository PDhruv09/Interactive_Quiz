// QuizNode.java
public class QuizNode {
    String question;
    String[] options;
    String correctAnswer;
    QuizNode next;
    QuizNode prev;

    public QuizNode(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.next = null;
        this.prev = null;
    }
}
