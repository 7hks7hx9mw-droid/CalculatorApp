package Calculator;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculatorEngine {

    private BigDecimal current = BigDecimal.ZERO;
    private BigDecimal stored = BigDecimal.ZERO;
    private String pendingOp = "";
    private boolean startNewNumber = true;

    public void appendDigit(String digit) {
        if (startNewNumber) {
            current = new BigDecimal(digit);
            startNewNumber = false;
        } else {
            current = new BigDecimal(current.toPlainString() + digit);
        }
    }

    public void appendDot() {
        if (!current.toPlainString().contains(".")) {
            current = new BigDecimal(current.toPlainString() + ".");
            startNewNumber = false;
        }
    }

    public void toggleSign() {
        current = current.negate();
    }

    public void clear() {
        current = BigDecimal.ZERO;
        stored = BigDecimal.ZERO;
        pendingOp = "";
        startNewNumber = true;
    }

    public void setOperation(String op) {
        if (!pendingOp.isEmpty() && !startNewNumber) {
            computeResult();
        } else if (pendingOp.isEmpty()) {
            stored = current;
        }
        pendingOp = op;
        startNewNumber = true;
    }

    public BigDecimal computeResult() {
        if (pendingOp.isEmpty()) return current;
        BigDecimal result = BigDecimal.ZERO;
        switch (pendingOp) {
            case "+":
                result = stored.add(current);
                break;
            case "-":
                result = stored.subtract(current);
                break;
            case "×":
                result = stored.multiply(current);
                break;
            case "÷":
                if (current.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = stored.divide(current, MathContext.DECIMAL128);
                break;
        }
        stored = result;
        current = result;
        startNewNumber = true;
        pendingOp = "";
        return result;
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public boolean isStartNewNumber() {
        return startNewNumber;
    }
}

