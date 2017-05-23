define(['angular', './routes','./controllers', '../common/playRoutes'], function(angular) {
  'use strict';

  return angular.module('gameModules.home', ['ngRoute', 'home.routes']);
});
