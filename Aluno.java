
public class Aluno extends Usuario{
	
	public Aluno cadastrarUsuario(String nome, String email, int idade) {
		this.prazo = 15;
		this.max_emprestimo = 2;
		this.cadastrar(nome, email, idade);
		return this;
	}
}
