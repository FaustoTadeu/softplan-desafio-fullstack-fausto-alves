package com.softplan.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softplan.gestao.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {


    @Transactional(readOnly = true)
	@Query("SELECT u FROM usuarios u where u.emailUsuarios = :emailUsuario")
    public Usuarios findByEmail(String emailUsuario);

    @Transactional(readOnly = true)
    @Query("SELECT u FROM usuarios u where u.emailUsuarios = :emailUsuario AND u.statusUsuarios <> 'E'")
    public Usuarios findByEmailNaoExcluido(String emailUsuario);

    @Transactional(readOnly = true)
    @Query("SELECT u FROM usuarios u where u.cpfUsuarios = :cpfUsuarios AND u.statusUsuarios <> 'E'")
    public Usuarios findByCpfUsuariosNaoExcluidos(String cpfUsuarios);

    @Transactional(readOnly = true)
    public Usuarios findByCpfUsuariosAndStatusUsuarios(String cpfUsuarios, String statusUsuarios);

    @Transactional(readOnly = true)
    @Query("SELECT u FROM usuarios u WHERE u.statusUsuarios <> 'E' ORDER BY u.dataCadastro DESC")
    public List<Usuarios> getListaUsuarios();

}
