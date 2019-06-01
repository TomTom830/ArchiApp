angular.module('PolyNet_registration',[]).controller('mainController', function ($scope, $http){

    $scope.User = {};

   $scope.inscription = function() {
       $http.post("/register",$scope.User).then(function (value) {
           console.log(value.data.response);
           var message = document.getElementsByClassName("nom_deja_pris")[0];
           message.style.visibility = "visible";

           if(value.data.response != "OK") {
               message.innerHTML = value.data.response;
           }
           else{
               message.innerHTML = "Inscription reussie";
               $scope.User = {};
               window.location.replace("/");
           }
       });
   }
});