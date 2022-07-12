package inheritance;

import utils.CpfUtils;

/**
 * Funcionario.
 */
public abstract class Funcionario {

    private String nome;
    private String sobrenome;
    private String cpf;
    private double planoSaude;
    private double valeTransporte;
    private double salarioBase;

    /**
     * Cria um funcionario.
     *
     * @param nome           o nome
     * @param sobrenome      o sobrenome
     * @param cpf            o cpf
     * @param planoSaude     o plano de saude
     * @param valeTransporte o vale transporte
     * @param salarioBase    o salario-base
     */
    public Funcionario(String nome, String sobrenome, String cpf, double planoSaude,
        double valeTransporte, double salarioBase) {
        setNome(nome);
        setSobrenome(sobrenome);
        setCpf(cpf);
        setPlanoSaude(planoSaude);
        setValeTransporte(valeTransporte);
        setSalarioBase(salarioBase);
    }

    public final String getNome() {
        return nome;
    }

    /**
     * Altera o primeiro nome.
     *
     * @param nome o nome
     */
    public final void setNome(String nome) {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.nome = nome;
    }

    public final String getSobrenome() {
        return sobrenome;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }

    /**
     * Altera o valor do plano de saude.
     *
     * @param planoSaude o plano de saude
     */
    public void setPlanoSaude(double planoSaude) {
        if (planoSaude < 0) {
            throw new IllegalArgumentException("Valor do plano de saude nao pode ser negativo");
        }
        this.planoSaude = planoSaude;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    /**
     * Altera o valor do vale-transporte.
     *
     * @param valeTransporte o vale-transporte
     */
    public void setValeTransporte(double valeTransporte) {
        if (valeTransporte < 0) {
            throw new IllegalArgumentException("Valor do vale transporte nao pode ser negativo");
        }
        this.valeTransporte = valeTransporte;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * Altera o valor do salario-base.
     *
     * @param salarioBase o salario-base
     */
    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 0) {
            throw new IllegalArgumentException("Salario bruto nao pode ser negativo");
        }
        this.salarioBase = salarioBase;
    }

    /**
     * Altera o valor do sobrenome.
     *
     * @param sobrenome o sobrenome
     */
    public final void setSobrenome(String sobrenome) {
        if (sobrenome.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    /**
     * Altera o valor do cpf.
     *
     * @param cpf o cpf
     */
    public final void setCpf(String cpf) {
        if (!CpfUtils.isValid(cpf)) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        this.cpf = cpf;
    }

    public double getSalarioBruto() {
        return getSalarioBase();
    }

    public double getSalarioLiquido() {
        return getSalarioBruto() - getValeTransporte() - getPlanoSaude();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s %s\n", getNome(), getSobrenome())
            +
            String.format("CPF: %s \n", getCpf())
            +
            "Descontos:\n"
            +
            String.format("  Vale Transporte: R$-%.2f\n", getValeTransporte())
            +
            String.format("  Plano de saude: R$-%.2f\n", getPlanoSaude())
            +
            String.format("Base: R$%.2f \n", getSalarioBase())
            +
            String.format("Bruto: R$%.2f \n", getSalarioBruto())
            +
            String.format("Liquido: R$%.2f \n", getSalarioLiquido());
    }
}
