package DAO;

import model.OpcaoVoto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OpcaoDAO {

    public void inserir(OpcaoVoto opcao) {

        String sql = "INSERT INTO opcoes(descricao, enquete_id) VALUES(?, ?)";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, opcao.getDescricao());
            stmt.setInt(2, opcao.getEnqueteId());

            stmt.executeUpdate();

            System.out.println("Opção cadastrada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void listar() {

        String sql = "SELECT * FROM opcoes";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("descricao") + " - " +
                                rs.getInt("enquete_id")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public OpcaoVoto buscarPorId(int id) {

        String sql = "SELECT * FROM opcoes WHERE id = ?";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {

                return new OpcaoVoto(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getInt("enquete_id")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void atualizar(OpcaoVoto opcao) {

        String sql = "UPDATE opcoes SET descricao=?, enquete_id=? WHERE id=?";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, opcao.getDescricao());
            stmt.setInt(2, opcao.getEnqueteId());
            stmt.setInt(3, opcao.getId());

            stmt.executeUpdate();

            System.out.println("Opção atualizada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM opcoes WHERE id=?";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Opção removida!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
