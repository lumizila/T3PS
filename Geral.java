
public class Geral extends Usuario{
	public Geral cadastrarUsuario(String nome, String email, int idade) {
		this.prazo = 7;
		this.max_emprestimo = 1;
		this.cadastrar(nome, email, idade);
		return this;
	}
}
