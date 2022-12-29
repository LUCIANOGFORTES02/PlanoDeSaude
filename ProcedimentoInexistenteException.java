package prova1LucianoGuimaraes;

public class ProcedimentoInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProcedimentoInexistenteException(int codigo) {
		super("Procedimento "+ codigo +"inexistente");
	}
	
}
