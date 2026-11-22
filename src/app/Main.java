package app;

import DAO.Conexao;
import Service.VotacaoProxy;
import Service.VotacaoService;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        try {

            Connection conn =
                    Conexao.getInstance()
                            .getConnection();

            System.out.println("Conectado ao SQLite!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        VotacaoService votacao =
                new VotacaoProxy();

        System.out.println("\n================================");
        System.out.println("TESTE OBSERVER + PROXY");
        System.out.println("================================");

        System.out.println("\nPrimeiro voto:");

        votacao.votar(
                1, // usuarioId
                1, // enqueteId
                1  // opcaoId
        );

        System.out.println("\nTentativa de voto duplicado:");

        votacao.votar(
                1, // mesmo usuário
                1, // mesma enquete
                2  // outra opção
        );

        System.out.println("\nFim dos testes.");
    }
}