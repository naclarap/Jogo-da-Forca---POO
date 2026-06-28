import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class Jogo {
    private String palavra;
    private ArrayList<Character> estado;
    private int erros;

    public Jogo(ArrayList<Character> estado){
        palavra = lerAletatorio();
        this.estado = this.InicializarEstado(estado, palavra);
        erros = 0;
    }

    // Getters e Setters
    public String getPalavra() { return palavra; }
    public void setPalavra(String palavra) { this.palavra = palavra; }
    public ArrayList<Character> getEstado() { return estado; }
    public void setEstado(ArrayList<Character> estado) { this.estado = estado; }
    public int getErros() { return erros; }
    public void setErros(int erros) { this.erros = erros; }

    //Ler arquivo e escolhe uma palavra aleatória a cada jogada
    public String lerAletatorio(){
        //importando arquivo de palavras
        String arquivo = "C:\\Users\\otavi\\OneDrive\\Documentos\\UFOP\\3 Periodo\\POO\\Trabalhos\\TP2\\Forca\\src\\words-pt";
        //armazenando cada palavra
        ArrayList<String> words = new ArrayList<String>();

        //LENDO ARQUIVO TRATANDO EXECEÇÕES
        try(BufferedReader ler = new BufferedReader(new FileReader(arquivo))) {
            //variável local
            String linhas;

            //ler cada linha
            while((linhas = ler.readLine()) != null){
                words.add(linhas.trim()); //adiciona a linha atual e para o \n

            }
        }
        catch(FileNotFoundException e){
            System.out.println("Não foi possível encontrar o arquivo!");
        }
        catch(IOException e){
            System.out.println("Algo deu errado!");
        }
        //ESCOLHENDO UMA PALAVRA ALEATÓRIA
        Random aleatoria = new Random();

        //gerando palavra dentro do intervalo e guardando na variável classe
        return words.get(aleatoria.nextInt(words.size()));
    }

    //Inicializa o estado inicial da palavra com '_'
    public ArrayList<Character> InicializarEstado(ArrayList<Character> estado, String palavra){
        for (int i = 0; i < palavra.length(); i++) {
            estado.add('_');
        }
        return estado;
    }

    //Função que verifica se a letra está na palavra ou não
    public boolean processarTentativa(char letra) {
        boolean acertou = false;
        letra = removerAcentos(Character.toLowerCase(letra));


        for (int i = 0; i < palavra.length(); i++) {
            //verifica a correspondencia exata da letra na palavra
            if (removerAcentos(palavra.charAt(i)) == letra) {
                estado.set(i, letra);
                acertou = true; //acertou a letra
            }
        }
        return acertou; //errou retorna false
    }

    public static char removerAcentos(char ch) {
        String str = String.valueOf(ch);
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").charAt(0);
    }

}
