package DAO;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
