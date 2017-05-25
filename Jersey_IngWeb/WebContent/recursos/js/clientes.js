/**
 * 
 */
var appCliente = angular.module('clientes', ['ngRoute','ngCookies']);

appCliente.service('usuarios', 
	function($http, $cookies, $location){
		this.autenticar = function(u,p){
			return $http({
				url: 'http://localhost:8080/Jersey_IngWeb/raul/usuario',
				//url: 'http://192.168.56.1:8080/EjemploJersey/juan/usuario',
				method: 'GET',
				params: {
					login: u,
					pass: p
				}
			});
		},

		this.validarEstado = function(){
			if(typeof($cookies.username) == 'undefined' || $cookies.username == ''){
				$location.url('/');
				return false;
			}
			if($location.url() == '/'){
				
			}
		}
	}
);

appCliente.service('clientes', 
	function($http){
		this.listaClientes = function(){
			return $http({
				url: 'http://localhost:8080/Jersey_IngWeb/raul/cliente', 
				method: 'GET'}
			);
		};
		
		this.guardarCliente = function(cliente){
			return $http({
				url: 'http://localhost:8080/Jersey_IngWeb/raul/cliente', 
				method: 'POST',
				params: 
					{
						cc: cliente.cedula,
						nombres: cliente.nombres,
						apellidos: cliente.apellidos,
						correo: cliente.correo,
						user: 'elver'
					}
			   }
			);
		};
	}	
);

appCliente.controller('listaClientes',
	function($scope, $location, clientes, usuarios){
		
		if(usuarios.validarEstado() ){
			clientes.listaClientes().then(
					function success(data){
						$scope.listaClientes = data.data.clienteJersey;
					}
			);
		}
		
		$scope.agregar = function(){
			$location.url('/nuevo');
		}
	}
);

appCliente.controller('Login',
		function($scope, $location, $cookies, usuarios){
			$scope.login = function(){
				usuarios.autenticar($scope.username, $scope.password).then(
					function success(data){
						if(data.data != "Usario validado"){
							alert(data.data);
							$scope.username = '';
							$scope.password = '';
						}
						$cookies.username = $scope.username;
						$location.url('/listaCliente');
						
					},
					function failure(data){
						alert(data.data);
					}			
				);
			}
		}
	);

appCliente.config(
	['$routeProvider', 
		function($routeProvider){
			$routeProvider.when('/listaClientes',{
					templateUrl : 'listaClientes.html', controller: 'listaClientes'
				}					
			);
			
			$routeProvider.when('/nuevo',{
					templateUrl : 'nuevoCliente.html', controller: 'nuevoCliente'
				}					
			);
			
			$routeProvider.when('/',{
				templateUrl : 'login.html', controller: 'Login'
			}					
		);
		}
	]
);

appCliente.controller('nuevoCliente', 
	function($scope, $location, clientes){
		$scope.cliente = {
			nombre: '',
			apellidos: '',
			cedula: '',
			email: ''
		};
		
		$scope.guardar = function(){
			clientes.guardar($scope.cliente).then(
				function success(data){
					alert('Cliente creado');
					$location.url('/listaClientes');
				}
			)
		}
	}
);

appCliente.run(function($rootScope, usuarios){
	$rootScope.$on('$routeChangeStart', function(){
		usuarios.validarEstado();
	})
});