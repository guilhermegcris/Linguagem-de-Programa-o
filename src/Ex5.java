import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

// =========================
// MAIN
// =========================
public class Ex5 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipalEx5());
    }
}

// =========================
// Tela Principal
// =========================
class TelaPrincipalEx5 extends JFrame {
    public TelaPrincipalEx5() {
        setTitle("Menu Principal - VÍDEO: QUEM É O JOGADOR PROFISSIONAL? Feat. Vampeta");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnJogador = new JButton("Cadastrar Jogador");
        JButton btnChuteira = new JButton("Cadastrar Chuteira");
        JButton btnPrancheta = new JButton("Cadastrar Prancheta");

        add(btnJogador);
        add(btnChuteira);
        add(btnPrancheta);

        // Evento Botão Jogador
        btnJogador.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Digite o nome do jogador:");
            String trabalho = JOptionPane.showInputDialog("Digite a posição/função do jogador:");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do jogador:"));

            Jogador jogador = new Jogador(trabalho, idade, nome);
            jogador.ser();
            salvarCSV("Jogador", nome + ";" + trabalho + ";" + idade);
        });

        // Evento Botão Chuteira
        btnChuteira.addActionListener(e -> {
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço da chuteira (R$):"));
            double tamanho = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho da chuteira (número):"));
            String marca = JOptionPane.showInputDialog("Digite a marca da chuteira:");

            Chuteira chuteira = new Chuteira(preco, tamanho, marca);
            chuteira.comprar();
            salvarCSV("Chuteira", preco + ";" + tamanho + ";" + marca);
        });

        // Evento Botão Prancheta
        btnPrancheta.addActionListener(e -> {
            String material = JOptionPane.showInputDialog("Digite o material da prancheta:");
            String durabilidade = JOptionPane.showInputDialog("Digite a durabilidade da prancheta:");
            String tipo = JOptionPane.showInputDialog("Digite o tipo da prancheta:");

            Prancheta prancheta = new Prancheta(material, durabilidade, tipo);
            prancheta.escrever();
            salvarCSV("Prancheta", material + ";" + durabilidade + ";" + tipo);
        });

        setVisible(true);
    }

    // Método para salvar em CSV
    private void salvarCSV(String tipo, String dados) {
        try (FileWriter writer = new FileWriter("dados_ex5.csv", true)) {
            writer.write(tipo + ";" + dados + "\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV: " + ex.getMessage());
        }
    }
}

// =========================
// CLASSES
// =========================
class Jogador {
    private String trabalho;
    private int idade;
    private String nome;

    public Jogador(String trabalho, int idade, String nome) {
        this.trabalho = trabalho;
        this.idade = idade;
        this.nome = nome;
    }

    public void ser() {
        JOptionPane.showMessageDialog(null,
                nome + " é jogador, joga como " + trabalho + " e tem " + idade + " anos.");
    }
}

class Chuteira {
    private double preco;
    private double tamanho;
    private String marca;

    public Chuteira(double preco, double tamanho, String marca) {
        this.preco = preco;
        this.tamanho = tamanho;
        this.marca = marca;
    }

    public void comprar() {
        JOptionPane.showMessageDialog(null,
                "Cadastrando chuteira do tamanho " + tamanho + " da marca " + marca + " por R$" + preco);
    }
}

class Prancheta {
    private String material;
    private String durabilidade;
    private String tipo;

    public Prancheta(String material, String durabilidade, String tipo) {
        this.material = material;
        this.durabilidade = durabilidade;
        this.tipo = tipo;
    }

    public void escrever() {
        JOptionPane.showMessageDialog(null,
                "Escrevendo na prancheta de " + material + ", com durabilidade " + durabilidade + ", do tipo " + tipo);
    }
}