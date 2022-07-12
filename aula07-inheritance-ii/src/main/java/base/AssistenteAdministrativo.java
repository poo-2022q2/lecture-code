package base;

import utils.CpfUtils;

/**
 * Assistente administrativo.
 */
public class AssistenteAdministrativo {

    private String firstName;
    private String lastName;
    private String cpf;
    private double salarioBase;
    private double planoSaude;
    private double valeTransporte;
    private double horasExtras;

    /**
     * Cria um assistente administrativo.
     *
     * @param nome           o primeiro nome
     * @param sobrenome      o sobrenome
     * @param cpf            o cpf
     * @param salarioBase    o salario base
     * @param planoSaude     o plano de saude
     * @param valeTransporte o vale transporte
     * @param horasExtras    as horas extras
     */
    public AssistenteAdministrativo(String nome, String sobrenome, String cpf, double salarioBase,
        double planoSaude, double valeTransporte, double horasExtras) {
        setFirstName(nome);
        setLastName(sobrenome);
        setCpf(cpf);
        setSalarioBase(salarioBase);
        setPlanoSaude(planoSaude);
        setValeTransporte(valeTransporte);
        setHorasExtras(horasExtras);
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Alter o valor do primeiro nome.
     *
     * @param nome o primeiro nome
     */
    public final void setFirstName(String nome) {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = nome;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalarioLiquido() {
        return getSalarioBruto() - planoSaude - valeTransporte;
    }

    /**
     * Altera o valor do sobrenome.
     *
     * @param sobrenome o sobrenome
     */
    public final void setLastName(String sobrenome) {
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
    public final void setCpf(String cpf) {
        if (!CpfUtils.isValid(cpf)) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        this.cpf = cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }

    /**
     * Altera o valor do plano de saude.
     *
     * @param planoSaude o valor
     */
    public void setPlanoSaude(double planoSaude) {
        if (planoSaude < 0) {
            throw new IllegalArgumentException("Valor do plano de saude deve ser positivo");
        }
        this.planoSaude = planoSaude;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    /**
     * Altera o valor do vale transporte.
     *
     * @param valeTransporte o valor do vale transporte
     */
    public void setValeTransporte(double valeTransporte) {
        if (valeTransporte < 0) {
            throw new IllegalArgumentException("Valor do vale transporte não pode ser negativo");
        }
        this.valeTransporte = valeTransporte;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    /**
     * Altera o valor das horas extras.
     *
     * @param horasExtras o valor das horas extras
     */
    public void setHorasExtras(double horasExtras) {
        if (horasExtras < 0) {
            throw new IllegalArgumentException("A qtde. de horas deve ser positiva");
        }
        this.horasExtras = horasExtras;
    }

    public double getSalarioBruto() {
        return getSalarioBase() + getRendimentoHorasExtras();
    }

    public double getRendimentoHorasExtras() {
        return getSalarioBase() / 220 * getHorasExtras() * 1.5;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s %s\n", getFirstName(), getLastName())
            + String.format("CPF: %s \n", getCpf())
            + "Cargo: Assistente Administrativo\n"
            + String.format("Salario-base: R$%.2f \n", getSalarioBase())
            + String.format("Horas-extra: %.2f (R$%.2f) \n", getHorasExtras(),
                getRendimentoHorasExtras())
            + String.format("Bruto: R$%.2f \n", getSalarioBruto())
            + "Descontos:\n"
            + String.format("  Vale Transporte: -R$%.2f\n", getValeTransporte())
            + String.format("  Plano de saude: -R$%.2f\n", getPlanoSaude())
            + String.format("Liquido: R$%.2f \n", getSalarioLiquido());
    }
}
