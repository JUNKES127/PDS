package Calculadora;

import javax.swing.*;
import java.awt.event.*;

public class formSobre {

    private JFrame frame;

    public formSobre() {
        frame = new JFrame("Sobre o CalcInvest");
        frame.setSize(300, 200);
        frame.getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("CalcInvest - Calculadora de Investimentos");
        lblTitulo.setBounds(20, 20, 260, 20);

        JLabel lblVersao = new JLabel("Versão: 1.0");
        lblVersao.setBounds(20, 50, 200, 20);

        JLabel lblAutor = new JLabel("Autor: Victor Junkes");
        lblAutor.setBounds(20, 70, 250, 20);

        JLabel lblContato = new JLabel("Contato: victor.j1@aluno.ifsc.edu.br");
        lblContato.setBounds(20, 90, 260, 20);

        JButton btnOK = new JButton("OK");
        btnOK.setBounds(100, 120, 80, 25);

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.getContentPane().add(lblTitulo);
        frame.getContentPane().add(lblVersao);
        frame.getContentPane().add(lblAutor);
        frame.getContentPane().add(lblContato);
        frame.getContentPane().add(btnOK);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
