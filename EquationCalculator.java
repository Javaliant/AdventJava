/* Author: Luigi Vincent
Simple Calculator done with Lambdas
*/

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		JPanel panel = new JPanel(new GridLayout(1, 3));
		JTextField first = new JTextField("2");
		JTextField second = new JTextField("3");
		JComboBox<Operation> calculate = new JComboBox<>();

		calculate.addItem(Operation.SUM);
		calculate.addItem(Operation.DIFFERENCE);
		calculate.addItem(Operation.PRODUCT);
		calculate.addItem(Operation.QUOTIENT);
		calculate.addItem(Operation.EXPONENT);
		calculate.addActionListener(
			e -> JOptionPane.showMessageDialog(
				null, "The result is " +
				calculate(
					((Operation)calculate.getSelectedItem()).getEquation(),
					Double.parseDouble(first.getText()),
					Double.parseDouble(second.getText())
				), 
				"Result", JOptionPane.INFORMATION_MESSAGE
			)
		);

		panel.add(first);
		panel.add(second);
		panel.add(calculate);

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
