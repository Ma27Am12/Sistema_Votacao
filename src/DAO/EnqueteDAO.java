package DAO;

import model.Enquete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EnqueteDAO {

    public void inserir(Enquete enquete) {
        String sql = "INSERT INTO enquetes(titulo, descricao, criador_id) VALUES(?, ?, ?)";

        try {
            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, enquete.getTitulo());
            stmt.setString(2, enquete.getDescricao());
            stmt.setInt(3, enquete.getCriadorId());

            stmt.executeUpdate();

            System.out.println("Enquete cadastrada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        String sql = "SELECT * FROM enquetes";

        try {
            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-" + rs.getString("titulo") +
                        "-" + rs.getString("descricao")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Enquete buscarPorId(int id) {
        String sql = "SELECT * FROM enquetes WHERE id=?";

        try {
            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new Enquete(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getInt("criador_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizar(Enquete enquete) {

        String sql = "UPDATE enquetes SET titulo=?, descricao=?, criador_id=? WHERE id=?";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, enquete.getTitulo());
            stmt.setString(2, enquete.getDescricao());
            stmt.setInt(3, enquete.getCriadorId());
            stmt.setInt(4, enquete.getId());

            stmt.executeUpdate();

            System.out.println("Enquete atualizada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM enquetes WHERE id=?";

        try {

            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Enquete removida!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
