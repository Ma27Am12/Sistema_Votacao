package Observer;

public class ResultadoObserver implements Observer{
    @Override
    public void atualizar(String mensagem) {

        System.out.println(
                "[RESULTADO] " + mensagem);
    }
}
