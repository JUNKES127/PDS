package cadastro;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Plano extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Plano frame = new Plano();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Plano() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[30][30][30][30][30][30][30]"));

        JLabel lblNewLabel = new JLabel("CADASTRO CLIENTE - ACADEMIA TREINO FIT");
        contentPane.add(lblNewLabel, "cell 1 0 4 1");

        JLabel lblNewLabel_1 = new JLabel("Nome:");
        contentPane.add(lblNewLabel_1, "cell 0 1,alignx right");

        textField_1 = new JTextField();
        contentPane.add(textField_1, "cell 1 1 4 1,growx");

        JLabel lblNewLabel_2 = new JLabel("Telefone:");
        contentPane.add(lblNewLabel_2, "cell 0 2,alignx right");

        textField = new JTextField();
        contentPane.add(textField, "cell 1 2 4 1,growx");

        JLabel lblNewLabel_3 = new JLabel("Tipo de Plano:");
        contentPane.add(lblNewLabel_3, "cell 0 3,alignx right");

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Básico");
        contentPane.add(rdbtnNewRadioButton, "cell 1 3");

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Intermediario");
        contentPane.add(rdbtnNewRadioButton_1, "cell 2 3");

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Premium");
        contentPane.add(rdbtnNewRadioButton_2, "cell 3 3");

        JLabel lblNewLabel_4 = new JLabel("Duração:");
        contentPane.add(lblNewLabel_4, "cell 0 4,alignx right");

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Mensal");
        contentPane.add(rdbtnNewRadioButton_3, "cell 1 4");

        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Semestral");
        contentPane.add(rdbtnNewRadioButton_4, "cell 2 4");

        JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Anual");
        contentPane.add(rdbtnNewRadioButton_5, "cell 3 4");

        JLabel lblNewLabel_5 = new JLabel("Frequencia Semanal:");
        contentPane.add(lblNewLabel_5, "cell 0 5,alignx right");

        JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("2x por semana");
        contentPane.add(rdbtnNewRadioButton_6, "cell 1 5");

        JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("3x por semana");
        contentPane.add(rdbtnNewRadioButton_7, "cell 2 5");

        JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("5x por semana");
        contentPane.add(rdbtnNewRadioButton_8, "cell 3 5");

        // ✅ Grupos (IMPORTANTE)
        ButtonGroup grupoPlano = new ButtonGroup();
        grupoPlano.add(rdbtnNewRadioButton);
        grupoPlano.add(rdbtnNewRadioButton_1);
        grupoPlano.add(rdbtnNewRadioButton_2);

        ButtonGroup grupoDuracao = new ButtonGroup();
        grupoDuracao.add(rdbtnNewRadioButton_3);
        grupoDuracao.add(rdbtnNewRadioButton_4);
        grupoDuracao.add(rdbtnNewRadioButton_5);

        ButtonGroup grupoFrequencia = new ButtonGroup();
        grupoFrequencia.add(rdbtnNewRadioButton_6);
        grupoFrequencia.add(rdbtnNewRadioButton_7);
        grupoFrequencia.add(rdbtnNewRadioButton_8);

        JLabel lblNewLabel_6 = new JLabel("Valor Final:");
        contentPane.add(lblNewLabel_6, "cell 2 6");

        JButton btnNewButton = new JButton("Calcular");
        contentPane.add(btnNewButton, "cell 1 6");

        // ✅ Evento do botão
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nome = textField_1.getText();
                String telefone = textField.getText();

                if (nome.isEmpty() || telefone.isEmpty()) {
                    lblNewLabel_6.setText("Preencha nome e telefone!");
                    return;
                }

                String plano = "";
                String duracao = "";
                String frequencia = "";

                if (rdbtnNewRadioButton.isSelected()) plano = "Basico";
                if (rdbtnNewRadioButton_1.isSelected()) plano = "Intermediario";
                if (rdbtnNewRadioButton_2.isSelected()) plano = "Premium";

                if (rdbtnNewRadioButton_3.isSelected()) duracao = "Mensal";
                if (rdbtnNewRadioButton_4.isSelected()) duracao = "Semestral";
                if (rdbtnNewRadioButton_5.isSelected()) duracao = "Anual";

                if (rdbtnNewRadioButton_6.isSelected()) frequencia = "2x";
                if (rdbtnNewRadioButton_7.isSelected()) frequencia = "3x";
                if (rdbtnNewRadioButton_8.isSelected()) frequencia = "5x";

                if (plano.isEmpty() || duracao.isEmpty() || frequencia.isEmpty()) {
                    lblNewLabel_6.setText("Selecione todas as opções!");
                    return;
                }

                double valorBase = 0;

                // Plano
                if (plano.equals("Basico")) valorBase = 80;
                if (plano.equals("Intermediario")) valorBase = 120;
                if (plano.equals("Premium")) valorBase = 180;

                // Frequência
                if (frequencia.equals("3x")) valorBase += valorBase * 0.20;
                if (frequencia.equals("5x")) valorBase += valorBase * 0.50;

                // Duração
                if (duracao.equals("Semestral")) valorBase -= valorBase * 0.10;
                if (duracao.equals("Anual")) valorBase -= valorBase * 0.20;

                lblNewLabel_6.setText("Valor Final: R$ " + String.format("%.2f", valorBase));
            }
        });
    }
}