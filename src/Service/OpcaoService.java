package Service;

import DAO.OpcaoDAO;
import model.OpcaoVoto;

public class OpcaoService {
    private OpcaoDAO opcaoDAO =
            new OpcaoDAO();

    public void criar(
            String descricao,
            int enqueteId
    ) {

        OpcaoVoto opcao =
                new OpcaoVoto(
                        0,
                        descricao,
                        enqueteId
                );

        opcaoDAO.inserir(opcao);
    }

    public void listar() {
        opcaoDAO.listar();
    }

    public OpcaoVoto buscarPorId(int id) {
        return opcaoDAO.buscarPorId(id);
    }

    public void atualizar(OpcaoVoto opcao) {
        opcaoDAO.atualizar(opcao);
    }

    public void excluir(int id) {
        opcaoDAO.excluir(id);
    }
}
