package com.jantorno.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jantorno.shopping.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}