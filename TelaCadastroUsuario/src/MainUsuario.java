import java.awt.EventQueue;
import controller.UsuarioController;

/**
 * Classe principal do sistema de Cadastro de Usuários.
 * Ela só faz uma coisa: criar o controller e mandar ele abrir a tela de cadastro.
 */
public class MainUsuario {

    public static void main(String[] args) {

        // EventQueue.invokeLater garante que a janela Swing seja aberta
        // de forma segura, na thread correta do Swing.
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                UsuarioController controller = new UsuarioController();
                controller.abrirTelaCadastro();
            }
        });
    }
}
