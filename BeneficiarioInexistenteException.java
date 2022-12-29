package prova1LucianoGuimaraes;

public class BeneficiarioInexistenteException extends Exception{

	private static final long serialVersionUID = 1L;

	public BeneficiarioInexistenteException(int cpf) {
		super("Beneficiario de cpf "+ cpf+" não foi cadastrado");
	}
	
}
