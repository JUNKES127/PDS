import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Olá!");
		lblNewLabel.setBounds(242, 31, 89, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btnFechar.setBounds(55, 38, 89, 23);
		contentPane.add(btnFechar);
		
		JLabel lblLupa = new JLabel("");
		lblLupa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = txtNome.getText();
				lblMensagem.setText(nome+" não foi encontrado na base de dados.");
				
				JOptionPane.showMessageDialog(null, nome+" não foi encontrado na base de dados.");
				
			}
		});
		lblLupa.setIcon(new ImageIcon(Janela.class.getResource("/img/lupa.png")));
		lblLupa.setBounds(252, 79, 51, 48);
		contentPane.add(lblLupa);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() ==  KeyEvent.VK_ENTER) {
					String nome = txtNome.getText();
					lblMensagem.setText(nome+" não foi encontrado na base de dados.");
					
					JOptionPane.showMessageDialog(null, nome+" não foi encontrado na base de dados.");
				}
				
			}
		});
		txtNome.setBounds(55, 94, 192, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(55, 69, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblMensagem = new JLabel("");
		lblMensagem.setBounds(55, 178, 310, 23);
		contentPane.add(lblMensagem);

	}
}
