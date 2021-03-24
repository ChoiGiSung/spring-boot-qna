function validate() {
    getInput = document.question.getElementsByTagName("input");

    for (var i = 0; i < getInput.length; i++) {
        if (getInput[i].value.trim() == "") {
            let getName = getInput[i].getAttribute("id");
            alert(getName + "를 입력하세요")
            return;
        }
    }
    document.question.submit();
}


var blnClickstop= false;
function submitCheck()
{
    if(blnClickstop== true)
    { alert("이미 클릭했습니다."); return false; }
    blnClickstop= true;

}
