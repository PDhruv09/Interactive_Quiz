import java.util.Scanner;

public class Quiz {
    private DoublyLinkedList<Question> questions; // Stores questions in a linked list
    private MyQueue<String> userResponses;         // Stores user responses

    // Question class to hold question text, options, and answer
    private class Question {
        String questionText;
        String[] options;
        String correctAnswer;

        Question(String questionText, String[] options, String correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public Quiz() {
        questions = new DoublyLinkedList<>();
        userResponses = new MyQueue<>();
        
        // Add sample questions with options and correct answers
        addQuestion("What is the capital of France?", new String[]{"A. Paris", "B. London", "C. Berlin", "D. Madrid"}, "A");
        addQuestion("What is the largest planet in our Solar System?", new String[]{"A. Earth", "B. Jupiter", "C. Mars", "D. Venus"}, "B");
        addQuestion("Who wrote 'Hamlet'?", new String[]{"A. Charles Dickens", "B. William Shakespeare", "C. J.K. Rowling", "D. Jane Austen"}, "B");
    }

    // Method to add questions to the quiz
    public void addQuestion(String questionText, String[] options, String correctAnswer) {
        questions.add(new Question(questionText, options, correctAnswer));
    }

    // Method to start the quiz
    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            System.out.println(currentQuestion.questionText);

            for (int j = 0; j < currentQuestion.options.length; j++) {
                System.out.println(currentQuestion.options[j]);
            }

            System.out.print("Enter your answer (A, B, C, D): ");
            String response = scanner.nextLine().toUpperCase();
            userResponses.enqueue(response);

            if (!response.equalsIgnoreCase(currentQuestion.correctAnswer)) {
                System.out.println("Incorrect. Moving to the next question.\n");
            } else {
                System.out.println("Correct!\n");
            }
        }

        scanner.close();
        showResults();
    }

    // Method to display results
    private void showResults() {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            String response = userResponses.dequeue();

            if (response != null && response.equalsIgnoreCase(question.correctAnswer)) {
                score++;
            }
        }
        System.out.println("Your total score is: " + score + " out of " + questions.size());
    }
}
