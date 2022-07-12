package inheritance;

import java.util.ArrayList;
import java.util.List;
import utils.CpfUtils;

/**
 * Cliente para o sistema de folha de pagamento.
 */
public final class FolhaPagamento {

    private FolhaPagamento() {
    }

    /**
     * Cria objetos da hierarquia e os imprime.
     *
     * @param args os argumentos (nao utilizados)
     */
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(
            new Vendedor("Joao", "Silva", CpfUtils.random(), 10000, 0.1, 2000, 300, 500));
        funcionarios.add(
            new Vendedor("Maria", "Pereira", CpfUtils.random(), 25000, 0.15, 2000, 300, 500));

        funcionarios.add(
            new AssistenteAdministrativo("Pedro", "Parente", CpfUtils.random(), 2500, 330, 300, 0));
        funcionarios.add(
            new AssistenteAdministrativo("Joana", "Peixoto", CpfUtils.random(), 3300, 700, 200,
                10));

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
}
