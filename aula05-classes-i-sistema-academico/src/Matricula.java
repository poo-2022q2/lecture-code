public class Matricula {
    Aluno aluno;
    private float nota;

    public Matricula(Aluno aluno) {
        this.aluno = aluno;
    }

    public Matricula(Aluno aluno, float nota) {
        this.aluno = aluno;
        this.nota = nota;
    }

    public void setNota(float nota) {
        if (nota < 0 && nota > 10) {
            throw new IllegalArgumentException("Nota must be in [0,10]");
        }
        this.nota = nota;
    }

    public float getNota() {
        return this.nota;
    }
}
