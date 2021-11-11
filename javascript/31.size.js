window.addEventListener("load",function() {
    document.querySelector("#btn-small").addEventListener("click", function() {
         var image=document.querySelector("#sample");
         image.width = 100;
         image.height = 100;
     });
     
        document.querySelector("#btn-normal").addEventListener("click", function() {
             var image=document.querySelector("#sample");
             image.width = 200;
             image.height = 200;
         });
 

    document.querySelector("#btn-large").addEventListener("click", function() {
         var image=document.querySelector("#sample");
         image.width = 300;
         image.height = 300;
     });

 });