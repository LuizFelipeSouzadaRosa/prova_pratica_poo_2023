package prova_pratica_poo_2023;

import java.util.List;

class VeiculoCarga extends Veiculo {
    private int Carga;

    public VeiculoCarga(int anoFabricacao, List<Pessoa> pessoas, Pessoa condutor, int carga) {
        super(anoFabricacao, pessoas, condutor);
        this.Carga = (int) carga;
    }

    public int getCarga() {
        return Carga;
    }

	public void setQtCarga(int Carga) {
		this.Carga = (int) Carga;
	}
}