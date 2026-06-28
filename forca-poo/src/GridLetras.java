import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GridLetras extends JPanel {
    private char letraPressionada;

    public GridLetras(DesenhoForca forca) {
        super();
        this.setLayout(new GridLayout(3, 9));   // Layout de grid para todas as letras

        // Vetor de botões para cada letra
        JButton[] botoesLetras = new JButton[26];
        for (int i = 0; i < 26; i++) {
            final int index = i;
            final char letra = (char) (i + 65); // Letra correspondente
            botoesLetras[i] = new JButton(String.valueOf(letra));

            // Ação ao ser apertado
            botoesLetras[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    letraPressionada = letra;       // Retorna a letra digitado

                    // Torna o botão inacessível e altera a aparência dele
                    botoesLetras[index].setEnabled(false);
                    botoesLetras[index].setOpaque(false);
                    botoesLetras[index].setContentAreaFilled(false);
                    botoesLetras[index].setBorderPainted(true);
                }
            });

            this.add(botoesLetras[i]);
        }

        // Adiciona um KeyListener para capturar eventos do teclado
        this.setFocusable(true);
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                char tecla = Character.toUpperCase(e.getKeyChar()); // Captura a tecla pressionada em maiúsculo

                if (tecla >= 'A' && tecla <= 'Z') {
                    int index = tecla - 'A'; // Calcula o índice do botão correspondente
                    botoesLetras[index].doClick(); // Simula o clique no botão
                }
            }
        });
    }

    public char getLetraPressionada() {
        return letraPressionada;
    }

    public void resetLetraPressionada() {
        letraPressionada = '\0';
    }
}