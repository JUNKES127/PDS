import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conversao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTemperaturaFahrenheit;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversao frame = new Conversao();
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
	public Conversao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Temperatura (F):");
		lblNewLabel.setBounds(22, 29, 84, 14);
		contentPane.add(lblNewLabel);
		
		txtTemperaturaFahrenheit = new JTextField();
		txtTemperaturaFahrenheit.setBounds(116, 26, 189, 20);
		contentPane.add(txtTemperaturaFahrenheit);
		txtTemperaturaFahrenheit.setColumns(10);
		
		JButton btnNewButton = new JButton("Converter Celsius");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = txtTemperaturaFahrenheit.getText();
				
				//Conversão de String para Float
//				float tempF = Float.parseFloat(temp);
				//Conversão de String para Double
				double tempD = Double.parseDouble(temp);
				//Conversão de String para Int
//				int tempI = Integer.parseInt(temp);
				
				double C = (tempD - 32 ) * 5.0/9.0;
				
				String TempResultado = String.valueOf(C);
				TempResultado = String.format("%.2f", C); //Formatador de Números com virgula
				//Conversão de Float/Double/Int para String
				lblResultado.setText(TempResultado);
				
				
			}
		});
		btnNewButton.setBounds(87, 76, 189, 23);
		contentPane.add(btnNewButton);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(65, 155, 211, 14);
		contentPane.add(lblResultado);

	}
}
