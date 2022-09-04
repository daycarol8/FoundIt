package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Candidatura {
	private LocalDateTime data;
	private StatusCandidatura status;
	private Pessoa candidato;
	private Vaga vaga;
	
	public Candidatura(LocalDateTime data, StatusCandidatura status, Vaga vaga, Pessoa candidato) {
		this.data = data;
		this.status = status;
		this.candidato = candidato;
		this.vaga = vaga;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public StatusCandidatura getStatus() {
		return status;
	}

	public void setStatus(StatusCandidatura status) {
		this.status = status;
	}

	public Pessoa getCandidato() {
		return candidato;
	}

	public void setCandidato(Pessoa pessoa){this.candidato = pessoa;}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {this.vaga = vaga;}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Candidatura that = (Candidatura) o;
		return Objects.equals(data, that.data) && status == that.status && Objects.equals(candidato, that.candidato) && Objects.equals(vaga, that.vaga);
	}

}
