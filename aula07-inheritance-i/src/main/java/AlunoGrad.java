/**
 * Aluno de graduacao.
 */
public class AlunoGrad extends Aluno {
    String curso;

    /**
     * Cria um aluno de graduacao.
     *
     * @param nome o nome
     * @param sobrenome o sobrenome
     * @param ra o ra
     * @param curso o curso
     */
    public AlunoGrad(String nome, String sobrenome, String ra, String curso) {
        super(nome, sobrenome, ra);
        setCurso(curso);
        System.out.println("AlunoGrad");
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + "Curso: " + curso + "\n";
    }
}
