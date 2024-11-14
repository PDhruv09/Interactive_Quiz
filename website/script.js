let currentQuestionIndex = 0;
let questions = [];

// Load questions from JSON
async function loadQuestions() {
  const response = await fetch("code/questions.json");
  const data = await response.json();
  questions = data.questions;
}

document.getElementById("startQuiz").addEventListener("click", startQuiz);
document.getElementById("checkAnswer").addEventListener("click", checkAnswer);
document.getElementById("nextQuestion").addEventListener("click", nextQuestion);

function startQuiz() {
  document.getElementById("startQuiz").classList.add("hidden");
  document.getElementById("quizBox").classList.remove("hidden");
  loadQuestions().then(() => showQuestion(currentQuestionIndex));
}

function showQuestion(index) {
  const questionText = document.getElementById("questionText");
  const optionsContainer = document.getElementById("options");
  
  questionText.textContent = questions[index].question;
  optionsContainer.innerHTML = '';
  
  // Create option buttons with keys (A, B, C, D)
  for (const [key, value] of Object.entries(questions[index].options)) {
    const button = document.createElement("button");
    button.textContent = `${key}: ${value}`;
    button.classList.add("option-button");
    button.dataset.optionKey = key;  // Store the option key in a data attribute
    button.addEventListener("click", () => selectOption(button));
    optionsContainer.appendChild(button);
  }
}

let selectedOption = null;

function selectOption(button) {
  if (selectedOption) {
    selectedOption.classList.remove("selected");
  }
  button.classList.add("selected");
  selectedOption = button;
}

function checkAnswer() {
  if (selectedOption) {
    const selectedAnswerKey = selectedOption.dataset.optionKey;
    const correctAnswerKey = questions[currentQuestionIndex].answer;
    if (selectedAnswerKey === correctAnswerKey) {
      selectedOption.classList.add("correct");
      alert("Correct!");
    } else {
      selectedOption.classList.add("incorrect");
      alert("Incorrect. The correct answer is " + correctAnswerKey);
    }
  } else {
    alert("Please select an answer.");
  }
}

function nextQuestion() {
  selectedOption = null;
  currentQuestionIndex++;
  if (currentQuestionIndex < questions.length) {
    showQuestion(currentQuestionIndex);
  } else {
    alert("Quiz completed!");
    document.getElementById("quizBox").classList.add("hidden");
    document.getElementById("startQuiz").classList.remove("hidden");
    currentQuestionIndex = 0; // Reset for replay
  }
}
