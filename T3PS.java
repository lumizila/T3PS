
public class T3PS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Iniciando programa...\n");
		Biblioteca bib = new Biblioteca();
		
		bib.newAluno("Joao", "joao@email", 18);
		bib.newAluno("Luiza Maria", "luiza@email", 22);
		bib.imprimeUsuarios();
		
		bib.procurarUsuario("joao@email");
		
		bib.procurarNumObras("50 tons");
		bib.newLivro("50 tons", 2007, "grey", "pinguim");
		bib.imprimeDescricoes();
		
		bib.imprimeObras();
		bib.realizaEmprestimo("joao@email", 0);
		bib.finalizaEmprestimo("joao@email", 0);
	}
}
