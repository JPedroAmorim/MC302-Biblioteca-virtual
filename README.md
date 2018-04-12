# trabalho1MC302

Trabalho 1 de MC302: Biblioteca Virtual

Nesse trabalho, implementaremos uma biblioteca virtual, onde pessoas podem emprestar ou pegar livros emprestados. Os empréstimos poder ser pagos ou gratuitos. Os clientes podem ser pessoas ou estudantes. No caso de estudantes, é necesário cadastrar a instituição de ensino e obter descontos exclusivos. Instituições podem fazer requisições para seus estudantes ou gerenciar seus empréstimos no acervo próprio para seus alunos.

Classes

## Livro:
### Atributos
	*codigoLivro: String
	*nome: String
	*autor: String
	*descricao: String
	*ano: int
	*numeroEmprestimos: static int
	*genero: GeneroLivro(enum)
	*numLivros: int
### Metodos:
	*verificarDisponibilidade();


#### Construtor
	*
#### Get/Set
	*
#### toString()
	
	 

## Usuario
### Atributos
	id: static int
	nome: String
	idade: int
	email: String
#### Metodos

## Biblioteca
	clientes: ArrayList<PessoaEstudante>
	admins: Arraylist<PessoaAdmin>
	acervo: ArrayList<Livros>

## PessoaEstudante
	super()
	instituicao;
	RA;
	historicolivros: ArrayList<Livro>
	saldoDisponivel: float
	status: boolean
### Metodos

	
## PessoaAdmin
### Atributos
	super()
	chaveAcesso: 
### Metodos
	cadastrarLivro(Livro livro);
	adicionarCliente(PessoaEstudante estudante);
	adicionarSaldo(PessoaEstudante estudante, double valor)
	

## Emprestimo
	idTransacao: int 
	idEstudante: int
	dataEmprestimo: String
	dataDevolucao: String
	codigoLivro: int
	valor: 
### Metodo:
	atualizaSaldo();



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