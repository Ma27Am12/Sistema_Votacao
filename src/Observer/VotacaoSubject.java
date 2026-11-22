package Observer;

import java.util.ArrayList;
import java.util.List;

public class VotacaoSubject {
    private List<Observer> observers =
            new ArrayList<>();

    public void adicionarObserver(
            Observer observer) {

        observers.add(observer);
    }

    public void notificar(
            String mensagem) {

        for (Observer observer : observers) {

            observer.atualizar(mensagem);
        }
    }
}
