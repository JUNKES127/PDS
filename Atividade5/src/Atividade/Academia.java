package Atividade;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Academia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Field_Nome;
	private JTextField Field_Telefone;
	private JLabel lblNewLabel_Telefone;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton Calc_Button;
	private JLabel ValorFinal_lbl;
	private JLabel Valor_lbl;
	private JComboBox comboBoxPlano;
	private JComboBox comboBoxDuracao;
	private JComboBox comboBoxSemanal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Academia frame = new Academia();
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
	public Academia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[3.00,grow][70.00,grow][110.00,grow][110,grow][110,grow]", "[30.00,grow][30.00,grow][30.00,grow][30.00,grow][30.00,grow][30.00,grow][30.00,grow]"));
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE CLIENTE - ACADEMIA TREINO FIT");
		contentPane.add(lblNewLabel, "cell 2 0 3 1");
		
		JLabel lblNewLabel_Nome = new JLabel("Nome");
		contentPane.add(lblNewLabel_Nome, "cell 1 1,alignx trailing");
		
		Field_Nome = new JTextField();
		contentPane.add(Field_Nome, "cell 2 1 2 1,growx");
		Field_Nome.setColumns(10);
		
		lblNewLabel_Telefone = new JLabel("Telefone");
		contentPane.add(lblNewLabel_Telefone, "cell 1 2,alignx trailing");
		
		Field_Telefone = new JTextField();
		contentPane.add(Field_Telefone, "cell 2 2 2 1,growx");
		Field_Telefone.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Tipo de Plano");
		contentPane.add(lblNewLabel_3, "cell 1 3,alignx trailing");
		
		JComboBox<TipoDePlano> ComboBoxPlano= new JComboBox<>(TipoDePlano.values());
		contentPane.add(ComboBoxPlano, "cell 2 3 3 1,growx");
		
		
		lblNewLabel_4 = new JLabel("Duração");
		contentPane.add(lblNewLabel_4, "cell 1 4,alignx trailing");
		
		JComboBox<Duracao> comboBoxDuracao = new JComboBox<>(Duracao.values());
		contentPane.add(comboBoxDuracao, "cell 2 4 3 1,growx");
		
		lblNewLabel_5 = new JLabel("Frequência semanal");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5, "cell 1 5,alignx trailing");
		
		JComboBox<Semanal>comboBoxSemanal = new JComboBox<>(Semanal.values());
		contentPane.add(comboBoxSemanal, "cell 2 5 3 1,growx");
		
		Calc_Button = new JButton("Calcular");
		Calc_Button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TipoDePlano PlanoSelecionado = (TipoDePlano) ComboBoxPlano.getSelectedItem();
				Duracao Duracao = (Duracao) comboBoxDuracao.getSelectedItem();
				Semanal Frequencia = (Semanal) comboBoxSemanal.getSelectedItem();
				
				Double Valor = PlanoSelecionado.getValor();
				
				if(Field_Nome.getText().isEmpty() || Field_Telefone.getText().isEmpty()) {
					javax.swing.JOptionPane.showMessageDialog(null, "Preencha nome e telefone");
					return;
				}
				
				Valor = Valor + ((Valor / 100) * Frequencia.getAcrescimo());
				
				Valor = Valor - ((Valor / 100) * Duracao.getDescontos());
				
				Valor_lbl.setText("R$" + String.format("%.2f", Valor));
			}
		});
		
		contentPane.add(Calc_Button, "cell 2 6,alignx center,aligny center");
		
		ValorFinal_lbl = new JLabel("Valor Final:");
		contentPane.add(ValorFinal_lbl, "cell 3 6,alignx center");
		
		Valor_lbl = new JLabel("");
		contentPane.add(Valor_lbl, "cell 4 6,alignx left");

	}

}
