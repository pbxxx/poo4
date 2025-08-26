import java.util.Scanner;

public class Atividade12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] idades = new int[5];
        double[] alturas = new double[5];
        
        System.out.println("Digite idade e altura de 5 pessoas:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Pessoa " + (i+1) + " - idade: ");
            idades[i] = scanner.nextInt();
            System.out.print("Pessoa " + (i+1) + " - altura: ");
            alturas[i] = scanner.nextDouble();
        }
        
        System.out.println("\nOrdem inversa:");
        for (int i = 4; i >= 0; i--) {
            System.out.println("Pessoa " + (5-i) + ": idade=" + idades[i] + ", altura=" + alturas[i]);
        }
        
        int maisVelho = idades[0], maisNovo = idades[0];
        double maisAlto = alturas[0], maisBaixo = alturas[0];
        double somaIdade = 0, somaAltura = 0;
        
        for (int i = 0; i < 5; i++) {
            if (idades[i] > maisVelho) maisVelho = idades[i];
            if (idades[i] < maisNovo) maisNovo = idades[i];
            if (alturas[i] > maisAlto) maisAlto = alturas[i];
            if (alturas[i] < maisBaixo) maisBaixo = alturas[i];
            somaIdade += idades[i];
            somaAltura += alturas[i];
        }
        
        double mediaIdade = somaIdade / 5;
        double mediaAltura = somaAltura / 5;
        
        System.out.println("\nMais velho: " + maisVelho + " anos");
        System.out.println("Mais novo: " + maisNovo + " anos");
        System.out.println("Mais alto: " + maisAlto + "m");
        System.out.println("Mais baixo: " + maisBaixo + "m");
        
        System.out.println("\nAcima da média de idade (" + mediaIdade + "):");
        for (int i = 0; i < 5; i++) {
            if (idades[i] > mediaIdade) {
                System.out.println("Pessoa " + (i+1) + ": " + idades[i] + " anos");
            }
        }
        
        System.out.println("\nAbaixo da média de altura (" + mediaAltura + "m):");
        for (int i = 0; i < 5; i++) {
            if (alturas[i] < mediaAltura) {
                System.out.println("Pessoa " + (i+1) + ": " + alturas[i] + "m");
            }
        }
    }
}