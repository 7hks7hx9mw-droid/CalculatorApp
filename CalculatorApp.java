package Calculator;

import javax.swing.SwingUtilities;

public class CalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorModel engine = new CalculatorModel();
            CalculatorView view = new CalculatorView();
            new CalculatorController(engine, view);
        });
    }
}
