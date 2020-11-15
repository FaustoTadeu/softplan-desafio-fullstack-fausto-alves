package com.softplan.gestao.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import com.softplan.gestao.model.Processos;
import com.softplan.gestao.model.Usuarios;

public class ParecerAtribuirDTO implements Serializable{

	    private static final long serialVersionUID = 1L;

	    
	    @NotEmpty(message = "Preenchimento obrigatório")
		private Integer idUsuario;
		
	    @NotEmpty(message = "Preenchimento obrigatório")
		private Integer idProcesso;

		
		
		public ParecerAtribuirDTO() {}
		
		public ParecerAtribuirDTO(Integer idUsuario, Integer idProcesso) {
			super();
			this.idUsuario = idUsuario;
			this.idProcesso = idProcesso;
		}

		public Integer getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
		}

		public Integer getIdProcesso() {
			return idProcesso;
		}

		public void setIdProcesso(Integer idProcesso) {
			this.idProcesso = idProcesso;
		}
		
		

}
