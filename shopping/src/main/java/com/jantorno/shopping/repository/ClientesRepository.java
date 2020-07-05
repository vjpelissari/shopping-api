package com.jantorno.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jantorno.shopping.domain.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {

}