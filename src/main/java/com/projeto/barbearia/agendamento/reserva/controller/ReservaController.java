package com.projeto.barbearia.agendamento.reserva.controller;

import com.projeto.barbearia._utils.Util;
import com.projeto.barbearia.agendamento.fidelidade.dto.FidelidadeDTO;
import com.projeto.barbearia.agendamento.horarios.dto.PesquisaHorariosDTO;
import com.projeto.barbearia.agendamento.reserva.aplicacao.ReservaService;
import com.projeto.barbearia.agendamento.reserva.dto.ReservaDTO;
import com.projeto.barbearia.agendamento.reserva.entidade.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reserva")
public class ReservaController  {

    private final ReservaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody ReservaDTO dto) {
        return service.inserir(dto).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody ReservaDTO dto) {
        return service.editar(dto).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public ReservaDTO consultar(@PathVariable Long id) {
        Reserva reserva = service.consultar(id);
        return new ReservaDTO().from(reserva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<ReservaDTO> listar() {
        return service.listar();
    }

    @GetMapping(value = "/fidelidade/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<FidelidadeDTO> obterFidelidadeCliente(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.obterCountFidelidadeCliente(id));
    }

    @PostMapping(value = "/consultarHorarios")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarHorarios(@RequestBody PesquisaHorariosDTO pesquisaHorariosDTO) {
        List<Reserva> reservas = service.obterReservasDoFuncionarioPorData(pesquisaHorariosDTO.getProfissional().getId(), pesquisaHorariosDTO.getData());
        List<String> horariosReservados = service.getHorariosReservadosDasReservas(reservas);
        return Response.ok(service.getHorariosFiltrados(horariosReservados, pesquisaHorariosDTO.getServicos(), pesquisaHorariosDTO.getData())).build();
    }

    @PostMapping(value = "/listarFiltrado")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarFiltrado(@RequestBody PesquisaHorariosDTO pesquisaHorarios) {
        return Response.ok(service.listarFiltrado(pesquisaHorarios.getProfissional().getId(), pesquisaHorarios.getData())).build();
    }

    @PostMapping(value = "/salvarReserva")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarReserva(@RequestBody ReservaDTO dto) {
        if (Util.isDiferenteDeNullEDeVazio(dto.getId())) dto.setId(null);
        service.inserir(dto);
        return Response.ok().build();
    }

}
