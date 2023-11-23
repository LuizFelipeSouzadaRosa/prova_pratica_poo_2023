package prova_pratica_poo_2023;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
    	List<Rodovia> rodovias = new ArrayList<>();
        List<Acidente> acidentes = new ArrayList<>();

        int opcao;
        do {
            String menu = "Selecione uma opção:\n" +
                    "1. Cadastrar Rodovia\n" +
                    "2. Cadastrar Acidente\n" +
                    "3. Listar Acidentes com Condutores Embriagados\n" +
                    "4. Listar Quantidade de Acidentes por Periculosidade\n" +
                    "5. Listar Veículos de Carga Envolvidos em Acidentes\n" +
                    "6. Rodovia com Mais Acidentes com Bicicletas\n" +
                    "7. Rodovia com Mais Acidentes Fatais\n" +
                    "8. Quantidade de Acidentes com Veículos Novos\n" +
                    "9. Rodovias com Acidentes no Carnaval\n" +
                    "0. Sair";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    Rodovia rodovia = Rodovia.cadastrarRodovia();
                    rodovias.add(rodovia);
                    JOptionPane.showMessageDialog(null, "Rodovia cadastrada com sucesso!");
                    break;
                case 2:
                    Acidente acidente = Acidente.cadastrarAcidente(rodovias);
                    acidentes.add(acidente);
                    JOptionPane.showMessageDialog(null, "Acidente cadastrado com sucesso!");
                    break;
                case 3:
                    List<Acidente> acidentesEmbriagados = Acidente.listarAcidentesEmbriagados(acidentes);
                    exibirAcidentes("Acidentes com Condutores Embriagados", acidentesEmbriagados);
                    break;
                case 4:
                    String periculosidade = JOptionPane.showInputDialog("Informe a periculosidade:");
                    int quantidade = Acidente.contarAcidentesPorPericulosidade(acidentes, periculosidade);
                    JOptionPane.showMessageDialog(null, "Quantidade de Acidentes por Periculosidade: " + quantidade);
                    break;
                case 5:
                    List<Veiculo> veiculosDeCarga = Acidente.listarVeiculosDeCargaEnvolvidosEmAcidentes(acidentes);
                    exibirVeiculos("Veículos de Carga Envolvidos em Acidentes", veiculosDeCarga);
                    break;
                case 6:
                    Rodovia rodoviaMaisAcidentesBicicletas = Acidente.rodoviaComMaisAcidentesComBicicletas(rodovias, acidentes);
                    JOptionPane.showMessageDialog(null, "Rodovia com Mais Acidentes com Bicicletas: " +
                            (rodoviaMaisAcidentesBicicletas != null ? rodoviaMaisAcidentesBicicletas.getSigla() : "Nenhuma"));
                    break;
                case 7:
                    Rodovia rodoviaMaisAcidentesFatais = Rodovia.rodoviaComMaisAcidentesFatais(rodovias, acidentes);
                    JOptionPane.showMessageDialog(null, "Rodovia com Mais Acidentes Fatais: " +
                            (rodoviaMaisAcidentesFatais != null ? rodoviaMaisAcidentesFatais.getSigla() : "Nenhuma"));
                    break;
                case 8:
                    int acidentesComVeiculosNovos = Acidente.contarAcidentesComVeiculosNovos();
                    JOptionPane.showMessageDialog(null, "Quantidade de Acidentes com Veículos Novos: " + acidentesComVeiculosNovos);
                    break;
                case 9:
                    List<Rodovia> rodoviasNoCarnaval = Rodovia.rodoviasComAcidentesNoCarnaval(rodovias, acidentes);
                    exibirRodovias("Rodovias com Acidentes no Carnaval", rodoviasNoCarnaval);
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirAcidentes(String titulo, List<Acidente> acidentes) {
    }

    private static void exibirVeiculos(String titulo, List<Veiculo> veiculos) {
    }

    private static void exibirRodovias(String titulo, List<Rodovia> rodovias) {
    }
}

