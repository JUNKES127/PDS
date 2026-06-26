package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

/**
 * Tela de Cadastro de Usuário.
 *
 * PADRÃO MVC: essa classe APENAS cria os componentes visuais (campos,
 * botões, cores, layout). Ela NÃO sabe o que acontece quando um botão
 * é clicado — isso é responsabilidade do Controller.
 *
 * O cabeçalho preto com logo "JOBFY" é mantido igual ao projeto original.
 */
public class TelaCadastroUsuario extends JFrame {

    private static final long serialVersionUID = 1L;

    // --- Campos do formulário ---
    private JTextField    txtNome;
    private JTextField    txtEmail;
    private JPasswordField txtSenha;
    private JTextField    txtTelefone;
    private JTextField    txtDataNascimento;   // formato: dd/mm/aaaa
    private JComboBox<String> cbEscolaridade;
    private JTextArea     txtExperiencia;      // não obrigatório
    private JTextArea     txtHabilidades;

    // --- Botões ---
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnVerUsuarios;

    public TelaCadastroUsuario() {

        setTitle("JOBFY - Cadastro de Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 620);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);

        // Layout principal com MigLayout (mesmo padrão do projeto original)
        contentPane.setLayout(new MigLayout("fillx", "[][40.00,grow,right][grow][grow]",
                "[38.00][][][bottom][][][][grow]"));

        // ===================== CABEÇALHO (igual ao original) =====================
        JPanel cabecalho = new JPanel();
        contentPane.add(cabecalho, "cell 1 0 3 1, height 100, grow");
        cabecalho.setBackground(Color.BLACK);
        cabecalho.setLayout(new MigLayout("insets 0, align center center"));

        // Logo da aplicação
        ImageIcon iconeLogo = carregarIcone("/imagens/LOGO.png", 40, 40);
        if (iconeLogo != null) {
            JLabel lblLogo = new JLabel(iconeLogo);
            cabecalho.add(lblLogo, "split 2");
        }

        JLabel lblJobfy = new JLabel("JOBFY");
        lblJobfy.setForeground(Color.WHITE);
        lblJobfy.setFont(new Font("Times New Roman", Font.BOLD, 32));
        cabecalho.add(lblJobfy);

        // Título da tela
        JLabel lblTitulo = new JLabel("Cadastro de Usuário");
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 18));
        contentPane.add(lblTitulo, "cell 2 1, alignx center, gapbottom 10");

        // ===================== PAINEL DE CAMPOS =====================
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        contentPane.add(panel, "cell 2 2, growx");

