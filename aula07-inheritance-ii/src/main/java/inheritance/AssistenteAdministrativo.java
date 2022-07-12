package inheritance;

/**
 * Assistente administrativo.
 */
public class AssistenteAdministrativo extends Funcionario {

    private double horasExtras;

    /**
     * Cria um assistente administrativo.
     *
     * @param nome           o nome
     * @param sobrenome      o sobrenome
     * @param cpf            o cpf
     * @param salarioBase    o salario-base
     * @param planoSaude     o plano de saude
     * @param valeTransporte o vale transporte
     * @param horasExtras    as horas extras
     */
    public AssistenteAdministrativo(String nome, String sobrenome, String cpf, double salarioBase,
        double planoSaude, double valeTransporte, double horasExtras) {
        super(nome, sobrenome, cpf, planoSaude, valeTransporte, salarioBase);
        setHorasExtras(horasExtras);
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
            throw new IllegalArgumentException("Horas extras nao pode ser negativo");
        }
        this.horasExtras = horasExtras;
    }

    public double getRendimentoHorasExtras() {
        return getSalarioBase() / 220 * getHorasExtras() * 1.5;
    }

    @Override
    public double getSalarioBruto() {
        return getSalarioBase() + getRendimentoHorasExtras();
    }

    @Override
    public String toString() {
        return "Cargo: Assistente Administrativo\n"
            +
            String.format("Horas-extra: %.2f (R$%.2f) \n", getHorasExtras(),
                getRendimentoHorasExtras())
            +
            super.toString();
    }
}
