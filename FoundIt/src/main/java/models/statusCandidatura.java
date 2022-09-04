package models;

public enum statusCandidatura {
	ENVIADO("Enviado"), ANALISE("Análise"), ESCOLHIDO("Escolhido");
	
	private String statuscand;
	
	statusCandidatura(String statuscand) {
		this.statuscand = statuscand;
	}

	@Override
	public String toString() {
	return "statusCandidatura{" + "Status da Candidatura ='" + statuscand + '\'' + '}';
	}
	
}
