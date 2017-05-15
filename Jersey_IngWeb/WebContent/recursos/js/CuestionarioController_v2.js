var cuestionario = angular.module('modCuestionario',[]);

cuestionario.controller('contCuestionario', function($scope){
	$scope.preguntas = [
		{
			id: 1,
			texto: 'Pregunta 1', 
			respValida: 1, 
			respUser: null,
			estado: '',
			respPosibles:[
				{id: 1, texto: 'Respuesta 1.1'},
				{id: 2, texto: 'Respuesta 1.2'},
				{id: 3, texto: 'Respuesta 1.3'},
				{id: 4, texto: 'Respuesta 1.4'} 
			]
		},
		{
			id: 2,
			texto: 'Pregunta 2', 
			respValida: 2, 
			respUser: null,
			estado: '',
			respPosibles:[
				{id: 1, texto: 'Respuesta 2.1'},
				{id: 2, texto: 'Respuesta 2.2'},
				{id: 3, texto: 'Respuesta 2.3'},
				{id: 4, texto: 'Respuesta 2.4'} 
			]
		},
		{
			id: 3,
			texto: 'Pregunta 3', 
			respValida: 3, 
			respUser: null,
			estado: '',
			respPosibles:[
				{id: 1, texto: 'Respuesta 3.1'},
				{id: 2, texto: 'Respuesta 3.2'},
				{id: 3, texto: 'Respuesta 3.3'},
				{id: 4, texto: 'Respuesta 3.4'} 
			]
		},
		{
			id: 4,
			texto: 'Pregunta 4', 
			respValida: 4, 
			respUser: null,
			estado: '',
			respPosibles:[
				{id: 1, texto: 'Respuesta 4.1'},
				{id: 2, texto: 'Respuesta 4.2'},
				{id: 3, texto: 'Respuesta 4.3'},
				{id: 4, texto: 'Respuesta 4.4'} 
			]
		}
	];
	
	$scope.respCorrectas = 0;
	$scope.estadoUsuario = '';
	
	$scope.calificar = function(){
		//alert('calificar');
		$scope.respCorrectas = 0;
		angular.forEach($scope.preguntas, function(item){
			if(item.respUser == item.respValida){
				$scope.respCorrectas++;
				item.estado = 'ok';
			}else{
				item.estado = 'error';
			}
		});
		estadoUsuario();
	}


	/* $scope.validar = function(pregunta){
		if(pregunta.respValida == pregunta.respUser){
			$scope.respCorrectas++;
			pregunta.estado = 'ok';
			//alert('Correcto')
		}else{
			if($scope.respCorrectas > 0 && pregunta.estado == 'ok'){
				$scope.respCorrectas--;
				pregunta.estado = 'error';
			}
			
			//alert('Incorrecto')
		}
		estadoUsuario();
	}; */
	
	function estadoUsuario(){
		var total = $scope.respCorrectas/$scope.preguntas.length;
		if(total == 0){
			$scope.estadoUsuario = 'looser';
		}else if(total == 1){
			$scope.estadoUsuario = 'guru';
		}else{
			$scope.estadoUsuario = 'poor';
		}
	};
});