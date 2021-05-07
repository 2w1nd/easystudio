const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const fistForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");

signInBtn.addEventListener("click", () => {
    container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
    container.classList.add("right-panel-active");
});

// fistForm.addEventListener("submit", (e) => e.preventDefault());
// secondForm.addEventListener("submit", (e) => e.preventDefault());


function shoeTips(spanId, tips) {
    var span = document.getElementById(spanId);
    span.innerHTML = tips;
}

/**
 * 校验用户名
 */

function hint() {
    var value = document.getElementById("username").value;
    var hint = document.getElementById("hint");
    if(value.length < 4) {
        hint.innerHTML = "用户名太短";
        return false;
    } else {
        hint.innerHTML = "用户名合格";
        return true;
    }
}

function hint_hide() {
    var hint = document.getElementById("hint");
    hint.innerHTML = "";
}

// 校验是否是纯数字
function checknumber (String) {
    var reg = /^[0-9]+.?[0-9]*$/;
    if (reg.test(String)) {
        return true;
    }
    return false;
}

/**
 * 校验密码
 */

function checkPass() {
    var value = document.getElementById("pwd").value;
    var hint = document.getElementById("pass_hint");
    if(value.length < 6) {
        hint.innerHTML = "密码太短";
        return false;
    }
    else if(checknumber(value)){
        hint.innerHTML = "不能是纯数字";
        return false;
    }
    else {
        hint.innerHTML = "密码格式合格";
        return true;
    }
}

function pass_hide() {
    var hint = document.getElementById("pass_hint");
    hint.innerHTML = "";
}
