/**
 * Testes de instanciacao da hierarquia de alunos.
 */
public final class AlunosTest {

    private AlunosTest() {

    }

    /**
     * O metodo main.
     *
     * @param args os argumentos
     */
    public static void main(String[] args) {
        AlunoGrad a1 = new AlunoGrad("joao", "silva", "1234", "bcc");
        AlunoPos a2 = new AlunoPos("maria", "pereira", "5678",
                "ppgcc", "pedro souza");

        System.out.println(a1);
        System.out.println();
        System.out.println(a2);
        System.out.println();

        AlunoPosLato ap1 = new AlunoPosLato("maria", "pereira", "5678",
                "ppgcc", "pedro souza");

        System.out.println(ap1);
        System.out.println();

        AlunoPosStricto ap2 = new AlunoPosStricto("pedro", "siqueira", "92983",
                "ppgcc", "pedro souza");

        System.out.println(ap2);
        System.out.println();
    }
}
