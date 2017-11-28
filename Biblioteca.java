import java.util.ArrayList;

//essa classe teve o objetivo de implementar o padrao Controlador, em que esta
//classe faz a interface usuario-sistema

public class Biblioteca {
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
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
	
	//funcoes de imprecao 
	public void imprimeUsuarios() {
		System.out.println("--> Os usuarios atuais sao:");
		for(int i = 0; i < usuarios.size(); i++) {
			System.out.println(usuarios.get(i).nome);
		}	
	}
	
	//funcoes relacionadas aos usuarios
	public Usuario procurarUsuario(String email){
		System.out.printf("--> Procurando usuario com email %s\n", email);
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).email.equals(email)) {
				System.out.println("Usuario encontrado");
				return usuarios.get(i);
			}
		}
		System.out.println("ERRO: Usuario nao encontrado");
		return null;
	}
	
	public void excluirUsuario(String email) {
		Usuario aux = this.procurarUsuario(email);
		System.out.println("Checando se usuario nao tem emprestimos..");
		if(aux.checaEmprestimos() == true){
			System.out.println("OK: Usuario removido com sucesso");
			usuarios.remove(aux);
			aux = null;
		}
		else{
			System.out.println("ERRO: Usuario ainda tem emprestimos, devolver primeiro");
		}
	}
	
	public void editarUsuario(String nome, String email, int idade, String emailNovo) {
		Usuario aux = this.procurarUsuario(email);
		aux.editarUsuario(nome, emailNovo, idade);
	}
	
	//usa os usuario e obra
	public void realizaEmprestimo(String email, int id, Acervo acv) {
		Obra obra = acv.procurarObra(id);
		if(obra != null){
			Usuario aux = this.procurarUsuario(email);
			if(aux != null){
				aux.novoEmprestimo(obra);
				System.out.printf("--> Emprestimo da obra: '%s' para o usuario de email: %s realizado com sucesso!\n", obra.desc.nome, email);
			}
		}
	}
	
	public void finalizaEmprestimo(String email, int id) {
		Usuario aux = this.procurarUsuario(email);
		int multa = aux.checaEmprestimo(id);
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
