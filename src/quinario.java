import java.util.Scanner;

public class quinario {

    // Função para converter de quinário para decimal
    public static int quinarioParaDecimal(String quinario) {
        int decimal = 0;
        int tamanho = quinario.length() - 1;

        for (int i = 0; i < quinario.length(); i++) {
            int digito = Character.getNumericValue(quinario.charAt(i));
            decimal += digito * Math.pow(5, tamanho);
            tamanho--;
        }

        return decimal;
    }

    // Função para converter de decimal para duodecimal
    public static String decimalParaDuodecimal(int decimal) {
        StringBuilder duodecimal = new StringBuilder();

        while (decimal > 0) {
            int resto = decimal % 12;
            char digito = (resto < 10) ? (char) ('0' + resto) : (char) ('A' + resto - 10);
            duodecimal.insert(0, digito);
            decimal /= 12;
        }

        return duodecimal.toString();
    }

    // Função para converter de decimal para vigesimal
    public static String decimalParaVigesimal(int decimal) {
        StringBuilder vigesimal = new StringBuilder();

        while (decimal > 0) {
            int resto = decimal % 20;
            char digito = (char) ('0' + resto);
            vigesimal.insert(0, digito);
            decimal /= 20;
        }

        return vigesimal.toString();
    }

    // Função para converter de decimal para sexagesimal
    public static String decimalParaSexagesimal(int decimal) {
        int horas = decimal / 60;
        int minutos = decimal % 60;

        return horas + ":" + minutos;
    }

    // Função para converter de duodecimal para quinário
    public static String duodecimalParaQuinario(String duodecimal) {
        int decimal = Integer.parseInt(duodecimal, 12);
        return decimalParaQuinario(decimal);
    }

    // Função para converter de duodecimal para vigesimal
    public static String duodecimalParaVigesimal(String duodecimal) {
        int decimal = Integer.parseInt(duodecimal, 12);
        return decimalParaVigesimal(decimal);
    }

    // Função para converter de duodecimal para sexagesimal
    public static String duodecimalParaSexagesimal(String duodecimal) {
        int decimal = Integer.parseInt(duodecimal, 12);
        return decimalParaSexagesimal(decimal);
    }

    // Função para converter de vigesimal para quinário
    public static String vigesimalParaQuinario(String vigesimal) {
        int decimal = Integer.parseInt(vigesimal, 20);
        return decimalParaQuinario(decimal);
    }

    // Função para converter de vigesimal para duodecimal
    public static String vigesimalParaDuodecimal(String vigesimal) {
        int decimal = Integer.parseInt(vigesimal, 20);
        return decimalParaDuodecimal(decimal);
    }

    // Função para converter de vigesimal para sexagesimal
    public static String vigesimalParaSexagesimal(String vigesimal) {
        int decimal = Integer.parseInt(vigesimal, 20);
        return decimalParaSexagesimal(decimal);
    }

    // Função para converter de sexagesimal para quinário
    public static String sexagesimalParaQuinario(String sexagesimal) {
        String[] partes = sexagesimal.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        int decimal = horas * 60 + minutos;
        return decimalParaQuinario(decimal);
    }

    // Função para converter de sexagesimal para duodecimal
    public static String sexagesimalParaDuodecimal(String sexagesimal) {
        String[] partes = sexagesimal.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        int decimal = horas * 60 + minutos;
        return decimalParaDuodecimal(decimal);
    }

    // Função para converter de sexagesimal para vigesimal
    public static String sexagesimalParaVigesimal(String sexagesimal) {
        String[] partes = sexagesimal.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        int decimal = horas * 60 + minutos;
        return decimalParaVigesimal(decimal);
    }

    // Função para converter de decimal para quinário
    public static String decimalParaQuinario(int decimal) {
        StringBuilder quinario = new StringBuilder();

        while (decimal > 0) {
            int resto = decimal % 5;
            quinario.insert(0, resto);
            decimal /= 5;
        }

        return quinario.toString();
    }

    // Função principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a base de entrada:");
        System.out.println("1. Quinária");
        System.out.println("2. Duodecimal");
        System.out.println("3. Vigesimal");
        System.out.println("4. Sexagesimal");
        System.out.println("5. Decimal");

        int escolhaBaseEntrada = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.println("Digite o valor na base escolhida:");
        String valorEntrada = scanner.nextLine();

        System.out.println("Escolha a base de saída:");
        System.out.println("1. Duodecimal");
        System.out.println("2. Vigesimal");
        System.out.println("3. Sexagesimal");
        System.out.println("4. Quinária");
        System.out.println("5. Decimal");

        int escolhaBaseSaida = scanner.nextInt();

        int valorDecimal = 0;

        switch (escolhaBaseEntrada) {
            case 1:
                valorDecimal = quinarioParaDecimal(valorEntrada);
                break;
            case 2:
                valorDecimal = Integer.parseInt(valorEntrada, 12);
                break;
            case 3:
                valorDecimal = Integer.parseInt(valorEntrada, 20);
                break;
            case 4:
                String[] partes = valorEntrada.split(":");
                int horas = Integer.parseInt(partes[0]);
                int minutos = Integer.parseInt(partes[1]);
                valorDecimal = horas * 60 + minutos;
                break;
            case 5:
                valorDecimal = Integer.parseInt(valorEntrada);
                break;
            default:
                System.out.println("Opção de base de entrada inválida.");
                return;
        }

        String resultado = "";

        switch (escolhaBaseSaida) {
            case 1:
                resultado = decimalParaDuodecimal(valorDecimal);
                break;
            case 2:
                resultado = decimalParaVigesimal(valorDecimal);
                break;
            case 3:
                resultado = decimalParaSexagesimal(valorDecimal);
                break;
            case 4:
                resultado = decimalParaQuinario(valorDecimal);
                break;
            case 5:
                resultado = String.valueOf(valorDecimal);
                break;
            default:
                System.out.println("Opção de base de saída inválida.");
                return;
        }

        System.out.println("Resultado: " + resultado);
    }
}

