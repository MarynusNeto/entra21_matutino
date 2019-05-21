package acao;

import javax.swing.table.DefaultTableModel;

import beans.Pessoa;
import dados.Dados;

public class Acao {

	//Cadastro
	public void cadastrar(Pessoa p) {
		Dados.arrayPessoa.add(p);
	}
	
	//Sele��o
	public DefaultTableModel selecionar() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("Altura");
		modelo.addColumn("Peso");
		modelo.addColumn("IMC");
		
		for( int indice=0; indice<Dados.arrayPessoa.size(); indice++) {
			modelo.addRow(new Object[]{
				Dados.arrayPessoa.get(indice).getNome(),
				Dados.arrayPessoa.get(indice).getIdade(),
				Dados.arrayPessoa.get(indice).getAltura(),
				Dados.arrayPessoa.get(indice).getPeso(),
				Dados.arrayPessoa.get(indice).getIMC(),
				
				
			});
			
		}
		return modelo;
		
	}
	
	//Alterar
	public void alterar (int indice, Pessoa p) {
		Dados.arrayPessoa.set(indice, p);
	}
	
	//Exclus�o
	public void excluir (int indice) {
		Dados.arrayPessoa.remove(indice);
	}
	
	
	
	
	
}
