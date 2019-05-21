package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.Acao;
import beans.Pessoa;
import dados.Dados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIdade;
	private JTextField textAltura;
	private JTextField textPeso;
	private JTable tabela;
	private static int CodigoPessoa;

	private void limparcampos() {
		
		//Limpeza dos campos
		textNome.setText("");
		textIdade.setText("");
		textAltura.setText("");
		textPeso.setText("");
		
		//Focus
		textNome.requestFocus();
		
	}
	
	
	public Formulario() {
		
		setResizable(false);
		
		//Objeto da classe Acao
		Acao a = new Acao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(10, 11, 77, 19);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdade.setBounds(10, 47, 77, 20);
		contentPane.add(lblIdade);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAltura.setBounds(10, 83, 77, 20);
		contentPane.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPeso.setBounds(10, 120, 77, 19);
		contentPane.add(lblPeso);
		
		textNome = new JTextField();
		textNome.setBounds(68, 11, 216, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textIdade = new JTextField();
		textIdade.setColumns(10);
		textIdade.setBounds(68, 47, 216, 20);
		contentPane.add(textIdade);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(68, 83, 216, 20);
		contentPane.add(textAltura);
		
		textPeso = new JTextField();
		textPeso.setColumns(10);
		textPeso.setBounds(68, 121, 216, 20);
		contentPane.add(textPeso);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrar.setBounds(10, 168, 101, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAlterar.setBounds(125, 168, 101, 25);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExcluir.setBounds(252, 168, 101, 25);
		contentPane.add(btnExcluir);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setEnabled(false);
		btnSelecionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSelecionar.setBounds(364, 168, 101, 25);
		contentPane.add(btnSelecionar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(364, 120, 101, 25);
		contentPane.add(btnCancelar);
		
		JButton btnEstat = new JButton("Estat\u00EDsticas IMC");
		btnEstat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEstat.setBounds(318, 9, 147, 25);
		contentPane.add(btnEstat);
		
		//A��es dos bot�es
		
		//A��o bot�o cadastro
				btnCadastrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						boolean Repeticao = false;
						//Criar um objeto Pessoa
						Pessoa p = new Pessoa();
						p.setNome(textNome.getText());
						p.setIdade(Integer.parseInt(textIdade.getText()));
						p.setAltura(Double.parseDouble(textAltura.getText()));
						p.setPeso(Double.parseDouble(textPeso.getText()));
						
						//Valida��o de repeti��o
						String Duplicata = textNome.getText();
						for (int i = 0; i<Dados.arrayPessoa.size(); i++) {
							if(Duplicata.equals(Dados.arrayPessoa.get(i).getNome())) {
								JOptionPane.showMessageDialog(null, "Essa pessoa j� existe");
								Repeticao = true;
							} 
							
							//Calculo do IMC
							double IMCalc = p.getPeso() / Math.pow(p.getAltura(), 2); 
							
							if(IMCalc <=18.5) { 
								p.setIMC("Abaixo do Peso");
							}else if((IMCalc >18.5) && (IMCalc<=24.9)) { 
								p.setIMC("Peso Normal");
							}else if((IMCalc >24.9) && (IMCalc<=29.9)) { 
								p.setIMC("Sobrepeso");
							}else if((IMCalc >29.9) && (IMCalc<=34.9)) { 
							}
							
							//Efetuar o cadastro
							if(Repeticao == false) {
							a.cadastrar(p);
							}
							
							//Atualizar tabela
							tabela.setModel(a.selecionar());
							
							//Limpar campos
							limparcampos();
					
					}
				}});
				
				//A�ao botao cancelar
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						//Limpar campos
						limparcampos();
						
						//Botoes
						btnCadastrar.setEnabled(true);
						btnAlterar.setEnabled(false);
						btnExcluir.setEnabled(false);
						btnCancelar.setEnabled(false);
						
						
					
					}
				});
		
				//A�ao botao excluir
				btnExcluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						//Remover jogo
						a.excluir(CodigoPessoa);
					
					//Atualizar listagem de cursos
						tabela.setModel(a.selecionar());
					
					}
				});
				
				
				//A�ao do botao alterar
				btnAlterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						//Instanciar um objeto da classe Jogo
						Pessoa p = new Pessoa();
						p.setNome(textNome.getText());
						p.setIdade(Integer.parseInt(textAltura.getText()));
						p.setAltura(Double.parseDouble(textAltura.getText()));
						p.setPeso(Double.parseDouble(textPeso.getText()));
						
						//Realizar a altera�ao
						a.alterar(CodigoPessoa, p);
						
						//Atualizar listagem de cursos
						tabela.setModel(a.selecionar());
						
						//Limpar campos
						limparcampos();
						
						
						//Botoes atAlterar
						btnCadastrar.setEnabled(true);
						btnAlterar.setEnabled(false);
						btnExcluir.setEnabled(false);
						btnCancelar.setEnabled(false);
						
						
					
					
					}
				});
		
		//ScrollPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 204, 455, 271);
		contentPane.add(scrollPane);
		
		//tabela
		tabela = new JTable();
		tabela.setModel(a.selecionar());
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//Obter o �ndice da tabela
				int indice = tabela.getSelectedRow();
				
				//Adicionar o valor do indice no atributo
				CodigoPessoa = indice;
				
				//Selecionando dados do curso
				textNome.setText(tabela.getValueAt(indice, 0).toString());
				textIdade.setText(tabela.getValueAt(indice, 1).toString());
				textAltura.setText(tabela.getValueAt(indice, 2).toString());
				textPeso.setText(tabela.getValueAt(indice, 3).toString());
				
				
				//Botoes
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tabela);
	}
}
