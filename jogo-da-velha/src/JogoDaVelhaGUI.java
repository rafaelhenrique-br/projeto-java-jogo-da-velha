import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDaVelhaGUI extends JFrame implements ActionListener {
    private JButton[][] botoes; // Matriz de botões para o tabuleiro
    private char[][] tabuleiro; // Matriz que representa o estado do jogo
    private char jogadorAtual; // jogador atual (X ou O)
    private String nomeJogadorX; // Nome do jogador X
    private String nomeJogadorO; // Nome do jogador O
    private int placarJogadorX; // Placar do jogador X
    private int placarJogadorO; // Placar do jogador O
    private JLabel placarLabel; // exibir o placar
