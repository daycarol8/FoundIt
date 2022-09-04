package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Candidatura {
	private LocalDateTime data;
	private statusCandidatura status;
	Lista<Pessoa> candidato;
	Lista<Vaga> vaga;
	
	public Candidatura(LocalDateTime data, statusCandidatura status) {
		this.data = data;
		this.status = status;
		this.candidato = new ArrayList();
		this.vaga = new ArrayList();
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public statusCandidatura getStatus() {
		return status;
	}

	public void setStatus(statusCandidatura status) {
		this.status = status;
	}

	public Lista<Pessoa> getCandidato() {
		return candidato;
	}

	public Lista<Vaga> getVaga() {
		return vaga;
	}
}
