## Intro
Rock Paper Scissors web game
 
For now 2 mods are supporter
* Player vs Computer
* Computer vs Computer

Implemented with Scala Play framework, AngularJs 1.4, WebJars and RequireJS 

## Code Organization

The Application modules are organized as follows:

    |- app
    |-- assets 
    |--- javascripts <- contains all the JavaScript modules
    |--- stylesheets <- contains all styles needed
    |--controllers <- controllers to serve backend actions
    |--models <- models for rendering 
    |--views <- index page

## Implementation Details
  
  JsRoutes Controller - The play framework is able to generate Javascript code to handle routing from 
  Javascript running client side back to your application. JsRoutes Controller serves this functionality which 
  basically configuration. No need to write tests for this.
  
  AppLoader - is the entry point for the application and holds configurations for play framework. No tests needed
  
  GameController - Main Controller for the game

## Trying It Out

### Dev Mode

* Load dependencies via `sbt update`
* Run via `sbt ~run`
* Go to [localhost:9000](http://localhost:9000)

This uses the normal JavaScript files and loads libraries from the downloaded WebJars.

### Prod Mode

Running:

* Run `sbt testProd`

Deployment:

* Produce executable via `sbt clean dist`
* Extract `unzip target/universal/rock-paper-scissors-1.x.x.zip`
* Run `rock-paper-scissors-1.x.x/bin/rock-paper-scissors -Dhttp.port=9000 -Dconfig.resource=prod.conf`


This uses the uglified JavaScript files, versioned and compressed assets
