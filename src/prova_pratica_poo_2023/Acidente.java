package prova_pratica_poo_2023;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Acidente {
	
    private Rodovia rodovia;
    private int vitimasFatais;
    private int feridos;
    private int mes;
    private static List<Veiculo> veiculosEnvolvidos;
    static List<Acidente> acidentes;
    
    public Acidente(Rodovia rodovia, int vitimasFatais, int feridos, int mes, List<Veiculo> veiculosEnvolvidos) {
        this.rodovia = rodovia;
        this.vitimasFatais = vitimasFatais;
        this.feridos = feridos;
        this.mes = mes;
        Acidente.veiculosEnvolvidos = veiculosEnvolvidos;
    }
    
    public static Acidente cadastrarAcidente(List<Rodovia> rodovias) {
        String siglaRodoviaAcidente = JOptionPane.showInputDialog("Informe a sigla da rodovia do acidente:");
        Rodovia rodoviaAcidente = null;

        for (Rodovia rodovia : rodovias) {
            if (rodovia.getSigla().equalsIgnoreCase(siglaRodoviaAcidente)) {
                rodoviaAcidente = rodovia;
                break;
            }
        }

        if (rodoviaAcidente != null) {
            int vitimasFatais = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de vítimas fatais:"));
            int feridos = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de feridos:"));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês do acidente:"));

            List<Veiculo> veiculosEnvolvidos = new ArrayList<>();

            int numVeiculos = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de veículos envolvidos no acidente:"));
            for (int i = 0; i < numVeiculos; i++) {
                Veiculo veiculo = Veiculo.cadastrarVeiculo();
                veiculosEnvolvidos.add(veiculo);
            }

            return new Acidente(rodoviaAcidente, vitimasFatais, feridos, mes, veiculosEnvolvidos);
        }
		return null;
    }
    
    public static List<Acidente> listarAcidentesEmbriagados(List<Acidente> acidentes) {
        List<Acidente> acidentesEmbriagados = new ArrayList<>();
        for (Acidente acidente : acidentes) {
            for (Veiculo veiculo : acidente.getVeiculosEnvolvidos()) {
                for (Pessoa pessoa : veiculo.getPessoas()) {
                    if (pessoa.isCondutor() && pessoa.isEmbriagado()) {
                        acidentesEmbriagados.add(acidente);
                        break;
                    }
                }
            }
        }
        return acidentesEmbriagados;
    }
    
    public static int contarAcidentesPorPericulosidade(List<Acidente> acidentes, String periculosidade) {
        int count = 0;
        for (Acidente acidente : acidentes) {
            if (acidente.getRodovia().getPericulosidade().equalsIgnoreCase(periculosidade)) {
                count++;
            }
        }
        return count;
    }
    
    public static List<Veiculo> listarVeiculosDeCargaEnvolvidosEmAcidentes(List<Acidente> acidentes) {
        List<Veiculo> veiculosDeCarga = new ArrayList<>();
        for (Acidente acidente : acidentes) {
            for (Veiculo veiculo : acidente.getVeiculosEnvolvidos()) {
                if (veiculo instanceof VeiculoCarga && ((VeiculoCarga) veiculo).getCarga() > 0) {
                    veiculosDeCarga.add(veiculo);
                }
            }
        }
        return veiculosDeCarga;
    }

    public static Rodovia rodoviaComMaisAcidentesComBicicletas(List<Rodovia> rodovias, List<Acidente> acidentes) {
        int maxAcidentes = 0;
        Rodovia rodoviaMaisAcidentes = null;

        for (Rodovia rodovia : rodovias) {
            int acidentesComBicicletas = 0;
            for (Veiculo veiculo : veiculosEnvolvidos) {
                for (Pessoa pessoa : veiculo.getPessoas()) {
                        acidentesComBicicletas++;
                        break;
                    }
            }
            if (acidentesComBicicletas > maxAcidentes) {
                maxAcidentes = acidentesComBicicletas;
                rodoviaMaisAcidentes = rodovia;
            }
        }
        return rodoviaMaisAcidentes;
    }
    public static int contarAcidentesComVeiculosNovos() {
        int acidentesComVeiculosNovos = 0;
        for (Acidente acidente : acidentes) {
            for (Veiculo veiculo : acidente.getVeiculosEnvolvidos()) {
                if (veiculo.getAnoFabricacao() > 2013) {
                    acidentesComVeiculosNovos++;
                    break;
                }
            }
        }
        return acidentesComVeiculosNovos;
    }
        
	public Rodovia getRodovia() {
		return rodovia;
	}
	public void setRodovia(Rodovia rodovia) {
		this.rodovia = rodovia;
	}
	public int getVitimasFatais() {
		return vitimasFatais;
	}
	public void setVitimasFatais(int vitimasFatais) {
		this.vitimasFatais = vitimasFatais;
	}
	public int getFeridos() {
		return feridos;
	}
	public void setFeridos(int feridos) {
		this.feridos = feridos;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public List<Veiculo> getVeiculosEnvolvidos() {
		return veiculosEnvolvidos;
	}
	public void setVeiculosEnvolvidos(List<Veiculo> veiculosEnvolvidos) {
		this.veiculosEnvolvidos = veiculosEnvolvidos;
	}

	public static List<Acidente> getAcidentes() {
		// TODO Auto-generated method stub
		return null;
	} 

}
