package web

import amstel.AmstelModule
import com.google.inject.AbstractModule
import ratpack.error.ClientErrorHandler
import ratpack.error.ServerErrorHandler
import web.controllers.HelloController
import web.core.ExceptionHandler

class RatpackModule extends AbstractModule {

    protected void configure() {
        println 'Building Ratpack module.'
        install(new AmstelModule())

        bind(HelloController)

        bind(ClientErrorHandler).to(ExceptionHandler)
        bind(ServerErrorHandler).to(ExceptionHandler)
    }
}
