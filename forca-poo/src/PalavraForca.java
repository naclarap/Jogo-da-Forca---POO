import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PalavraForca extends JPanel {
    private ArrayList<Character> estado;

    public PalavraForca() {
        super();

        estado = new ArrayList<>();

        JLabel palavra = new JLabel(this.montaPalavra());
        palavra.setFont(new Font("Arial", java.awt.Font.BOLD, 24)); // Define a fonte e o tamanho do texto

        this.add(palavra);
    }

    public ArrayList<Character> getEstado() {
        return estado;
    }

    public void setEstado(ArrayList<Character> estado) {
        this.estado = estado;
    }

    // Junta todos os caracteres em uma string final
    public String montaPalavra(){
        StringBuilder sb = new StringBuilder();
        for (Character c : estado) {
            sb.append(c).append(' ');
        }

        return sb.toString().trim();
    }

    public void atualizaPalavra(String texto) {
        JLabel palavra = (JLabel) this.getComponent(0);
        if (texto.isEmpty())
            palavra.setText(this.montaPalavra());
        else
            palavra.setText(texto);
        repaint();
    }

    public void mudarCor(Color novaCor) {
        JLabel palavra = (JLabel) this.getComponent(0);
        palavra.setForeground(novaCor);
        repaint();
    }
}