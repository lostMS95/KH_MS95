window.addEventListener("load",function(){
    var confirmLinkList = document.querySelectorAll("a.confirm-link");
    for(var i =0; i <confirmLinkList.length; i++){
        confirmLinkList[i].addEventListener("click",function(e) {
         var choice = confirm("정말 "+this.textContent+"하시겠습니까?");
         if(!choice){
             e.preventDefault();
         }
        });
    }
});
