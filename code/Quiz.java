import java.util.Scanner;

public class Quiz {
    private DoublyLinkedList<Question> questions;
    private DoublyLinkedList.Node<Question> currentQuestionNode;
    private int score;

    public Quiz() {
        questions = new DoublyLinkedList<>();
        score = 0;
    }

    // Add a question to the doubly linked list
    public void addQuestion(String questionText, String[] options, String correctAnswer) {
        questions.add(new Question(questionText, options, correctAnswer));
    }

    // Start the quiz, initializing current question to the head
    public void start() {
        currentQuestionNode = questions.getHead();
        if (currentQuestionNode != null) {
            displayCurrentQuestion();
        } else {
            System.out.println("No questions in the quiz.");
        }
    }

    // Display the current question
    public void displayCurrentQuestion() {
        Question question = currentQuestionNode.getData();
        System.out.println(question.getQuestionText());
        
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((char)('A' + i) + ": " + options[i]);
        }
        System.out.print("Enter your answer (A, B, C, or D): ");
    }

    // Check answer, give feedback, and move to the next question
    public void checkAnswer(String userAnswer) {
        Question question = currentQuestionNode.getData();
        if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was " + question.getCorrectAnswer() + ".");
        }
        
        // Move to the next question or show results
        if (currentQuestionNode.getNext() != null) {
            currentQuestionNode = currentQuestionNode.getNext();
            displayCurrentQuestion();
        } else {
            showResults();
        }
    }

    // Show the results
    private void showResults() {
        System.out.println("Quiz complete! Your total score is: " + score + " out of " + questions.size());
    }

    // Inner class for doubly linked list
    private static class DoublyLinkedList<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        public Node<T> getHead() {
            return head;
        }

        public int size() {
            return size;
        }

        // Node class for the doubly linked list
        private static class Node<T> {
            private T data;
            private Node<T> next;
            private Node<T> prev;

            public Node(T data) {
                this.data = data;
            }

            public T getData() {
                return data;
            }

            public Node<T> getNext() {
                return next;
            }

            public Node<T> getPrev() {
                return prev;
            }
        }
    }
}
