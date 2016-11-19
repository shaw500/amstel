import web.RatpackModule
import web.controllers.HelloController

import static ratpack.groovy.Groovy.ratpack

ratpack {
    bindings {
        module new RatpackModule()
    }
    handlers {
        path 'hello', HelloController
        path 'hello/:name', HelloController
    }
}