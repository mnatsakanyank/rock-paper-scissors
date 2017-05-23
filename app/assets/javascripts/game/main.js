define(['angular', 'jquery', './routes', './controllers','./services','../common/playRoutes'], function(angular) {
  'use strict';

  return angular.module('gameModules.game', ['ngRoute', 'game.routes', 'game.services','common.playRoutes']);
});
