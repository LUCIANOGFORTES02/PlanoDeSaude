package prova1LucianoGuimaraes;

import java.util.ArrayList;
import java.util.Date;

public class Beneficiario {

	private int cpf;
	private String nome;
	private Date ingressoNoPlano;
	private Date nasc;
	private int genero;// 1 = masculino, 2 = feminino

	private ArrayList<Historico> historico = new ArrayList<Historico>();

	
	
	
	public Beneficiario() {
		
	}

	public Beneficiario(int cpf, String nome, Date ingressoNoPlano, Date nasc, int genero) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.ingressoNoPlano = ingressoNoPlano;
		this.nasc = nasc;
		this.genero = genero;

	}

	public void adicionar(Historico b) {
		historico.add(b);
	}

	public Date procurar(int cod) throws ProcedimentoInexistenteException {
		if (!historico.isEmpty()) {
			for (Historico x : historico) {
				if (x.getCod() == cod) {
					return x.getDate();
				}
			}
		}
		return null;
	}

	public int quantidade(int cod) {
		int i = 1;

		if (!historico.isEmpty()) {
			for (Historico x : historico) {
				if (x.getCod() == cod) {
					i++;
				}
			}
		}
		return i;
	}

	public int procurarData(int mes, int ano) {

		if (!historico.isEmpty()) {
			for (Historico x : historico) {
				int mesEscolhido = x.getDate().getMonth() + 1;
				int anoEscolhido = x.getDate().getYear() + 1900;

				if (mesEscolhido == mes && anoEscolhido == ano) {

					return x.getCod();
				}
			}
		}
		return 0;
	}

	public double valortotal(int mes, int ano) {
		double soma = 0;
		if (!historico.isEmpty()) {
			for (Historico x : historico) {
				int mesEscolhido = x.getDate().getMonth() + 1;
				int anoEscolhido = x.getDate().getYear() + 1900;

				if (mesEscolhido == mes && anoEscolhido == ano) {
					soma = soma + x.getProcedimento().valor();

				}
			}
		}

		return soma;
	}

	public int getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Date getNasc() {
		return nasc;
	}

	public Date getIngressoNoPlano() {
		return ingressoNoPlano;
	}

	public int getGenero() {
		return genero;
	}

	public ArrayList<Historico> getHistorico() {
		return historico;
	}

	public void setHistorico(ArrayList<Historico> historico) {
		this.historico = historico;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIngressoNoPlano(Date ingressoNoPlano) {
		this.ingressoNoPlano = ingressoNoPlano;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}
 
}
