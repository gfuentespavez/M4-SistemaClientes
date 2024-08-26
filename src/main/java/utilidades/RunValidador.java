package utilidades;

public class RunValidador {

    public static boolean verificarRUT (String rut, char digitoverificador) {
        int suma = 0;
        int multiplicador = 2;

        //Recorrer dígitos del run
        for (int i = rut.length() - 1; i >= 0; i--) {
            int numero = Character.getNumericValue(rut.charAt(i));
            suma += numero * multiplicador;
            multiplicador++;

            //Reinicia multiplicador
            if (multiplicador > 7) {
                multiplicador = 2;
            }
        }

        //Módulo 11

        int resto = suma % 11;
        int digitoCalculado = 11 - resto;

        char digitoCalculadoChar;
        if (digitoCalculado == 11) {
            digitoCalculadoChar = '0';
        } else if (digitoCalculado == 10) {
            digitoCalculadoChar = 'K';
        } else {
            digitoCalculadoChar = (char) (digitoCalculado + '0');
        }
        return digitoCalculadoChar == digitoverificador;
    }
}
