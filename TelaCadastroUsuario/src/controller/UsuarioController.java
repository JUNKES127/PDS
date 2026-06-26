package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioTableModel;
import view.JanelaVisualizarUsuario;
import view.TelaCadastroUsuario;
import view.TelaListagemUsuario;

/**
 * Essa classe é o "cérebro" do sistema (Controller no padrão MVC).
 *
 * Responsabilidades:
 *  1. Guardar a lista de usuários em memória.
 *  2. Abrir as telas (View).
 *  3. Registrar os ActionListeners dos botões de cada tela.
 *  4. Executar as ações (salvar, remover, validar, etc.).
 *
 * As telas (TelaCadastroUsuario, TelaListagemUsuario...) NÃO sabem
 * o que acontece quando um botão é clicado. Elas apenas criam os
 * componentes. O Controller, de fora, usa os getters dos botões para
 * registrar o que cada um faz com addActionListener.
 */
public class UsuarioController {

    // Lista que guarda todos os usuários cadastrados (em memória).
    private ArrayList<Usuario> lista;

    public UsuarioController() {
        lista = new ArrayList<Usuario>();
    }

    // ====================================================================
    // ABERTURA DAS TELAS
    // ====================================================================

    /**
     * Cria a tela de Cadastro e registra os listeners dos botões dela.
     * É o método chamado pela classe Main para iniciar o programa.
     */
    public void abrirTelaCadastro() {

        TelaCadastroUsuario tela = new TelaCadastroUsuario();

        // Cada botão recebe aqui o que deve acontecer quando for clicado.
        tela.getBtnSalvar().addActionListener(e -> salvarCadastro(tela));
        tela.getBtnLimpar().addActionListener(e -> tela.limparCampos());
        tela.getBtnVerUsuarios().addActionListener(e -> abrirTelaListagem(tela));

        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }

    /**
     * Cria a tela de Listagem (tabela) e registra os listeners dos botões.
     */
    private void abrirTelaListagem(TelaCadastroUsuario telaAnterior) {

        UsuarioTableModel tableModel = new UsuarioTableModel(lista);
        TelaListagemUsuario tela = new TelaListagemUsuario(tableModel);

        tela.getBtnAdicionar().addActionListener(e -> abrirJanelaAdicionar(tela));
        tela.getBtnRemover().addActionListener(e -> removerSelecionado(tela));
        tela.getBtnVisualizar().addActionListener(e -> abrirJanelaVisualizar(tela));
        tela.getBtnVoltar().addActionListener(e -> voltarParaCadastro(tela));

        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        telaAnterior.dispose();  // fecha a tela anterior
    }

    /**
     * Cria a janela de adicionar/editar e registra os listeners dos botões.
     * Método reutilizado por abrirJanelaAdicionar e abrirJanelaVisualizar.
     */
    private JanelaVisualizarUsuario criarJanela(TelaListagemUsuario telaListagem) {

        JanelaVisualizarUsuario janela = new JanelaVisualizarUsuario();

        janela.getBtnSalvar().addActionListener(e -> salvarJanela(janela, telaListagem));
        janela.getBtnCancelar().addActionListener(e -> janela.dispose());

        return janela;
    }

    // ====================================================================
    // AÇÕES DA TELA DE CADASTRO
    // ====================================================================

