package main;

import controller.PessoaController;
import model.PessoaTableModel;
import view.JanelaPessoa;

public class Main {

	public static void main(String[] args) {
		
		PessoaTableModel model = new PessoaTableModel();
		JanelaPessoa view = new JanelaPessoa();
		PessoaController controller = new PessoaController(model, view);
		view.setVisible(true);
		

	}

}
