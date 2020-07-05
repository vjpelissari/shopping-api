package com.jantorno.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jantorno.shopping.domain.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long>{

}