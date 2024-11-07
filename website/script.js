let currentQuestionIndex = 0;
let quiz;

function displayQuestion() {
    const questionData = quiz.questions.getNodeAt(currentQuestionIndex);

    if (questionData) {
        document.getElementById("question").textContent = questionData.questionText;

        const optionsContainer = document.getElementById("options");
        optionsContainer.innerHTML = ''; // Clear previous options

        // Loop through options as key-value pairs
        Object.entries(questionData.options).forEach(([key, optionText]) => {
            const optionButton = document.createElement("button");
            optionButton.textContent = `${key}: ${optionText}`;
            optionButton.onclick = () => selectAnswer(key);
            optionsContainer.appendChild(optionButton);
        });
    } else {
        console.error("No question data found!");
    }
}


function selectAnswer(selectedOption) {
    const questionData = quiz.questions.getNodeAt(currentQuestionIndex);
    if (questionData && selectedOption === questionData.correctAnswer) {
        document.getElementById("answer-feedback").textContent = "Correct!";
        document.getElementById("answer-feedback").style.color = "green";
    } else {
        document.getElementById("answer-feedback").textContent = "Incorrect!";
        document.getElementById("answer-feedback").style.color = "red";
    }
    document.getElementById("answer-feedback").style.display = "block";
}

function startQuiz() {
    document.getElementById("start-button").style.display = "none";
    document.getElementById("quiz-container").style.display = "block";

    quiz = new Quiz();
    quiz.addQuestion("What is the capital of France?", { A: "Paris", B: "London", C: "Berlin", D: "Madrid" }, "A");
    quiz.addQuestion("What is the largest planet in our Solar System?", { A: "Earth", B: "Jupiter", C: "Mars", D: "Venus" }, "B");
    quiz.addQuestion("Who wrote 'Hamlet'?", { A: "Charles Dickens", B: "William Shakespeare", C: "J.K. Rowling", D: "Jane Austen" }, "B");

    displayQuestion();
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
    currentQuestionIndex = 0;
    document.getElementById("quiz-container").style.display = "none";
    document.getElementById("start-button").style.display = "block";
}
