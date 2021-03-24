var validateFlag = false;
function validate() {

    if(validateFlag == true) {
        return;
    }

    validateFlag = true;

    getInput = document.question.getElementsByTagName("input");

    for (var i = 0; i < getInput.length; i++) {
        if (getInput[i].value.trim() == "") {
            let getName = getInput[i].getAttribute("id");
            alert(getName + "를 입력하세요")
            return;
        }
    }
    validateFlag = false;
    document.question.submit();
}
