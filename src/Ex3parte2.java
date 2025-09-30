import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

// =========================
// MAIN
// =========================
public class Ex3parte2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal3());
    }
}

// =========================
// Tela Principal
// =========================
class TelaPrincipal3 extends JFrame {
    public TelaPrincipal3() {
        setTitle("Menu Principal - IMAGEM 2: Torre Eiffel");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnPais = new JButton("Cadastrar País");
        JButton btnEdificio = new JButton("Cadastrar Edifício");
        JButton btnArvore = new JButton("Cadastrar Árvore");

        add(btnPais);
        add(btnEdificio);
        add(btnArvore);

        // Evento Botão País
        btnPais.addActionListener(e -> {
            String nacionalidade = JOptionPane.showInputDialog("Digite o nome do país:");
            int habitantes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de habitantes:"));
            String continente = JOptionPane.showInputDialog("Digite o continente:");

            Pais pais = new Pais(nacionalidade, habitantes, continente);
            pais.viajar();
            salvarCSV("Pais", nacionalidade + ";" + habitantes + ";" + continente);
        });

        // Evento Botão Edifício
        btnEdificio.addActionListener(e -> {
            String material = JOptionPane.showInputDialog("Digite o material:");
            double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura (em metros):"));
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor (em R$):"));

            Edificio edificio = new Edificio(material, altura, valor);
            edificio.construir();
            salvarCSV("Edificio", material + ";" + altura + ";" + valor);
        });

        // Evento Botão Árvore
        btnArvore.addActionListener(e -> {
            double tamanho = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho (em metros):"));
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade (em anos):"));
            String especie = JOptionPane.showInputDialog("Digite a espécie:");

            Arvore arvore = new Arvore(tamanho, idade, especie);
            arvore.plantar();
            salvarCSV("Arvore", tamanho + ";" + idade + ";" + especie);
        });

        setVisible(true);
    }

    private void salvarCSV(String tipo, String dados) {
        try (FileWriter writer = new FileWriter("dados_ex2.csv", true)) {
            writer.write(tipo + ";" + dados + "\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV: " + ex.getMessage());
        }
    }
}

// =========================
// CLASSES
// =========================
class Pais {
    private String nacionalidade;
    private int habitantes;
    private String continente;

    public Pais(String nacionalidade, int habitantes, String continente) {
        this.nacionalidade = nacionalidade;
        this.habitantes = habitantes;
        this.continente = continente;
    }

    public void viajar() {
        JOptionPane.showMessageDialog(null,
                "Viajando pelo " + nacionalidade + " localizado na " + continente +
                        " com mais de " + habitantes + " habitantes");
    }
}

class Edificio {
    private String material;
    private double altura;
    private double valor;

    public Edificio(String material, double altura, double valor) {
        this.material = material;
        this.altura = altura;
        this.valor = valor;
    }

    public void construir() {
        JOptionPane.showMessageDialog(null,
                "Construindo edifício de " + material + " com altura " + altura +
                        "m que custará R$ " + valor);
    }
}

class Arvore {
    private double tamanho;
    private int idade;
    private String especie;

    public Arvore(double tamanho, int idade, String especie) {
        this.tamanho = tamanho;
        this.idade = idade;
        this.especie = especie;
    }

    public void plantar() {
        JOptionPane.showMessageDialog(null,
                "Plantando árvore da espécie " + especie +
                        " que chega a " + tamanho + "m e vive até " + idade + " anos");
    }
}