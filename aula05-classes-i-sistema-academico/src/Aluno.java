public class Aluno {
    private String nome;
    private String sobrenome;
    private String ra;

    public Aluno(String nome, String sobrenome, String ra) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        setRa(ra);
    }

    public void setRa(String ra) {
        if (!ra.matches("\\d+")) {
            throw new IllegalArgumentException("RA must be a number");

        }
        this.ra = ra;
    }

    public String getRa() {
        return this.ra;
    }

    public void setNome(String nome) {
        if (nome.split(" ").length > 1) {
            throw new IllegalArgumentException("nome must be a single word");
        }
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }
}
