import java.util.Date;
import java.util.Scanner;

public class Main {
    public Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Cliente joao = new PessoaFisica("João", "Av. Antonio Carlos, 6627",
                                        new Date(), "111.111.111-11", 36, 'm');
        Cliente lojinha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000",
                                        new Date(), "000.00000.0000/0001", 25, "Comércio");
        //Cliente fantasma
        
        Cliente fantasminha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000",
        new Date(), "000.00000.0000/0001", 25, "Comércio");


        //Teste do equals de clientes
        System.out.println(lojinha.equals(fantasminha));
        //contas
        Conta conta1 = new ContaPoupanca(1234, joao, 1000,800);
        Conta conta2 = new ContaUniversitaria(12121, lojinha, 10000,500);
        //Conta fantasma para testar o equals
        Conta fantasma = new ContaCorrente(12121, lojinha, 10000,200);
        

        conta1.sacar(100);
        conta1.depositar(100);
        conta1.sacar(200);
        conta1.depositar(200);
        conta1.sacar(150);
        conta1.depositar(160);
        
        conta1.imprimirExtratoTaxas();
        fantasma.imprimirExtratoTaxas();
        //implementacao do equals
        //retorna true devido ao fato do numero ser igual e é verificado no metodo equals
       //Nova forma de imprimir 
        System.out.println("--------------------");
        System.out.println(conta1.toString());
        System.out.println("--------------------");
        System.out.println(conta2.toString());
        System.out.println("--------------------");
        //Forma antiga com modificacoes internas
        conta1.impressao_extratosMAIN();
        conta2.impressao_extratosMAIN();
        //teste da implementacao dos novos metodos 
        System.out.println("Informacoes dos usuarios : ");
        System.out.println("-------------------");
        System.out.println(lojinha.toString());
        System.out.println("-------------------");
        System.out.println(joao.toString());
        System.out.println("-------------------");
        int media = Operacao.getTotalOperacoes() / Conta.getTotalContas();
        System.out.println("Média de operações por conta aberta: " + media);

        System.out.println(conta1.getDono().getClass()==PessoaJuridica.class);



    }
}