package web

import amstel.AmstelModule
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.AbstractModule
import ratpack.error.ClientErrorHandler
import ratpack.error.ServerErrorHandler
import web.controllers.CalculationController
import web.controllers.HelloController
import web.core.ExceptionHandler
import web.core.JsonMarshaller

class RatpackModule extends AbstractModule {

    protected void configure() {
        install(new AmstelModule())

        bind(HelloController)
        bind(CalculationController)

        bind(ObjectMapper).to(JsonMarshaller)
        bind(ClientErrorHandler).to(ExceptionHandler)
        bind(ServerErrorHandler).to(ExceptionHandler)
    }
}
