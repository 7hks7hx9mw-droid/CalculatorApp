package Calculator;

import javax.swing.SwingUtilities;

public class CalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorEngine engine = new CalculatorEngine();
            CalculatorView view = new CalculatorView();
            new CalculatorController(engine, view);
        });
    }
}
