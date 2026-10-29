package com.projeto.sistema.modelos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
public interface ItemEntradaRepositorio extends JpaRepository<ItemEntrada, Long> {
	@Query("SELECT e FROM ItemEntrada e WHERE e.entrada.id = ?1")
	List<ItemEntrada> buscarPorEntrada(long id);
}
