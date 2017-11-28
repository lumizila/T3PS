import java.io.Console;

public class T3PS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Iniciando programa...\n");
		Biblioteca bib = new Biblioteca();
		Acervo acv = new Acervo();
		Console c = System.console();
		/*bib.newAluno("Joao", "joao@email", 18);
		bib.newAluno("Luiza Maria", "luiza@email", 22);
		bib.imprimeUsuarios();

		bib.procurarUsuario("joao@email");
		
		acv.procurarNumObras("50 tons");
		acv.newLivro("50 tons", 2007, "grey", "pinguim");
		acv.imprimeDescricoes();
		
		acv.imprimeObras();
		bib.realizaEmprestimo("joao@email", 0, acv);
		bib.excluirUsuario("joao@email");
		bib.finalizaEmprestimo("joao@email", 0);*/
		int opcao = 1;
		
		String nome;
		String email;
		int idade;
		String usuario;
		int ano;
		String tipo;
		int id;
		String autor;
		String editora;
		String volume;
		int mes;
		System.out.println("Bem vindo a biblioteca, esses sao os comandos:");
		System.out.println("0 - Sair do programa");
		System.out.println("1 - Adicionar usuario");
		System.out.println("2 - Adicionar obra");
		System.out.println("3 - Modificar usuario");
		System.out.println("4 - Modificar obra");
		System.out.println("5 - Excluir usuario");
		System.out.println("6 - Excluir obra");
		System.out.println("7 - Realizar emprestimo");
		System.out.println("8 - Finalizar emprestimo");
		System.out.println("9 - Pagar multa");
		System.out.println("10 - Pesquisar obras");
		while(opcao != 0){
			opcao = Integer.parseInt(c.readLine("Sua opcao: "));
			switch (opcao) {
				case 1:
					nome = c.readLine("Qual o nome do usuario? ");
					email = c.readLine("Qual o email do usuario? ");
					idade = Integer.parseInt(c.readLine("Qual a idade do usuario? "));
					usuario = c.readLine("Qual o tipo de usuario? (aluno, professor, geral): ");
					switch (usuario) {
						case "professor":
							bib.newProfessor(nome, email, idade);
							break;
						case "aluno":
							bib.newAluno(nome, email, idade);
							break;
						case "geral":
							bib.newGeral(nome, email, idade);
							break;
					}
					break;
				case 2:
					nome = c.readLine("Qual o nome da obra? ");
					ano = Integer.parseInt(c.readLine("Qual o ano da obra? "));
					tipo = c.readLine("Qual o tipo de obra? (livro, periodico): ");
					switch (tipo) {
						case "livro":
							autor = c.readLine("Qual o autor do livro? ");
							editora = c.readLine("Qual a editora do livro? ");
							acv.newLivro(nome, ano, autor, editora);
							break;
						case "periodico":
							volume = c.readLine("Qual o volume do periodico? ");
							mes = Integer.parseInt(c.readLine("Qual o mes do periodico? "));
							acv.newPeriodico(nome, ano, volume, mes);
							break;
					}
					break;
				case 3:
					nome = c.readLine("Qual o novo nome do usuario? ");
					email = c.readLine("Qual o email antigo do usuario? ");
					idade = Integer.parseInt(c.readLine("Qual a idade do usuario? "));
					String emailnovo = c.readLine("Qual o email novo do usuario? ");
					bib.editarUsuario(nome, email, idade, emailnovo);
					break;
				case 4:
					id = Integer.parseInt(c.readLine("Qual o id da obra? "));
					nome = c.readLine("Qual o novo nome da obra? ");
					ano = Integer.parseInt(c.readLine("Qual o novo ano da obra? "));
					tipo = c.readLine("Qual o tipo de obra? (livro, periodico): ");
					switch (tipo) {
						case "livro":
							autor = c.readLine("Qual o novo autor do livro? ");
							editora = c.readLine("Qual a nova editora do livro? ");
							acv.editarLivro(id, nome, ano, autor, editora);
							break;
						case "periodico":
							volume = c.readLine("Qual o novo volume do periodico? ");
							mes = Integer.parseInt(c.readLine("Qual o novo mes do periodico? "));
							acv.editarPeriodico(id, nome, ano, volume, mes);
							break;
					}
					break;
				case 5:
					email = c.readLine("Qual o email do usuario? ");
					bib.excluirUsuario(email);
					break;
				case 6:
					id = Integer.parseInt(c.readLine("Qual o id da obra? "));
					acv.excluirObra(id);
					break;
				case 7:
					email = c.readLine("Qual o email do usuario? ");
					id = Integer.parseInt(c.readLine("Qual o id da obra? "));
					bib.realizaEmprestimo(email, id, acv);
					break;
				case 8:
					email = c.readLine("Qual o email do usuario? ");
					id = Integer.parseInt(c.readLine("Qual o id da obra? "));
					bib.finalizaEmprestimo(email, id);
					break;
				case 9:
					int val = Integer.parseInt(c.readLine("Qual o valor a ser pago? "));
					email = c.readLine("Qual o email do usuario? ");
					id = Integer.parseInt(c.readLine("Qual o id da obra? "));
					bib.pagaMulta(email, id, val);
					break;
				case 10:
					nome = c.readLine("Qual o nome da obra? ");
					acv.procurarObras(nome);
					break;
			}
		}	
	}
}
