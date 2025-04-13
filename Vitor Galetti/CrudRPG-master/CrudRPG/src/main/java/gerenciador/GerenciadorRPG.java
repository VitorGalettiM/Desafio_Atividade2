package gerenciador;

import models.Personagem;
import models.ItemMagico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorRPG {
    private List<Personagem> personagens = new ArrayList<>();
    private List<ItemMagico> itensMagicos = new ArrayList<>();

    public void adicionarPersonagem(Personagem p) {
        personagens.add(p);
    }

    public List<Personagem> listarPersonagens() {
        return personagens;
    }

    public boolean atualizarPersonagem(int id, Personagem novo) {
        for (int i = 0; i < personagens.size(); i++) {
            if (personagens.get(i).getId() == id) {
                personagens.set(i, novo);
                return true;
            }
        }
        return false;
    }

    public boolean removerPersonagem(int id) {
        return personagens.removeIf(p -> p.getId() == id);
    }

    public Optional<Personagem> buscarPersonagemPorId(int id) {
        return personagens.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public void adicionarItem(ItemMagico i) {
        itensMagicos.add(i);
    }

    public List<ItemMagico> listarItens() {
        return itensMagicos;
    }

    public boolean atualizarItem(int id, ItemMagico novo) {
        for (int i = 0; i < itensMagicos.size(); i++) {
            if (itensMagicos.get(i).getId() == id) {
                itensMagicos.set(i, novo);
                return true;
            }
        }
        return false;
    }

    public boolean removerItem(int id) {
        return itensMagicos.removeIf(i -> i.getId() == id);
    }

    public Optional<ItemMagico> buscarItemPorId(int id) {
        return itensMagicos.stream()
                .filter(i -> i.getId() == id)
                .findFirst();
    }
}
