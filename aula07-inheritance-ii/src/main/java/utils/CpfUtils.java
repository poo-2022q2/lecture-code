package utils;

/**
 * Biblioteca de funcoes para manipular números de CPF.
 */
public final class CpfUtils {

    private CpfUtils() {

    }

    /**
     * Gera o primeiro digito verificador.
     *
     * @param cpf uma string com os 9 primeiros digitos do cpf.
     * @return o digito verificador
     */
    private static int firstCheckDigit(String cpf) {
        int vi = 0;

        for (int i = 10; i >= 2; i--) {
            vi += Character.digit(cpf.charAt(10 - i), 10) * i;
        }
        vi %= 11;

        return vi < 2 ? 0 : 11 - vi;
    }

    /**
     * Gera o segundo digito verificador do cpf.
     *
     * @param cpf uma string contendo os nove primeiros digitos do cpf
     * @return o digito verificador
     */
    private static int secondCheckDigit(String cpf) {
        int vii = 0;

        for (int i = 10; i >= 1; i--) {
            vii += Character.digit(cpf.charAt(10 - i), 10) * (i + 1);
        }

        vii = vii % 11;

        return vii < 2 ? 0 : 11 - vii;
    }

    /**
     * Verifica se um cpf valido, ou seja, se os digitos verificadores sao validos para os nove
     * primeiro numeros do cpf.
     *
     * @param cpf numero de cpf
     * @return true se eh valido, false caso contrário
     */
    public static boolean isValid(String cpf) {
        if (cpf.length() != 11) {
            return false;
        }

        return firstCheckDigit(cpf) == Character.digit(cpf.charAt(9), 10)
            && secondCheckDigit(cpf) == Character.digit(cpf.charAt(10), 10);
    }

    /**
     * Gera um CPF valido aleatorio.
     *
     * @return o cpf
     */
    public static String random() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            builder.append((int) (Math.random() * 10));
        }

        builder.append(firstCheckDigit(builder.toString()));
        builder.append(secondCheckDigit(builder.toString()));

        return builder.toString();
    }

    /**
     * Testes das funcoes.
     *
     * @param args os argumentos (nao utilizados)
     */
    public static void main(String[] args) {
        System.out.println(CpfUtils.firstCheckDigit("05388534170"));
        System.out.println(CpfUtils.secondCheckDigit("05388534170"));

        System.out.println(CpfUtils.isValid("05388534170"));
        System.out.println(CpfUtils.isValid("05387535170"));

        System.out.println(CpfUtils.random());
    }
}
