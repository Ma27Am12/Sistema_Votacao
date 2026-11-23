package Service;

import DAO.EnqueteDAO;
import model.Enquete;

public class EnqueteService {
    private EnqueteDAO enqueteDAO =
            new EnqueteDAO();

    public void criar(
            String titulo,
            String descricao,
            int criadorId
    ) {

        Enquete enquete =
                new Enquete(
                        0,
                        titulo,
                        descricao,
                        criadorId
                );

        enqueteDAO.inserir(enquete);
    }

    public void listar() {
        enqueteDAO.listar();
    }

    public Enquete buscarPorId(int id) {
        return enqueteDAO.buscarPorId(id);
    }

    public void atualizar(Enquete enquete) {
        enqueteDAO.atualizar(enquete);
    }

    public void excluir(int id) {
        enqueteDAO.excluir(id);
    }
}
