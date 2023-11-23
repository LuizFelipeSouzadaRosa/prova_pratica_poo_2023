package prova_pratica_poo_2023;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Veiculo {
	
    protected int anoFabricacao;
    protected List<Pessoa> pessoas;
    protected Pessoa condutor;
    
    public Veiculo(int anoFabricacao, List<Pessoa> pessoas, Pessoa condutor) {
        this.anoFabricacao = anoFabricacao;
        this.pessoas = pessoas;
        this.condutor = condutor;
    }
    
    public static Veiculo cadastrarVeiculo() {
        int tipoVeiculo = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o tipo de veículo:\n1 - Normal\n2 - Veículo de Carga\n3 - Bicicleta"));

        int anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de fabricação do veículo:"));

        List<Pessoa> ocupantes = new ArrayList<>();
        int quantidadeOcupantes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de ocupantes:"));

        for (int i = 0; i < quantidadeOcupantes; i++) {
            ocupantes.add(Pessoa.cadastrarPessoa());
        }

        Pessoa condutor = Pessoa.cadastrarPessoa();

        Veiculo veiculo = null;

        switch (tipoVeiculo) {
            case 1:
                veiculo = new Veiculo(anoFabricacao, ocupantes, condutor);
                break;
            case 2:
                int carga = Integer.parseInt(JOptionPane.showInputDialog("Informe a carga do veículo de carga:"));
                veiculo = new VeiculoCarga(anoFabricacao, ocupantes, condutor, carga);
                break;
            case 3:
                veiculo = new Bicicleta(anoFabricacao, ocupantes, condutor);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de veículo inválido.");
        }

        if (veiculo != null) {
            veiculo.setCondutor(condutor);
            }
		return veiculo;
        }
    
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public Pessoa getCondutor() {
		return condutor;
	}

	public void setCondutor(Pessoa condutor) {
		this.condutor = condutor;
	}
    
}
