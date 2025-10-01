package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;

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
    private static JTextArea areaResultados;

    public TelaPrincipalEx5() {
        setTitle("Menu Principal - VÍDEO: QUEM É O JOGADOR PROFISSIONAL? Feat. Vampeta");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel botoes = new JPanel(new GridLayout(3, 1));
        JButton btnJogador = new JButton("Cadastrar Jogador");
        JButton btnChuteira = new JButton("Cadastrar Chuteira");
        JButton btnPrancheta = new JButton("Cadastrar Prancheta");

        botoes.add(btnJogador);
        botoes.add(btnChuteira);
        botoes.add(btnPrancheta);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultados);

        add(botoes, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnJogador.addActionListener(e -> new JogadorGUI());
        btnChuteira.addActionListener(e -> new ChuteiraGUI());
        btnPrancheta.addActionListener(e -> new PranchetaGUI());

        setVisible(true);
    }

    // método de registro ajustado
    public static void registrar(String tipo, String linha, String mensagem) {
        areaResultados.append(mensagem + "\n");

        switch (tipo) {
            case "Jogador":
                UtilCSV.salvar("jogadores.csv", linha);
                break;
            case "Chuteira":
                UtilCSV.salvar("chuteiras.csv", linha);
                break;
            case "Prancheta":
                UtilCSV.salvar("pranchetas.csv", linha);
                break;
        }
    }
}

// =========================
// Tela Jogador
// =========================
class JogadorGUI extends JFrame {
    private JTextField nomeField, trabalhoField, idadeField;

    public JogadorGUI() {
        setTitle("Cadastro de Jogador");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Trabalho/Função:"));
        trabalhoField = new JTextField();
        add(trabalhoField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String trabalho = trabalhoField.getText();
            int idade = Integer.parseInt(idadeField.getText());

            Jogador jogador = new Jogador(trabalho, idade, nome);
            String mensagem = jogador.ser();
            TelaPrincipalEx5.registrar("Jogador", nome + ";" + trabalho + ";" + idade, mensagem);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =========================
// Tela Chuteira
// =========================
class ChuteiraGUI extends JFrame {
    private JTextField precoField, tamanhoField, marcaField;

    public ChuteiraGUI() {
        setTitle("Cadastro de Chuteira");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Preço (R$):"));
        precoField = new JTextField();
        add(precoField);

        add(new JLabel("Tamanho:"));
        tamanhoField = new JTextField();
        add(tamanhoField);

        add(new JLabel("Marca:"));
        marcaField = new JTextField();
        add(marcaField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            double preco = Double.parseDouble(precoField.getText());
            double tamanho = Double.parseDouble(tamanhoField.getText());
            String marca = marcaField.getText();

            Chuteira chuteira = new Chuteira(preco, tamanho, marca);
            String mensagem = chuteira.comprar();
            TelaPrincipalEx5.registrar("Chuteira", preco + ";" + tamanho + ";" + marca, mensagem);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =========================
// Tela Prancheta
// =========================
class PranchetaGUI extends JFrame {
    private JTextField materialField, durabilidadeField, tipoField;

    public PranchetaGUI() {
        setTitle("Cadastro de Prancheta");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Material:"));
        materialField = new JTextField();
        add(materialField);

        add(new JLabel("Durabilidade:"));
        durabilidadeField = new JTextField();
        add(durabilidadeField);

        add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        add(tipoField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            String material = materialField.getText();
            String durabilidade = durabilidadeField.getText();
            String tipo = tipoField.getText();

            Prancheta prancheta = new Prancheta(material, durabilidade, tipo);
            String mensagem = prancheta.escrever();
            TelaPrincipalEx5.registrar("Prancheta", material + ";" + durabilidade + ";" + tipo, mensagem);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =========================
// UtilCSV
// =========================
class UtilCSV5 {
    public static void salvar(String nomeArquivo, String linha) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(linha + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }
}

// =========================
// Classes
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

    public String ser() {
        return nome + " é jogador, atua como " + trabalho + " e tem " + idade + " anos.";
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

    public String comprar() {
        return "Chuteira tamanho " + tamanho + " da marca " + marca + " custa R$" + preco;
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

    public String escrever() {
        return "Prancheta de " + material + ", durabilidade " + durabilidade + ", tipo " + tipo;
    }
}
