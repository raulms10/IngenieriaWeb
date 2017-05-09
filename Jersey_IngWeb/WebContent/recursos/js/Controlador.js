/**
 * 
 */
var modulo = angular.module('myModule',[]);

modulo.controller('myController',[
	'$scope',	
	function($scope){
		$scope.lista = [{texto: 'Elemento 1', checked: true},{texto: 'Elemento 2', checked: false}];
		
		$scope.texto = '';
		$scope.agregar = function(){
			if ($scope.texto == '') {
				alert("Debe digitar el texto");
				return;
			}
			$scope.lista.push( {texto: $scope.texto, checked: false} );
			$scope.texto = '';
		}
		
		$scope.eliminar = function(){
			var lista = $scope.lista;
			$scope.lista = [];
			angular.forEach(lista, function(item){
				if(!item.checked()){
					$scope.lista.push(item);
				}
			})
		}
	}
]);