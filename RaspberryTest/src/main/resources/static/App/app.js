(function(){
	'use strict'
	var app = angular.module('app', ['ngRoute', 'ngResource']);
	
	app.config(function($routeProvider){
		$routeProvider.when('/TempHum',{
			templateUrl: 'templates/TemperatureHumidity.html',
			controller: 'TempHumController'
		})
		.when('/Gas',{
			templateUrl: 'templates/Gas.html',
			controller: 'gasController'
		})
	})
	
	
	app.controller('TempHumController', function($scope, $http) {
		$scope.getData = function(){
			$http.get('/tempHum')
			.then(function(response){
				$scope.temperature = response.data.temperature;
				$scope.humidity = response.data.humidity;
			});				
		}		
	});
	
	app.controller('gasController', function($scope) {

	});
})();
