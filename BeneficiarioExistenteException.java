package prova1LucianoGuimaraes;

public class BeneficiarioExistenteException extends Exception{

		private static final long serialVersionUID = 1L;

	public BeneficiarioExistenteException() {
		super("Cliente já cadastrado\n");
	}
}
