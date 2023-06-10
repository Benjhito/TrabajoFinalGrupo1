package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String consulta;
    private String descr;    
	private Boolean estado;

    public Servicio() {
		//TODO Auto-generated constructor stub
	}

	public Servicio(Integer codigo, String consulta, String descr, Boolean estado) {
		super();
		this.codigo = codigo;
		this.consulta = consulta;
		this.descr = descr;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
