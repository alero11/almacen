package axa.egpp.bo.almacen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import axa.egpp.bo.almacen.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}