        // Grid: coluna rótulo | coluna campo
        panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));

        // --- Nome ---
        panel.add(rotulo("Nome*:"), "cell 0 0");
        txtNome = new RoundedJTextField(1);
        panel.add(txtNome, "cell 1 0, growx");

        // --- E-mail ---
        panel.add(rotulo("E-mail*:"), "cell 0 1");
        txtEmail = new RoundedJTextField(1);
        panel.add(txtEmail, "cell 1 1, growx");

        // --- Senha ---
        panel.add(rotulo("Senha*:"), "cell 0 2");
        txtSenha = new JPasswordField();
        txtSenha.setOpaque(false);
        panel.add(txtSenha, "cell 1 2, growx");

        // --- Telefone ---
        panel.add(rotulo("Telefone*:"), "cell 0 3");
        txtTelefone = new RoundedJTextField(1);
        panel.add(txtTelefone, "cell 1 3, growx");

        // --- Data de Nascimento ---
        panel.add(rotulo("Nascimento*:"), "cell 0 4");
        txtDataNascimento = new RoundedJTextField(1);
        txtDataNascimento.setToolTipText("Formato: dd/mm/aaaa");
        panel.add(txtDataNascimento, "cell 1 4, growx");

        // --- Escolaridade (ComboBox) ---
        panel.add(rotulo("Escolaridade*:"), "cell 0 5");
        cbEscolaridade = new JComboBox<>(new String[]{
            "Selecione...",
            "Ensino Fundamental Incompleto",
            "Ensino Fundamental Completo",
            "Ensino Médio Incompleto",
            "Ensino Médio Completo",
            "Ensino Superior Graduado"
        });
        cbEscolaridade.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        panel.add(cbEscolaridade, "cell 1 5, growx");

        // --- Experiência (não obrigatório) ---
        panel.add(rotulo("Experiência:"), "cell 0 6, aligny top");
        txtExperiencia = new JTextArea(3, 1);
        txtExperiencia.setLineWrap(true);
        txtExperiencia.setWrapStyleWord(true);
        txtExperiencia.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        panel.add(new JScrollPane(txtExperiencia), "cell 1 6, growx");

        // --- Habilidades ---
        panel.add(rotulo("Habilidades*:"), "cell 0 7, aligny top");
        txtHabilidades = new JTextArea(3, 1);
        txtHabilidades.setLineWrap(true);
        txtHabilidades.setWrapStyleWord(true);
        txtHabilidades.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        panel.add(new JScrollPane(txtHabilidades), "cell 1 7, growx");

        // ===================== BOTÕES =====================
        JPanel painelBotoes = new JPanel(new MigLayout("insets 0", "[100!][100!]"));
        painelBotoes.setBackground(Color.WHITE);

        btnSalvar = new JButton("Salvar");
        estilizarBotao(btnSalvar);
        painelBotoes.add(btnSalvar, "grow");

        btnLimpar = new JButton("Limpar");
        estilizarBotao(btnLimpar);
        painelBotoes.add(btnLimpar, "grow");

        contentPane.add(painelBotoes, "cell 2 3, alignx center, aligny center");

        btnVerUsuarios = new JButton("Ver Usuários Cadastrados");
        estilizarBotao(btnVerUsuarios);
        contentPane.add(btnVerUsuarios, "cell 2 4, alignx center, aligny center, gapy 8");
    }

    // ===================== MÉTODOS AUXILIARES =====================

    /** Cria um JLabel com a fonte padrão dos rótulos do formulário. */
    private JLabel rotulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        return label;
    }

    /** Aplica o estilo padrão (preto + branco + negrito) a um botão. */
    private void estilizarBotao(JButton botao) {
        botao.setBackground(Color.BLACK);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Tahoma", Font.BOLD, 11));
    }

    /**
     * Carrega a logo do projeto. Se não encontrar o arquivo,
     * retorna null e a tela continua funcionando normalmente.
     */
    private ImageIcon carregarIcone(String caminho, int largura, int altura) {
        URL url = getClass().getResource(caminho);
        if (url == null) return null;
        Image img = new ImageIcon(url).getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    /** Apaga todos os campos e volta o ComboBox para a opção inicial. */
    public void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        txtTelefone.setText("");
        txtDataNascimento.setText("");
        cbEscolaridade.setSelectedIndex(0);
        txtExperiencia.setText("");
        txtHabilidades.setText("");
        txtNome.requestFocus();
    }

    // ===================== GETTERS DOS CAMPOS =====================
    // O Controller usa esses métodos para ler o que o usuário digitou.

    public JTextField     getTxtNome()            { return txtNome; }
    public JTextField     getTxtEmail()           { return txtEmail; }
    public JPasswordField getTxtSenha()           { return txtSenha; }
    public JTextField     getTxtTelefone()        { return txtTelefone; }
    public JTextField     getTxtDataNascimento()  { return txtDataNascimento; }
    public JComboBox<String> getCbEscolaridade()  { return cbEscolaridade; }
    public JTextArea      getTxtExperiencia()     { return txtExperiencia; }
    public JTextArea      getTxtHabilidades()     { return txtHabilidades; }

    // ===================== GETTERS DOS BOTÕES =====================
    // O Controller usa esses métodos para registrar os ActionListeners.

    public JButton getBtnSalvar()       { return btnSalvar; }
    public JButton getBtnLimpar()       { return btnLimpar; }
    public JButton getBtnVerUsuarios()  { return btnVerUsuarios; }
}
