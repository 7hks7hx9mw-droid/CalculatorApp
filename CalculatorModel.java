package Calculator;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculatorModel {

    private BigDecimal current = BigDecimal.ZERO;
    private BigDecimal stored = BigDecimal.ZERO;
    private String pendingOp = "";
    private boolean startNewNumber = true;

public void appendDigit(String digit) {
    if (startNewNumber) {
        current = new BigDecimal(digit);
        startNewNumber = false;
        return;
    }

    String text = current.toPlainString();
    if (text.endsWith(".0")) {
        text = text.substring(0, text.length() - 1);
    }

    current = new BigDecimal(text + digit);
}

    public void appendDot() {
    if (startNewNumber) {
        current = new BigDecimal("0.0");
        startNewNumber = false;
        return;
    }

    String text = current.toPlainString();
    if (!text.contains(".")) {
        current = new BigDecimal(text + ".0");
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

    public void backspace() {
    if (startNewNumber) return;

    String text = current.toPlainString();

    if (text.length() <= 1 || (text.length() == 2 && text.startsWith("-"))) {
        current = BigDecimal.ZERO;
        startNewNumber = true;
        return;
    }

    text = text.substring(0, text.length() - 1);

    if (text.equals("-")) {
        current = BigDecimal.ZERO;
        startNewNumber = true;
    } else {
        current = new BigDecimal(text);
    }
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

