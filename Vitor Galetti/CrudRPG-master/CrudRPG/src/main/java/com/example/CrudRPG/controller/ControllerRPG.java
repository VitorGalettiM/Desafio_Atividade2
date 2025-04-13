package com.example.CrudRPG.controller;

import gerenciador.GerenciadorRPG;
import models.Personagem;
import models.ItemMagico;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRPG {

    @GetMapping("")
    public String home() {
        return "OK!";
    }


    private GerenciadorRPG gerenciador = new GerenciadorRPG();


    @PostMapping("/personagens")
    public void adicionarPersonagem(@RequestBody Personagem personagem) {
        gerenciador.adicionarPersonagem(personagem);
    }

    @GetMapping("/personagens")
    public List<Personagem> listarPersonagens() {
        return gerenciador.listarPersonagens();
    }

    @GetMapping("/personagens/{id}")
    public Optional<Personagem> buscarPersonagem(@PathVariable int id) {
        return gerenciador.buscarPersonagemPorId(id);
    }

    @PutMapping("/personagens/{id}")
    public boolean atualizarPersonagem(@PathVariable int id, @RequestBody Personagem personagem) {
        return gerenciador.atualizarPersonagem(id, personagem);
    }

    @DeleteMapping("/personagens/{id}")
    public boolean removerPersonagem(@PathVariable int id) {
        return gerenciador.removerPersonagem(id);
    }

    @PostMapping("/itens")
    public void adicionarItem(@RequestBody ItemMagico item) {
        gerenciador.adicionarItem(item);
    }

    @GetMapping("/itens")
    public List<ItemMagico> listarItens() {
        return gerenciador.listarItens();
    }

    @GetMapping("/itens/{id}")
    public Optional<ItemMagico> buscarItem(@PathVariable int id) {
        return gerenciador.buscarItemPorId(id);
    }

    @PutMapping("/itens/{id}")
    public boolean atualizarItem(@PathVariable int id, @RequestBody ItemMagico item) {
        return gerenciador.atualizarItem(id, item);
    }

    @DeleteMapping("/itens/{id}")
    public boolean removerItem(@PathVariable int id) {
        return gerenciador.removerItem(id);
    }
}
