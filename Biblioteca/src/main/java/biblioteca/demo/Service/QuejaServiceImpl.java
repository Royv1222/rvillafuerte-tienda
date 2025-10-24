package biblioteca.demo.Service;

import biblioteca.demo.domain.Queja;
import biblioteca.demo.Repository.QuejaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuejaServiceImpl implements QuejaService {
    private final QuejaRepository repo;

    @Override
    public Queja guardar(Queja q) {
        if (q.getTratado() == null) q.setTratado(Boolean.FALSE);
        return repo.save(q);
    }
}