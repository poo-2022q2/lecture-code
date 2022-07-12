package inheritance;

/**
 * Vendedor.
 */
public class Vendedor extends Funcionario {

    private double vendasBrutas;
    private double taxaComissao;

    /**
     * Cria um vendedor.
     *
     * @param nome           o nome
     * @param sobrenome      o sobrenome
     * @param cpf            o cpf
     * @param vendasBrutas   as vendar brutas
     * @param taxaComissao   a taxa de comissao
     * @param salarioBase    o salario-base
     * @param valeTransporte o vale-transporte
     * @param planoSaude     o plano de saude
     */
    public Vendedor(String nome, String sobrenome, String cpf,
        double vendasBrutas, double taxaComissao, double salarioBase, double valeTransporte,
        double planoSaude) {
        super(nome, sobrenome, cpf, planoSaude, valeTransporte, salarioBase);
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

    public double getComissao() {
        return vendasBrutas * taxaComissao;
    }

    @Override
    public double getSalarioBruto() {
        return super.getSalarioBase() + getComissao();
    }

    @Override
    public String toString() {
        return "Cargo: Vendedor\n"
            +
            String.format("Vendas brutas: R$%.2f \n", getVendasBrutas())
            +
            String.format("Taxa comissao: %.2f%% \n", getTaxaComissao() * 100)
            +
            String.format("Comissao: R$%.2f \n", getComissao())
            +
            super.toString();
    }
}
