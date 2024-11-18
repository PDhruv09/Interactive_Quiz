document.addEventListener("DOMContentLoaded", () => {
  const questionBox = document.getElementById("question-box");
  const optionsBox = document.getElementById("options-box");
  const checkAnswerBtn = document.getElementById("check-answer");
  const nextQuestionBtn = document.getElementById("next-question");

  let currentQuestionIndex = 0;

  const questions = [
      {
          question: "What is the capital of France?",
          options: ["Paris", "Rome", "Berlin", "Madrid"],
          correctAnswer: "Paris"
      },
      {
          question: "What is 2 + 2?",
          options: ["3", "4", "5", "6"],
          correctAnswer: "4"
      }
  ];

  const displayQuestion = () => {
      const currentQuestion = questions[currentQuestionIndex];
      questionBox.textContent = currentQuestion.question;
      optionsBox.innerHTML = "";
      currentQuestion.options.forEach(option => {
          const btn = document.createElement("button");
          btn.textContent = option;
          btn.onclick = () => selectAnswer(option);
          optionsBox.appendChild(btn);
      });
  };

  const selectAnswer = (answer) => {
      if (answer === questions[currentQuestionIndex].correctAnswer) {
          alert("Correct!");
          nextQuestionBtn.disabled = false;
      } else {
          alert("Wrong! Try again.");
      }
  };

  nextQuestionBtn.onclick = () => {
      currentQuestionIndex++;
      if (currentQuestionIndex < questions.length) {
          displayQuestion();
          nextQuestionBtn.disabled = true;
      } else {
          alert("Quiz Complete!");
      }
  };

  displayQuestion();
});
