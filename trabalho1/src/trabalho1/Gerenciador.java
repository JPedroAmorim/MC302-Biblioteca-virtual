package trabalho1;

/*
    Classe Gerenciador: Funciona como uma espécie de "cerne" do sistema. É responsável por métodos estáticos de criação de usuários (geradorUsuario),
    verificação de elementos no sistema (métodos checaXXXX), login e tratamento de exceções. Além disso, é a classe do método opcoesUsuario, que é
    reponsável por ditar o fluxo de execução do sistema a partir dos dados obtidos pela entrada padrão.

 */

public class Gerenciador {

    // Metodo geradorUsuario: Gera um um objeto Usuario ou UsuarioEstudante com os dados fornecidos pela entrada.
    public static void geradorUsuario(String nome, String senha, String email, String data, String instituicao, int ra, boolean estudante) {   
        if (estudante) {
            UsuarioEstudante novoUsuarioEstudante = new UsuarioEstudante(nome, senha, data, email, true,
                    instituicao, ra);
        } else {
            UsuarioComum novoUsuario = new UsuarioComum(nome, senha, data, email, true);
        }
    }

    /* Mtodo checaUsuario: Retorna o pindice de um usurio caso ele exista (nome consta na AL usuarios da Biblioteca).
    Caso contrário, retorna -1.*/
    public static int checaUsuario(String nome) throws SistemaExcecao {
        for (int i = 0; i < Biblioteca.usuarios.size(); i++) {
            if ((Biblioteca.usuarios.get(i)).getNome().equals(nome))
            	return i;
        }

        throw new SistemaExcecao("Usuário não existe!");
    }

    /* Método trataExececao: Retorna true se o usuário, durante a execução do método adicionarAmigo,
     tentar se adicionar ou adicionar um usuário que já está em sua lista de amigos.*/
    public static void checaExcecao(Usuario usuarioAtual, Usuario usuarioAlvo) throws SistemaExcecao {
        for (int i = 0; i < usuarioAtual.getAmigos().size(); i++) {
            if (usuarioAtual.getAmigos().get(i).getNome().equals(usuarioAlvo.getNome())) {
            	throw new SistemaExcecao("Você já possui esse usuário em sua lista de amigos!");
            }
        }
        
        if (usuarioAtual.getNome().equals(usuarioAlvo.getNome())) {
        	throw new SistemaExcecao("Você não pode se adicionar em sua lista de amigos!");
        }
    }

    /*Método login: Retorna o índice do usuário na AL usuarios da Biblioteca caso encontrado
     (nome e senha batem com os dados na AL), e -1 caso contrário.*/
    public static int login(String nome, String senha) throws SistemaExcecao {
    	
        for (int i = 0; i < Biblioteca.usuarios.size(); i++) {
            if (Biblioteca.usuarios.get(i).getNome().equals(nome) && Biblioteca.usuarios.get(i).getSenha().equals(senha))
                return i;
        }
        throw new SistemaExcecao("Usuário ou senha incorretos!");
    }

    /* Método pagamentoVálido: "Checa" se as informações de pagamento dadas são válidas. Se houver
     16 caracteres na string (como em um número de cartão da vida real), retorna true.*/
    public static void pagamentoValido(String infoPagamento) throws SistemaExcecao {
        if(!(infoPagamento.length() == 2)) throw new SistemaExcecao("Cartão de crédito inválido! Por favor, insira um método de pagamento válido");
    }

    /* Método checaCupom: Verifica se o código de Cupom dado pelo usuário é um código válido
     - isto é, existe um cupom com esse código e ele não foi utilizado.
     Retorna o índice do cupom na AL cupons da Biblioteca caso o cupom seja válido e -1 caso contrário.*/
    public static int checaCupom(String codigo) throws SistemaExcecao {
        for (int i = 0; i < Biblioteca.cupons.size(); i++) {
            if (Biblioteca.cupons.get(i).getCodigo().equals(codigo)) {
                if (!Biblioteca.cupons.get(i).getFoiUsado()) {
                    return i;
                } else {
                    throw new SistemaExcecao("Cupom já utilizado!");
                }
            }
        }
       throw new SistemaExcecao("Código de cupom inválido (não existe)!");
    }

