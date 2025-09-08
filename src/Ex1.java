import java.util.Scanner;

class Ex1 {

    public static double calcularMedia(double P1, double E1, double E2, double X, double SUB, double API) {
        double notaBase = P1 * 0.5 + E1 * 0.2 + E2 * 0.3 + X + SUB * 0.15;
        double parte1 = notaBase * 0.5;
        double diferenca = notaBase - 5.9;

        double parte2 = 0;

        if (diferenca > 0) {
            parte2 = API * 0.5;
        }

        return parte1 + parte2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos cenários você quer testar? ");
        int totalCenarios = scanner.nextInt();

        System.out.println("\nInforme as notas para cada cenário (P1, E1, E2, X, SUB, API):");

        System.out.println("\nCenário |   P1 |  E1 |  E2 |  X  | SUB | API | Média");
        System.out.println("--------|------|-----|-----|-----|-----|-----|-------");

        for (int i = 0; i < totalCenarios; i++) {
            System.out.printf("\nCenário %d:\n", i + 1);

            System.out.print("Digite a nota P1: ");
            double P1 = scanner.nextDouble();

            System.out.print("Digite a nota E1: ");
            double E1 = scanner.nextDouble();

            System.out.print("Digite a nota E2: ");
            double E2 = scanner.nextDouble();

            System.out.print("Digite a nota X: ");
            double X = scanner.nextDouble();

            System.out.print("Digite a nota SUB: ");
            double SUB = scanner.nextDouble();

            System.out.print("Digite a nota API: ");
            double API = scanner.nextDouble();

            double media = calcularMedia(P1, E1, E2, X, SUB, API);

            System.out.printf("   %2d    | %4.1f | %3.1f | %3.1f | %3.1f | %3.1f | %3.1f | %5.2f\n",
                    i + 1, P1, E1, E2, X, SUB, API, media);
        }

        scanner.close();
    }
}