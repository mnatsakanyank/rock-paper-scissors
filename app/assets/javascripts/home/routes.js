/**
 * Main routes.
 */
define(['angular', './controllers', 'common'], function (angular, controllers) {
    'use strict';

    var mod = angular.module('home.routes', ['gameModules.common']);
    mod.config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {templateUrl: '/assets/javascripts/home/newGame.html', controller: controllers.NewGameCtrl})
            .otherwise({templateUrl: '/assets/javascripts/home/notFound.html'});
    }]);
    return mod;
});
