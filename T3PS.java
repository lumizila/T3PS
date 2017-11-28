public class T3PS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Iniciando programa...\n");
		Biblioteca bib = new Biblioteca();
		Acervo acv = new Acervo();
		
		bib.newAluno("Joao", "joao@email", 18);
		bib.newAluno("Luiza Maria", "luiza@email", 22);
		bib.imprimeUsuarios();

		bib.procurarUsuario("joao@email");
		
		acv.procurarNumObras("50 tons");
		acv.newLivro("50 tons", 2007, "grey", "pinguim");
		acv.imprimeDescricoes();
		
		acv.imprimeObras();
		bib.realizaEmprestimo("joao@email", 0, acv);
		bib.excluirUsuario("joao@email");
		bib.finalizaEmprestimo("joao@email", 0);
	}
}
