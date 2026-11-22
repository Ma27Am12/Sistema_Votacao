package Observer;

public class LogObserver implements Observer{
    @Override
    public void atualizar(String mensagem) {

        System.out.println(
                "[LOG] " + mensagem
        );
    }
}
