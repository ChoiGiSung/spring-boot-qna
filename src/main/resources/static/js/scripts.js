$(".answer-write button[type=submit]" ).click(addAnswer);
$(document).on('click', '.link-delete-ATag-article', deleteAnswer);


var isRun = false;
function addAnswer(e){
    e.preventDefault();

    if(isRun == true) { return; } isRun = true;

    var queryString = $(".answer-write").serialize();
    var url = $(".answer-write").attr("action");

    $.ajax({
        type : "post",
        url : url,
        data : queryString,
        dataType : "json",
        error : onError,
        success : onSuccess
    });
}

function deleteAnswer(e){
    e.preventDefault();
    if(isRun == true) { return; } isRun = true;

    var deleteBtn = $(this);
    var url = deleteBtn.attr("href");
    console.log("url" + url);

    $.ajax({
        type : "delete",
        url : url,
        dataType : "text",
        error: onError,
        success : function(data, status){
            if(data == "true"){
                console.log("success");
                deleteBtn.closest("article").remove();
                isRun = true;
            }
        }
    });
}

function onError(request, error){
    alert("fail");
    alert("code:"+request.status+"\n"+"message: 실패요"+"\n"+"error:"+error);

}

function onSuccess(data, status){
    console.log(data);
    isRun  = false;
    var answerTemplate = $("#answerTemplate").html();
    var template = answerTemplate.format(data.writerUserId, data.formatCreateDateTime, data.contents, data.questionId, data.id);
     $(".qna-comment-slipp-articles").prepend(template);

     $(".answer-write textarea").val("");

}


String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};
