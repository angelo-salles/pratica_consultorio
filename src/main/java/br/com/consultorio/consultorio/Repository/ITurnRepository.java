package br.com.consultorio.consultorio.Repository;

import br.com.consultorio.consultorio.Entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {

}
