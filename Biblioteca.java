import java.util.ArrayList;

//essa classe teve o objetivo de implementar o padrao Controlador, em que esta
//classe faz a interface usuario-sistema

public class Biblioteca {
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public ArrayList<Obra> obras = new ArrayList<Obra>();
	public ArrayList<Livro> livros = new ArrayList<Livro>();
	public ArrayList<Periodico> periodicos = new ArrayList<Periodico>();
	public ArrayList<Descricao> descricoes = new ArrayList<Descricao>();
	
	//como nao temos um banco de dados tenho que guardar o id em algum lugar
	int id = 0;
	
	//UTILIZANDO O PADRAO CREATOR
	//criacao de usuarios
	public void newAluno(String nome, String email, int idade) {
		System.out.printf("--> Criando novo aluno: %s\n", nome);
		Aluno aux = new Aluno();
		aux.cadastrarUsuario(nome, email, idade);
		usuarios.add(aux);
	}
	
	public void newProfessor(String nome, String email, int idade) {
		System.out.printf("--> Criando novo professor: %s\n", nome);
		Professor aux = new Professor();
		aux.cadastrarUsuario(nome, email, idade);
		usuarios.add(aux);
	}
	
	public void newGeral(String nome, String email, int idade) {
		System.out.printf("--> Criando novo usuario geral: %s\n", nome);
		Geral aux = new Geral();
		aux.cadastrarUsuario(nome, email, idade);
		usuarios.add(aux);
	}
	
	//criacao de obras
	public void newLivro(String nome, int ano, String autor, String editora) {
		System.out.printf("--> Criando novo livro: %s\n", nome);
		Livro livro = new Livro();
		livro.cadastrarObra(nome, ano, autor, editora, descricoes, id);
		id = id + 1;
		obras.add(livro);
		livros.add(livro);
	}
	
	public void newPeriodico(String nome, int ano, String volume, int mes) {
		System.out.printf("--> Criando novo periodico %s\n", nome);
		Periodico periodico = new Periodico();
		periodico.cadastrarObra(nome, ano, volume, mes, descricoes, id);
		id = id + 1;
		obras.add(periodico);
		periodicos.add(periodico);
	}
	
	//funcoes de imprecao 
	public void imprimeUsuarios() {
		System.out.println("--> Os usuarios atuais sao:");
		for(int i = 0; i < usuarios.size(); i++) {
			System.out.println(usuarios.get(i).nome);
		}	
	}
	
	public void imprimeObras() {
		System.out.println("--> As obras atuais sao:");
		for(int i = 0; i < obras.size(); i++) {
			System.out.printf("id: %d, nome: %s\n", obras.get(i).id, obras.get(i).desc.nome);
		}	
	}
	
	public void imprimeDescricoes() {
		System.out.println("--> As descricoes atuais existentes sao:");
		for(int i = 0; i < descricoes.size(); i++) {
			System.out.printf("nome: %s, ano: %d\n", descricoes.get(i).nome, descricoes.get(i).ano);
		}	
	}
	
	//funcoes relacionadas aos usuarios
	public Usuario procurarUsuario(String email){
		System.out.printf("--> Procurando usuario com email %s\n", email);
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).email == email) {
				System.out.println("Usuario encontrado");
				return usuarios.get(i);
			}
		}
		System.out.println("ERRO: Usuario nao encontrado");
		return null;
	}
	
	public void excluirUsuario(String email) {
		Usuario aux = this.procurarUsuario(email);
		usuarios.remove(aux);
		aux = null;
	}
	
	public void editarUsuario(String nome, String email, int idade) {
		Usuario aux = this.procurarUsuario(email);
		aux.editarUsuario(nome, email, idade);
	}
	
	//funcoes relacionadas as obras
	public void procurarObras(String nome) {
		System.out.printf("--> Procurando por obras com nome: %s\n", nome);
		for(int i = 0; i < obras.size(); i++) {
			if(obras.get(i).desc.nome == nome) {
				System.out.printf("id: %d, emprestada: %d\n", obras.get(i).id, obras.get(i).emprestada);
			}
		}
	}
	
	public int procurarNumObras(String nome) {
		System.out.printf("--> Procurando por numero de obras com nome: %s\n", nome);
		for(int i = 0; i < obras.size(); i++) {
			if(obras.get(i).desc.nome == nome) {
				System.out.printf("O numero de obras com nome %s foi: %d\n", nome, obras.get(i).desc.num_obras);
				return obras.get(i).desc.num_obras;
			}
		}
		System.out.printf("O numero de obras com nome %s foi 0\n", nome);
		return 0;
	}
	
	//procura uma obra por id e a retorna
	public Obra procurarObra(int id) {
		System.out.printf("--> Procurando Obra com id %s\n", id);
		for(int i = 0; i < obras.size(); i++) {
			if(obras.get(i).id == id) {
				System.out.println("Obra encontrada");
				return obras.get(i);
			}
		}
		System.out.println("ERRO: Obra nao encontrada");
		return null;
	}

	//procura um livro por id e a retorna
	public Livro procurarLivro(int id) {
		System.out.printf("--> Procurando livro com id %s\n", id);
		for(int i = 0; i < livros.size(); i++) {
			if(livros.get(i).id == id) {
				System.out.println("Livro encontrado");
				return livros.get(i);
			}
		}
		return null;
	}
	
	//procura um periodico por id e a retorna
	public Periodico procurarPeriodico(int id) {
		System.out.printf("--> Procurando periodico com id %s\n", id);
		for(int i = 0; i < periodicos.size(); i++) {
			if(periodicos.get(i).id == id) {
				System.out.println("Periodico encontrado");
				return periodicos.get(i);
			}
		}
		return null;
	}
		
	public void excluirObra(int id) {
		Obra aux = this.procurarObra(id);
		livros.remove(aux);
		periodicos.remove(aux);
		obras.remove(aux);
		aux = null;
	}
	
	public void editarLivro(int id, String nome, int ano, String autor, String editora) {
		Livro aux = this.procurarLivro(id);
		aux.editar(nome, ano, autor, editora);
	}
	
	public void editarPeriodico(int id, String nome, int ano, String volume, int mes){
		Periodico aux = this.procurarPeriodico(id);
		aux.editar(nome, ano, volume, mes);
	}
	
	public void realizaEmprestimo(String email, int id) {
		Obra obra = this.procurarObra(id);
		if(obra != null){
			Usuario aux = this.procurarUsuario(email);
			if(aux != null){
				aux.novoEmprestimo(obra);
				System.out.printf("--> Emprestimo da obra: '%s' para o usuario de email: %s realizado com sucesso!\n", obra.desc.nome, email);
			}
		}
	}
	
	public void finalizaEmprestimo(String email, int id) {
		int multa = this.procurarUsuario(email).checaEmprestimo(id);
		Usuario aux = this.procurarUsuario(email);
		if(aux != null){
			if(multa > 0){
				System.out.printf("--> Voce nao pode finalizar o emprestimo, pois tem uma multa de: %d. Pague primeiro.\n", multa);
			}
			else if(multa == 0) {
				System.out.println("--> Emprestimo devolvido com sucesso !");
			}
		}
	}
	
	public void pagaMulta(String email, int id, int valor) {
		System.out.println("--> Pagando a multa...");
		this.procurarUsuario(email).pagar(id, valor);
	}
	
}
