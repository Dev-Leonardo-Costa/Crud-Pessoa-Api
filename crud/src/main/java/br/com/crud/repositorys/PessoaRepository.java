package br.com.crud.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crud.model.Pessoa;



@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
