package app;

import DAO.Conexao;
import DAO.UsuarioDAO;
import DAO.EnqueteDAO;
import model.Usuario;
import DAO.OpcaoDAO;
import model.OpcaoVoto;
import model.Enquete;
import DAO.VotoDAO;
import model.Voto;

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

        /*UsuarioDAO dao = new UsuarioDAO();

        // CREATE
        Usuario usuario = new Usuario(
                0,
                "Carlos",
                "carlos2@email.com",
                "123456"
        );

        dao.inserir(usuario);

        // READ
        System.out.println("\n=== LISTA DE USUÁRIOS ===");
        dao.listar();

        // Como o usuário criado apareceu com ID 2 no teste,
        // vamos buscar esse ID.
        Usuario usuarioBanco = dao.buscarPorId(3);

        /*if (usuarioBanco != null) {

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
        }*/

        // ENQUETE

        EnqueteDAO dao = new EnqueteDAO();

        // INSERIR

        /*EnqueteDAO enqueteDAO = new EnqueteDAO();

        Enquete enquete = new Enquete(
                0,
                "Melhor linguagem de programação",
                "Vote na sua linguagem favorita",
                4
        );

        enqueteDAO.inserir(enquete);*/

        // READ
        System.out.println("\n=== LISTA DE ENQUETES ===");
        dao.listar();

        // BUSCAR
        Enquete enqueteBanco = dao.buscarPorId(1);

        /*if (enqueteBanco != null) {

            System.out.println("\n=== ENQUETE ENCONTRADA ===");
            System.out.println(enqueteBanco);

            // UPDATE
            enqueteBanco.setTitulo(
                    "Melhor linguagem para Backend"
            );

            dao.atualizar(enqueteBanco);

            System.out.println("\n=== ENQUETE ATUALIZADA ===");
            System.out.println(
                    dao.buscarPorId(1)
            );

            // DELETE
            dao.excluir(1);

            System.out.println("\n=== APÓS EXCLUSÃO ===");
            dao.listar();

        } else {

            System.out.println(
                    "Enquete não encontrada!"
            );
        }*/

        OpcaoDAO Odao = new OpcaoDAO();

        // CREATE
        /*OpcaoVoto opcao = new OpcaoVoto(
                0,
                "Java",
                2
        );

        Odao.inserir(opcao);*/

        // READ
        System.out.println("\n=== LISTA DE OPÇÕES ===");
        dao.listar();

        // BUSCAR
        OpcaoVoto opcaoBanco = Odao.buscarPorId(1);

        /*if (opcaoBanco != null) {

            System.out.println("\n=== OPÇÃO ENCONTRADA ===");
            System.out.println(opcaoBanco);

            // UPDATE
            opcaoBanco.setDescricao("Java SE");

            Odao.atualizar(opcaoBanco);

            System.out.println("\n=== OPÇÃO ATUALIZADA ===");
            System.out.println(
                    Odao.buscarPorId(1)
            );

            // DELETE
            Odao.excluir(1);

            System.out.println("\n=== APÓS EXCLUSÃO ===");
            Odao.listar();

        } else {

            System.out.println("Opção não encontrada!");
        }*/

        VotoDAO vdao = new VotoDAO();

// CREATE
        Voto voto = new Voto(
                0,
                2,
                1,
                1
        );

        vdao.inserir(voto);

// READ
        System.out.println("\n=== LISTA DE VOTOS ===");
        dao.listar();

// BUSCAR
        Voto votoBanco = vdao.buscarPorId(1);

        /*if(votoBanco != null) {

            System.out.println("\n=== VOTO ENCONTRADO ===");
            System.out.println(votoBanco);

            // DELETE
            vdao.excluir(votoBanco.getId());

            System.out.println("\n=== APÓS EXCLUSÃO ===");
            vdao.listar();

        } else {

            System.out.println("Voto não encontrado!");

        }*/
    }
}