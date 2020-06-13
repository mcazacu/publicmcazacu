package hftstuttgart;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(8080);
        get("/calc/:method/:op1/:op2", (req, res) -> {
            res.type("application/json");
            Calculator calc = new Calculator();
            int result = 0;
            int op1 = Integer.parseInt(req.params("op1"));
            int op2 = Integer.parseInt(req.params("op2"));
            switch (req.params("method")) {
                case "sum":
                    result = calc.sum(op1, op2);
                    break;
                case "prod":
                    result = calc.prod(op1, op2);
                    break;
                default:
            }
            return "{\"result\": " + result + "\"}";
        });
    }
}
