package Service;

import DAO.VotoDAO;
import model.Voto;
import Observer.VotacaoSubject;
import Observer.ResultadoObserver;
import Observer.LogObserver;

public class VotacaoServiceImpl implements VotacaoService{
    private VotoDAO votoDAO = new VotoDAO();
    private VotacaoSubject subject = new VotacaoSubject();

    public VotacaoServiceImpl() {

        subject.adicionarObserver(
                new ResultadoObserver());

        subject.adicionarObserver(
                new LogObserver());
    }

    @Override
    public void votar(
            int usuarioId,
            int enqueteId,
            int opcaoId
    ) {

        Voto voto = new Voto(
                0,
                usuarioId,
                enqueteId,
                opcaoId
        );

        votoDAO.inserir(voto);
        subject.notificar("Novo voto registrado!");
    }

    @Override
    public void exibirResultados(
            int enqueteId
    ) {

        votoDAO.exibirResultados(
                enqueteId
        );
    }

}
