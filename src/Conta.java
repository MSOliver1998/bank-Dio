import java.util.Locale;
import java.util.Scanner;

public abstract class Conta {
    
    private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
    private Scanner scanner=new Scanner(System.in).useLocale(Locale.US);

    protected int numero;
    protected int agencia;
    protected String tipo;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.numero=SEQUENCIAL;
        this.agencia=AGENCIA_PADRAO;
        this.cliente=cliente;
    }    

    public String verificarSaldo(){
        return String.format("R$: %.2f",this.saldo);
    }

    public void deposito(double valor){
        this.saldo+= valor;
    }

    public void saque(double valor) throws Exception{
        if(this.saldo>=valor){
            this.saldo-=valor;
        }else{
            throw new Exception("saldo indisponivel");
        }
    }

    public void transferir(double valor, Conta conta) throws Exception{
        if(this.saldo>= valor){
            System.out.println(String.format("Deseja transferir R$: %.2f para %S", valor,conta.cliente.getNome()));
            System.out.println("s/n");
            String confirmacao=scanner.next();
            if(confirmacao.equalsIgnoreCase("s")){
                this.saque(valor);
                conta.deposito(valor);
                System.out.println(String.format("você transeferiu R$: %.2f para %S", valor,conta.cliente.getNome()));
                System.err.println(String.format("saldo atual é de R$: %S",this.verificarSaldo()));
            }else{
                System.out.println("transferencia cancelada pelo usuario");
            }
        }else{
            throw new Exception("saldo indisponivel");
        }
    };
}
