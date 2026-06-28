import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    private static Janela janela;  // Janela principal do jogo
    private static ArrayList<Character> estado;  // Estado da palavra no jogo (letras descobertas ou não)
    private static Jogo jogo;  // Instância do jogo
    private static int erros;  // Contador de erros (tentativas erradas)

    public static void main(String[] args) {
        // Inicia uma nova partida
        novaPartida(0, 0, 0);

        // Loop principal do jogo
        while (!janela.getOpcoes().isSairDoJogo() && !janela.getOpcoes().isNovaPartida()) {
            // Enquanto o número de erros for menor que 6
            while (erros < 6) {
                // Aguarda até que uma letra seja pressionada
                char guess = '\0';
                while (guess == '\0') {
                    guess = janela.getGridLetras().getLetraPressionada();
                    try {
                        Thread.sleep(100); // Pausa para evitar loop excessivo
                    } catch (InterruptedException e) {
                        System.err.println("Thread interrupted: " + e.getMessage());
                    }

                    janela.getGridLetras().requestFocusInWindow(); // Solicita o foco para o painel de letras

                    // Verifica se o usuário quer sair ou iniciar uma nova partida
                    if (janela.getOpcoes().isNovaPartida() || janela.getOpcoes().isSairDoJogo()) {
                        break;
                    }
                }

                // Verifica se o usuário escolheu sair do jogo
                if (janela.getOpcoes().isSairDoJogo()) {
                    ResultadoFinal resultado = new ResultadoFinal(janela.getInfos().getTotal(),
                            janela.getInfos().getHits(), janela.getInfos().getFails());
                    janela.getOpcoes().setSairDoJogo(false);
                    janela.dispose();
                }
                // Caso o usuário queira iniciar uma nova partida
                else if (janela.getOpcoes().isNovaPartida()) {
                    janela.dispose();
                    novaPartida(janela.getInfos().getTotal(), janela.getInfos().getHits(), janela.getInfos().getFails());
                    continue;
                }

                // Processa a tentativa do jogador
                if (jogo.processarTentativa(guess)) {
                    janela.getPalavra().atualizaPalavra("");

                    // Verifica se o jogador venceu (todas as letras foram acertadas)
                    if (!jogo.getEstado().contains('_')) {
                        janela.getPalavra().mudarCor(Color.GREEN);
                        janela.getPalavra().atualizaPalavra("VOCÊ VENCEU!  A palavra correta era: " + jogo.getPalavra());
                        janela.getInfos().setHits(janela.getInfos().getHits() + 1);
                        janela.getInfos().setTotal(janela.getInfos().getTotal() + 10
                                + jogo.getPalavra().length() * 2 - erros);
                        break;
                    }
                } else {
                    erros++;  // Incrementa o contador de erros
                    janela.getInfos().setChutes(6 - erros);
                    janela.getForca().desenharProximaParte();  // Desenha a próxima parte da forca
                }

                // Reseta a letra pressionada
                janela.getGridLetras().resetLetraPressionada();
            }

            // Caso o jogador tenha cometido 6 erros, termina o jogo
            if (erros >= 6) {
                janela.getPalavra().mudarCor(Color.RED);
                janela.getPalavra().atualizaPalavra("GAME OVER!  A palavra correta era: " + jogo.getPalavra());
                janela.getInfos().setFails(janela.getInfos().getFails() + 1);
            }

            // Reseta a letra pressionada
            janela.getGridLetras().resetLetraPressionada();

            // Aguarda até que o jogador escolha se quer sair ou iniciar uma nova partida
            while (!janela.getOpcoes().isSairDoJogo() && !janela.getOpcoes().isNovaPartida()) {
                try {
                    Thread.sleep(100); // Pausa para evitar loop excessivo
                } catch (InterruptedException e) {
                    System.err.println("Thread interrupted: " + e.getMessage());
                }
            }

            // Verifica se o jogador escolheu sair do jogo
            if (janela.getOpcoes().isSairDoJogo()) {
                ResultadoFinal resultado = new ResultadoFinal(janela.getInfos().getTotal(),
                        janela.getInfos().getHits(), janela.getInfos().getFails());
                janela.dispose();
                break;
            }
            // Caso o jogador queira iniciar uma nova partida
            else if (janela.getOpcoes().isNovaPartida()) {
                janela.dispose();
                novaPartida(janela.getInfos().getTotal(), janela.getInfos().getHits(), janela.getInfos().getFails());
                continue;
            }
        }
    }

    // Função para iniciar uma nova partida
    public static void novaPartida(int total, int hits, int fails) {
        // Inicializa a janela principal do programa
        janela = new Janela("Jogo da Forca - POO");
        janela.getInfos().setScore(total, hits, fails);  // Atualiza o score da partida
        estado = janela.getPalavra().getEstado();  // Obtém o estado atual da palavra
        jogo = new Jogo(estado);  // Cria uma nova instância do jogo
        erros = jogo.getErros();  // Reseta o contador de erros

        // Exibe informações de debug
        System.out.println(jogo.getPalavra());
        System.out.println(janela.getPalavra().montaPalavra());
    }
}
