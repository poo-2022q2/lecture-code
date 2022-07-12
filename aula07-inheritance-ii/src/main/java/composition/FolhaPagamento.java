package composition;

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
     * Cria elementos da hierarquia e imprime os objetos resultantes.
     *
     * @param args os argumentos (nao utilizados)
     */
    public static void main(String[] args) {
        List<Vendedor> vendedores = new ArrayList<>();
        List<AssistenteAdministrativo> administrativos = new ArrayList<>();

        vendedores.add(
            new Vendedor("Joao", "Silva", CpfUtils.random(), 10000, 0.1, 2000, 300, 500));
        vendedores.add(
            new Vendedor("Maria", "Pereira", CpfUtils.random(), 25000, 0.15, 2000, 300, 500));

        administrativos.add(
            new AssistenteAdministrativo("Pedro", "Parente", CpfUtils.random(), 2500, 330, 300));
        administrativos.add(
            new AssistenteAdministrativo("Joana", "Peixoto", CpfUtils.random(), 3300, 700, 200));

        for (Vendedor vendedor : vendedores) {
            System.out.println(vendedor);
        }

        for (AssistenteAdministrativo administrativo : administrativos) {
            System.out.println(administrativo);
        }
    }
}
