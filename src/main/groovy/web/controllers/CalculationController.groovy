package web.controllers

import amstel.calculator.Calculator
import com.google.inject.Inject
import ratpack.handling.Context

import static ratpack.jackson.Jackson.json

class CalculationController extends ControllerBase {

    private Calculator calculator

    @Inject
    CalculationController(Calculator calculator) {
        this.calculator = calculator
    }

    void get(Context ctx) {
        def x = ctx.pathTokens.asInt('x')
        def y = ctx.pathTokens.asInt('y')
        def operation = ctx.pathTokens.operation

        ctx.render(json(result: calculator.calculate(x, operation, y)))
    }

    @Override
    String idField() {
        'name'
    }
}
