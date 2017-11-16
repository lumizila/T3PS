import java.util.ArrayList;

public class Periodico extends Obra{
	public String volume;
	public int mes;
	
	public void cadastrarObra(String nome, int ano, String volume, int mes, ArrayList<Descricao> descricoes, int id) {
		this.volume = volume;
		this.mes = mes;
		this.emprestada = false;
		this.id = id;
		this.adicionaDescricao(nome, ano, descricoes);
	}

	public void editar(String nome, int ano, String volume, int mes) {
		this.volume = volume;
		this.mes = mes;
		this.desc.nome = nome;
		this.desc.ano = ano;
	}
}
