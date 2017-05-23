/**
 * Game routes.
 */
define(['angular', './controllers'], function(angular, controllers) {
  'use strict';

  var mod = angular.module('game.routes', []);
  mod.config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/game',  {templateUrl: '/assets/javascripts/game/home.html', controller:controllers.HomeCtrl});
  }]);
  return mod;
});
