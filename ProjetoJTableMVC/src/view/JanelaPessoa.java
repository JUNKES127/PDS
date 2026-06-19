package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Pessoa;
import model.PessoaTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JanelaPessoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JTextField txtIdade;
	private JTable table;
	
	private JButton btnAdicionar;
	private JButton btnRemover;
	private JButton btnVisualizar;
	private JLabel lblIdade;
	private JLabel lblNewLabel_2;
	

	

	/**
	 * Create the frame.
	 */
	public JanelaPessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][grow][][]", "[][][][][][grow][][][]"));
		
		JLabel lblNewLabel = new JLabel("Nome:");
		contentPane.add(lblNewLabel, "cell 1 0,alignx trailing");
		
		txtNome = new JTextField();
		contentPane.add(txtNome, "cell 2 0 2 1,growx");
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		contentPane.add(lblNewLabel_1, "cell 1 1,alignx trailing");
		
		txtCPF = new JTextField();
		contentPane.add(txtCPF, "cell 2 1 2 1,growx");
		txtCPF.setColumns(10);
		
		lblIdade = new JLabel("Idade:");
		contentPane.add(lblIdade, "cell 1 2,alignx trailing");
		
		txtIdade = new JTextField();
		contentPane.add(txtIdade, "cell 2 2 2 1,growx");
		txtIdade.setColumns(10);
		
		lblNewLabel_2 = new JLabel("E-mail:");
		contentPane.add(lblNewLabel_2, "cell 1 3,alignx trailing");
		
		txtEmail = new JTextField();
		contentPane.add(txtEmail, "cell 2 3 2 1,growx");
		txtEmail.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		contentPane.add(btnAdicionar, "cell 1 4");
		
		btnRemover = new JButton("Remover");
		
		contentPane.add(btnRemover, "cell 2 4");
		
		btnVisualizar = new JButton("Visualizar");
		
		contentPane.add(btnVisualizar, "cell 3 4");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 5 4 4,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}
	
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtIdade() {
		return txtIdade;
	}

	

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public JButton getBtnRemover() {
		return btnRemover;
	}
	
	public JButton getBtnVisualizar() {
		return btnVisualizar;
	}
	
	

}
