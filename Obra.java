import java.util.ArrayList;

abstract class Obra{
	public int id;
	public boolean emprestada;
	public Descricao desc = null;
	
	public void editarLivro(String nome, int ano, String autor, String editora){};
	public void editarPeriodico(String nome, int ano, String volume, int mes){};
	
	//este metodo primeiro vai checar se ja existe descricao com esses
	//dados, se nao existe deve criar uma descricao
	public void adicionaDescricao(String nome, int ano, ArrayList<Descricao> descricoes) {
		for(int i = 0; i < descricoes.size(); i++) {
			//se ja existe descricao assim, entao
			if(descricoes.get(i).nome.equals(nome) && descricoes.get(i).ano == ano) {
				desc = descricoes.get(i);
			}
		}
		//se nao encontrou nenhuma descricao assim
		if(desc == null) {
			desc = new Descricao();
			desc.ano = ano;
			desc.nome = nome;
			descricoes.add(desc);
		}
		desc.incrementaDescricao();
	}
	
	public boolean checaObra(){
		if(emprestada){
			return false;
		}
		else{
			return true;
		}
	}
}
