import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emprestimo {
	public Date data_emprestimo;
	public Date data_devolucao;
	public int multa_acumulada;
	public Obra obra;
	
	public Emprestimo(int prazo, Obra obra) {
		this.data_emprestimo = new Date();
		this.data_devolucao = new Date();
		this.multa_acumulada = 0;
		long millis = data_emprestimo.getTime()+TimeUnit.DAYS.toMillis(prazo);
		this.data_devolucao.setTime(millis);
		System.out.printf("data emprestimo: %s\n", data_emprestimo.toGMTString());
		System.out.printf("data devolucao: %s\n", data_devolucao.toGMTString());
		this.obra = obra;
	}
	
	public int calculaMulta() {
		Date hoje = new Date();
		this.multa_acumulada = 5* ((int) TimeUnit.MILLISECONDS.toDays(hoje.getTime() - data_devolucao.getTime()));
		if(multa_acumulada < 0) {
			multa_acumulada = 0;
		}
		return multa_acumulada;
	}
	
	public boolean pagaMulta(int valor) {
		//atualizando valor da multa
		this.calculaMulta();
		if(this.multa_acumulada > valor) {
			System.out.printf("O valor pago eh menor que a multa, a sua multa eh de: %d\n", multa_acumulada);
			return false;
		}
		else{
			this.multa_acumulada = 0;
			int troco = valor - multa_acumulada;
			System.out.printf("Multa Paga com sucesso, seu troco foi de: %d\n", troco);
			return true;
		}
	}

	public void devolveObra() {
		this.obra.emprestada = false;
		return;
	}
}
