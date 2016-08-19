var webAppModule = angular.module('webApp');

webAppModule.controller('ArtistaListController', function ($scope, $rootScope, WebServiceX, $state, $uibModal, AlertService) {
    $scope.list = {}; 
    $scope.pesquisa = {pesquisa:''};
    
    
    $scope.buscar = function() {
        WebServiceX.post("rest/artista/listar",  JSON.stringify($scope.pesquisa))
      	.then(function(data) {
			$scope.list = data;
			$scope.$apply();
      	}, function(xhr, status, err) {
      		console.log(err);
      		AlertService.add("danger", "Erro : " + err);
      	});        
    };
    
    $scope.remover = function(artista) {
    	
    	var modalInstance = $uibModal.open({
			animation : true,
			templateUrl : 'pages/modal/modalYesNo.html',
			controller : 'ModalInstanceCtrl',
			resolve : {
				nome : function() {
					return artista.nome;
				},
				title : function() {
					return 'Confirmação';
				}
			}
		});
    	

    	modalInstance.result.then(function(selectedItem) {
			WebServiceX.deleta("rest/artista/remover", JSON.stringify(artista))
			.then(function(data) {
				AlertService.add(data.status, data.msg);
				$scope.buscar();
			}, function(xhr, status, err) {
				console.log(err);
				AlertService.add("danger", "Erro : " + err);
			});
		}, function() {
			// no
		});
    	
    };
    
    
    $scope.abrirIncluirArtista = function() {
    	$state.go("incluir_artista");  
    	
    };
    
    $scope.buscar();
    
});

webAppModule.controller('ArtistaIncluirController', function ($scope, $rootScope, WebServiceX, $state, AlertService) {
	$scope.entregadores = [];
	
	
    $scope.salvar = function() {
    	if($scope.artista != undefined){
	    	WebServiceX.post("rest/artista/salvar", JSON.stringify($scope.artista))
	    	.then(function(data) {
	    		AlertService.add(data.status, data.msg);
	    		$state.go("list_artista");  
	    	}, function(xhr, status, err) {
	    		console.log(err);
	    		AlertService.add("danger", "Erro : " + err);
	    	});
	    }else{
	    	AlertService.add("info", "Preencha os campos");
	    }
    };
	
    
    $scope.cancelar = function() {
    	$state.go("list_artista");  
    	
    };
    
});


webAppModule.controller('MusicaListController', function ($scope, $rootScope, WebServiceX, $state, $uibModal, AlertService) {
	$scope.list = {};   
	$scope.pesquisa = {pesquisa:''};
	
	$scope.buscar = function() {
		
		WebServiceX.post("rest/musica/listar",  JSON.stringify($scope.pesquisa))
			.then(function(data) {
				$scope.list = data;
				$scope.$apply();
			}, function(xhr, status, err) {
				console.log(err);
				AlertService.add("danger", "Erro : " + err);
			});        
	};
	
	$scope.remover = function(musica) {
		
		var modalInstance = $uibModal.open({
			animation : true,
			templateUrl : 'pages/modal/modalYesNo.html',
			controller : 'ModalInstanceCtrl',
			resolve : {
				nome : function() {
					return musica.nome;
				},
				title : function() {
					return 'Confirmação';
				}
			}
		});
    	

    	modalInstance.result.then(function(selectedItem) {
    		WebServiceX.deleta("rest/musica/remover", JSON.stringify(musica))
	      	.then(function(data) {
	      		AlertService.add(data.status, data.msg);
	      		$scope.buscar();
	      	}, function(xhr, status, err) {
	      		console.log(err);
	      		AlertService.add("danger", "Erro : " + err);
	      	}); 
		}, function() {
			// no
		});
		
    };
	
	$scope.abrirIncluirMusica = function() {
		$state.go("incluir_musica");  
		
	};
	
	$scope.carregarArtista = function() {
        WebServiceX.get("rest/artista/listar_todos")
      	.then(function(data) {
			$scope.artistas = data;
			$scope.$apply();
      	}, function(xhr, status, err) {
      		console.log(err);
      		AlertService.add("danger", "Erro : " + err);
      	});        
    };
	
    $scope.carregarArtista();
	$scope.buscar();
	
});

webAppModule.controller('MusicaIncluirController', function ($scope, $rootScope, WebServiceX, $state, AlertService) {
	$scope.musica = {};
	
	$scope.carregarArtista = function() {
        WebServiceX.get("rest/artista/listar_todos")
      	.then(function(data) {
			$scope.artistas = data;
			$scope.$apply();
      	}, function(xhr, status, err) {
      		console.log(err);
      		AlertService.add("danger", "Erro : " + err);
      	});        
    };
    
    
	$scope.salvar = function() {
		if($scope.musica != undefined){
			WebServiceX.post("rest/musica/salvar", JSON.stringify($scope.musica))
			.then(function(data) {
				AlertService.add(data.status, data.msg);
				$state.go("list_musica");  
			}, function(xhr, status, err) {
				console.log(err);
				AlertService.add("danger", "Erro : " + err);
			});
		}else{
			AlertService.add("info", "Preencha os campos");
		}
	};
	

	$scope.cancelar = function() {
		$state.go("list_musica");  
		
	};
	
	$scope.carregarArtista();
	
});

webAppModule.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, nome, title) {

	  $scope.nome = nome;
	  $scope.title = title;
	  
	  $scope.ok = function () {
	    $uibModalInstance.close();
	  };

	  $scope.cancel = function () {
	    $uibModalInstance.dismiss('cancel');
	  };
	});


webAppModule.controller('AlertCtrl', function($rootScope, $location, AlertService) {
	$rootScope.changeView = function(view) {
		$location.path(view);
	}

	$rootScope.closeAlert = AlertService.closeAlert;

});



