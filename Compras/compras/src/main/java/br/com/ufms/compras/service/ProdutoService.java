package br.com.ufms.compras.service;

import br.com.ufms.compras.entity.Categoria;
import br.com.ufms.compras.entity.Produto;
import br.com.ufms.compras.exception.DataIntegrityException;
import br.com.ufms.compras.exception.ObjectNotFoundException;
import br.com.ufms.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        Produto produto = produtoRepository.findOne(id);

        if (produto == null) {
            throw new ObjectNotFoundException("Objeto não encontrado, Id: " + id
                    + " Classe: " + Produto.class.getName());
        }

        return produto;
    }
    public Produto insert(Produto produto) {
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto) {
        findById(produto.getId());
        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        findById(id);
        try {
            produtoRepository.delete(id);
        } catch (DataIntegrityViolationException e) {
            throw  new DataIntegrityException("Não é possível excluir um produto vinculado à um pedido produto!");
        }
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
}
