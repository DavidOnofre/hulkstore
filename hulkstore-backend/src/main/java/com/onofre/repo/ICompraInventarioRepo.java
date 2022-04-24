package com.onofre.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onofre.model.CompraInventario;

public interface ICompraInventarioRepo extends IGenericRepo<CompraInventario, Integer> {

	@Modifying
	@Query(value = "INSERT INTO compra_inventario(id_compra, id_inventario) VALUES (:idCompra, :idInventario)", nativeQuery = true)
	Integer registrar(@Param("idCompra") Integer idCompra, @Param("idInventario") Integer idInventario);

}
