package DAO;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    public void inserir(Usuario usuario) {
        String sql = " INSERT INTO usuarios(nome, email, senha) VALUES(?, ?, ?)";
        try {
            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            stmt.executeUpdate();

            System.out.println("Usuário Cadastrado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        String sql = "SELECT * FROM usuarios";
        try {
            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-" + rs.getString("nome") + "-"
                        + rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try {
            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome=?, email=?, senha=? WHERE id=?";

        try {
            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());

            stmt.executeUpdate();

            System.out.println("Usuário atualizado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";

        try {
            Connection conn = Conexao.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Usuário removido");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
