import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {
    // Elementos da nossa janela
    private InfosJogo infos;
    private DesenhoForca forca;
    private PalavraForca palavra;
    private GridLetras gridLetras;
    private Opcoes opcoes;

    // Construtor da janela (montagem completa)
    public Janela(String titulo){
        super(titulo);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Informações do jogo (Pontuação total, hits, fails)
        infos = new InfosJogo();
        infos.setScore(20, 3, 2);
        infos.atualizarScore();
        gbc.gridx = 0; // Primeira coluna
        gbc.gridy = 0; // Primeira linha
        gbc.anchor = GridBagConstraints.PAGE_START; // Alinhar ao topo-esquerda
        gbc.gridwidth = 3;
        this.add(infos, gbc);

        // Imagem central da forca
        forca = new DesenhoForca();
        gbc.gridy = 1; // Segunda linha
        gbc.gridwidth = 3; // Ocupar duas colunas
        gbc.anchor = GridBagConstraints.CENTER; // Centralizar
        gbc.insets = new Insets(40, 0, 0, 0); // Espaçamento (topo, esquerda, baixo, direita)
        this.add(forca, gbc);

        // Impressão da palavra do jogo
        palavra = new PalavraForca();
        gbc.gridy = 2;
        gbc.gridwidth = 3; // Ocupar três colunas
        gbc.anchor = GridBagConstraints.CENTER; // Centralizar
        this.add(palavra, gbc);

        // Componente de botões de letras
        gridLetras = new GridLetras(forca);
        gbc.gridy = 3; // Segunda linha
        gbc.gridwidth = 3; // Ocupar tres colunas
        gbc.anchor = GridBagConstraints.CENTER; // Centralizar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(gridLetras, gbc);

        // Componente das opções de nova partida ou sair
        opcoes = new Opcoes();
        gbc.gridy = 4; // Terceira linha
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(opcoes, gbc);

        // Propriedades da janela
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    // Getters e Setters
    public InfosJogo getInfos() {
        return infos;
    }

    public void setInfos(InfosJogo infos) {
        this.infos = infos;
    }

    public DesenhoForca getForca() {
        return forca;
    }

    public void setForca(DesenhoForca forca) {
        this.forca = forca;
    }

    public PalavraForca getPalavra() {
        return palavra;
    }

    public void setPalavra(PalavraForca palavra) {
        this.palavra = palavra;
    }

    public GridLetras getGridLetras() {
        return gridLetras;
    }

    public void setGridLetras(GridLetras gridLetras) {
        this.gridLetras = gridLetras;
    }

    public Opcoes getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(Opcoes opcoes) {
        this.opcoes = opcoes;
    }

}
