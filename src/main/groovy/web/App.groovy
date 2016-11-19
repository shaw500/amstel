package web

import com.google.inject.Module
import ratpack.guice.Guice
import ratpack.handling.Chain
import ratpack.server.RatpackServer
import ratpack.server.RatpackServerSpec
import web.controllers.CalculationController
import web.controllers.HelloController

class App {

    Module module
    RatpackServer server

    App(Module module) {
        this.module = module
    }

    public void buildServer() {
        server = RatpackServer.of { spec ->
            configureServer(spec)
        }
    }

    public void start() {
        server.start()
    }

    public void stop() {
        server.stop()
    }

    public void configureServer(RatpackServerSpec spec) {
        spec.registry(Guice.registry { r ->
            r.module module
        }).handlers { chain ->
            routes(chain)
        }
    }

    private void routes(Chain chain) {
        chain.path 'hello', HelloController
        chain.path 'hello/:name', HelloController

        chain.path 'api/calculate/:x/:operation/:y', CalculationController
    }

    public static void main(String[] args) {
        def app = new App(new RatpackModule())
        app.buildServer()
        app.start()
    }
}