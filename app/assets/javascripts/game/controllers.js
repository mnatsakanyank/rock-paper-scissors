/**
 * Game controllers.
 */
define(['angular'], function (angular) {
    'use strict';
    var CvCGameFrequency = 2000; //milliseconds

    /** Controls the index page */
    var HomeCtrl = function ($scope, $rootScope, $location, $routeParams, gameService) {
        $rootScope.pageTitle = 'Game';
        $scope.mode = $routeParams.mode;

        resetView($scope);

        $scope.randomMove = function () {
            gameService.randomMove();
        };

        $scope.startGame = function () {
            if ($scope.mode === "CvC") {
                $scope.startGameCvsC();
            } else if ($scope.mode === "PvC") {
                //Nothing to initialize yet
            }
        };

        $scope.doCvsC = function () {
            var pv1Move;
            gameService.randomMove().then(function (value) {
                pv1Move = value.data;
                $scope.movePv1 = "pv1-" + angular.lowercase(pv1Move);
            }).then(function () {
                doSecondPlayerMoveAndProcessResult($scope, pv1Move, gameService);
            });
        };

        $scope.playerMove = function (move) {
            doSecondPlayerMoveAndProcessResult($scope, move, gameService);
        };


        $scope.startGameCvsC = function () {
            var gameInterval = setInterval(function () {
                $scope.doCvsC();
            }, CvCGameFrequency);

            $scope.$on('$destroy', function () {
                clearInterval(gameInterval);
                resetView($scope);
            });
        };

        $scope.startGame();


    };

    function doSecondPlayerMoveAndProcessResult($scope, pv1Move, gameService) {
        var pv2Move;
        gameService.randomMove().then(function (value) {
            pv2Move = value.data;
            $scope.movePv2 = "pv2-" + angular.lowercase(pv2Move);
        }).then(function () {
            return gameService.resultForFirstPlayer(pv1Move, pv2Move);
        }).then(function (value) {
            updateViewsWithResultForFirstPlayer($scope, value);
        });
    }

    function resetView($scope) {
        $scope.pv1Score = 0;
        $scope.pv2Score = 0;
        $scope.pv1GameStatus = "";
        $scope.pv2GameStatus = "";
        $scope.pv1GameClass = "";
        $scope.pv2GameClass = "";
    }

    function updateViewsWithResultForFirstPlayer($scope, pv1GameStatus) {
        if (pv1GameStatus === "WIN") {
            $scope.pv1Score++;
            $scope.pv1GameStatus = "Won";
            $scope.pv2GameStatus = "Loose";
            $scope.pv1GameClass = "btn-success";
            $scope.pv2GameClass = "btn-danger";
        } else if (pv1GameStatus === "LOOSE") {
            $scope.pv2Score++;
            $scope.pv1GameStatus = "Loose";
            $scope.pv2GameStatus = "Won";
            $scope.pv1GameClass = "btn-danger";
            $scope.pv2GameClass = "btn-success";
        } else {
            $scope.pv1GameStatus = "Draw";
            $scope.pv2GameStatus = "Draw";
            $scope.pv1GameClass = "btn-primary";
            $scope.pv2GameClass = "btn-primary";
        }
    }

    HomeCtrl.$inject = ['$scope', '$rootScope', '$location', '$routeParams', 'gameService'];

    return {
        HomeCtrl: HomeCtrl
    };

});
