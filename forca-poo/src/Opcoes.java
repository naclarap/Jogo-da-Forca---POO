import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Opcoes extends JPanel {
    boolean novaPartida;
    boolean sairDoJogo;

    public Opcoes(){
        super();
        this.setLayout(new GridLayout(1, 3));

        novaPartida = false;
        sairDoJogo = false;

        JButton novaP = new JButton("Nova partida");
        JButton preenche = new JButton();
        preenche.setVisible(false);
        JButton sair = new JButton("Sair do jogo");

        novaP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novaPartida = true;
            }
        });
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sairDoJogo = true;
            }
        });

        this.add(novaP);
        this.add(preenche);
        this.add(sair);
    }

    public boolean isNovaPartida() {
        return novaPartida;
    }

    public void setNovaPartida(boolean novaPartida) {
        this.novaPartida = novaPartida;
    }

    public boolean isSairDoJogo() {
        return sairDoJogo;
    }

    public void setSairDoJogo(boolean sairDoJogo) {
        this.sairDoJogo = sairDoJogo;
    }
}

