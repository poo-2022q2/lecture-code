package composition;

/**
 * Vendedor.
 */
public class Vendedor {

    private final Funcionario funcionario;
    private double vendasBrutas;
    private double taxaComissao;

    /**
     * Cria um vendedor.
     *
     * @param nome           o nome
     * @param sobrenome      o sobrenome
     * @param cpf            o cpf
     * @param vendasBrutas   as vendas brutas
     * @param taxaComissao   a taxa de comissao
     * @param planoSaude     o plano de saude
     * @param valeTransporte o vale transpore
     * @param salarioBruto   o salario bruto
     */
    public Vendedor(String nome, String sobrenome, String cpf, double vendasBrutas,
        double taxaComissao, double planoSaude, double valeTransporte, double salarioBruto) {
        funcionario = new Funcionario(nome, sobrenome, cpf, planoSaude, valeTransporte,
            salarioBruto);
        setVendasBrutas(vendasBrutas);
        setTaxaComissao(taxaComissao);
    }


    public final double getVendasBrutas() {
        return vendasBrutas;
    }

    /**
     * Altera o valor das vendas brutas.
     *
     * @param vendasBrutas as vendas brutas
     */
    public final void setVendasBrutas(double vendasBrutas) {
        if (vendasBrutas < 0.0) {
            throw new IllegalArgumentException("Gross sales cannot be negative");
        }
        this.vendasBrutas = vendasBrutas;
    }

    public final double getTaxaComissao() {
        return taxaComissao;
    }

    /**
     * Altera o valor da taxa de comissao.
     *
     * @param taxaComissao a taxa de comissao
     */
    public final void setTaxaComissao(double taxaComissao) {
        if (taxaComissao < 0.0 || taxaComissao > 1.0) {
            throw new IllegalArgumentException("Comission rate must a percentage --- [0,1]");
        }
        this.taxaComissao = taxaComissao;
    }

    public String getFirstName() {
        return funcionario.getFirstName();
    }

    public void setFirstName(String firstName) {
        funcionario.setFirstName(firstName);
    }

    public String getLastName() {
        return funcionario.getLastName();
    }

    public double getPlanoSaude() {
        return funcionario.getPlanoSaude();
    }

    public void setPlanoSaude(double planoSaude) {
        funcionario.setPlanoSaude(planoSaude);
    }

    public double getValeTransporte() {
        return funcionario.getValeTransporte();
    }

    public void setValeTransporte(double valeTransporte) {
        funcionario.setValeTransporte(valeTransporte);
    }

    public void setSalarioBruto(double salarioBruto) {
        funcionario.setSalarioBruto(salarioBruto);
    }

    public void setLastName(String lastName) {
        funcionario.setLastName(lastName);
    }

    public String getCpf() {
        return funcionario.getCpf();
    }

    public void setCpf(String cpf) {
        funcionario.setCpf(cpf);
    }

    public double getSalarioLiquido() {
        return funcionario.getSalarioLiquido();
    }

    public double getSalarioBruto() {
        return funcionario.getSalarioBruto() + vendasBrutas * taxaComissao;
    }

    @Override
    public String toString() {
        return "Cargo: Vendedor Comissionista\n"
            +
            super.toString()
            +
            String.format("Vendas brutas: R$%.2f \n", getVendasBrutas())
            +
            String.format("Taxa comissao: %.2f%% \n", getTaxaComissao() * 100)
            +
            String.format("Comissao (Bruto): R$%.2f \n", getSalarioBruto())
            +
            String.format("Liquido: R$%.2f \n", getSalarioLiquido());
    }
}
