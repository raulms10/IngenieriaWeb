/**
 * 
 */
var appCliente = angular.module('clientes', ['ngRoute']);

appCliente.service('clientes', 
	function($http){
		this.listaClientes = function(){
			return $http({
				url: 'http://localhost:8080/Jersey_IngWeb/raul/cliente', 
				method: 'GET'}
			);
		}
	}	
);

appCliente.controller('listaClientes',
	function($scope, clientes){
		clientes.listaClientes().then(
			function success(data){
				$scope.listaClientes = data.data.clienteJersey;
			}
		);
	}
);

appCliente.config(
	['$routeProvider', 
		function($routeProvider){
			$routeProvider.when('/',{
					templateUrl : 'listaClientes.html', controller: 'listaClientes'
				}					
			);
		}
	]
);