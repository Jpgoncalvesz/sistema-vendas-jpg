package com.projeto.sistema.modelos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
public interface ItemVendaRepositorio extends JpaRepository<ItemVenda, Long> {
	@Query("SELECT e FROM ItemVenda e WHERE e.venda.id = ?1")
	List<ItemVenda> buscarPorVenda(long id);
}
