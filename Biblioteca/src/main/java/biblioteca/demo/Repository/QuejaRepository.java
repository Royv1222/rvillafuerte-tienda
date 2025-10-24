package biblioteca.demo.Repository;

import biblioteca.demo.domain.Queja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuejaRepository extends JpaRepository<Queja, Long> { }
