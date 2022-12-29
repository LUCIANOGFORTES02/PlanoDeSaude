package prova1LucianoGuimaraes;

public class Cirurgia extends Procedimento{

	private int unicidade;
	private double honorario;
	private double material;
  //  private int quant=0;
	
	public Cirurgia(int codigo, String nome, int idadeMin, int idadeMax, int genero, int unicidade, double honorario,
			double material) {
		super(codigo, nome, idadeMin, idadeMax, genero);
		this.unicidade = unicidade;
		this.honorario = honorario;
		this.material = material;
	}
	
	public int getUnicidade() {
		return unicidade;
	}
	
	public double getHonorario() {
		return honorario;
	}

	public double getMaterial() {
		return material;
	}

//	public int getQuant() {
//		return quant;
//	}
//
//	public void setQuant(int quant) {
//		this.quant = quant;
//	}

	@Override
	public double valor() {
		return honorario+material;	
		}





	
	
	
	
}
