package prova1LucianoGuimaraes;

import java.util.ArrayList;
import java.util.Date;

public class ControlePlanoDeSaude extends PlanoDeSaude {


	ArrayList<Beneficiario> lista = new ArrayList<>();
	ArrayList<Procedimento> procedimento = new ArrayList<>();


	@Override
	public void cadastrarBeneficiario(Beneficiario b)
			throws BeneficiarioExistenteException, DadosInvalidosException, IdadeInvalidaException {

		// Para descobrir se tem paciente repetido
		if (!lista.isEmpty()) {
			for (Beneficiario a : lista) {
				if (b.getCpf() == a.getCpf()) {
					throw new BeneficiarioExistenteException();
				}
			}
		}

		 

		// Se cadastrar dados invalidos
		
			if (b.getCpf()==0 || b.getIngressoNoPlano()==null || b.getNasc()==null || b.getNome()==null || b.getNome()=="") {
			throw new DadosInvalidosException();
		}
			// Se tiver idade invalida
			
					if ((calculaIdade(b.getNasc()) < 18)  ||  (calculaIdade(b.getNasc()) > 65)) {
					throw new IdadeInvalidaException();
				}
					
			if(b.getGenero() != 1 && b.getGenero() != 2) {
			throw new DadosInvalidosException();
		}

			lista.add(b);			
		
	}

	
	@Override
	public void salvarProcedimento(Procedimento p) throws DadosInvalidosException {
		int i = 0;
		

		if(p instanceof Cirurgia) {   
			   if(p.getCodigo() <= 0 || p.getNome()==null || p.getNome()=="" || p.getIdadeMin() < 0   ||  p.getIdadeMax() < 0  || p.getGenero() == 0 ||  p.getGenero() >3  ||  p.getGenero() < 0 || 
					   ((Cirurgia)p).getUnicidade() < 0 || ((Cirurgia)p).getHonorario() < 0 || ((Cirurgia)p).getMaterial() < 0) {
				 
				 throw new DadosInvalidosException();
			   }
			   if(p.getIdadeMin() > p.getIdadeMax()) {
				   throw new DadosInvalidosException();  
			   }
			   
			  }
			
			if(p instanceof Exame) {   
			   if(p.getCodigo() <= 0 || p.getNome()==null || p.getNome()=="" || p.getIdadeMin() < 0   ||  p.getIdadeMax() < 0 || p.getGenero() == 0 ||  p.getGenero() >3  || 
					   p.getGenero() < 0  || ((Exame)p).getCarencia() < 0 || ((Exame)p).getPeriodicidade() < 0 || ((Exame)p).getPorte() < 0 || ((Exame)p).getCustoOperacional() < 0) {
				 
				 throw new DadosInvalidosException();
				  }
			   if(p.getIdadeMin() > p.getIdadeMax()) {
				   throw new DadosInvalidosException();  
			   }
			}	
								
if(!procedimento.isEmpty()) {
		// Para alterar o nome
		for (Procedimento x : procedimento) {
			if (x.getCodigo() == p.getCodigo()) {
				procedimento.set(i, p);
			}
			i++;
		}
}
		// Para adicionar
		if (procedimento.size() == i) {
			procedimento.add(p);
		}
		}

	

	@Override
	public void solicitar(int cpf, int codProcedimento, Date data) throws IdadeInvalidaException,
			GeneroInvalidoException, CarenciaException, PeriodicidadeException, UnicidadeException,
			BeneficiarioInexistenteException, ProcedimentoInexistenteException, BeneficiarioExistenteException {
		
		// Para descobrir que tipo de procedimneto
		Procedimento pro = pesquisarProcedimento(codProcedimento);

		// Para descobrir o beneficiario
		Beneficiario ben = pesquisarBeneficiario(cpf);

		
		// Varificar se a idade é compatível
		if (calculaIdade(ben.getNasc()) < pro.getIdadeMin() || calculaIdade(ben.getNasc()) > pro.getIdadeMax()) {
			throw new IdadeInvalidaException();
		}
		// Verificar se o genero é compatível
		 if (ben.getGenero() != pro.getGenero() && pro.getGenero() != 3) {
			throw new GeneroInvalidoException();
		}

		
		 if (pro instanceof Exame){

			// Verificar se está correta a Carencia
			if ( (difDatas(data,ben.getIngressoNoPlano()) ) < ((Exame) pro).getCarencia()) {
				throw new CarenciaException();
			}
						
			// Verificar se está correta a periodicidade -> tempo para se fazer um novo exame, depois de já te-lo feito uma vez
				
			//Se o procedimento for diferente de null é porque ja foi realizado  
			 if(ben.procurar(codProcedimento)!=null){
				
				 if (((difDatas( data , ben.procurar(codProcedimento)))  <  ((Exame) pro).getPeriodicidade())) {
						throw new PeriodicidadeException();
			}
			 }
    	
		    			
				ben.adicionar((new Historico(data , ((Exame)pro).getCodigo() , ((Exame) pro))));
		
		}

		else if (pro instanceof Cirurgia){ 
			// Para unicidade -> quantas vezes uma cirurgia pode ser feita em um paciente em sua vida
			
			if (((Cirurgia)pro).getUnicidade() < ben.quantidade(codProcedimento)) {
			
			throw new UnicidadeException();
					
		}
				
			ben.adicionar((new Historico(data ,((Cirurgia)pro).getCodigo() ,((Cirurgia) pro))));
		
		}

		 }
	

	@Override
	public double faturar(int mes, int ano) {
    //Deve retornar o total de faturamento em um determinado mes
		
		 
		double soma=0;		 
		for (Beneficiario x: lista ) {
			soma=soma+x.valortotal(mes,ano);
		}
		return soma;
	}

	@Override
	public Procedimento pesquisarProcedimento(int cod) throws ProcedimentoInexistenteException {
		for (Procedimento x : procedimento) {
			if (x.getCodigo() == cod) {
				return x;
			}
		}

		throw new ProcedimentoInexistenteException(cod);

	}

	@Override
	public Beneficiario pesquisarBeneficiario(int cpf) throws BeneficiarioInexistenteException {

		for (Beneficiario x : lista) {
			if (x.getCpf() == cpf) {
				return x;
			}
		}

		throw new BeneficiarioInexistenteException(cpf);

	}

}
