package base;

import utils.CpfUtils;

/**
 * Vendedor.
 */
public class Vendedor {

    private String nome;
    private String sobrenome;
    private String cpf;
    private double vendasBrutas;
    private double taxaComissao;
    private double salarioBase;
    private double valeTransporte;
    private double planoSaude;

    /**
     * Cria um vendedor.
     *
     * @param nome           o primeiro nome
     * @param sobrenome      o sobrenome
     * @param cpf            o cpf
     * @param vendasBrutas   as vendas brutas
     * @param taxaComissao   a taxa de comissao
     * @param salarioBase    o salario-base
     * @param valeTransporte o vale transporte
     * @param planoSaude     o plano de saude
     */
    public Vendedor(String nome, String sobrenome, String cpf,
        double vendasBrutas, double taxaComissao, double salarioBase, double valeTransporte,
        double planoSaude) {
        setNome(nome);
        setSobrenome(sobrenome);
        setCpf(cpf);
        setVendasBrutas(vendasBrutas);
        setTaxaComissao(taxaComissao);
        setSalarioBase(salarioBase);
        setValeTransporte(valeTransporte);
        setPlanoSaude(planoSaude);
    }

    public String getNome() {
        return nome;
    }

    /**
     * Altera o valor do nome.
     *
     * @param nome o nome
     */
    private void setNome(String nome) {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Altera o valor do sobrenome.
     *
     * @param sobrenome o sobrenome
     */
    private void setSobrenome(String sobrenome) {
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
    private void setCpf(String cpf) {
        if (!CpfUtils.isValid(cpf)) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        this.cpf = cpf;
    }

    public double getVendasBrutas() {
        return vendasBrutas;
    }

    /**
     * Altera o valor das vendas brutas.
     *
     * @param vendasBrutas as vendas brutas
     */
    public void setVendasBrutas(double vendasBrutas) {
        if (vendasBrutas < 0.0) {
            throw new IllegalArgumentException("Gross sales cannot be negative");
        }
        this.vendasBrutas = vendasBrutas;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    /**
     * Altera o valor da taxa de comissao.
     *
     * @param taxaComissao a taxa de comissao
     */
    public void setTaxaComissao(double taxaComissao) {
        if (taxaComissao < 0.0 || taxaComissao > 1.0) {
            throw new IllegalArgumentException("Comission rate must a percentage --- [0,1]");
        }
        this.taxaComissao = taxaComissao;
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
        if (salarioBase < 0.0) {
            throw new IllegalArgumentException("Salario base nao pode ser negativo");
        }
        this.salarioBase = salarioBase;
    }

    public double getSalarioBruto() {
        return getSalarioBase() + getVendasBrutas() * getTaxaComissao();
    }

    public double getSalarioLiquido() {
        return getSalarioBruto() - getValeTransporte() - getPlanoSaude();
    }

    public double getComissao() {
        return getVendasBrutas() * getTaxaComissao();
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
     * @param valeTransporte o vale transporte
     */
    public void setValeTransporte(double valeTransporte) {
        if (valeTransporte < 0) {
            throw new IllegalArgumentException("Valor do vale transporte não pode ser negativo");
        }
        this.valeTransporte = valeTransporte;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s %s\n", getNome(), getSobrenome())
            + String.format("CPF: %s \n", getCpf())
            +
            "Cargo: Vendedor\n"
            +
            String.format("Vendas brutas: R$%.2f \n", getVendasBrutas())
            +
            String.format("Taxa comissao: %.2f%% \n", getTaxaComissao() * 100)
            +
            String.format("Comissao: R$%.2f \n", getComissao())
            +
            String.format("Base: R$%.2f\n", getSalarioBase())
            +
            "Descontos:\n"
            +
            String.format("  Vale Transporte: -R$%.2f\n", getValeTransporte())
            +
            String.format("  Plano de saude: -R$%.2f\n", getPlanoSaude())
            +
            String.format("Bruto: R$%.2f\n", getSalarioBruto())
            +
            String.format("Liquido: R$%.2f \n", getSalarioLiquido());
    }
}
