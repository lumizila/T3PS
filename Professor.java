
public class Professor extends Usuario{
		public Professor cadastrarUsuario(String nome, String email, int idade) {
			this.prazo = 30;
			this.max_emprestimo = 3;
			this.cadastrar(nome, email, idade);
			return this;
		}
}
