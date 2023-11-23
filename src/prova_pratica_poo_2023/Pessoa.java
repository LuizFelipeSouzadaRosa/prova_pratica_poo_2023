package prova_pratica_poo_2023;
import javax.swing.JOptionPane;

public class Pessoa {
	
	private String nome;
	private int idade;
	private char sexo;
	private boolean condutor;
	private boolean embriagado;
	
    public Pessoa(String nome, int idade, char sexo, boolean condutor, boolean embriagado) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.condutor = condutor;
        this.embriagado = embriagado;
    }
    
    public static Pessoa cadastrarPessoa() {
        String nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade da pessoa:"));
        char sexo = JOptionPane.showInputDialog("Informe o sexo da pessoa (M/F):").toUpperCase().charAt(0);
        boolean condutor = JOptionPane.showInputDialog("A pessoa é o condutor do veículo? (S/N):").equalsIgnoreCase("S");
        boolean embriagado = condutor && JOptionPane.showInputDialog("O condutor estava embriagado? (S/N):").equalsIgnoreCase("S");
        return new Pessoa(nome, idade, sexo, condutor, embriagado);
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public boolean isCondutor() {
		return condutor;
	}
	public void setCondutor(boolean condutor) {
		this.condutor = condutor;
	}
	public boolean isEmbriagado() {
		return embriagado;
	}
	public void setEmbriagado(boolean embriagado) {
		this.embriagado = embriagado;
	}

}
