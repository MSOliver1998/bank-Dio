import java.util.ArrayList;
import java.util.List;

public class Banco{

    private List<Conta> contas;
    private int agencia;
    private int codigo;
    private String nome;

    public Banco(String nome, int codigo){
        this.nome=nome;
        this.codigo=codigo;
        contas= new ArrayList<>();
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public void excluirConta(Conta conta){
        Conta contaParaDeletar=null;
        if(contas.size()>0){
            for(Conta c: contas){
                if(c==conta){
                    contaParaDeletar=c;
                }
            }
            contas.remove(contaParaDeletar);
        }
    }

    public boolean encontrarConta(Conta conta){
        if(contas.size()>0){
            for(Conta c : contas){
                if(c.equals(conta)){
                    return true;
                }
            }
        }
        return false;
    }
}
