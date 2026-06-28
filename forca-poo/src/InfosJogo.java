import javax.swing.*;
import java.awt.*;

public class InfosJogo extends JPanel {
    private int total;
    private int hits;
    private int fails;
    private int chutes;

    private JLabel score;
    private JLabel chutesRestantes;

    public InfosJogo() {
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Componente de informações do jogo
        score = new JLabel();
        atualizarScore();
        score.setFont(new Font("Arial", java.awt.Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(score, gbc); // Adiciona o componente centralizado

        // Componente de chutes restantes
        chutesRestantes = new JLabel();
        this.chutesRestantes.setText("              Chutes restantes: " + 6);
        gbc.gridx = 2;
        chutesRestantes.setFont(new Font("Arial", java.awt.Font.BOLD, 18));
        this.add(chutesRestantes, gbc);
    }

    // Getters e setters
    public int getTotal() {
            return total;
    }

    public void setTotal(int total) {
        this.total = total;
        atualizarScore();
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
        atualizarScore();
    }

    public int getFails() {
        return fails;
    }

    public void setFails(int fails) {
        this.fails = fails;
        atualizarScore();
    }

    public void setScore(int total, int hits, int fails){
        this.total = total;
        this.hits = hits;
        this.fails = fails;
        atualizarScore();
    }

    public void setChutes(int chutes){
        this.chutes = chutes;
        atualizarChutes();
    }

    // Atualiza o componente dos dados
    public void atualizarScore(){
        this.score.setText("Total Score: " + total + "  Hits: " + hits + "  Fails: " + fails);
        repaint();
    }

    // Atualiza o componente dos chutes
    public void atualizarChutes(){
        this.chutesRestantes.setText("              Chutes restantes: " + chutes);
        repaint();
    }
}
