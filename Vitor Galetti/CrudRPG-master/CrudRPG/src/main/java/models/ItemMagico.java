package models;

import jakarta.persistence.*;

@Entity
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoItem tipo;

    private int forca;
    private int defesa;

    public enum TipoItem {
        ARMA, ARMADURA, AMULETO
    }

    public ItemMagico() {
        // Construtor vazio para o JPA
    }

    public ItemMagico(int id, String nome, TipoItem tipo, int forca, int defesa) {
        if (forca < 0 || forca > 10 || defesa < 0 || defesa > 10) {
            throw new IllegalArgumentException("Força e defesa devem ser de 0 à 10");
        }

        if (forca == 0 && defesa == 0) {
            throw new IllegalArgumentException("Força e defesa devem ser maior que 0");
        }

        switch (tipo) {
            case ARMA -> {
                if (defesa != 0) throw new IllegalArgumentException("Armas não podem ter defesa");
            }
            case ARMADURA -> {
                if (forca != 0) throw new IllegalArgumentException("Armaduras não podem ter força");
            }
            case AMULETO -> {
                // Amuleto pode ter os dois
            }
        }

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }

    @Override
    public String toString() {
        return String.format("ItemMagico{id=%d, nome='%s', tipo=%s, forca=%d, defesa=%d}",
                id, nome, tipo, forca, defesa);
    }
}
