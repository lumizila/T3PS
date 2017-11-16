import java.util.ArrayList;

public class Livro extends Obra{
	public String autor;
	public String editora;
	
	public void cadastrarObra(String nome, int ano, String autor, String editora, ArrayList<Descricao> descricoes, int id) {
		this.autor = autor;
		this.editora = editora;
		this.emprestada = false;
		this.id = id;
		this.adicionaDescricao(nome, ano, descricoes);
	}

	public void editar(String nome, int ano, String autor, String editora) {
		this.autor = autor;
		this.editora = editora;
		this.desc.nome = nome;
		this.desc.ano = ano;
	}
}