    /**
     * Executado quando clica em "Salvar" na tela de cadastro.
     * Lê os campos, valida e, se tudo ok, adiciona à lista.
     */
    private void salvarCadastro(TelaCadastroUsuario tela) {

        String nome            = tela.getTxtNome().getText();
        String email           = tela.getTxtEmail().getText();
        String senha           = new String(tela.getTxtSenha().getPassword());
        String telefone        = tela.getTxtTelefone().getText();
        String dataNascimento  = tela.getTxtDataNascimento().getText();
        String escolaridade    = tela.getCbEscolaridade().getSelectedItem().toString();
        String experiencia     = tela.getTxtExperiencia().getText();
        String habilidades     = tela.getTxtHabilidades().getText();

        String erro = validar(nome, email, senha, telefone, dataNascimento, escolaridade, habilidades);

        if (erro != null) {
            JOptionPane.showMessageDialog(tela, erro, "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario novo = new Usuario(nome, email, senha, telefone, dataNascimento,
                                   escolaridade, experiencia, habilidades);
        lista.add(novo);

        JOptionPane.showMessageDialog(tela, "Usuário cadastrado com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        tela.limparCampos();
    }

    /**
     * Executado quando clica em "Voltar ao Cadastro" na tela de listagem.
     */
    private void voltarParaCadastro(TelaListagemUsuario telaAtual) {
        abrirTelaCadastro();
        telaAtual.dispose();
    }

    // ====================================================================
    // AÇÕES DA TELA DE LISTAGEM
    // ====================================================================

    /**
     * Executado quando clica em "Adicionar" na tela de listagem.
     * Abre a janela em modo de novo cadastro (linhaEditando = -1).
     */
    private void abrirJanelaAdicionar(TelaListagemUsuario telaListagem) {

        JanelaVisualizarUsuario janela = criarJanela(telaListagem);
        janela.setTitle("Adicionar Usuário");
        janela.getCbEscolaridade().setSelectedIndex(0);
        janela.setLocationRelativeTo(telaListagem);
        janela.setVisible(true);
    }

    /**
     * Executado quando clica em "Remover" na tela de listagem.
     */
    private void removerSelecionado(TelaListagemUsuario telaListagem) {

        int linha = telaListagem.getTable().getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(telaListagem, "Selecione um usuário na tabela.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                telaListagem,
                "Deseja realmente remover este usuário?",
                "Confirmar remoção",
                JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            lista.remove(linha);
            telaListagem.atualizarTabela();
        }
    }

    /**
     * Executado quando clica em "Visualizar / Editar" na tela de listagem.
     * Abre a janela já preenchida com os dados do usuário selecionado.
     */
    private void abrirJanelaVisualizar(TelaListagemUsuario telaListagem) {

        int linha = telaListagem.getTable().getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(telaListagem, "Selecione um usuário na tabela.");
            return;
        }

        Usuario usuario = lista.get(linha);

        JanelaVisualizarUsuario janela = criarJanela(telaListagem);
        janela.setTitle("Editar Usuário");
        janela.setLinhaEditando(linha);

        // Preenche os campos com os dados do usuário selecionado
        janela.getTxtNome().setText(usuario.getNome());
        janela.getTxtEmail().setText(usuario.getEmail());
        janela.getTxtSenha().setText(usuario.getSenha());
        janela.getTxtTelefone().setText(usuario.getTelefone());
        janela.getTxtDataNascimento().setText(usuario.getDataNascimento());
        janela.getCbEscolaridade().setSelectedItem(usuario.getEscolaridade());
        janela.getTxtExperiencia().setText(usuario.getExperiencia());
        janela.getTxtHabilidades().setText(usuario.getHabilidades());

        janela.setLocationRelativeTo(telaListagem);
        janela.setVisible(true);
    }

    // ====================================================================
    // AÇÕES DA JANELA DE ADICIONAR / EDITAR
    // ====================================================================

    /**
     * Executado quando clica em "Salvar" dentro da janela de adicionar/editar.
     *
     * Se linhaEditando == -1 → cadastro novo.
     * Se linhaEditando >= 0  → edição do usuário existente naquela posição.
     */
    private void salvarJanela(JanelaVisualizarUsuario janela, TelaListagemUsuario telaListagem) {

        String nome           = janela.getTxtNome().getText();
        String email          = janela.getTxtEmail().getText();
        String senha          = new String(janela.getTxtSenha().getPassword());
        String telefone       = janela.getTxtTelefone().getText();
        String dataNascimento = janela.getTxtDataNascimento().getText();
        String escolaridade   = janela.getCbEscolaridade().getSelectedItem().toString();
        String experiencia    = janela.getTxtExperiencia().getText();
        String habilidades    = janela.getTxtHabilidades().getText();

        String erro = validar(nome, email, senha, telefone, dataNascimento, escolaridade, habilidades);

        if (erro != null) {
            JOptionPane.showMessageDialog(janela, erro, "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int linha = janela.getLinhaEditando();

        if (linha == -1) {
            // Novo cadastro: adiciona um usuário novo na lista
            lista.add(new Usuario(nome, email, senha, telefone, dataNascimento,
                                  escolaridade, experiencia, habilidades));
        } else {
            // Edição: atualiza o usuário que já existe
            Usuario usuario = lista.get(linha);
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setTelefone(telefone);
            usuario.setDataNascimento(dataNascimento);
            usuario.setEscolaridade(escolaridade);
            usuario.setExperiencia(experiencia);
            usuario.setHabilidades(habilidades);
        }

        telaListagem.atualizarTabela();
        janela.dispose();
    }

    // ====================================================================
    // VALIDAÇÃO DOS CAMPOS
    // ====================================================================

    /**
     * Verifica se os dados preenchidos são válidos.
     *
     * Retorna null se tudo estiver correto, ou uma mensagem de erro
     * descrevendo o primeiro problema encontrado.
     *
     * Regras:
     *  - Nome: obrigatório, mínimo 3 caracteres
     *  - E-mail: obrigatório, deve conter "@"
     *  - Senha: obrigatório, mínimo 6 caracteres
     *  - Telefone: obrigatório, apenas números
     *  - Data de nascimento: obrigatório, formato dd/mm/aaaa
     *  - Escolaridade: obrigatório, deve escolher uma opção
     *  - Habilidades: obrigatório
     *  - Experiência: NÃO é validada (campo opcional)
     */
    private String validar(String nome, String email, String senha, String telefone,
                            String dataNascimento, String escolaridade, String habilidades) {

        if (nome == null || nome.trim().isEmpty()) {
            return "O nome é obrigatório.";
        }
        if (nome.trim().length() < 3) {
            return "O nome deve ter pelo menos 3 caracteres.";
        }

        if (email == null || email.trim().isEmpty()) {
            return "O e-mail é obrigatório.";
        }
        if (!email.contains("@")) {
            return "Informe um e-mail válido (deve conter '@').";
        }

        if (senha == null || senha.trim().isEmpty()) {
            return "A senha é obrigatória.";
        }
        if (senha.length() < 6) {
            return "A senha deve ter pelo menos 6 caracteres.";
        }

        if (telefone == null || telefone.trim().isEmpty()) {
            return "O telefone é obrigatório.";
        }
        if (!telefone.matches("[0-9]+")) {
            return "O telefone deve conter somente números.";
        }

        if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
            return "A data de nascimento é obrigatória.";
        }
        // Valida formato dd/mm/aaaa (aceita também d/m/aaaa)
        if (!dataNascimento.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            return "Informe a data de nascimento no formato dd/mm/aaaa.";
        }

        if (escolaridade == null || escolaridade.equals("Selecione...")) {
            return "Selecione um nível de escolaridade.";
        }

        if (habilidades == null || habilidades.trim().isEmpty()) {
            return "O campo Habilidades é obrigatório.";
        }

        // Tudo ok
        return null;
    }
}
