package com.projeto.barbearia.loja.produto.dto;

import com.projeto.barbearia.loja.produto.entidade.Produto;
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
public class ProdutoDTO {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private Long quantidade;

    public Produto toDomain() {
        return new Produto(id, valor, descricao, quantidade);
    }

    public static List<Produto> toDomain(List<ProdutoDTO> produtosDTO) {
        return produtosDTO != null ? produtosDTO.stream().map(ProdutoDTO::toDomain).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static ProdutoDTO from(Produto produto) {
        if (produto == null) return null;

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setValor(produto.getValor());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setQuantidade(produto.getQuantidade());

        return produtoDTO;
    }

    public static List<ProdutoDTO> from(List<Produto> produtosDominio) {
        return produtosDominio != null ? produtosDominio.stream().map(ProdutoDTO::from).collect(Collectors.toList()) : new ArrayList<>();
    }

}
