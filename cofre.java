// Moeda.java
public class Moeda {
    private String pais;
    private double valor;

    public Moeda(String pais, double valor) {
        this.pais = pais;
        this.valor = valor;
    }

    public String getPais() {
        return pais;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return pais + " - " + valor;
    }
}


// Cofrinho.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cofrinho {
    private List<Moeda> moedas;

    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
    }

    public void removerMoeda(int indice) {
        if (indice >= 0 && indice < moedas.size()) {
            moedas.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarMoedas() {
        System.out.println("Moedas no cofrinho:");
        for (int i = 0; i < moedas.size(); i++) {
            System.out.println(i + ": " + moedas.get(i));
        }
    }

    public double calcularTotalEmReais() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.getValor();
        }
        return total;
    }

    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;
        do {
            System.out.println("------- Menu -------");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Calcular total em Reais");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o país da moeda: ");
                    scanner.nextLine(); // Consumir a quebra de linha
                    String pais = scanner.nextLine();
                    System.out.print("Informe o valor da moeda: ");
                    double valor = scanner.nextDouble();
                    cofrinho.adicionarMoeda(new Moeda(pais, valor));
                    break;
                case 2:
                    cofrinho.listarMoedas();
                    System.out.print("Informe o índice da moeda a ser removida: ");
                    int indice = scanner.nextInt();
                    cofrinho.removerMoeda(indice);
                    break;
                case 3:
                    cofrinho.listarMoedas();
                    break;
                case 4:
                    System.out.println("Total em Reais: R$" + cofrinho.calcularTotalEmReais());
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
