/*import gerenciador.GerenciadorRPG;
import models.ItemMagico;
import models.Personagem;

public class Main {
    public static void main(String[] args) {
        GerenciadorRPG gerenciador = new GerenciadorRPG();

        Personagem p1 = new Personagem(1, "Lia", "Caçadora Sombria", Personagem.Classe.ARQUEIRO, 3, 5, 5);
        gerenciador.adicionarPersonagem(p1);

        ItemMagico arma = new ItemMagico(1, "Arco Elétrico", ItemMagico.TipoItem.ARMA, 5, 0);
        ItemMagico armadura = new ItemMagico(2, "Manto Sombrio", ItemMagico.TipoItem.ARMADURA, 0, 4);

        gerenciador.adicionarItem(arma);
        gerenciador.adicionarItem(armadura);

        p1.adicionarItem(arma);
        p1.adicionarItem(armadura);

        System.out.println("Personagens:");
        for (Personagem p : gerenciador.listarPersonagens()) {
            System.out.println(p);
        }

        System.out.println("\nItens mágicos:");
        for (ItemMagico i : gerenciador.listarItens()) {
            System.out.println(i);
        }
    }
}
*/