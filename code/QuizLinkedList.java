// QuizLinkedList.java
public class QuizLinkedList {
    private QuizNode head;
    private QuizNode current;

    public QuizLinkedList() {
        this.head = null;
        this.current = null;
    }

    public void addQuestion(String question, String[] options, String correctAnswer) {
        QuizNode newNode = new QuizNode(question, options, correctAnswer);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            QuizNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public QuizNode getCurrentQuestion() {
        return current;
    }

    public boolean checkAnswer(String answer) {
        return current != null && current.correctAnswer.equals(answer);
    }

    public void moveToNextQuestion() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void moveToPreviousQuestion() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }
}
