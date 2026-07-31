
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
}

loadQuestion();

