package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Conexao instance;
    private Connection connection;

    private Conexao() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:votacaodb.sqlite");
    }

    public static Conexao getInstance() throws SQLException{
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
