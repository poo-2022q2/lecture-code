/**
 * Aluno da pos-graducao stricto sensu.
 */
public class AlunoPosStricto extends AlunoPos {

    /**
     * Cria um aluno de posgraducao stricto sensu.
     *
     * @param nome o nome
     * @param sobrenome o sobrenome
     * @param ra o ra
     * @param orientador o orientador
     * @param programa o programa
     */
    public AlunoPosStricto(String nome, String sobrenome, String ra,
                    String orientador, String programa) {
        super(nome, sobrenome, ra, orientador, programa);
        System.out.println("AlunoPosStricto");
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo do programa: " + "Stricto sensu\n";
    }
}
