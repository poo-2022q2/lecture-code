/**
 * Testa a ordem de chamada dos contrutores em uma hierarquia.
 */
public final class TestAlunosConstructorOrder {
    private TestAlunosConstructorOrder() {

    }

    /**
     * O metodo main.
     *
     * @param args os argumentos
     */
    public static void main(String[] args) {
        new AlunoGrad("joao", "silva", "1234", "bcc");
        System.out.println();
        new AlunoPos("maria", "pereira", "5678",
                "ppgcc", "pedro souza");
        System.out.println();
        new AlunoPosLato("maria", "pereira", "5678",
                "ppgcc", "pedro souza");
        System.out.println();
        new AlunoPosStricto("pedro", "siqueira", "92983",
                "ppgcc", "pedro souza");

    }
}
