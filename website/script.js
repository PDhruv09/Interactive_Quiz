let quiz;
let currentQuestionIndex = 0;
let isAnswerChecked = false;

function startQuiz() {
    document.getElementById("start-button").style.display = "none"; // Hide start button
    document.getElementById("quiz-container").style.display = "block"; // Show quiz container

    quiz = new Quiz(); // Initialize the quiz object

    // Add questions to the doubly linked list
    quiz.addQuestion("What is the capital of France?", ["Paris", "London", "Berlin", "Madrid"], "A");
    quiz.addQuestion("What is the largest planet in our Solar System?", ["Earth", "Jupiter", "Mars", "Venus"], "B");
    quiz.addQuestion("Who wrote 'Hamlet'?", ["Charles Dickens", "William Shakespeare", "J.K. Rowling", "Jane Austen"], "B");

    displayQuestion();
}

function displayQuestion() {
    const question = quiz.questions[currentQuestionIndex];
    document.getElementById("question").textContent = question.questionText;

    const optionsContainer = document.getElementById("options");
    optionsContainer.innerHTML = ''; // Clear previous options

    question.options.forEach((option, index) => {
        const button = document.createElement("button");
        button.textContent = `${index + 1}: ${option}`;
        button.onclick = () => selectAnswer(index);
        optionsContainer.appendChild(button);
    });

    // Reset the checkbox and feedback message
    document.getElementById("check-answer").checked = false;
    document.getElementById("answer-feedback").style.display = "none";
    document.getElementById("next-button").style.display = "none"; // Hide the "Next Question" button until the answer is checked
    isAnswerChecked = false;
}

function selectAnswer(answerIndex) {
    // Store the user's selected answer
    const question = quiz.questions[currentQuestionIndex];
    document.getElementById("answer-feedback").style.display = "none"; // Hide any previous feedback
    selectedAnswer = answerIndex === 0 ? "A" : answerIndex === 1 ? "B" : answerIndex === 2 ? "C" : "D"; // Map index to options (A, B, C, D)
}

function checkAnswer() {
    const question = quiz.questions[currentQuestionIndex];
    const selectedAnswer = document.querySelector('input[name="options"]:checked')?.value;

    if (selectedAnswer) {
        const correct = selectedAnswer === question.correctAnswer;

        // Show feedback and firework if correct
        if (correct) {
            document.getElementById("answer-feedback").innerHTML = "Correct!";
            document.getElementById("answer-feedback").style.color = "green";
            showFireworks(); // Show fireworks animation
        } else {
            document.getElementById("answer-feedback").innerHTML = "Incorrect.";
            document.getElementById("answer-feedback").style.color = "red";
        }

        document.getElementById("answer-feedback").style.display = "block";
        document.getElementById("next-button").style.display = "block"; // Show the "Next Question" button after checking answer
        isAnswerChecked = true; // Prevent the user from selecting an answer again
    }
}

function nextQuestion() {
    if (currentQuestionIndex < quiz.questions.size() - 1) {
        currentQuestionIndex++;
        displayQuestion();
    } else {
        showResetButton();
    }
}

function resetQuiz() {
    // Reset to start page
    currentQuestionIndex = 0;
    document.getElementById("quiz-container").style.display = "none";
    document.getElementById("start-button").style.display = "block";
}

function showFireworks() {
    const fireworkContainer = document.getElementById("firework-container");
    fireworkContainer.innerHTML = "🎆"; // Add a simple firework emoji (can replace with a real animation)
    fireworkContainer.style.display = "block";
    setTimeout(() => {
        fireworkContainer.style.display = "none"; // Hide fireworks after 3 seconds
    }, 3000);
}

function showResetButton() {
    document.getElementById("next-button").style.display = "none"; // Hide the "Next Question" button
    document.getElementById("reset-button").style.display = "block"; // Show the "Reset" button
}
