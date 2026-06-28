# Jogo da Forca — Interface Gráfica em Java

Implementação do clássico jogo da forca em Java, com interface gráfica em Swing/AWT, banco de palavras em português e desenho progressivo do "boneco" conforme os erros. Projeto da disciplina de Programação Orientada a Objetos (UFOP).

> ⚠️ Trabalho desenvolvido em grupo, como parte da disciplina.

## Funcionalidades

- Sorteio aleatório de palavras a partir de um banco de palavras em português (`words-pt`)
- Normalização de texto (remoção de acentos) para comparação de letras
- Desenho incremental da forca a cada erro (até 6 tentativas)
- Tela de resultado final (vitória ou derrota)
- Menu de opções para iniciar nova partida ou sair

## Arquitetura (POO)

| Classe | Responsabilidade |
|---|---|
| `Jogo` | Regras do jogo: sorteio da palavra, controle de estado e erros |
| `PalavraForca` | Representação da palavra e progresso de letras descobertas |
| `Janela` | Janela principal e orquestração da interface |
| `GridLetras` | Componente visual do teclado/grade de letras |
| `DesenhoForca` | Renderização progressiva do desenho da forca |
| `Opcoes` | Controle de opções (nova partida / sair) |
| `InfosJogo` | Exibição de informações da partida em andamento |
| `ResultadoFinal` | Tela de fim de jogo |
| `Main` | Loop principal e orquestração entre as classes |

O projeto separa claramente **modelo** (`Jogo`, `PalavraForca`), **visão** (`Janela`, `GridLetras`, `DesenhoForca`, `ResultadoFinal`) e **controle** (`Main`, `Opcoes`), aplicando encapsulamento e responsabilidade única entre as classes.

## Tecnologias

- **Java** (Swing/AWT para interface gráfica)

## Como executar

```bash
cd src
javac *.java
java Main
```
