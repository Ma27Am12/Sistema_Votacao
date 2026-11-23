package View;

import Service.UsuarioService;
import Service.EnqueteService;
import Service.OpcaoService;
import Service.VotacaoService;
import Service.VotacaoProxy;
import model.Usuario;
import model.Enquete;
import model.OpcaoVoto;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    private UsuarioService usuarioService =
            new UsuarioService();
    private Usuario usuarioLogado;

    private EnqueteService enqueteService =
            new EnqueteService();

    private OpcaoService opcaoService =
            new OpcaoService();

    private VotacaoService votacao =
            new VotacaoProxy();

    private void menuUsuarios() {

        int opcao;

        do {

            System.out.println("\n===== USUÁRIOS =====");

            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar");
            System.out.println("5- Login");
            System.out.println("6- Logout");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    usuarioService.cadastrar(
                            nome,
                            email,
                            senha
                    );

                    break;

                case 2:
                    System.out.print("ID do usuário: ");

                    int id =
                            scanner.nextInt();

                    scanner.nextLine();

                    Usuario usuario =
                            usuarioService.buscarPorId(id);

                    if (usuario != null) {

                        System.out.print("Novo nome: ");

                        usuario.setNome(
                                scanner.nextLine()
                        );

                        System.out.print("Novo email: ");
                        usuario.setEmail(scanner.nextLine());

                        System.out.print("Nova senha: ");
                        usuario.setSenha(scanner.nextLine());

                        usuarioService.atualizar(
                                usuario
                        );

                    } else {

                        System.out.println(
                                "Usuário não encontrado!"
                        );
                    }

                    break;

                case 3:
                    System.out.print("ID do usuário: ");

                    int idExcluir =
                            scanner.nextInt();

                    usuarioService.excluir(
                            idExcluir
                    );

                    break;

                case 4:
                    usuarioService.listar();

                    break;

                case 5:

                    scanner.nextLine();

                    System.out.print("Email: ");
                    String emailLogin =
                            scanner.nextLine();

                    System.out.print("Senha: ");
                    String senhaLogin =
                            scanner.nextLine();

                    usuarioLogado =
                            usuarioService.login(
                                    emailLogin,
                                    senhaLogin
                            );

                    if(usuarioLogado != null){

                        System.out.println(
                                "Login realizado!"
                        );

                        System.out.println(
                                "Bem-vindo "
                                        + usuarioLogado.getNome()
                        );

                    }else{

                        System.out.println(
                                "E-mail ou senha inválidos!"
                        );
                    }

                    break;

                case 6:

                    usuarioLogado = null;

                    System.out.println(
                            "Logout realizado!"
                    );

                    break;
            }

        } while (opcao != 0);
    }

    private void menuEnquetes() {

        int opcao;

        do {

            System.out.println("\n===== ENQUETES =====");

            System.out.println("1 - Criar enquete");
            System.out.println("2 - Editar enquete");
            System.out.println("3 - Excluir enquete");
            System.out.println("4 - Listar enquetes");
            System.out.println("5 - Adicionar opção");
            System.out.println("6 - Editar opção");
            System.out.println("7- Excluir opção");
            System.out.println("8- Listar Opções");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();

                    System.out.print("Título: ");
                    String titulo =
                            scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao =
                            scanner.nextLine();

                    if(usuarioLogado == null){

                        System.out.println(
                                "Faça login primeiro!"
                        );

                        break;
                    }

                    enqueteService.criar(
                            titulo,
                            descricao,
                            usuarioLogado.getId()
                    );

                    break;

                case 2:

                    if(usuarioLogado == null){

                        System.out.println(
                                "Faça login primeiro!"
                        );

                        break;
                    }

                    System.out.print("ID da enquete: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();

                    Enquete enquete =
                            enqueteService.buscarPorId(idEditar);

                    if(enquete == null){

                        System.out.println(
                                "Enquete não encontrada!"
                        );

                        break;
                    }

                    if(enquete.getCriadorId()
                            != usuarioLogado.getId()){

                        System.out.println(
                                "Você não é o criador desta enquete!"
                        );

                        break;
                    }

                    System.out.print("Novo título: ");
                    enquete.setTitulo(
                            scanner.nextLine()
                    );

                    System.out.print("Nova descrição: ");
                    enquete.setDescricao(
                            scanner.nextLine()
                    );

                    enqueteService.atualizar(
                            enquete
                    );

                    break;

                case 3:

                    if(usuarioLogado == null){

                        System.out.println(
                                "Faça login primeiro!"
                        );

                        break;
                    }

                    System.out.print("ID da enquete: ");
                    int idExcluir = scanner.nextInt();

                    Enquete enqueteExcluir =
                            enqueteService.buscarPorId(idExcluir);

                    if(enqueteExcluir == null){

                        System.out.println(
                                "Enquete não encontrada!"
                        );

                        break;
                    }

                    if(enqueteExcluir.getCriadorId()
                            != usuarioLogado.getId()){

                        System.out.println(
                                "Você não é o criador desta enquete!"
                        );

                        break;
                    }

                    enqueteService.excluir(idExcluir);

                    break;


                case 4:

                    enqueteService.listar();

                    break;

                case 5:

                    if(usuarioLogado == null){

                        System.out.println(
                                "Faça login primeiro!"
                        );

                        break;
                    }

                    scanner.nextLine();

                    System.out.print(
                            "Descrição da opção: "
                    );

                    String descricaoOpcao =
                            scanner.nextLine();

                    System.out.print(
                            "ID da enquete: "
                    );

                    int enqueteId =
                            scanner.nextInt();

                    opcaoService.criar(
                            descricaoOpcao,
                            enqueteId
                    );

                    break;

                case 6:

                    if(usuarioLogado == null){

                        System.out.println(
                                "Faça login primeiro!"
                        );

                        break;
                    }

                    System.out.print("ID da opção: ");
                    int idOpcaoEditar = scanner.nextInt();
                    scanner.nextLine();

                    OpcaoVoto opcaoEditar =
                            opcaoService.buscarPorId(idOpcaoEditar);

                    if (opcaoEditar != null) {

                        System.out.print("Nova descrição: ");
                        opcaoEditar.setDescricao(
                                scanner.nextLine()
                        );

                        opcaoService.atualizar(
                                opcaoEditar
                        );

                    } else {

                        System.out.println(
                                "Opção não encontrada!"
                        );
                    }

                    break;

                case 7:

                    if(usuarioLogado == null){

                        System.out.println(
                                "Faça login primeiro!"
                        );

                        break;
                    }

                    System.out.print("ID da opção: ");
                    int idOpcaoExcluir =
                            scanner.nextInt();

                    opcaoService.excluir(
                            idOpcaoExcluir
                    );

                    break;

                case 8:

                    opcaoService.listar();

                    break;

                case 0:

                    System.out.println(
                            "Voltando..."
                    );

                    break;

                default:

                    System.out.println(
                            "Opção inválida!"
                    );
            }

        } while (opcao != 0);
    }

    private void menuVotacao() {

        int opcao;

        do {

            System.out.println("\n===== VOTAÇÃO =====");

            System.out.println("1 - Votar");
            System.out.println("2 - Exibir resultados");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {

                case 1: {

                    if(usuarioLogado == null){

                        System.out.println(
                                "Faça login primeiro!"
                        );

                        break;
                    }

                    System.out.print("ID da enquete: ");
                    int enqueteId = scanner.nextInt();

                    System.out.print("ID da opção: ");
                    int opcaoId = scanner.nextInt();

                    scanner.nextLine();

                    votacao.votar(
                            usuarioLogado.getId(),
                            enqueteId,
                            opcaoId
                    );

                    break;
                }

                case 2: {

                    System.out.print(
                            "ID da enquete: "
                    );

                    int enqueteId = scanner.nextInt();

                    scanner.nextLine();

                    votacao.exibirResultados(
                            enqueteId
                    );

                    break;
                }

                case 0:

                    System.out.println("Voltando...");

                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }



    public void iniciar() {

        int opcao;

        do {

            System.out.println("\n===== SISTEMA DE VOTAÇÃO =====");

            if(usuarioLogado != null){

                System.out.println(
                        "Usuário logado: "
                                + usuarioLogado.getNome()
                );
            }

            System.out.println("1 - Usuários");
            System.out.println("2 - Enquetes");
            System.out.println("3 - Votação");
            System.out.println("0 - Sair");

            System.out.println("Digite sua Opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    menuUsuarios();
                    break;

                case 2:
                    menuEnquetes();
                    break;

                case 3:
                    menuVotacao();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}
