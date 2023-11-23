package prova_pratica_poo_2023;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Rodovia {
	
    private String sigla;
    private String periculosidade;
    
    List<Rodovia> rodovias = new ArrayList<>();
    
    public Rodovia(String sigla, String periculosidade) {
        this.sigla = sigla;
        this.periculosidade = periculosidade;
    }
    
    public static Rodovia cadastrarRodovia() {
        String sigla = JOptionPane.showInputDialog("Informe a sigla da rodovia:");
        String periculosidade = JOptionPane.showInputDialog("Informe a periculosidade da rodovia:");

        return new Rodovia(sigla, periculosidade);
    }
    
    public static Rodovia rodoviaComMaisAcidentesFatais(List<Rodovia> rodovias, List<Acidente> acidentes) {
        int maxAcidentesFatais = 0;
        Rodovia rodoviaMaisAcidentesFatais = null;

        for (Rodovia rodovia : rodovias) {
            int acidentesFatais = 0;
            for (Acidente acidente : acidentes) {
                acidentesFatais += acidente.getVitimasFatais();
            }
            if (acidentesFatais > maxAcidentesFatais) {
                maxAcidentesFatais = acidentesFatais;
                rodoviaMaisAcidentesFatais = rodovia;
            }
        }
        return rodoviaMaisAcidentesFatais;
    }
    
    public static List<Rodovia> rodoviasComAcidentesNoCarnaval(List<Rodovia> rodovias, List<Acidente> acidentes) {
        List<Rodovia> rodoviasNoCarnaval = new ArrayList<>();
        for (Acidente acidente : acidentes) {
            if (acidente.getMes() == 2) {
                Rodovia rodovia = acidente.getRodovia();
                if (!rodoviasNoCarnaval.contains(rodovia)) {
                    rodoviasNoCarnaval.add(rodovia);
                }
            }
        }
        return rodoviasNoCarnaval;
    }
    
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getPericulosidade() {
		return periculosidade;
	}
	public void setPericulosidade(String periculosidade) {
		this.periculosidade = periculosidade;
	}

	public static List<Rodovia> getRodovias() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
