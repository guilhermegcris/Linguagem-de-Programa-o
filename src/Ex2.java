import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
// =====================
// MAIN
// =====================
public class Ex2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal());
    }
}

// =====================
// Tela Principal
// =====================
class TelaPrincipal extends JFrame {
    public TelaPrincipal() {
        setTitle("Música: Corra, Djonga");
        setSize(400, 200);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnPovo = new JButton("Cadastrar Povo");
        JButton btnEmprego = new JButton("Cadastrar Emprego");
        JButton btnDinheiro = new JButton("Cadastrar Dinheiro");

        add(btnPovo);
        add(btnEmprego);
        add(btnDinheiro);

        btnPovo.addActionListener(e -> new PovoGUI());
        btnEmprego.addActionListener(e -> new EmpregoGUI());
        btnDinheiro.addActionListener(e -> new DinheiroGUI());

        setLocationRelativeTo(null); // centralizar janela
        setVisible(true);
    }
}

// =====================
// GUI Povo
// =====================
class PovoGUI extends JFrame {
    private JTextField nomeField, origemField, qtdField;

    public PovoGUI() {
        setTitle("Cadastro de Povo");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só esta janela

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Origem:"));
        origemField = new JTextField();
        add(origemField);

        add(new JLabel("Quantidade:"));
        qtdField = new JTextField();
        add(qtdField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String origem = origemField.getText();
            int quantidade = Integer.parseInt(qtdField.getText());

            Povo povo = new Povo(nome, origem, quantidade);
            povo.existir();
            UtilCSV.salvar("povo.csv", nome + ";" + origem + ";" + quantidade);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// GUI Emprego
// =====================
class EmpregoGUI extends JFrame {
    private JTextField cargoField, salarioField, turnoField;

    public EmpregoGUI() {
        setTitle("Cadastro de Emprego");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Cargo:"));
        cargoField = new JTextField();
        add(cargoField);

        add(new JLabel("Salário:"));
        salarioField = new JTextField();
        add(salarioField);

        add(new JLabel("Turno:"));
        turnoField = new JTextField();
        add(turnoField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            String cargo = cargoField.getText();
            double salario = Double.parseDouble(salarioField.getText());
            String turno = turnoField.getText();

            Emprego emprego = new Emprego(cargo, salario, turno);
            emprego.exercer();
            UtilCSV.salvar("emprego.csv", cargo + ";" + salario + ";" + turno);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// GUI Dinheiro
// =====================
class DinheiroGUI extends JFrame {
    private JTextField valorField, poderField, moedaField;

    public DinheiroGUI() {
        setTitle("Cadastro de Dinheiro");
        setSize(400, 200);
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Valor:"));
        valorField = new JTextField();
        add(valorField);

        add(new JLabel("Poder Aquisitivo:"));
        poderField = new JTextField();
        add(poderField);

        add(new JLabel("Moeda:"));
        moedaField = new JTextField();
        add(moedaField);

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        salvarButton.addActionListener(e -> {
            double valor = Double.parseDouble(valorField.getText());
            String poder = poderField.getText();
            String moeda = moedaField.getText();

            Dinheiro dinheiro = new Dinheiro(valor, poder, moeda);
            dinheiro.comprar();
            UtilCSV.salvar("dinheiro.csv", valor + ";" + poder + ";" + moeda);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// =====================
// Utilitário para salvar CSV
// =====================
class UtilCSV {
    public static void salvar(String nomeArquivo, String linha) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(linha + "\n");
            JOptionPane.showMessageDialog(null, "Registro salvo em " + nomeArquivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }
}

// =====================
// Classes de Domínio
// =====================
class Povo {
    private String nome;
    private String sentimento;
    private int quantidade;

    public Povo(String nome, String sentimento, int quantidade) {
        this.nome = nome;
        this.sentimento = sentimento;
        this.quantidade = quantidade;
    }

    public void existir() {
        System.out.println(nome + " existe com sentimento de " + sentimento +
                " e possui " + quantidade + " habitantes.");
    }
}

class Emprego {
    private String cargo;
    private double salario;
    private String turno;

    public Emprego(String cargo, double salario, String turno) {
        this.cargo = cargo;
        this.salario = salario;
        this.turno = turno;
    }

    public void exercer() {
        System.out.println("Exercendo cargo de " + cargo +
                " no turno " + turno + " com salário " + salario);
    }
}

class Dinheiro {
    private double valor;
    private String poderAquisitivo;
    private String moeda;

    public Dinheiro(double valor, String poderAquisitivo, String moeda) {
        this.valor = valor;
        this.poderAquisitivo = poderAquisitivo;
        this.moeda = moeda;
    }

    public void comprar() {
        System.out.println("Comprando algo por " + valor + " " + moeda +
                " (poder aquisitivo " + poderAquisitivo + ")");
    }
}