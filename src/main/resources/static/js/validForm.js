var validateFlag = false;
function validate() {

    alert(validateFlag+"현상태");
    if(validateFlag == true) {
        return;
    }

    validateFlag = true;

    getInput = document.question.getElementsByTagName("input");

    for (var i = 0; i < getInput.length; i++) {
        if (getInput[i].value.trim() == "") {
            let getName = getInput[i].getAttribute("id");
            alert(getName + "를 입력하세요")
             alert(validateFlag+"현상태2");
            return;
        }
    }
    validateFlag = false;
    document.question.submit();
             alert(validateFlag+"현상태3");
}
