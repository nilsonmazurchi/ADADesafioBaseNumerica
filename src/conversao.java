import java.util.Scanner;

public class conversao {

    public static String decimalParaBinario(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static String decimalParaOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    public static String decimalParaHexadecimal(int decimal) {
        return Integer.toHexString(decimal);
    }

    public static int binarioParaDecimal(String binario) {
        return Integer.parseInt(binario, 2);
    }

    public static String binarioParaOctal(String binario) {
        int decimal = binarioParaDecimal(binario);
        return decimalParaOctal(decimal);
    }

    public static String binarioParaHexadecimal(String binario) {
        int decimal = binarioParaDecimal(binario);
        return decimalParaHexadecimal(decimal);
    }

    public static int octalParaDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    public static String octalParaBinario(String octal) {
        int decimal = octalParaDecimal(octal);
        return decimalParaBinario(decimal);
    }

    public static String octalParaHexadecimal(String octal) {
        int decimal = octalParaDecimal(octal);
        return decimalParaHexadecimal(decimal);
    }

    public static int hexadecimalParaDecimal(String hexadecimal) {
        return Integer.parseInt(hexadecimal, 16);
    }

    public static String hexadecimalParaBinario(String hexadecimal) {
        int decimal = hexadecimalParaDecimal(hexadecimal);
        return decimalParaBinario(decimal);
    }

    public static String hexadecimalParaOctal(String hexadecimal) {
        int decimal = hexadecimalParaDecimal(hexadecimal);
        return decimalParaOctal(decimal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a base de entrada:");
        System.out.println("1. Decimal");
        System.out.println("2. Binário");
        System.out.println("3. Octal");
        System.out.println("4. Hexadecimal");

        int escolhaBaseEntrada = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.println("Digite o valor na base escolhida:");
        String valorEntrada = scanner.nextLine();

        System.out.println("Escolha a base de saída:");
        System.out.println("1. Decimal");
        System.out.println("2. Binário");
        System.out.println("3. Octal");
        System.out.println("4. Hexadecimal");

        int escolhaBaseSaida = scanner.nextInt();

        int valorDecimal;

        switch (escolhaBaseEntrada) {
            case 1:
                valorDecimal = Integer.parseInt(valorEntrada);
                break;
            case 2:
                valorDecimal = binarioParaDecimal(valorEntrada);
                break;
            case 3:
                valorDecimal = octalParaDecimal(valorEntrada);
                break;
            case 4:
                valorDecimal = hexadecimalParaDecimal(valorEntrada);
                break;
            default:
                System.out.println("Opção de base de entrada inválida.");
                return;
        }

        switch (escolhaBaseSaida) {
            case 1:
                System.out.println("Resultado: " + valorDecimal);
                break;
            case 2:
                System.out.println("Resultado: " + decimalParaBinario(valorDecimal));
                break;
            case 3:
                System.out.println("Resultado: " + decimalParaOctal(valorDecimal));
                break;
            case 4:
                System.out.println("Resultado: " + decimalParaHexadecimal(valorDecimal));
                break;
            default:
                System.out.println("Opção de base de saída inválida.");
        }
    }
}
