package br.com.meloafc.redis.service;

import br.com.meloafc.redis.exception.EntityNotFoundException;
import br.com.meloafc.redis.model.Pessoa;
import br.com.meloafc.redis.repository.PessoaRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Cacheable(cacheNames = Pessoa.CACHE_NAME, key="#root.method.name")
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Cacheable(cacheNames = Pessoa.CACHE_NAME, key="#id")
    public Pessoa findById(final Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada. Id=" + id));
    }

    @CacheEvict(cacheNames = Pessoa.CACHE_NAME, allEntries = true)
    public Pessoa create(final Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @CachePut(cacheNames = Pessoa.CACHE_NAME, key="#pessoa.getId()")
    public Pessoa update(final Pessoa pessoa) {
        if(pessoa.getId() == null) {
            throw new EntityNotFoundException("Id vazio!");
        }

        return pessoaRepository.save(pessoa);
    }

    @CacheEvict(cacheNames = Pessoa.CACHE_NAME, key="#id")
    public void delete(final Long id) {
        if(id == null) {
            throw new EntityNotFoundException("Id vazio!");
        }

        pessoaRepository.deleteById(id);
    }

}
