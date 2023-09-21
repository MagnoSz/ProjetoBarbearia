package com.projeto.barbearia._shared.core.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class EntidadeGenerica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro")
    private Date dataCadastro;

    @Column(name = "flag_ativo")
    private Boolean ativo;

    @PrePersist
    public void preSalvar() {
        if (this.getId() == null) dataCadastro = new Date();

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        EntidadeGenerica other = (EntidadeGenerica) obj;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @JsonIgnore
    public boolean isNew(){
        return Objects.isNull(id);
    }

}
