package prova1LucianoGuimaraes;

public abstract class Procedimento {

	private int codigo;
	private String nome;
	private int idadeMin;
	private int idadeMax;
	private int genero;
	
	public Procedimento(int codigo, String nome, int idadeMin, int idadeMax, int genero) {
		this.codigo = codigo;
		this.nome = nome;
		this.idadeMin = idadeMin;
		this.idadeMax = idadeMax;
		this.genero = genero;
	}
	
	public abstract double valor();
	
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public int getIdadeMin() {
		return idadeMin;
	}

	public int getIdadeMax() {
		return idadeMax;
	}

	public int getGenero() {
		return genero;
	}
	
}
