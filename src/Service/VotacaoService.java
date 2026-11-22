package Service;

public interface VotacaoService {
    void votar(
            int usuarioId,
            int enqueteId,
            int opcaoId
    );
}
