package br.com.meloafc.redis.controller;

import br.com.meloafc.redis.model.Pessoa;
import br.com.meloafc.redis.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable("id") final Long id) {
        return pessoaService.findById(id);
    }

    @PostMapping
    public Pessoa create(@RequestBody final Pessoa pessoa) {
        return pessoaService.create(pessoa);
    }

    @PutMapping
    public Pessoa update(@RequestBody final Pessoa pessoa) {
        return pessoaService.update(pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        pessoaService.delete(id);
    }

}
