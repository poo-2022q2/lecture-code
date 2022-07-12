package staff;

/**
 * Teste de chamda de construtores da hiearquia de funcionarios.
 */
public final class FuncionariosTest {
    private FuncionariosTest() {

    }

    /**
     * O metodo main.
     *
     * @param args os argumentos
     */
    public static void main(String[] args) {
        new Funcionario();
        System.out.println();
        new Docente();
        System.out.println();
        new Adjunto();
        System.out.println();
        new Titular();
        System.out.println();
        new TecnicoAdministrativo();
        System.out.println();
        new TecnicoAdministrativoNivelMedio();
        System.out.println();
        new TecnicoAdministrativoNivelSuperior();
    }
}
