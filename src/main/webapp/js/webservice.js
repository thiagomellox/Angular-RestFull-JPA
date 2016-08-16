(function() {
	'use strict';
	var app = angular.module('hs.WebService', []);
	app.factory('WebServiceX', function() {
		var ws = function(method, url, data) {
			return $.ajax({
				type : method,
				url : url,
				contentType : 'application/json;charset=utf-8',
				dataType : 'json',
				data : data
			});
		};
		return {
			get : function(url) {
				return ws('GET', url, {});
			},
			post : function(url, data) {
				return ws('POST', url, data);
			},
			put : function(url, data) {
				return ws('PUT', url, data);
			},
			deleta : function(url, data) {
				return ws('DELETE', url, data);
			}
		};
	});
	
	app.factory('alertService', function($rootScope) {
	    var alertService = {};

	    // create an array of alerts available globally
	    $rootScope.alerts = [];

	    alertService.add = function(type, msg) {
	      $rootScope.alerts.push({'type': type, 'msg': msg});
	    };

	    alertService.closeAlert = function(index) {
	      $rootScope.alerts.splice(index, 1);
	    };

	    return alertService;
	  });
})();