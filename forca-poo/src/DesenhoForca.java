import javax.swing.*;
import java.awt.*;

public class DesenhoForca extends JPanel {
    private int partesDesenhadas = 0; // Contador de partes do boneco desenhadas

    public DesenhoForca() {
        super();
        this.setPreferredSize(new Dimension(400, 400)); // Define o tamanho do painel
        this.setBackground(Color.WHITE); // Define o fundo branco
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Adiciona uma borda preta de 2px
    }

    public int getPartesDesenhadas() {
        return partesDesenhadas;
    }

    // Metodo responsável por desenhar a forca e as partes do boneco conforme avança o jogo.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(3)); // Espessura das linhas
        g2d.setColor(Color.BLACK); // Cor preta para os desenhos

        int centerX = getWidth() / 2;
        int startY = 50;

        // Desenha a estrutura fixa da forca
        g2d.drawLine(centerX - 110, startY, centerX, startY); // Braço superior
        g2d.drawLine(centerX - 110, startY, centerX - 110, startY + 300); // Poste vertical
        g2d.drawLine(centerX - 150, startY + 300, centerX - 70, startY + 300); // Base inferior
        g2d.drawLine(centerX, startY, centerX, startY + 50); // Corda

        // Desenha as partes do boneco conforme o progresso do jogo
        if (partesDesenhadas > 0) {
            g2d.drawOval(centerX - 25, startY + 50, 50, 50); // Cabeça
        }
        if (partesDesenhadas > 1) {
            g2d.drawLine(centerX, startY + 100, centerX, startY + 200); // Tronco
        }
        if (partesDesenhadas > 2) {
            g2d.drawLine(centerX, startY + 125, centerX - 50, startY + 150); // Braço esquerdo
        }
        if (partesDesenhadas > 3) {
            g2d.drawLine(centerX, startY + 125, centerX + 50, startY + 150); // Braço direito
        }
        if (partesDesenhadas > 4) {
            g2d.drawLine(centerX, startY + 200, centerX - 50, startY + 250); // Perna esquerda
        }
        if (partesDesenhadas > 5) {
            g2d.drawLine(centerX, startY + 200, centerX + 50, startY + 250); // Perna direita

            // X dos olhos
            g2d.drawLine(centerX - 10, startY + 65, centerX - 5, startY + 70); // Olho esquerdo
            g2d.drawLine(centerX - 5, startY + 65, centerX - 10, startY + 70);
            g2d.drawLine(centerX + 10, startY + 65, centerX + 5, startY + 70); // Olho direito
            g2d.drawLine(centerX + 5, startY + 65, centerX + 10, startY + 70);
        }
    }

    public void desenharProximaParte() {
        if (partesDesenhadas < 6) {
            partesDesenhadas++;
            repaint(); // Atualiza o painel para desenhar a nova parte
        }
    }
}
