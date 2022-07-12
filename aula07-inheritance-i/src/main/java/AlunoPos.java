/**
 * Aluno de pos-graducao.
 */
public class AlunoPos extends Aluno {
    private String orientador;
    private String programa;

    /**
     * Cria um aluno de pos-graducao.
     *
     * @param nome o nome
     * @param sobrenome o sobrenome
     * @param ra o ra
     * @param orientador o orientador
     * @param programa o programa
     */
    public AlunoPos(String nome, String sobrenome, String ra,
                    String orientador, String programa) {
        super(nome, sobrenome, ra);
        setOrientador(orientador);
        setPrograma(programa);

        System.out.println("AlunoPos");
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return super.toString() + "Orientador: " + orientador + "\n"
                + "Programa: " + programa + "\n";
    }
}
