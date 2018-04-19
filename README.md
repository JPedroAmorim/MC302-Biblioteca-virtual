# trabalho1MC302

Trabalho 1 de MC302: Biblioteca Virtual

Nesse trabalho, implementaremos uma biblioteca virtual, onde pessoas podem emprestar ou pegar livros emprestados. Os empréstimos poder ser pagos ou gratuitos. Os clientes podem ser pessoas ou estudantes. No caso de estudantes, é necesário cadastrar a instituição de ensino e obter descontos exclusivos. Instituições podem fazer requisições para seus estudantes ou gerenciar seus empréstimos no acervo próprio para seus alunos.


Classes

## Livro:
### Atributos
	*id: int
	*geradorId: static int
	*nome: String
	*autor: String
	*genero: String
	*edicao: String
	*ano: int
	*quantLivros: int
	*livrosDisponiveis: int

	
### Metodos:
	*disponibilidade(int id): boolean


#### Construtor
	*
#### Get/Set
	*
#### toString()
	
	 

## Usuario
### Atributos
<<<<<<< HEAD
	id: static int
	nome: String
	idade: int
	email: String
#### Metodos

## Biblioteca
	usuarios: ArrayList<PessoaEstudante>
	admins: Arraylist<PessoaAdmin>
	acervo: ArrayList<Livros>
=======
	*id: int
	*geradorId: static int
	*nome: String
	*dataNasc: String
	*email: String
	*status: boolean
	*livrosEmprestados: ArrayList<Livro> 
>>>>>>> 173bba521de2ef9490c5fd31ed4403bcf81cce3f

## UsuarioEstudante
	super()
	instituicao;
	RA;
	
### Metodos

## UsuarioAdmin
### Atributos
	super()
	chaveAcesso: 
### Metodos
	cadastrarLivro(Livro livro);
	adicionarCliente(PessoaEstudante estudante);
	adicionarSaldo(PessoaEstudante estudante, double valor)


## Biblioteca
	*acervo: ArrayList<Livro> 
	*emprestimos: ArrayList<Emprestimo> 
	*usuario: ArrayList<Usuario> 
### Metodos


## Emprestimo
	*idEmprestimo: int 
	*idUsuario: int
	*idLivro;
	*dataEmprestimo: String
	*dataDevolucao: String
	*valor: float

### Metodo:
	atualizaSaldo();


## Gerenciador  

### Metodos:
    geradorUsuario();
    checaUsuario();
    opcoesUsuario();
    opcoesUsuarioEstudante();
    novoEmprestimo();
    addAmigo();
    infoUsuario();
    alteraDados();
    finalizaEmprestimo();

## Enum

```j
enum{
	BIOLOGIA (45)
	MATEMATICA (467)
	PORTUGUES (12)
	FISICA (90)
	QUIMICA (45)
	GEOGRAFIA (65)
	HISTORIA (90)

	public enum(float valor){
		this.valor = valor;
	}
}
```
<<<<<<< HEAD

usuario 
=======
>>>>>>> 173bba521de2ef9490c5fd31ed4403bcf81cce3f
