package DAO;

import model.Voto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VotoDAO {

    public void inserir(Voto voto) {

        String sql = "INSERT INTO voto(usuario_id, enquete_id, opcao_id) VALUES(?,?,?)";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, voto.getUsuarioId());
            stmt.setInt(2, voto.getEnqueteId());
            stmt.setInt(3, voto.getOpcaoId());

            stmt.executeUpdate();

            System.out.println("Voto registrado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {

        String sql = "SELECT * FROM voto";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getInt("usuario_id") + " - " +
                                rs.getInt("enquete_id") + " - " +
                                rs.getInt("opcao_id")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Voto buscarPorId(int id) {

        String sql = "SELECT * FROM voto WHERE id = ?";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Voto(
                        rs.getInt("id"),
                        rs.getInt("usuario_id"),
                        rs.getInt("enquete_id"),
                        rs.getInt("opcao_id")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void excluir(int id) {

        String sql =
                "DELETE FROM voto WHERE id=?";

        try {

            Connection conn =
                    Conexao.getInstance().getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Voto removido!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
