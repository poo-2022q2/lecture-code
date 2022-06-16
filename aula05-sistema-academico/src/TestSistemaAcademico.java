public class TestSistemaAcademico {
    public static void main(String[] args) {
        Turma poo = new Turma("mcta018", "na2", 2);
        Turma pe = new Turma("mcta028", "na1", 3);

        Aluno joao = new Aluno("joao", "silva", "12345");
        Aluno maria = new Aluno("maria", "fernandes", "45678");
        Aluno catarina = new Aluno("catarina", "moreira", "45679");

        poo.addMatricula(new Matricula(joao));
        poo.addMatricula(new Matricula(maria));
        //poo.addMatricula(new Matricula(catarina)); // test turma overflow

        poo.setNota(joao.getRa(), 6);
        poo.setNota(maria.getRa(), 10);

        pe.addMatricula(new Matricula(joao));
        pe.addMatricula(new Matricula(maria));
        pe.addMatricula(new Matricula(catarina));

        pe.setNota(joao.getRa(), 10);
        pe.setNota(maria.getRa(), 10);
        pe.setNota(catarina.getRa(), 5);

        System.out.println(poo.buildRelatorio());
        System.out.println();
        System.out.println(pe.buildRelatorio());
    }
}
