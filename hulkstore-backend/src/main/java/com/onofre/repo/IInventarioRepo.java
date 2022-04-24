package com.onofre.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onofre.model.Inventario;

public interface IInventarioRepo extends IGenericRepo<Inventario, Integer> {

	@Modifying
	@Query("UPDATE Inventario inv SET inv.total = (inv.total + :total) WHERE inv.producto.idProducto =:idProducto")
	void actualizarInventario(@Param("total") Integer total, @Param("idProducto") Integer idProducto);

}
