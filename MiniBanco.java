package Minibanco;

import java.util.Scanner;



public class MiniBanco {
    //constantes
    static final double LIMITE_SAQUE = 1000.00; //valor limite de saque
    static final double TAXA_SAQUE = 0.02; //taxa de saque de 2%

    static void exibirExtrato(String[] extrato, int totalLinhas){
        System.out.println("\n======EXTRATo======");
        if(totalLinhas == 0){
            System.out.println("\nNenhum movimentação");
        }else{
            for (int i = 0; i< totalLinhas;i++){
                System.out.println(" " +extrato);
            }
        }
        System.out.println("=========================");
    }

    static int registrar(String[] extrato, int totalLinhas, String linha){
        extrato[totalLinhas] = linha;
        return totalLinhas + 1;
    }

    static double sacar(double saldo, double valor){
        return saldo - calcularTotalSaque(valor);
    }

    static double calcularTotalSaque(double valor){
        return valor + (valor * TAXA_SAQUE);
    }

    static boolean dentroDoLimite(double valor){
        return valor <= LIMITE_SAQUE;
    }

    static boolean saldoSuficiente(double valor, double saldo){
        return saldo >= calcularTotalSaque(valor);
    }

    static boolean valorEhValido(double valor){
        return valor > 0;
    }

    static double depositar(double saldo, double valor){
        return saldo + valor;  
    }

    static void exibirSaldo(double saldo){
        System.out.printf(" Saldo Atual: R$ %.2f%n",  saldo);
    }

    static void exibirMenu(){
        System.out.println("=== MINI BANCO ===");
        System.out.println("1 - Depositar");
        System.out.println("2-sacar");
        System.out.println("3-consultar saldo");
        System.out.println("4-ver extrato");
        System.out.println("0-sair");
        System.out.println("Digite uma das opçoes");
    }
    public static void main(String[] args) {
        //objeto para entrada de dados:

        Scanner scanner = new Scanner(System.in);

        double saldo = 0.0; 

        int opcao = -1;

        String[] extrato = new String[50];
        int totalLinhas = 0;

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

       // System.out.printf("Olá, %s! Saldo inicial: R$%.2f%n", nome, saldo);

       while (opcao != 0) {
            exibirMenu();
            opcao = scanner.nextInt();

            if(opcao == 1){
                //System.out.println("Depositar - Em breve");
                System.out.print("Valor a depositar: R$ ");
                double valor = scanner.nextDouble();

                if(!valorEhValido(valor)){
                    System.out.println("valor invalido ! deve ser maior que zero ");
                }else{
                     saldo = depositar(saldo, valor);
                    System.out.println("deposito realizado"); 
                    exibirSaldo(saldo);
                    totalLinhas = registrar(extrato, totalLinhas, String.format("Depósito + R$ %.2f -> Saldo: R$ %.2f", valor, saldo));
                    
                }

               
            }else if(opcao == 2){
                //FLUXO SACAR
 
                // System.out.println("Sacar - em breve");
                System.out.print("Valor a sacar: R$");
                double valorSaque = scanner.nextDouble();
 
                if(!valorEhValido(valorSaque)){
                    System.out.print("Valor invalido!");
                }else if(!dentroDoLimite(valorSaque)){
                    System.out.printf("Limite excedido. Máximo: R$ %.2f", LIMITE_SAQUE);
                }else if(!saldoSuficiente(saldo, valorSaque)){
                    System.out.printf("Saldo insulficiente. Necessario: R$ %.2f", calcularTotalSaque(valorSaque));
                }else{
                    double taxa = valorSaque * TAXA_SAQUE;
                    saldo = sacar(saldo, valorSaque);
                    System.out.printf("Saque realizado. Taxa cobrada: R$ %.2f", taxa);
                    exibirSaldo(saldo);
                    totalLinhas = registrar(extrato, totalLinhas, String.format("SAQUE -R$ %.2f -> Saldo: R$%.2f", valorSaque, saldo));
                }
            }else if(opcao == 3){
                // System.out.println("Consultar saldo - em breve");
                exibirSaldo(saldo);
            }else if(opcao == 4){
                // System.out.println("Extrato - em breve");
                exibirExtrato(extrato, totalLinhas);
 
            }else if(opcao == 0){
                exibirExtrato(extrato, totalLinhas);
                System.out.println("Até logo " + nome + "!");
            }else{
                System.out.println("Opção invalida. Tente novamente.");
            }
     }

        scanner.close();

    }
}
