public class Main {
    
    public static void main(String[] args){

        Banco msBank= new Banco("MSBank", 1);
        
        ContaCorrente cc= new ContaCorrente(new Cliente("matheus Silva de Oliveira"));
        ContaPoupanca poupanca= new ContaPoupanca(new Cliente("Fabio Santos Ferreira"));
        msBank.adicionarConta(cc);
        msBank.adicionarConta(poupanca);
    
        System.out.println(msBank.encontrarConta(poupanca));
        

        System.out.println(poupanca.verificarSaldo()); 
        cc.deposito(1000);
        System.out.println(cc.verificarSaldo());
        
        try {
            cc.verificarSaldo();
            cc.transferir(200, poupanca);
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("saldo insuficiente, tente tranferir um valor menor ou faça um deposito");
        }
    }

}
