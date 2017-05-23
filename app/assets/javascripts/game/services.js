/**
 * Game Service
 */
define(['angular'], function (angular) {
    'use strict';

    var mod = angular.module('game.services', ['ngCookies']);
    mod.factory('gameService', ['$http', '$q', 'playRoutes', '$cookies', function ($http, $q, playRoutes) {

        return {
            randomMove: function () {
                return playRoutes.controllers.GameController.randomMove().get().then(function (response) {
                    return response;
                });
            },
            resultForFirstPlayer: function (pv1Move, pv2Move) {
                return playRoutes.controllers.GameController.resultForFirstPlayer(pv1Move,pv2Move).get().then(function (response) {
                    return response.data;
                });
            }
        };
    }
    ])
    ;
});
