define([], function () {
    'use strict';

    var NewGameCtrl = function ($scope, $location,$rootScope) {
        $rootScope.pageTitle = 'Paper Rock Scissors';
        $scope.newGame = function (mode) {
            $location.path('/game').search({mode: mode});
        };
    };

    NewGameCtrl.$inject = ['$scope', '$location','$rootScope'];

    return {
        NewGameCtrl: NewGameCtrl
    };

});
