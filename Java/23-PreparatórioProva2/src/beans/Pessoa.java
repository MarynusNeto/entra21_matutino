package beans;

public class Pessoa {

	//Atributos cadastro
	private String Nome;
	private int idade;
	private double altura, peso, IMC;
	
	//Getters and Setters
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getIMC() {
		return IMC;
	}
	public void setIMC(String iMC) {
		IMC = iMC;
	}
	
	
	
	
}