    /* Método opcoesUsuario: Recebe do usuário um inteiro pela entrada padrão e realiza a opção ligada à
     esse inteiro. Enquanto não retorna false, ele continua a ser executado pela main em loop.*/
    public static boolean opcoesUsuario(Usuario usuarioAtual) throws SistemaExcecao {

        System.out.print("\n");
        System.out.println("Olá " + usuarioAtual.getNome() + " !");
        System.out.print("\n");
        System.out.println(" ***** Digite a tecla para executar a opção desejada... ***** ");
        System.out.print("\n");

        if (usuarioAtual instanceof UsuarioAdmin) { // Verifica se o usuarioAtual é um UsuarioAdmin e oferece as opções disponíveis à esse tipo de Usuario.

            System.out.println("0 - Listar conteúdo do sistema");
            System.out.println("1 - Cadastrar cupom de desconto");
            System.out.println("2 - Cadastrar um livro");
            System.out.println("3 - Banir um usuário");
            System.out.println("4 - Sair da Biblioteca Virtual");

            int opcaoAdmin = 0;
          
            if (opcaoAdmin == 0) {
                ((UsuarioAdmin) usuarioAtual).listaDados();
                return true;
            } else if (opcaoAdmin == 1) {
            	/*try {
            		((UsuarioAdmin) usuarioAtual).cadastrarCupom();
            		return true;
            	}catch(SistemaExcecao e) {
            		System.out.println(e.getMessage());
            		return true;
            	}*/
            } else if (opcaoAdmin == 2) {
                 //((UsuarioAdmin) usuarioAtual).cadastrarLivro();
                return true;
            } else if (opcaoAdmin == 3) {
            	try {
            	    String nome = "MUDAR AQUI";
            		((UsuarioAdmin) usuarioAtual).banirUsuario(nome);
            		return true;
            	}catch(SistemaExcecao e) {
            		System.out.println(e.getMessage());
            		return true;
            	}
            } else if (opcaoAdmin == 4) {
                return false;
            } else {
                System.out.println("Por favor, digite uma opção válida!");
                return true;
            }
        }

        // Opções de 0 à 9 são comuns para UsuarioComum e UsuarioEstudante.

        System.out.println("0 - Cadastrar um livro em seu acervo pessoal");
        System.out.println("1 - Realizar um empréstimo com a Biblioteca Virtual");
        System.out.println("2 - Realizar um empréstimo com um usuário da Biblioteca Virtual");
        System.out.println("3 - Adicionar um amigo");
        System.out.println("4 - Buscar informações de um usuário");
        System.out.println("5 - Alterar seus dados");
        System.out.println("6 - Adicionar saldo");
        System.out.println("7 - Ver suas informações");
        System.out.println("8 - Enviar uma mensagem a um usuário");
        System.out.println("9 - Ver suas mensagens recebidas");

        if (usuarioAtual instanceof UsuarioEstudante) { // Verifica se o usuarioAtual é um UsuarioEstudante e exibe as opções exclusivas à esse tipo de Usuario.
            System.out.println("10 - Realizar empréstimo com cupom de desconto (exclusivo para usuários estudantes)");
            System.out.println("11 - Mostrar usuários da mesma universidade");
            System.out.println("12 - Desconectar da Biblioteca Virtual");
        } else
            System.out.println("10 - Desconectar da Biblioteca Virtual");


        int opcao = 0;

        if (opcao == 0) {
            //usuarioAtual.cadastrarLivro();
            return true;

        } else if (opcao == 1) {
        		//usuarioAtual.novoEmprestimo(null, null);
        		return true;
        } else if (opcao == 2) {
            System.out.println("Digite o nome do usuário com quem você quer fazer um empréstimo ");

            String nome = "MUDAR AQUI";
            int resultado = checaUsuario(nome);
            if (resultado != -1) { // Resultado != -1 -> Usuário existe.
                //usuarioAtual.novoEmprestimo(Biblioteca.usuarios.get(resultado), null);
            }else { // Resultado == -1 -> Usuário não existe.
                System.out.println("Usuário não existe");
            }
            return true;

        } else if (opcao == 3) {
        	/*try {
        		//usuarioAtual.adicionarAmigo();
        		return true;
        	}catch(SistemaExcecao e) {
        		System.out.println(e.getMessage());
        		return true;
        	}*/

        } else if (opcao == 4) {
        	try {
        		usuarioAtual.infoUsuario();
        		return true;
        	}catch(SistemaExcecao e) {
        		System.out.println(e.getMessage());
        		return true;
        	}

        } else if (opcao == 5) {
            //usuarioAtual.alteraDados();
            return true;

        } else if (opcao == 6) {
        	/*try {
        		    usuarioAtual.adicionarSaldo();
            	return true;
        	}catch(SistemaExcecao e) {
        		System.out.println(e.getMessage());
        		return true;
        	}*/

        } else if (opcao == 7) {
            System.out.println("**** Suas informações ****");
            System.out.println(usuarioAtual);
            return true;

        } else if (opcao == 8) {
            //usuarioAtual.enviarMensagem();
            return true;

        } else if (opcao == 9) {
            //usuarioAtual.verMensagens();
            return true;

        } else if (!(usuarioAtual instanceof UsuarioEstudante) && opcao == 10) { // Verifica se usuarioAtual é uma instância apenas de usuário.
            return false;

        } else if (usuarioAtual instanceof UsuarioEstudante && opcao == 10) {
            System.out.println("Por favor, digite o código do seu cupom");
            int resultadoCupom = checaCupom("MUDAR AQUI");

            if (resultadoCupom != -1) { // resultadoCupom != -1 -> Cupom existe e é válido.

                System.out.println("Digite a opção que você deseja: ");
                System.out.println("1 - Utilizar o cupom de desconto em um empréstimo com a Biblioteca Virtual");
                System.out.println("2 - Utilizar o cupom de desconto em um empréstimo com um Usuário");

                int opcao1 = 1;

                if (opcao1 == 1) {
                    //  usuarioAtual.novoEmprestimo(null, Biblioteca.cupons.get(resultadoCupom));
                } else if (opcao1 == 2) {
                    System.out.println("Digite o nome do usuário com quem você quer fazer um empréstimo ");
                    String nome = "MUDAR AQUI";
                    int resultado = checaUsuario(nome);
                    if (resultado != -1) { // resultado != -1 -> Usuário existe.
                        // usuarioAtual.novoEmprestimo(Biblioteca.usuarios.get(resultado), Biblioteca.cupons.get(resultadoCupom));
                    } else {
                        System.out.println("Usuário não existe");
                    }
                } else {
                	 System.out.println("Por favor, digite uma opção válida");
                }
            }

            return true;

        } else if (usuarioAtual instanceof UsuarioEstudante && opcao == 11) {
        	try {
        		((UsuarioEstudante) usuarioAtual).buscaUsuarioUniversidade();
        		return true;
        	}catch(SistemaExcecao e) {
        		System.out.println(e.getMessage());
        		return true;
        	}
        } else if (usuarioAtual instanceof UsuarioEstudante && opcao == 12) 
            return false;
        else {
        	System.out.println("Por favor, escolha uma opção válida");
        	return true;
        }
        return true;
    }
}