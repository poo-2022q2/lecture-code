package composition;

import utils.CpfUtils;

/**
 * Funcionario.
 */
public class Funcionario {

    private String firstName;
    private String lastName;
    private String cpf;
    private double planoSaude;
    private double valeTransporte;
    private double salarioBruto;

    /**
     * Cria um funcionario.
     *
     * @param nome           o primeiro nome
     * @param sobrenome      o sobrenome
     * @param cpf            o cpf
     * @param planoSaude     o plano de saude
     * @param valeTransporte o vale transporte
     * @param salarioBruto   o salario bruto
     */
    public Funcionario(String nome, String sobrenome, String cpf, double planoSaude,
        double valeTransporte, double salarioBruto) {
        setFirstName(nome);
        setLastName(sobrenome);
        setCpf(cpf);
        setPlanoSaude(planoSaude);
        setValeTransporte(valeTransporte);
        setSalarioBruto(salarioBruto);
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Altera o primeiro nome.
     *
     * @param nome o nome
     */
    public void setFirstName(String nome) {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = nome;
    }

    public String getLastName() {
        return lastName;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }

    /**
     * Altera o valor do plano de saude.
     *
     * @param planoSaude o valor do plano de saude
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
     * Altera o valor do vale transporte.
     *
     * @param valeTransporte o vale transporte
     */
    public void setValeTransporte(double valeTransporte) {
        if (valeTransporte < 0) {
            throw new IllegalArgumentException("Valor do vale transporte nao pode ser negativo");
        }
        this.valeTransporte = valeTransporte;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    /**
     * Altera o valor do salario bruto.
     *
     * @param salarioBruto o salario bruto
     */
    public void setSalarioBruto(double salarioBruto) {
        if (salarioBruto < 0) {
            throw new IllegalArgumentException("Salario bruto nao pode ser negativo");
        }
        this.salarioBruto = salarioBruto;
    }

    /**
     * Altera o sobrenome.
     *
     * @param sobrenome o sobrenome
     */
    public void setLastName(String sobrenome) {
        if (sobrenome.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    /**
     * Altera o valor do cpf.
     *
     * @param cpf o cpf
     */
    public void setCpf(String cpf) {
        if (!CpfUtils.isValid(cpf)) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        this.cpf = cpf;
    }

    public double getSalarioLiquido() {
        return getSalarioBruto() - getValeTransporte() - getPlanoSaude();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s %s\n", getFirstName(), getLastName())
            +
            String.format("CPF: %s \n", getCpf())
            +
            "Descontos:\n"
            +
            String.format("  Vale Transporte: R$-%.2f\n", getValeTransporte())
            +
            String.format("  Plano de saude: R$-%.2f\n", getPlanoSaude())
            +
            String.format("Bruto: R$%.2f \n", getSalarioBruto())
            +
            String.format("Liquido: R$%.2f \n", getSalarioLiquido());
    }
}
