import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

abstract class Conta implements ITaxas {
    
    Scanner sc = new Scanner(System.in);
    private int numero;

    protected Cliente dono;

    private double saldo;

    protected double limite;

    private ArrayList<Operacao>  operacoes = new ArrayList<Operacao>();

    public ArrayList<Operacao> getOperacoes() {
        return operacoes;
    }

    int numero_operacao = 0;


    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
    
    
        

        Conta.totalContas++;
    }

    public void imprimirExtratoTaxas()
    {   
        double soma = 0;
        
       
        System.out.println("Extrato Taxas : ");
        System.out.println("=======================");
        System.out.println("Taxa de manuntencao : " + this.calculataxas());
        System.out.println("Operacoes: ");
        
        for(Operacao atual : operacoes)
        {   
            if(atual != null){
                if(atual.getTipo() == 's')
                {
                    int i = 0;
                    System.out.println("Saque " + i+1 + ": " + atual.calculataxas());
                    i++;
                    soma += atual.calculataxas(); 
                }
            }
            
        }
        soma = soma + this.calculataxas();
        System.out.println("Gasto total : " +  soma);
        System.out.println("=-----------------------------------=");
        
     
    }
    public void impressao_extratosMAIN()
    {
        int numero;
        System.out.println("digite a forma de ordenacao [1] - Por deposito [-1] - por saque [0] - Em ordem");
        numero = sc.nextInt();
        imprimirExtrato(numero);
    }
    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor ;

            setOperacoes( new OperacaoSaque(valor));
          
            
            return true;
        }   

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

      setOperacoes( new OperacaoDeposito(valor));
      
        
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean equals(int numero)
    {
        return this.numero == numero;
    }
    
    public String toString()
    {
        String contaStr = "Conta : "  +  this.numero + "\n" + " Saldo : " + this.saldo + "\n" + "Limite : " + this.limite ;

        return contaStr;
    }
    public void imprimirExtrato(int num) {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                
                System.out.println(atual.toString()); 
               
            }
        }
        System.out.println("====================");

        System.out.println("Extrato ordenado: ");
        Collections.sort(operacoes);
        for(Operacao atual : this.operacoes)
        {
            System.out.println(atual);
        }
        
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public void setOperacoes(Operacao operacoes) {
        this.operacoes.add(operacoes);
    }

}
