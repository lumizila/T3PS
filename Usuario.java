import java.util.ArrayList;

public class Usuario {
	public String nome;
	public String email;
	public int idade; 
	public int prazo;
	public int max_emprestimo;
	public ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	
	public void cadastrar(String nome, String email, int idade) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}

	public void editarUsuario(String nome, String email, int idade) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}
	
	//retorna o valor da multa caso o usuario tenha emprestado obra com id = id
	public int checaEmprestimo(int id) {
		for(int i = 0; i < emprestimos.size(); i++) {
			if(emprestimos.get(i).obra.id == id) {
				return emprestimos.get(i).calculaMulta();
			}
		}
		System.out.println("Nao existe obra emprestada com esse id");
		return -1;
	}
	
	public boolean pagar(int id, int valor) {
		for(int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emp = emprestimos.get(i);
			if(emp.obra.id == id) {
				return emp.pagaMulta(valor);
			}
		}
		System.out.println("Nao existe obra emprestada com esse id");
		return false;
	}
	
	public void terminaEmprestimo(int id) {
		for(int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emp = emprestimos.get(i);
			if(emp.obra.id == id) {
				emp.devolveObra();
				emp = null;
				emprestimos.remove(emp);
			}
		}
		return;
	}
	
	public void novoEmprestimo(Obra obra) {
		if(obra.emprestada == true){
			System.out.printf("ERRO: Esta obra de nome %s ja esta emprestada.\n", obra.desc.nome);
			return;
		}
		System.out.printf("Esta obra de nome %s esta disponivel.\n", obra.desc.nome);
		Emprestimo empre = new Emprestimo(this.prazo, obra);
		emprestimos.add(empre);
		return;
	}
}
