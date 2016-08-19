var $stateProviderRef = null;

angular.module("webApp", ["ui.router", "webApp.service", 'ui.mask','ui.bootstrap'])
    .config(function ($stateProvider, $urlRouterProvider) {
    	// For any unmatched url, send to /index
		  $urlRouterProvider.otherwise("/listartista");

		  $stateProvider
		  .state('list_artista', {
		      url: "/listartista",
		      templateUrl: "pages/artista/list.html",
		      controller: "ArtistaListController"
		    })
		    .state('incluir_artista', {
		      url: "/incluirartista",
		      templateUrl: "pages/artista/incluir.html",
		      controller: "ArtistaIncluirController"
		    })
		  	
		  
		  .state('list_musica', {
			  url: "/listmusica",
			  templateUrl: "pages/musica/list.html",
			  controller: "MusicaListController"
		  })
		  .state('incluir_musica', {
			  url: "/incluirmusica",
			  templateUrl: "pages/musica/incluir.html",
			  controller: "MusicaIncluirController"
		  });
    	
    });