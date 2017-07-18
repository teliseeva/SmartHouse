(function(){
	'use strict'
	var app = angular.module('app', []);
	app.controller('AppController', function($scope, $http) {
		$scope.getData = function(){
			$http.get('/temperature')
			.then(function(response){
				$scope.temperature = response.data;
			});
			$http.get('/humidity')
			.then(function(response){
				$scope.humidity = response.data;
			});					
		}		
	});		
})();
