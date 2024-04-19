package riwi.firstWeb.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import riwi.firstWeb.entity.Coder;
import riwi.firstWeb.repository.CoderRepository;

// Indica que esta clase sera un servicio
@Service
@RequiredArgsConstructor
public class CoderService {

    // Indica que esto es una inyeccion de dependencias
    @Autowired
    private CoderRepository objCoderRepository;

    public Page<Coder> fingPaginated(int page, int size) {
        if (page < 0) {
            page = 0;
        }

        // Crear objeto de paginación
        Pageable objPageable = PageRequest.of(page, size);

        return this.objCoderRepository.findAll(objPageable);
    }

    // Servicio para listar todos los coders
    public List<Coder> findAll() {
        return objCoderRepository.findAll();
    }

    public Coder findById(long id) {
       return objCoderRepository.getById(id);
    }

    public void create(Coder coder) {
        objCoderRepository.save(coder);
    }

    public void delete (Long id){
        objCoderRepository.deleteById(id);
    }

}
