package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;

// =====================
// MAIN
// =====================
public class Ex4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipalEx4());
    }
}

// =====================
// Tela Principal
// =====================
class TelaPrincipalEx4 extends JFrame {
    private static JTextArea areaResultados;

    public TelaPrincipalEx4() {
        setTitle("Menu Principal - IMAGEM 3: Amarula Cup");
        setSize(400, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel botoes = new JPanel(new GridLayout(3, 1));
        JButton btnAnimal = new JButton("Cadastrar Animal");
        JButton btnBebida = new JButton("Cadastrar Bebida");
        JButton btnCopo = new JButton("Cadastrar Copo");

        botoes.add(btnAnimal);
        botoes.add(btnBebida);
        botoes.add(btnCopo);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultados);

        add(botoes, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnAnimal.addActionListener(e -> new AnimalGUI());
        btnBebida.addActionListener(e -> new BebidaGUI());
        btnCopo.addActionListener(e -> new CopoGUI());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void registrar(String arquivo, String linha, String mensagem) {
        areaResultados.append(mensagem + "\n");
        UtilCSV.salvar(arquivo, linha);
    }
}

// =====================
// Tela Animal
// =====================
class AnimalGUI extends JFrame {
    private JTextField especieField, tamanhoField, alimentacaoField;

    public AnimalGUI() {
        setTitle("Cadastro de Animal");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Espécie:"));
        especieField = new JTextField();
        add(especieField);

        add(new JLabel("Tamanho (m):"));
        tamanhoField = new JTextField();
        add(tamanhoField);

        add(new JLabel("Alimentação:"));
        alimentacaoField = new JTextField();
        add(alimentacaoField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            String especie = especieField.getText();
            double tamanho = Double.parseDouble(tamanhoField.getText());
            String alimentacao = alimentacaoField.getText();

            Animal animal = new Animal(especie, tamanho, alimentacao);
            String mensagem = animal.comer();
            TelaPrincipalEx4.registrar("animal.csv",
                    especie + ";" + tamanho + ";" + alimentacao,
                    mensagem);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// Tela Bebida
// =====================
class BebidaGUI extends JFrame {
    private JTextField idadeField, teorField, saborField;

    public BebidaGUI() {
        setTitle("Cadastro de Bebida");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Idade (anos):"));
        idadeField = new JTextField();
        add(idadeField);

        add(new JLabel("Teor Alcoólico (%):"));
        teorField = new JTextField();
        add(teorField);

        add(new JLabel("Sabor:"));
        saborField = new JTextField();
        add(saborField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            int idade = Integer.parseInt(idadeField.getText());
            double teor = Double.parseDouble(teorField.getText());
            String sabor = saborField.getText();

            Bebida bebida = new Bebida(idade, teor, sabor);
            String mensagem = bebida.beber();
            TelaPrincipalEx4.registrar("bebida.csv",
                    idade + ";" + teor + ";" + sabor,
                    mensagem);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// Tela Copo
// =====================
class CopoGUI extends JFrame {
    private JTextField materialField, precoField, qtdField;

    public CopoGUI() {
        setTitle("Cadastro de Copo");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Material:"));
        materialField = new JTextField();
        add(materialField);

        add(new JLabel("Preço (R$):"));
        precoField = new JTextField();
        add(precoField);

        add(new JLabel("Quantidade (ml):"));
        qtdField = new JTextField();
        add(qtdField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            String material = materialField.getText();
            double preco = Double.parseDouble(precoField.getText());
            int quantidade = Integer.parseInt(qtdField.getText());

            Copo copo = new Copo(material, preco, quantidade);
            String mensagem = copo.encher();
            TelaPrincipalEx4.registrar("copo.csv",
                    material + ";" + preco + ";" + quantidade,
                    mensagem);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// UtilCSV
// =====================
class UtilSCV {
    public static void salvar(String nomeArquivo, String linha) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(linha + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }
}

// =====================
// Classes
// =====================
class Animal {
    private String especie;
    private double tamanho;
    private String alimentacao;

    public Animal(String especie, double tamanho, String alimentacao) {
        this.especie = especie;
        this.tamanho = tamanho;
        this.alimentacao = alimentacao;
    }

    public String comer() {
        return "O " + especie + " tem " + tamanho +
                " metros e se alimenta de " + alimentacao;
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

    public String beber() {
        return "Bebendo " + sabor + " de " + idade +
                " anos com teor alcoólico " + teorAlcoolico + "%";
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

    public String encher() {
        return "Copo de " + material + " com " + quantidade +
                "ml custa R$" + preco;
    }
}
