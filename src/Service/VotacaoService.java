package Service;

public interface VotacaoService {
    void votar(
            int usuarioId,
            int enqueteId,
            int opcaoId
    );

    void exibirResultados(
            int enqueteId
    );
}
