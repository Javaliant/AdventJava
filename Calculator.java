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


		JTextField[] input = new JTextField[2];
		for (int i = 0; i < input.length; i++) {
			input[i] = new JTextField("");
			input[i].setToolTipText("input operand here");
		}

		JLabel result = new JLabel("Result will be here");
		result.setToolTipText("Click calculate to compute result");

		JComboBox<Operation> operation = new JComboBox<>();
		for (Operation o : Operation.values()) {
			operation.addItem(o);
		}

		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(
			e -> result.setText(
				calculateResult(
					(Operation)(operation.getSelectedItem()),
					input[0].getText(),
					input[1].getText()
				)
			)
		);

		panel.add(input[0]);
		panel.add(input[1]);
		panel.add(calculate);
		panel.add(operation);
		panel.add(result);

		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static String calculateResult(Operation op, String val1, String val2) {
    	double alpha;
    	double beta;

    	try {
    		alpha = Double.parseDouble(val1);
    		beta = Double.parseDouble(val2);
    	} catch(NumberFormatException nfe) {
    		return "Invalid input";
    	}

    	double result = op.compute(alpha, beta);

    	return result == (int)result ?
    		Integer.toString((int)result) : String.format("%.2f", result);
    }
}
