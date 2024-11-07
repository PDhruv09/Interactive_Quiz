import java.util.Scanner;

public class Quiz {
    private DoublyLinkedList<Question> questions;
    private int currentQuestionIndex;
    private Scanner scanner;

    public Quiz() {
        questions = new DoublyLinkedList<>();
        currentQuestionIndex = 0;
        scanner = new Scanner(System.in);
    }

    // Add questions to the doubly linked list
    public void addQuestion(String questionText, String[] options, String correctAnswer) {
        questions.add(new Question(questionText, options, correctAnswer));
    }

    // Start the quiz
    public void start() {
        displayCurrentQuestion();
    }

    // Display the current question and options
    private void displayCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            System.out.println("Question: " + currentQuestion.questionText);

            for (int i = 0; i < currentQuestion.options.length; i++) {
                System.out.println((i + 1) + ". " + currentQuestion.options[i]);
            }
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(currentQuestion.correctAnswer)) {
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect.\n");
            }
        } else {
            System.out.println("Quiz Over!");
        }
    }

    // Move to the next question in the list
    public void nextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            displayCurrentQuestion();
        } else {
            System.out.println("No more questions!");
        }
    }

    // Move to the previous question in the list
    public void previousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            displayCurrentQuestion();
        } else {
            System.out.println("This is the first question.");
        }
    }
}
