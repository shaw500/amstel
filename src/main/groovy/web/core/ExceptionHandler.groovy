package web.core

import ratpack.error.ClientErrorHandler
import ratpack.error.ServerErrorHandler
import ratpack.handling.Context

class ExceptionHandler implements ClientErrorHandler, ServerErrorHandler {

    public void error(Context context, int statusCode) throws Exception {
        context.getResponse().status(statusCode).send();
    }

    public void error(Context context, Throwable throwable) throws Exception {
        context.render(throwable.message)
    }

}