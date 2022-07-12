package composition;

/**
 * Assistente administrativo.
 */
public class AssistenteAdministrativo {

    private final Funcionario funcionario;

    /**
     * Cria um funcionario.
     *
     * @param nome           o nome
     * @param sobrenome      o sobrenome
     * @param cpf            o cpf
     * @param planoSaude     o plano de saude
     * @param valeTransporte o vale transporte
     * @param salarioBruto   o salario bruto
     */
    public AssistenteAdministrativo(String nome, String sobrenome, String cpf, double planoSaude,
        double valeTransporte, double salarioBruto) {
        funcionario = new Funcionario(nome, sobrenome, cpf, planoSaude, valeTransporte,
            salarioBruto);
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

    public double getSalarioBruto() {
        return funcionario.getSalarioBruto();
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


    @Override
    public String toString() {
        return String.format("Nome: %s %s\n", getFirstName(), getLastName())
            +
            String.format("CPF: %s \n", getCpf())
            +
            "Cargo: Assistente Administrativo\n"
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
