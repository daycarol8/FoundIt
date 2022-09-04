package models;

public enum StatusCandidatura {
	ENVIADO("Enviado"), ANALISE("Análise"), ESCOLHIDO("Escolhido"), NAOESCOLHIDO("Não escolhido");
	
	private String statuscand;
	
	StatusCandidatura(String statuscand) {
		this.statuscand = statuscand;
	}

	@Override
	public String toString() {
	return "statusCandidatura{" + "Status da Candidatura ='" + statuscand + '\'' + '}';
	}
	
}
