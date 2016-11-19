package web.controllers

import ratpack.handling.Context
import ratpack.handling.Handler

abstract class ControllerBase implements Handler {

    void handle(Context ctx) throws Exception {
        def id = ctx.pathTokens[idField()]
        ctx.byMethod { spec ->
            spec.get {
                id ? getById(ctx, id) : get(ctx)
            }
            spec.post {
                id ? unsupported("POST with an ID is not supported") : post(ctx)
            }
            spec.put {
                id ? put(ctx, id) : unsupported("PUT without an ID is not supported")
            }
            spec.delete {
                id ? put(ctx, id) : unsupported("DELETE without an ID is not supported")
            }
        }
    }

    public void get(Context ctx) {
        unsupported("GET in ${this.class.simpleName} is unsupported")
    }

    public void getById(Context ctx, String id) {
        unsupported("GET by ID in ${this.class.simpleName} is unsupported")
    }

    public void post(Context ctx) {
        unsupported("POST in ${this.class.simpleName} is unsupported")
    }

    public void put(Context ctx, String id) {
        unsupported("PUT in ${this.class.simpleName} is unsupported")
    }

    public void delete(Context ctx, String id) {
        unsupported("DELETE in ${this.class.simpleName} is unsupported")
    }


    private void unsupported(String message) {
        throw new RuntimeException(message)
    }

    abstract String idField()
}