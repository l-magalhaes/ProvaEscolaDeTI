module = angular.module("Prova", []);

module.controller("DisciplinaController", ["$scope", "http", DisciplinaController]);

function DisciplinaController($scope, $http){
    
    $scope.iniciar = funcaoIniciar;
    $scope.salvar = funcaoSalvar;
    $scope.excluir = funcaoExcluir;
    $scope.editar = funcaoEditar;
    
    $scope.disciplinas = [];
    $scope.disciplina = {};
    $scope.isNovo = true;
    
    function funcaoEditar(alvo) {
        $scope.disciplina = angular.copy(alvo);
        $scope.isNovo = false;
    }
    
    function funcaoExcluir(alvo) {
        $scope.excluir = angular.copy(alvo);
        $scope.isNovo = false;
    }
    
    function funcaoSalvar(alvo) {
        $scope.salvar = angular.create(alvo);
        $scope.isNovo = true;
    }
    
    function funcaoCarregar() {
        $http.get ("/disciplinas").success(onSuccess).error(onError);
        
        function onSuccess(data, status) {
            $scope.disciplinas = data;
            console.log(data);
        }
        function onError(data, status) {
            alert("Erro!!" + data);
        }
    }
    
    function funcaoIniciar() {
        funcaoCarregar();
        console.log(">>> Disciplinas estao sendo carregadas....");
    }
    
}

