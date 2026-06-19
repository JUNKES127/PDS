package Calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.JMenuItem;

public class ClaculadoraInvestimentosGrid extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField txtDeposito;
	private JTextField textMeses;
	private JTextField textJuros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClaculadoraInvestimentosGrid frame = new ClaculadoraInvestimentosGrid();
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
	public ClaculadoraInvestimentosGrid() {
		setBounds(new Rectangle(0, 0, 250, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ajuda");
		menuBar.add(mnNewMenu);
		
		JButton btnNewButton_1 = new JButton("Sobre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formSobre tela = new formSobre();
				tela.setVisible(true);
			}
		});
		mnNewMenu.add(btnNewButton_1);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Depósito Mensal R$:");
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtDeposito = new JTextField();
		panel_2.add(txtDeposito);
		txtDeposito.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Num. de Meses");
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textMeses = new JTextField();
		panel_3.add(textMeses);
		textMeses.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Juros ao Mês %");
		contentPane.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textJuros = new JTextField();
		panel_4.add(textJuros);
		textJuros.setColumns(10);
		
		JLabel lblTotalJuros = new JLabel("Total Investido + Juros");
		contentPane.add(lblTotalJuros);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
	
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int deposito = Integer.parseInt(txtDeposito.getText());
				int meses = Integer.parseInt(textMeses.getText());
				int juros = Integer.parseInt(textJuros.getText());
				
				Investimento inv = new Investimento(meses, juros, deposito);
				
				double total = inv.calculaTotal();
				
				lblTotalJuros.setText("Total + " + total);
			}
		});
		contentPane.add(btnNewButton);
		
		

		
		
		
		
		
		
		
		
		
		
		
		

	}

}
