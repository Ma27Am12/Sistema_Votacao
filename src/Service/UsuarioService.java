package Service;

import DAO.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
    private UsuarioDAO usuarioDAO =
            new UsuarioDAO();

    public void cadastrar(
            String nome,
            String email,
            String senha
    ) {

        Usuario usuario =
                new Usuario(
                        0,
                        nome,
                        email,
                        senha
                );

        usuarioDAO.inserir(usuario);
    }

    public void listar() {
        usuarioDAO.listar();
    }

    public Usuario buscarPorId(int id) {
        return usuarioDAO.buscarPorId(id);
    }

    public void atualizar(Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    public void excluir(int id) {
        usuarioDAO.excluir(id);
    }

    public Usuario login(
            String email,
            String senha
    ) {

        return usuarioDAO.login(
                email,
                senha
        );
    }
}
