/* Author: Luigi Vincent
Simple operations with lambdas
*/

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class EquationCalculator {
	static interface Equation {
		double compute(double val1, double val2);
	}

	static enum Operation {
        SUM((x, y) -> x + y),
    	DIFFERENCE((x, y) -> x - y),
        PRODUCT((x, y) -> x * y),
        QUOTIENT((x, y) -> x / y),
        EXPONENT(Math::pow);

    private final Equation equation;

    private Operation(Equation equation) {
        this.equation = equation;
    }

    public Equation getEquation() {
    	return this.equation;
    }

    @Override
    public String toString() {
        return 
        	this.name().charAt(0) + 
        	this.name().substring(1).toLowerCase()
        ;
    }
}

	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(EquationCalculator::new);
	}

	public EquationCalculator() {
		JFrame frame = new JFrame("Basic Operations");
		frame.setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(1, 5));
		JTextField first = new JTextField("2");
		JTextField second = new JTextField("3");
		JComboBox<Operation> calculate = new JComboBox<>();
		JLabel result = new JLabel("Outcome");

		for (Operation o : Operation.values()) {
			calculate.addItem(o);
		}

		JButton operate = new JButton("Result");
		operate.addActionListener(
			e -> result.setText(
				String.valueOf(calculate(
					((Operation)calculate.getSelectedItem()).getEquation(),
					Double.parseDouble(first.getText()),
					Double.parseDouble(second.getText())
				)
			))
		);

		panel.add(first);
		panel.add(second);
		panel.add(calculate);
		panel.add(operate);
		panel.add(result);

		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static double calculate(Equation operation, double val1, double val2) {
		return operation.compute(val1, val2);
	}
}
