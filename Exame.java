package prova1LucianoGuimaraes;

public class Exame extends Procedimento {

	 
	private int carencia;
	private int periodicidade;
	private double porte;
	private double custoOperacional;
	

	
	public Exame(int codigo, String nome, int idadeMin, int idadeMax, int genero, int carencia, int periodicidade,
			double porte, double custoOperacional) {
		super(codigo, nome, idadeMin, idadeMax, genero);
		this.carencia = carencia;
		this.periodicidade = periodicidade;
		this.porte = porte;
		this.custoOperacional = custoOperacional;
	}

	public int getCarencia() {
		return carencia;
	}

	public int getPeriodicidade() {
		return periodicidade;
	}

	public double getPorte() {
		return porte;
	}

	public double getCustoOperacional() {
		return custoOperacional;
	}

	@Override
	public double valor() {
		// TODO Auto-generated method stub
		return (porte*100)+custoOperacional;	
		}
	
	
	
	
}
