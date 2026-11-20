package app;

import DAO.Conexao;
import DAO.UsuarioDAO;
import model.Usuario;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        try {
            Connection conn = Conexao
                    .getInstance()
                    .getConnection();

            System.out.println("Conectado ao SQLite!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        UsuarioDAO dao = new UsuarioDAO();

        // CREATE
        /*Usuario usuario = new Usuario(
                0,
                "Carlos",
                "carlos2@email.com",
                "123456"
        );

        dao.inserir(usuario);*/

        // READ
        System.out.println("\n=== LISTA DE USUÁRIOS ===");
        dao.listar();

        // Como o usuário criado apareceu com ID 2 no teste,
        // vamos buscar esse ID.
        Usuario usuarioBanco = dao.buscarPorId(3);

        if (usuarioBanco != null) {

            // UPDATE
            usuarioBanco.setNome("Carlos Atualizado");

            dao.atualizar(usuarioBanco);

            System.out.println("\n=== USUÁRIO ATUALIZADO ===");
            System.out.println(
                    dao.buscarPorId(3)
            );

            // DELETE
            dao.excluir(3);

            System.out.println("\n=== APÓS EXCLUSÃO ===");
            dao.listar();

        } else {

            System.out.println("Usuário não encontrado!");
        }
    }
}