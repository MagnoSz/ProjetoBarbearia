package com.projeto.barbearia.loja.produto.infra;

import com.projeto.barbearia.loja.produto.infra.data.ProdutoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDataRepository extends JpaRepository<ProdutoData, Long> {
}
