package com.projeto.barbearia.agendamento.reserva.infra.data;

import com.projeto.barbearia._shared.core.base.EntidadeGenerica;
import com.projeto.barbearia.agendamento.pessoa.cliente.infra.data.ClienteData;
import com.projeto.barbearia.agendamento.pessoa.funcionario.infra.data.FuncionarioData;
import com.projeto.barbearia.agendamento.reserva.entidade.StatusReservaEnum;
import com.projeto.barbearia.agendamento.servico.infra.data.ServicoData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_reserva")
public class ReservaData extends EntidadeGenerica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private ClienteData cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private FuncionarioData funcionario;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "tb_reserva_servico", joinColumns = {@JoinColumn(name = "id_reserva")}, inverseJoinColumns = {@JoinColumn(name = "id_servico")})
    private List<ServicoData> servicos;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicial;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    @Enumerated(EnumType.STRING)
    private StatusReservaEnum statusReserva = StatusReservaEnum.RESERVADO;

}
