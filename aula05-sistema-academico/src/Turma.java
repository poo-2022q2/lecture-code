import java.util.ArrayList;
import java.util.List;

public class Turma {
    String codDisciplina;
    String codTurma;
    List<Matricula> matriculas;
    int tamanho;

    public Turma(String codDisciplina, String codTurma, int tamanho) {
        this.codDisciplina = codDisciplina;
        this.codTurma = codTurma;
        this.matriculas = new ArrayList<Matricula>();
        setTamanho(tamanho);
    }

    public void setTamanho(int tamanho) {
        if (tamanho < 0) {
            throw new IllegalArgumentException("vagas must be positive");
        }
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean cheia() {
        return matriculas.size() == tamanho;
    }

    public boolean temVagas() {
        return !cheia();
    }

    public void addMatricula(Matricula matricula) {
        if (!temVagas()) {
            throw new IllegalArgumentException("Capacidade da turma excedida");
        } else {
            for (Matricula m: matriculas) {
                if (m.aluno.getRa().equals(matricula.aluno.getRa())) {
                    throw new IllegalArgumentException(String.format(
                        "Aluno %s ja esta matriculado.", matricula.aluno.getRa()));
                }
            }
            this.matriculas.add(matricula);
        }
    }

    /**
     * Set nota for a specific student.
     * Inefficient, because it performs linear search
     * @param ra the student ra
     * @param nota the student nota
     */
    public void setNota(String ra, float nota) {
        for (Matricula matricula : matriculas) {
            if (matricula.aluno.getRa().equals(ra)) {
                matricula.setNota(nota);
            }
        }
    }

    /**
     * Computes the average grade of the class.
     * @return the class average
     */
    public float media() {
        if (matriculas.size() < 1)
            return 0;

        float average = 0;

        for (Matricula matricula : matriculas) {
            average += matricula.getNota();
        }

        return  average / matriculas.size();
    }

    /**
     * Build a tabular report of student grades
     * @return a string containing the report
     */
    public String buildRelatorio() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Disciplina: %s\n", codDisciplina));
        builder.append(String.format("Turma: %s\n\n", codTurma));
        builder.append(String.format("%-10s", "RA"));
        builder.append(String.format("%-30s", "Nome"));
        builder.append(String.format("%-7s", "Nota"));
        builder.append("\n");

        for (Matricula matricula : matriculas) {
            builder.append(String.format("%-10s", matricula.aluno.getRa()));
            builder.append(String.format("%-30s", String.format("%s %s",
                    matricula.aluno.getNome(), matricula.aluno.getSobrenome())));
            builder.append(String.format("%-7.2f", matricula.getNota()));
            builder.append("\n");
        }
        builder.append("\n");
        builder.append(String.format("Media: %.2f", media()));

        return builder.toString();
    }
}
