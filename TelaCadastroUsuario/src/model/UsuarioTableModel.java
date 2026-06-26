package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Ensina a JTable como mostrar a lista de usuários:
 * quais colunas existem e o que colocar em cada célula.
 */
public class UsuarioTableModel extends AbstractTableModel {

    private ArrayList<Usuario> lista;

    // Nomes das colunas que aparecem no cabeçalho da tabela
    private String[] colunas = { "Nome", "E-mail", "Telefone", "Escolaridade" };

    public UsuarioTableModel(ArrayList<Usuario> lista) {
        this.lista = lista;
    }

    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getValueAt(int linha, int coluna) {
        Usuario u = lista.get(linha);
        switch (coluna) {
            case 0: return u.getNome();
            case 1: return u.getEmail();
            case 2: return u.getTelefone();
            case 3: return u.getEscolaridade();
        }
        return null;
    }

    /**
     * Avisa a JTable que os dados mudaram para ela se redesenhar.
     */
    public void atualizar() {
        fireTableDataChanged();
    }
}
