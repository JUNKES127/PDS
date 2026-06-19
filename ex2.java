import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercicio02 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblResultado;
	private JTextField txtSobrenome;
	private JLabel lblCompleto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio02 frame = new Exercicio02();
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
	public Exercicio02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(63, 28, 84, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(116, 26, 189, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Mostrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeComp = "Seu nome é " + txtNome.getText() + " " + txtSobrenome.getText();
				lblCompleto.setText(nomeComp);
				
				
			}
		});
		btnNewButton.setBounds(135, 84, 142, 23);
		contentPane.add(btnNewButton);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(71, 161, 286, 14);
		contentPane.add(lblResultado);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(116, 56, 189, 18);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(38, 58, 84, 14);
		contentPane.add(lblSobrenome);
		
		lblCompleto = new JLabel("");
		lblCompleto.setBounds(50, 117, 334, 56);
		contentPane.add(lblCompleto);

	}
}
