package Calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorController {

    private CalculatorModel engine;
    private CalculatorView view;

    public CalculatorController(CalculatorModel engine, CalculatorView view) {
        this.engine = engine;
        this.view = view;
        initButtons();
    }

    private void initButtons() {
        JPanel buttons = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] labels = {
                "C", "←", "±", "÷",
                "7","8","9","×",
                "4","5","6","-",
                "1","2","3","+",
                "0",".","=", ""
        };

        for (String lab : labels) {
            if (lab.isEmpty()) { buttons.add(new JLabel()); continue; }
            JButton b = new JButton(lab);
            b.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            b.addActionListener(e -> onButton(lab));
            buttons.add(b);
        }

        view.add(buttons, BorderLayout.CENTER);
        view.setVisible(true);
    }

    private void onButton(String label) {
        try {
            switch (label) {
                case "C":
                    engine.clear();
                    break;
                case "←":
                    // Backspace 実装例（省略可能）
                    break;
                case "±":
                    engine.toggleSign();
                    break;
                case "+":
                case "-":
                case "×":
                case "÷":
                    engine.setOperation(label);
                    break;
                case "=":
                    engine.computeResult();
                    break;
                case ".":
                    engine.appendDot();
                    break;
                default:
                    engine.appendDigit(label);
                    break;
            }
            view.updateDisplay(engine.getCurrent().toPlainString());
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "エラー", JOptionPane.ERROR_MESSAGE);
        }
    }
}
