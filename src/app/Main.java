import DAO.Conexao;

import java.sql.Connection;
import model.Usuario;
import DAO.UsuarioDAO;
public class Main {

    public static void main(String[] args) {

        try {
            Connection conn =
                    Conexao
                            .getInstance()
                            .getConnection();

            System.out.println("Conectado ao SQLite!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Usuario usuario =
                new Usuario(0,
                        "João",
                        "João@email.com");

        UsuarioDAO dao = new UsuarioDAO();

        dao.inserir(usuario);
    }
}
