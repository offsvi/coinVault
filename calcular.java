// Nessa classe será feito o calculo da das moedas e a conversão 
public class MenuAdicionarMoeda {
    public static void exibir()
    {
        System.out.println("SELEÇÃO DE MOEDAS");
        System.out.println("[1] Dólar ($).");
        System.out.println("[2] Euro (€).");
        System.out.println("[3] Real (R$).");
        System.out.println("[4] Yen (¥).");
        System.out.println("[5] Cancelar adição.");
        System.out.println();
        System.out.print("Escolha uma Opção: ");

//Nessa parte irá mencionar qual o tipo de moeda 
        switch(Principal.ENTRADA.nextInt())
        {
            case 1 :
                adicionarDolar();
                break;

            case 2 :
                adicionarEuro();
                break;

            case 3 :
                adicionarReal();
                break;

            case 4 :
                adicionarYen();
                break;

            case 5 :
                break;

            default :
                System.out.println("Opção inválida.");
        }
    }

// Aqui será adcionado o valor da moeda e simbolo, para acrescentar o subtrair o valor
    private static void adicionarMoeda(int[] valoresPossiveis, String nome, String simbolo)
    {
        String valores = "";
        int valor;

        for(int valorPossivel : valoresPossiveis)
        {
            valores += simbolo + valorPossivel + " ";
        }

        System.out.println("Valores Disponíves Para " + nome);
        System.out.println(valores);
        System.out.println();
        System.out.print("Digite o valor a ser adicionado ou 0(zero) para cancelar: ");

        valor = Principal.ENTRADA.nextInt();

        if(valor == 0)
        {
            return;
        }

        System.out.println();
// Navareavel valor será inserido o valor que foi aplicado acima
        try
        {
            switch (nome)
            {
                case Dolar.NOME :
                    Principal.COFRINHO.adicionar(new Dolar(valor));
                break;

                case Euro.NOME :
                    Principal.COFRINHO.adicionar(new Euro(valor));
                break;

                case Real.NOME :
                    Principal.COFRINHO.adicionar(new Real(valor));
                break;

                case Yen.NOME :
                    Principal.COFRINHO.adicionar(new Yen(valor));
            }

            System.out.println("Você colocou " + simbolo + valor + " centavo(s) no cofrinho.");
        }
        catch(MoedaInexistenteException ex)
        {
            System.out.println("Não foi possível adicionar " + simbolo + valor + ", pois, não existe tal moeda."); // Se não for possível processar nenhuma informação irá aparecer essa parte
        }
    }

    private static void adicionarDolar()
    {
        adicionarMoeda(Dolar.VALORES_POSSIVEIS, Dolar.NOME, Dolar.SIMBOLO);
    }

    private static void adicionarEuro()
    {
        adicionarMoeda(Euro.VALORES_POSSIVEIS, Euro.NOME, Euro.SIMBOLO);
    }

    private static void adicionarReal()
    {
        adicionarMoeda(Real.VALORES_POSSIVEIS, Real.NOME, Real.SIMBOLO);
    }

    private static void adicionarYen()
    {
        adicionarMoeda(Yen.VALORES_POSSIVEIS, Yen.NOME, Yen.SIMBOLO);
    }
}
