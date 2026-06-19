import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercicio6 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtN1;
	private JLabel lblPreco;
	private JTextField txtN2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio6 frame = new Exercicio6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Exercicio6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblN1 = new JLabel("Numero 1: ");
		lblN1.setBounds(59, 96, 150, 14);
		contentPane.add(lblN1);

		txtN1 = new JTextField();
		txtN1.setBounds(121, 94, 189, 20);
		contentPane.add(txtN1);
		txtN1.setColumns(10);

		JLabel lblTitulo = new JLabel("Calculadora");
		lblTitulo.setBounds(59, 54, 300, 14);
		contentPane.add(lblTitulo);

		lblPreco = new JLabel("");
		lblPreco.setBounds(141, 239, 150, 14);
		contentPane.add(lblPreco);

		JLabel lblN2 = new JLabel("Numero 2:");
		lblN2.setBounds(59, 134, 80, 12);
		contentPane.add(lblN2);
		
		txtN2 = new JTextField();
		txtN2.setBounds(121, 131, 189, 20);
		contentPane.add(txtN2);
		txtN2.setColumns(10);
		
		JLabel lblResult = new JLabel("");
		lblResult.setBounds(163, 217, 107, 12);
		contentPane.add(lblResult);
		

		JButton btnSomar = new JButton("Somar");
		btnSomar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					double num1 = Double.parseDouble(txtN1.getText());
					double num2 = Double.parseDouble(txtN2.getText());
					
					String result =  "Resultado = " + String.format("%.2f", num1+num2) ;
					lblResult.setText(result);
				
			}
		});
		
		
		btnSomar.setBounds(31, 171, 80, 23);
		contentPane.add(btnSomar);
		
		JButton btnSubtrair = new JButton("Subtrair");
		btnSubtrair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(txtN1.getText());
				double num2 = Double.parseDouble(txtN2.getText());
				
				String result =  "Resultado = " + String.format("%.2f", num1-num2) ;
				lblResult.setText(result);
			}
		});
		btnSubtrair.setBounds(121, 171, 80, 23);
		contentPane.add(btnSubtrair);
		
		JButton btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(txtN1.getText());
				double num2 = Double.parseDouble(txtN2.getText());
				
				String result =  "Resultado = " + String.format("%.2f", num1*num2) ;
				lblResult.setText(result);
				
			}
		});
		btnMultiplicar.setBounds(211, 171, 107, 23);
		contentPane.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("Dividir");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(txtN1.getText());
				double num2 = Double.parseDouble(txtN2.getText());
				
				String result =  "Resultado = " + String.format("%.2f", num1/num2) ;
				lblResult.setText(result);
			}
		});
		btnDividir.setBounds(328, 171, 80, 23);
		contentPane.add(btnDividir);
	}
}