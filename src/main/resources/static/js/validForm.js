var isRun = false;
function validate() {
    getInput = document.question.getElementsByTagName("input");

    for (var i = 0; i < getInput.length; i++) {
        if (getInput[i].value.trim() == "") {
            let getName = getInput[i].getAttribute("id");
            alert(getName + "를 입력하세요")
            return;
        }
    }

    if(isRun == true) { return; } isRun = true;

    document.question.submit();
    isRun  = false;

}
