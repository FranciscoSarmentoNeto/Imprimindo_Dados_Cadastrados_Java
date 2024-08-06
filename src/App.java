import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    static JFrame frame;
    static JTextField nomeField;
    static JTextField telefoneField;
    static JTextArea displayArea;

    public static void main(String[] args) {
        frame = new JFrame("Cadastro de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nomeLabel, constraints);

        nomeField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(nomeField, constraints);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setFont(new Font("Arial", Font.BOLD, 14));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(telefoneLabel, constraints);

        telefoneField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(telefoneField, constraints);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(cadastrarButton, constraints);

        displayArea = new JTextArea(5, 30);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 14));
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(scrollPane, constraints);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });
    }

    private static void cadastrarCliente() {
        String nome = nomeField.getText();
        String telefone = telefoneField.getText();

        Cliente cliente = new Cliente(nome, telefone);
        displayArea.setText("Nome do cliente: " + cliente.getNome() + "\nTelefone do cliente: " + cliente.getTelefone());
    }
}
