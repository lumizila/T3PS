import java.util.ArrayList;

public class Acervo {
	public ArrayList<Obra> obras = new ArrayList<Obra>();
	public ArrayList<Descricao> descricoes = new ArrayList<Descricao>();
	//como nao temos um banco de dados tenho que guardar o id em algum lugar
	int id = 0;
	//criacao de obras
	public void newLivro(String nome, int ano, String autor, String editora) {
		System.out.printf("--> Criando novo livro: %s\n", nome);
		Livro livro = new Livro();
		livro.cadastrarObra(nome, ano, autor, editora, descricoes, id);
		id = id + 1;
		obras.add(livro);
	}
	
	public void newPeriodico(String nome, int ano, String volume, int mes) {
		System.out.printf("--> Criando novo periodico %s\n", nome);
		Periodico periodico = new Periodico();
		periodico.cadastrarObra(nome, ano, volume, mes, descricoes, id);
		id = id + 1;
		obras.add(periodico);
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
		
	public void excluirObra(int id) {
		Obra aux = this.procurarObra(id);
		if(aux.checaObra()){
			System.out.println("OK: Obra excluida com sucesso!");
			obras.remove(aux);
			aux = null;
		}
		else{
			System.out.println("ERRO: Obra esta emprestada e nao pode ser excluida.");
		}
	}
	
	public void editarLivro(int id, String nome, int ano, String autor, String editora) {
		Obra aux = this.procurarObra(id);
		aux.editarLivro(nome, ano, autor, editora);
	}
	
	public void editarPeriodico(int id, String nome, int ano, String volume, int mes){
		Obra aux = this.procurarObra(id);
		aux.editarPeriodico(nome, ano, volume, mes);
	}
	
}
