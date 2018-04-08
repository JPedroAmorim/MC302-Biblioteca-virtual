# trabalho1MC302

Trabalho 1 de MC302: Biblioteca Virtual

Nesse trabalho, implementaremos uma biblioteca virtual, onde pessoas podem emprestar ou pegar livros emprestados. Os empréstimos poder ser pagos ou gratuitos. Os clientes podem ser pessoas ou estudantes. No caso de estudantes, é necesário cadastrar a instituição de ensino e obter descontos exclusivos. Instituições podem fazer requisições para seus estudantes ou gerenciar seus empréstimos no acervo próprio para seus alunos.

Classes

## Livro:
#### Atributos
	*codigo;
	*nome;
	*descricao;
	*anoFabricacao;
	*anoValidade;
	*numeroEmprestimos;
#### Construtor
	*
#### Get/Set
	*
#### toString()
	
	 

## PessoaEmpresta
#### Atributos
	id;
	nome;
	idade;
	email;
	status;
	saldoDisponivel;
	livros;
## Cliente
	id;
	nome;
	idade;
	documentoRg;
	email;

	saldoDisponivel;
	historicoLivros;

## ClienteEstudante
	super();
	instituicao;
	codigoTurma;
	codigoInscricao;

## Emprestimo
	idTransacao;
	dataEmprestimo;
	dataDevolucao;
	livro;

## EmprestimoPago
	super();
	valor;

## EmprestimoGratuito
	super();
	instituicao;

## Instituicao

## Requisicao
