## Intro
Rock Paper Scissors web game
 
For now 2 mods are supporter
* Player vs Computer
* Computer vs Computer

Implemented with Scala Play framework, AngularJs 1.4, WebJars and RequireJS 

## Code Organization

The JavaScript modules are organized as follows:

    |- app
    |-- assets 
    |--- javascripts    <- contains all the JavaScript modules
    |--controllers <- controllers to serve backend actions
    |--models <- models for rendering 
    |--views <- index page


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
