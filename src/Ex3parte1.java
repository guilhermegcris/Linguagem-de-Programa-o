import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

// =====================
// MAIN
// =====================
public class Ex3parte1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal2());
    }
}

// =====================
// Tela Principal
// =====================
class TelaPrincipal2 extends JFrame {
    public TelaPrincipal2() {
        setTitle("IMAGEM 1: The Bearer Irma");
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnPessoa = new JButton("Cadastrar Pessoa");
        JButton btnLixo = new JButton("Cadastrar Lixo");
        JButton btnTecido = new JButton("Cadastrar Tecido");

        add(btnPessoa);
        add(btnLixo);
        add(btnTecido);

        btnPessoa.addActionListener(e -> new PessoaGUI());
        btnLixo.addActionListener(e -> new LixoGUI());
        btnTecido.addActionListener(e -> new TecidoGUI());

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// GUI Pessoa
// =====================
class PessoaGUI extends JFrame {
    private JTextField nomeField, idadeField, etniaField;

    public PessoaGUI() {
        setTitle("Cadastro de Pessoa");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        add(new JLabel("Etnia:"));
        etniaField = new JTextField();
        add(etniaField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String etnia = etniaField.getText();

            Pessoa pessoa = new Pessoa(nome, idade, etnia);
            pessoa.carregar();
            UtilCSV.salvar("pessoa.csv", nome + ";" + idade + ";" + etnia);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// GUI Lixo
// =====================
class LixoGUI extends JFrame {
    private JTextField qtdField, tipoField, materialField;

    public LixoGUI() {
        setTitle("Cadastro de Lixo");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Quantidade (kg):"));
        qtdField = new JTextField();
        add(qtdField);

        add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        add(tipoField);

        add(new JLabel("Material:"));
        materialField = new JTextField();
        add(materialField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            int quantidade = Integer.parseInt(qtdField.getText());
            String tipo = tipoField.getText();
            String material = materialField.getText();

            Lixo lixo = new Lixo(quantidade, tipo, material);
            lixo.coletar();
            UtilCSV.salvar("lixo.csv", quantidade + ";" + tipo + ";" + material);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// GUI Tecido
// =====================
class TecidoGUI extends JFrame {
    private JTextField valorField, materialField, grossuraField;

    public TecidoGUI() {
        setTitle("Cadastro de Tecido");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Valor:"));
        valorField = new JTextField();
        add(valorField);

        add(new JLabel("Material:"));
        materialField = new JTextField();
        add(materialField);

        add(new JLabel("Grossura:"));
        grossuraField = new JTextField();
        add(grossuraField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            double valor = Double.parseDouble(valorField.getText());
            String material = materialField.getText();
            double grossura = Double.parseDouble(grossuraField.getText());

            Tecido tecido = new Tecido(valor, material, grossura);
            tecido.fabricar();
            UtilCSV.salvar("tecido.csv", valor + ";" + material + ";" + grossura);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// Utilitário para salvar CSV
// =====================
class UtilCSV2 {
    public static void salvar(String nomeArquivo, String linha) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(linha + "\n");
            JOptionPane.showMessageDialog(null, "Registro salvo em " + nomeArquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }
}

// =====================
// Classes de Domínio
// =====================
class Pessoa {
    private String nome;
    private int idade;
    private String etnia;

    public Pessoa(String nome, int idade, String etnia) {
        this.nome = nome;
        this.idade = idade;
        this.etnia = etnia;
    }

    public void carregar() {
        System.out.println(nome + " tem " + idade + " anos e tem origem " + etnia);
    }
}

class Lixo {
    private int quantidade;
    private String tipo;
    private String material;

    public Lixo(int quantidade, String tipo, String material) {
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.material = material;
    }

    public void coletar() {
        System.out.println("Coletando " + quantidade + " quilos de lixo " + tipo + " (" + material + ")");
    }
}

class Tecido {
    private double valor;
    private String material;
    private double grossura;

    public Tecido(double valor, String material, double grossura) {
        this.valor = valor;
        this.material = material;
        this.grossura = grossura;
    }

    public void fabricar() {
        System.out.println("Fabricando tecido de " + material + " com grossura " + grossura);
    }
}