package amstel.calculator;

public class Calculator {

    public int calculate(int x, String operation, int y) {
        def result

        switch (operation) {
            case 'plus':
                result = x + y
                break
            default:
                throw new RuntimeException("Unsupported operation: $operation")
        }

        result
    }

}
