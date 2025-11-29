package Calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {

    private JTextField display = new JTextField();

    public CalculatorView() {
        setTitle("電卓");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        display.setText("0");
        add(display, BorderLayout.NORTH);
    }

    public JTextField getDisplay() {
        return display;
    }

    public void updateDisplay(String text) {
        display.setText(text);
    }
}
