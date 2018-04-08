# trabalho1MC302

Trabalho 1 de MC302: Biblioteca Virtual

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
