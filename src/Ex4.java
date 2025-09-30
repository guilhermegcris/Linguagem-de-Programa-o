import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

// =========================
// MAIN
// =========================
public class Ex4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipalEx4());
    }
}

// =========================
// Tela Principal
// =========================
class TelaPrincipalEx4 extends JFrame {
    public TelaPrincipalEx4() {
        setTitle("Menu Principal - IMAGEM 3: Amarula Cup");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnAnimal = new JButton("Cadastrar Animal");
        JButton btnBebida = new JButton("Cadastrar Bebida");
        JButton btnCopo = new JButton("Cadastrar Copo");

        add(btnAnimal);
        add(btnBebida);
        add(btnCopo);

        // Evento Botão Animal
        btnAnimal.addActionListener(e -> {
            String especie = JOptionPane.showInputDialog("Digite a espécie do animal:");
            double tamanho = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho (em metros):"));
            String alimentacao = JOptionPane.showInputDialog("Digite a alimentação:");

            Animal animal = new Animal(especie, tamanho, alimentacao);
            animal.comer();
            salvarCSV("Animal", especie + ";" + tamanho + ";" + alimentacao);
        });

        // Evento Botão Bebida
        btnBebida.addActionListener(e -> {
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da bebida (em anos):"));
            double teorAlcoolico = Double.parseDouble(JOptionPane.showInputDialog("Digite o teor alcoólico (%):"));
            String sabor = JOptionPane.showInputDialog("Digite o sabor:");

            Bebida bebida = new Bebida(idade, teorAlcoolico, sabor);
            bebida.beber();
            salvarCSV("Bebida", idade + ";" + teorAlcoolico + ";" + sabor);
        });

        // Evento Botão Copo
        btnCopo.addActionListener(e -> {
            String material = JOptionPane.showInputDialog("Digite o material do copo:");
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do copo (R$):"));
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade em ml:"));

            Copo copo = new Copo(material, preco, quantidade);
            copo.encher();
            salvarCSV("Copo", material + ";" + preco + ";" + quantidade);
        });

        setVisible(true);
    }

    // Método para salvar em CSV
    private void salvarCSV(String tipo, String dados) {
        try (FileWriter writer = new FileWriter("dados_ex4.csv", true)) {
            writer.write(tipo + ";" + dados + "\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV: " + ex.getMessage());
        }
    }
}

// =========================
// CLASSES
// =========================
class Animal {
    private String especie;
    private double tamanho;
    private String alimentacao;

    public Animal(String especie, double tamanho, String alimentacao) {
        this.especie = especie;
        this.tamanho = tamanho;
        this.alimentacao = alimentacao;
    }

    public void comer() {
        JOptionPane.showMessageDialog(null,
                "O " + especie + " tem " + tamanho +
                        " metros e está se alimentando de " + alimentacao);
    }
}

class Bebida {
    private int idade;
    private double teorAlcoolico;
    private String sabor;

    public Bebida(int idade, double teorAlcoolico, String sabor) {
        this.idade = idade;
        this.teorAlcoolico = teorAlcoolico;
        this.sabor = sabor;
    }

    public void beber() {
        JOptionPane.showMessageDialog(null,
                "Bebendo " + sabor + " de " + idade +
                        " anos com teor alcoólico " + teorAlcoolico + "%");
    }
}

class Copo {
    private String material;
    private double preco;
    private int quantidade;

    public Copo(String material, double preco, int quantidade) {
        this.material = material;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void encher() {
        JOptionPane.showMessageDialog(null,
                "Encher o copo de " + material +
                        " de " + quantidade + "ml no bar custa R$" + preco);
    }
}