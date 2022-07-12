/**
 * Aluno de pos-graducao lato sensu.
 */
public class AlunoPosLato extends AlunoPos {

    /**
     * Cria um aluno de pos-graducao lato sensu.
     *
     * @param nome o nome
     * @param sobrenome o sobrenome
     * @param ra o ra
     * @param orientador o orientador
     * @param programa o programa
     */
    public AlunoPosLato(String nome, String sobrenome, String ra,
                    String orientador, String programa) {
        super(nome, sobrenome, ra, orientador, programa);
        System.out.println("AlunoPosLato");
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo do programa: " + "Lato sensu\n";
    }
}
