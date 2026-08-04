
async function loadQuestion(){
    //Springから「問題（questions）」を貰う
    const response = await fetch("/api/questions/1");
    //JSONをJSのオブジェクトに変換
    const question = await response.json();

    //「id="列名"」の部分を.textContentを使ってJSONの内容を書き換える
    document.getElementById("question").textContent = question.question;
    document.getElementById("choice1").textContent = question.choice1;
    document.getElementById("choice2").textContent = question.choice2;
    document.getElementById("choice3").textContent = question.choice3;
    document.getElementById("choice4").textContent = question.choice4;

    //クリックイベント登録
    document.getElementById("choice1")
        .addEventListener("click", () => sendAnswer(1));

    document.getElementById("choice2")
        .addEventListener("click", () => sendAnswer(2));

    document.getElementById("choice3")
        .addEventListener("click", () => sendAnswer(3));

    document.getElementById("choice4")
        .addEventListener("click", () => sendAnswer(4));
}

loadQuestion();

//ユーザーの解答を送信する処理
async function  sendAnswer(userAnswer){

    const data = {
        questionId: 1,
        answer: userAnswer
    };

    const response = await fetch("/api/questions/answer",
    {method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });

    const result = await response.json();

    if(result){
        alert("正解！");
    }else{
        alert("不正解...");
    }
}
