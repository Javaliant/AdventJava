/* Author: Luigi Vincent
Simple Swing Calculator application to practice with Lambda expressions
*/

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Calculator {
	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info :
				UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(Calculator::new);
	}

	public Calculator() {
		JFrame frame = new JFrame("Simple Operation Calculator");
		JPanel panel = new JPanel(new GridLayout(1, 5));

		JTextField alpha = new JTextField("");
		alpha.setToolTipText("Write the first number here.");
		JTextField beta = new JTextField("");
		beta.setToolTipText("Write the second number here.");

		JLabel result = new JLabel("Result will be here");
		result.setToolTipText("Click calculate to compute result");

		JComboBox<Operation> operation = new JComboBox<>();
		for (Operation o : Operation.values()) {
			operation.addItem(o);
		}

		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(
			e -> result.setText(
				calculate(
					((Operation)operation.getSelectedItem()).getEquation(),
					Double.parseDouble(alpha.getText()),
					Double.parseDouble(beta.getText())
				)
			)
		);

		panel.add(alpha);
		panel.add(beta);
		panel.add(operation);
		panel.add(calculate);
		panel.add(result);

		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static String calculate(Equation operation, double val1, double val2) {
		double result = operation.compute(val1, val2);

		return result == (int)result ? 
			String.valueOf((int)result) :
			String.format("%.2f", result)
		;
	}
}
