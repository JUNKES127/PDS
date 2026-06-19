import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercicio4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLitro;
	private JTextField txtPago;
	private JLabel lblQnt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio4 frame = new Exercicio4();
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
	public Exercicio4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLitro = new JLabel("Preço/litro (R$):");
		lblLitro.setBounds(35, 96, 116, 14);
		contentPane.add(lblLitro);

		txtLitro = new JTextField();
		txtLitro.setBounds(161, 94, 189, 20);
		contentPane.add(txtLitro);
		txtLitro.setColumns(10);

		txtPago = new JTextField();
		txtPago.setBounds(161, 124, 189, 20);
		contentPane.add(txtPago);
		txtPago.setColumns(10);

		JLabel lblPago = new JLabel("Valor pago (R$):");
		lblPago.setBounds(35, 126, 116, 14);
		contentPane.add(lblPago);

		JLabel lblTitulo = new JLabel("Insira as seguintes informações sobre a gasolina:");
		lblTitulo.setBounds(35, 54, 300, 14);
		contentPane.add(lblTitulo);

		lblQnt = new JLabel("");
		lblQnt.setBounds(185, 197, 150, 14);
		contentPane.add(lblQnt);

		JButton btnQnt = new JButton("Calcular litros");
		btnQnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					double pLitro = Double.parseDouble(txtLitro.getText());
					double pPago = Double.parseDouble(txtPago.getText());
					String area = String.format("%.2f", pPago/pLitro) + " litros";
					lblQnt.setText(area);
				
			}
		});
		btnQnt.setBounds(185, 164, 142, 23);
		contentPane.add(btnQnt);
	}
}