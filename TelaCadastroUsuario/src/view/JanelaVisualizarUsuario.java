package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

/**
 * Janela (diálogo modal) usada para ADICIONAR um novo usuário ou
 * EDITAR um já existente.
 *
 * O Controller decide qual dos dois casos é usando "linhaEditando":
 *   -1  → cadastro novo
 *  >= 0 → edição da linha correspondente na lista
 *
 * PADRÃO MVC: só cria os componentes visuais. Os ActionListeners
 * são registrados pelo Controller.
 */
public class JanelaVisualizarUsuario extends JDialog {

    private static final long serialVersionUID = 1L;

    // Campos do formulário
    private JTextField    txtNome;
    private JTextField    txtEmail;
    private JPasswordField txtSenha;
    private JTextField    txtTelefone;
    private JTextField    txtDataNascimento;
    private JComboBox<String> cbEscolaridade;
    private JTextArea     txtExperiencia;
    private JTextArea     txtHabilidades;

    // Botões
    private JButton btnSalvar;
    private JButton btnCancelar;

    // -1 = novo cadastro; >= 0 = índice da linha sendo editada
    private int linhaEditando = -1;

    public JanelaVisualizarUsuario() {

        setModal(true);
        setTitle("Usuário");
        setBounds(100, 100, 460, 460);

        getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));

        // --- Nome ---
        add(rotulo("Nome*:"));
        txtNome = new RoundedJTextField(1);
        add(txtNome, "growx, wrap");

        // --- E-mail ---
        add(rotulo("E-mail*:"));
        txtEmail = new RoundedJTextField(1);
        add(txtEmail, "growx, wrap");

        // --- Senha ---
        add(rotulo("Senha*:"));
        txtSenha = new JPasswordField();
        add(txtSenha, "growx, wrap");

        // --- Telefone ---
        add(rotulo("Telefone*:"));
        txtTelefone = new RoundedJTextField(1);
        add(txtTelefone, "growx, wrap");

        // --- Data de Nascimento ---
        add(rotulo("Nascimento*:"));
        txtDataNascimento = new RoundedJTextField(1);
        txtDataNascimento.setToolTipText("Formato: dd/mm/aaaa");
        add(txtDataNascimento, "growx, wrap");

        // --- Escolaridade ---
        add(rotulo("Escolaridade*:"));
        cbEscolaridade = new JComboBox<>(new String[]{
            "Selecione...",
            "Ensino Fundamental Incompleto",
            "Ensino Fundamental Completo",
            "Ensino Médio Incompleto",
            "Ensino Médio Completo",
            "Ensino Superior Graduado"
        });
        cbEscolaridade.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        add(cbEscolaridade, "growx, wrap");

        // --- Experiência (não obrigatório) ---
        add(rotulo("Experiência:"), "aligny top");
        txtExperiencia = new JTextArea(3, 1);
        txtExperiencia.setLineWrap(true);
        txtExperiencia.setWrapStyleWord(true);
        txtExperiencia.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        add(new JScrollPane(txtExperiencia), "growx, wrap");

        // --- Habilidades ---
        add(rotulo("Habilidades*:"), "aligny top");
        txtHabilidades = new JTextArea(3, 1);
        txtHabilidades.setLineWrap(true);
        txtHabilidades.setWrapStyleWord(true);
        txtHabilidades.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        add(new JScrollPane(txtHabilidades), "growx, wrap");

        // --- Botões ---
        btnSalvar = new JButton("Salvar");
        estilizarBotao(btnSalvar);
        add(btnSalvar, "split 2, span, alignx right");

        btnCancelar = new JButton("Cancelar");
        estilizarBotao(btnCancelar);
        add(btnCancelar);
    }

    private JLabel rotulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        return label;
    }

    private void estilizarBotao(JButton botao) {
        botao.setBackground(Color.BLACK);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Tahoma", Font.BOLD, 11));
    }

    // ===================== GETTERS / SETTERS =====================

    public int  getLinhaEditando()       { return linhaEditando; }
    public void setLinhaEditando(int l)  { this.linhaEditando = l; }

    public JTextField     getTxtNome()           { return txtNome; }
    public JTextField     getTxtEmail()          { return txtEmail; }
    public JPasswordField getTxtSenha()          { return txtSenha; }
    public JTextField     getTxtTelefone()       { return txtTelefone; }
    public JTextField     getTxtDataNascimento() { return txtDataNascimento; }
    public JComboBox<String> getCbEscolaridade() { return cbEscolaridade; }
    public JTextArea      getTxtExperiencia()    { return txtExperiencia; }
    public JTextArea      getTxtHabilidades()    { return txtHabilidades; }

    public JButton getBtnSalvar()    { return btnSalvar; }
    public JButton getBtnCancelar()  { return btnCancelar; }
}
