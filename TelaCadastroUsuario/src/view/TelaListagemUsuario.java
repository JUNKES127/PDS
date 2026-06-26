package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import model.UsuarioTableModel;

/**
 * Tela que exibe a lista de usuários cadastrados em formato de tabela.
 *
 * PADRÃO MVC: só cria os componentes visuais. Não tem nenhum
 * addActionListener aqui. O Controller registra os listeners usando
 * os getters dos botões abaixo.
 */
public class TelaListagemUsuario extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTable table;
    private UsuarioTableModel tableModel;

    private JButton btnAdicionar;
    private JButton btnRemover;
    private JButton btnVisualizar;
    private JButton btnVoltar;

    public TelaListagemUsuario(UsuarioTableModel tableModel) {

        this.tableModel = tableModel;

        setTitle("JOBFY - Usuários Cadastrados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("fillx", "[][grow][][]", "[][][grow][]"));

        // Título da tela
        JLabel lblTitulo = new JLabel("Usuários Cadastrados");
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 18));
        contentPane.add(lblTitulo, "cell 0 0 4 1, alignx center, gapbottom 10");

        // Botões de ação
        btnAdicionar = new JButton("Adicionar");
        estilizarBotao(btnAdicionar);
        contentPane.add(btnAdicionar, "cell 0 1");

        btnRemover = new JButton("Remover");
        estilizarBotao(btnRemover);
        contentPane.add(btnRemover, "cell 1 1");

        btnVisualizar = new JButton("Visualizar / Editar");
        estilizarBotao(btnVisualizar);
        contentPane.add(btnVisualizar, "cell 2 1");

        btnVoltar = new JButton("Voltar ao Cadastro");
        estilizarBotao(btnVoltar);
        contentPane.add(btnVoltar, "cell 3 1, alignx right");

        // Tabela com scroll
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, "cell 0 2 4 1, grow");

        table = new JTable(tableModel);
        scrollPane.setViewportView(table);
    }

    private void estilizarBotao(JButton botao) {
        botao.setBackground(Color.BLACK);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Tahoma", Font.BOLD, 11));
    }

    /** Avisa a tabela que os dados mudaram para ela se redesenhar. */
    public void atualizarTabela() {
        tableModel.atualizar();
    }

    public JTable getTable() { return table; }

    // Getters dos botões para o Controller registrar os ActionListeners
    public JButton getBtnAdicionar()  { return btnAdicionar; }
    public JButton getBtnRemover()    { return btnRemover; }
    public JButton getBtnVisualizar() { return btnVisualizar; }
    public JButton getBtnVoltar()     { return btnVoltar; }
}
