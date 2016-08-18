var webAppModule = angular.module('webApp');

webAppModule.directive('maskData', function () { 
	return {
		template: '{{data}}',
	    scope:{data:'='},
	    link: function postLink(scope, element, attrs) {  
	    	scope.mascara = function() {
	    		var v = scope.data;
	    		v=v.replace(/^(\d{2})(\d)/g,"$1:$2"); 
	    		scope.data = v;
	        };
	    	
	        scope.mascara();
	    }
	}
});