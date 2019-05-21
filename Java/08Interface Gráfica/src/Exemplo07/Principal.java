package Exemplo07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Principal {

	public static void main(String[] args) {
	
		//Criar um formul�rio
		JFrame formulario = new JFrame();
		formulario.setSize(500, 300);
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setTitle("Meu primeiro formul�rio");
		formulario.setLocationRelativeTo(null);
		formulario.setLayout(null);
		
		//Radio Button
		JRadioButton rbt01 = new JRadioButton("Op��o 01");
		rbt01.setBounds(10,  10, 100, 20);
		rbt01.setActionCommand("Primeiro bot�o");
		
		JRadioButton rbt02 = new JRadioButton("Op��o 02");
		rbt02.setBounds(10,  40, 100, 20);
		rbt02.setActionCommand("Segundo bot�o");
		
		JRadioButton rbt03 = new JRadioButton("Op��o 03");
		rbt03.setBounds(10,  70, 100, 20);
		rbt03.setActionCommand("Terceiro bot�o");
		
		//Bot�o
		JButton btn = new JButton("Testar");
		btn.setBounds(10, 100, 100, 20);
		
		
		//Agrupar bot�es de r�dio
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbt01);
		bg.add(rbt02);
		bg.add(rbt03);
		
		//A��o no bot�o
		
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
					try {
					//getSelection: Obt�m o Radio Button selecionado
					//getActionCommand: retorna um valor do Radio Button
					JOptionPane.showMessageDialog(null, bg.getSelection().getActionCommand());
					}catch(Exception er) {
						JOptionPane.showMessageDialog(null, "Favor, selecionar uma op��o");
					}
					
					}
					});
		
		//Add elementos ao formul�rio
		formulario.add(rbt01);
		formulario.add(rbt02);
		formulario.add(rbt03);
		formulario.add(btn);
		
		//Exibir formul�rio e os componentes
		formulario.setVisible(true);
	}

}
