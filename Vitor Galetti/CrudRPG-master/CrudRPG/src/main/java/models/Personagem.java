package models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Column(name = "nome_aventureiro")
    private String nomeAventureiro;

    @Enumerated(EnumType.STRING)
    private Classe classe;

    private int level;

    private int forcaBase;

    private int defesaBase;

    @Transient // não será persistida no banco
    private List<ItemMagico> itensMagicos = new ArrayList<>();

    public enum Classe {
        GUERREIRO, MAGO, ARQUEIRO, LADINO, BARDO
    }

    public Personagem() {
        // Construtor vazio exigido pelo JPA
    }

    public Personagem(int id, String nome, String nomeAventureiro, Classe classe,
                      int level, int forcaBase, int defesaBase) {
        if (forcaBase + defesaBase > 10) {
            throw new IllegalArgumentException("A soma de força e defesa base deve ser no máximo 10");
        }

        this.id = id;
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.forcaBase = forcaBase;
        this.defesaBase = defesaBase;
    }

    // Métodos get/set e lógicos (como adicionarItem) seguem iguais

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getNomeAventureiro() { return nomeAventureiro; }
    public Classe getClasse() { return classe; }
    public int getLevel() { return level; }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public List<ItemMagico> getItensMagicos() {
        return itensMagicos;
    }

    public void adicionarItem(ItemMagico item) {
        if (item.getTipo() == ItemMagico.TipoItem.AMULETO) {
            for (ItemMagico i : itensMagicos) {
                if (i.getTipo() == ItemMagico.TipoItem.AMULETO) {
                    throw new IllegalArgumentException("Personagem já possui um amuleto");
                }
            }
        }
        itensMagicos.add(item);
    }

    public void removerItem(int itemId) {
        itensMagicos.removeIf(item -> item.getId() == itemId);
    }

    public int getForcaTotal() {
        int bonus = itensMagicos.stream().mapToInt(ItemMagico::getForca).sum();
        return forcaBase + bonus;
    }

    public int getDefesaTotal() {
        int bonus = itensMagicos.stream().mapToInt(ItemMagico::getDefesa).sum();
        return defesaBase + bonus;
    }

    @Override
    public String toString() {
        return String.format("Personagem{id=%d, nome='%s', aventureiro='%s', classe=%s, level=%d, força=%d, defesa=%d}",
                id, nome, nomeAventureiro, classe, level, getForcaTotal(), getDefesaTotal());
    }
}
