package br.com.consultorio.consultorio.Repository;

import br.com.consultorio.consultorio.Entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaryRepository extends JpaRepository<Diary, Long> {
}
