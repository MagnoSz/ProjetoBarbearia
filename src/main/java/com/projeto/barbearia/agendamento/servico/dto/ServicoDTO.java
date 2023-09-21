package com.projeto.barbearia.agendamento.servico.dto;

import com.projeto.barbearia.agendamento.servico.entidade.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private Long tempo;

    public Servico toDomain() {
        return new Servico(id, valor, descricao, tempo);
    }

    public static List<Servico> toDomain(List<ServicoDTO> servicosDTO) {
        return servicosDTO != null ? servicosDTO.stream().map(ServicoDTO::toDomain).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static ServicoDTO from(Servico servico) {
        if (servico == null) return null;

        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setId(servico.getId());
        servicoDTO.setValor(servico.getValor());
        servicoDTO.setDescricao(servico.getDescricao());
        servicoDTO.setTempo(servico.getTempo());

        return servicoDTO;
    }

    public static List<ServicoDTO> from(List<Servico> servicosDominio) {
        return servicosDominio != null ? servicosDominio.stream().map(ServicoDTO::from).collect(Collectors.toList()) : new ArrayList<>();
    }

}
