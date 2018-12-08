package br.com.ufms.compras.service;

import br.com.ufms.compras.entity.Categoria;
import br.com.ufms.compras.exception.DataIntegrityException;
import br.com.ufms.compras.exception.ObjectNotFoundException;
import br.com.ufms.compras.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) {
        Categoria categoria = categoriaRepository.findOne(id);

        if (categoria == null) {
            throw new ObjectNotFoundException("Objeto não encontrado, Id: " + id
                    + " Classe: " + Categoria.class.getName());
        }

        return categoria;
    }

    public Categoria insert(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id) {
        findById(id);
        try {

            categoriaRepository.delete(id);
        } catch (DataIntegrityViolationException e) {
           throw  new DataIntegrityException("Não é possível excluir uma categoria que possui produtos!");
        }
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }


}
