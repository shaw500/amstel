package web.controllers

import ratpack.handling.Context

import static ratpack.jackson.Jackson.json

class CalculationController extends ControllerBase {

    void get(Context ctx) {
        def x = ctx.pathTokens.asInt('x')
        def y = ctx.pathTokens.asInt('y')
        def operation = ctx.pathTokens.operation

        def result

        switch(operation) {
            case 'plus':
                result = x + y
                break
            default:
                throw new RuntimeException("Unsupported operation: $operation")
        }

        ctx.render(json(result: result))
    }

    @Override
    String idField() {
        'name'
    }
}
