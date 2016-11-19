package web.controllers

import ratpack.handling.Context

class HelloController extends ControllerBase {

    void get(Context ctx) {
        ctx.render 'Hello'
    }

    void getById(Context ctx, String name) {
        ctx.render "Hello $name!"
    }

    String idField() {
        'name'
    }
}
