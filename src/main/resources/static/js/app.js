let currentIndex = 0;
let questions = [];

document.addEventListener("DOMContentLoaded", () => {
    //クリックイベント登録
    document.getElementById("choice1")
        .addEventListener("click", () => sendAnswer(1));
    document.getElementById("choice2")
        .addEventListener("click", () => sendAnswer(2));
    document.getElementById("choice3")
        .addEventListener("click", () => sendAnswer(3));
    document.getElementById("choice4")
        .addEventListener("click", () => sendAnswer(4));
    document.getElementById("nextButton").addEventListener("click", nextQuestion)

    loadQuestion();
});

//Springから「問題（questions）」を貰う
async function loadQuestion() {
    const category = new URLSearchParams(window.location.search).get("category");

    const response = await fetch(`/api/questions/category?category=${category}`);
    //JSONをJSのオブジェクトに変換
    questions = await response.json();

    displayQuestion();
}

function displayQuestion(){
    const question = questions[currentIndex]

    //「id="列名"」の部分を.textContentを使ってJSONの内容を書き換える
    document.getElementById("question").textContent = question.question;
    document.getElementById("choice1").textContent = question.choice1;
    document.getElementById("choice2").textContent = question.choice2;
    document.getElementById("choice3").textContent = question.choice3;
    document.getElementById("choice4").textContent = question.choice4;
}

//ユーザーの解答を送信する処理
async function sendAnswer(userAnswer) {
    const data = {
        questionId: questions[currentIndex].id,
        answer: userAnswer
    };

    const response = await fetch("/api/questions/answer",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

    const result = await response.json();

    document.getElementById("result").textContent = result.correct ? "正解!" : "不正解";
    document.getElementById("explanation").textContent = result.explanation;
}

function nextQuestion() {
    /*前回の結果を消す処理*/
    document.getElementById("result").textContent = "";
    document.getElementById("explanation").textContent = "";

    /*次の問題へ*/
    currentIndex++;
    displayQuestion();
}
