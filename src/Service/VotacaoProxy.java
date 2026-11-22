package Service;

import DAO.VotoDAO;

public class VotacaoProxy implements VotacaoService{
    private VotacaoServiceImpl service =
            new VotacaoServiceImpl();

    private VotoDAO votoDAO =
            new VotoDAO();

    @Override
    public void votar(
            int usuarioId,
            int enqueteId,
            int opcaoId
    ) {

        if (votoDAO.jaVotou(
                usuarioId,
                enqueteId)) {

            System.out.println(
                    "Usuário já votou nesta enquete!"
            );

            return;
        }

        service.votar(
                usuarioId,
                enqueteId,
                opcaoId
        );

        System.out.println(
                "Voto registrado com sucesso!"
        );
    }
}
