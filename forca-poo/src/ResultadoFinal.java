import javax.swing.*;
import java.awt.*;

public class ResultadoFinal extends JFrame {
    public ResultadoFinal(int total, int hits, int fails) {
        super("Resultado Final");
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel resultado = new JLabel("Resultado Final");
        resultado.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(resultado, gbc);

        JLabel totalLabel = new JLabel("Total: " + total);
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.add(totalLabel, gbc);

        JLabel hitsLabel = new JLabel("Acertos: " + hits);
        hitsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 2;
        this.add(hitsLabel, gbc);

        JLabel failsLabel = new JLabel("Erros: " + fails);
        failsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 3;
        this.add(failsLabel, gbc);

        JButton fechar = new JButton("Fechar");
        fechar.addActionListener(e -> System.exit(0));
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 10, 10, 10);
        this.add(fechar, gbc);

        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}