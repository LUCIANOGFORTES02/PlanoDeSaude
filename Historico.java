package prova1LucianoGuimaraes;

import java.util.Date;

public class Historico {
	//Objetivo salvar o exame ou cirurgia na data informada

	private Date date;
	
	private int cod;
	private Procedimento procedimento;

	
	public Historico(Date date, int cod, Procedimento procedimento) {
		
		this.date = date;
		this.cod = cod;
		this.procedimento = procedimento;
	}
	
	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}


	

	
	
 	
	
	
	
	
	
}
