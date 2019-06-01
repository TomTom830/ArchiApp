angular.module('todoList',[]).controller('mainController', function ($scope, $http){

    $scope.Laliste={};
    $scope.Task={};
    $scope.modify=[];

    $http.get('/getTasks').then(function (response) {
        $scope.Laliste = response.data;
    });

    $scope.addTask = function(){
        if($scope.Task.content == "" || typeof $scope.Task.content == "undefined"){
            alert("Veuillez remplir le champ nom de la tache");
        }
        else {
            $http.post('/addTask', $scope.Task).then(function (response) {
                refresh_list();
                $scope.Task = {};
            });
        }
    }

    $scope.delTask = function(id) {
        $http.delete('/delTask?id='+id).then(function(){
           refresh_list();
        });
    }

    $scope.modifyList = function(id){
        if($scope.modify[id] == "" || typeof $scope.modify[id] == "undefined") {
            alert("Saisissez le nom de la tache a modifier");
        }
        else {
            $http.put("/modifTask?id=" + id + "&content=" + $scope.modify[id]).then(function () {
                $scope.modify = [];
                refresh_list();
            });
        }
    }

    refresh_list = function(){
        $http.get('/getTasks').then(function (response) {
            $scope.Laliste = response.data;
        });
    }
});