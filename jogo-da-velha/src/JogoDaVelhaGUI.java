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

public JogoDaVelhaGUI() {
        placarJogadorX = 0;
        placarJogadorO = 0;
        placarLabel = new JLabel("Placar: " + nomeJogadorX + " " + placarJogadorX + " - " + placarJogadorO + " " + nomeJogadorO);
        placarLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        placarLabel.setHorizontalAlignment(SwingConstants.CENTER);

        solicitarNomesJogadores();
        jogadorAtual = 'X'; // Inicia com o jogador X
        setTitle("Jogo da Velha - " + nomeJogadorX + " vs " + nomeJogadorO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel tabuleiroPanel = new JPanel(new GridLayout(3, 3));
        botoes = new JButton[3][3];
        tabuleiro = new char[3][3];

        // botões do tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j] = new JButton("");
                botoes[i][j].setFont(new Font("Arial", Font.PLAIN, 48));
                botoes[i][j].addActionListener(this);
                tabuleiroPanel.add(botoes[i][j]);
                tabuleiro[i][j] = ' ';
            }
        }

        add(placarLabel, BorderLayout.NORTH); // Adiciona o placar na parte superior
        add(tabuleiroPanel, BorderLayout.CENTER); // Adiciona o tabuleiro no centro

        setVisible(true); // Torna a janela visível
    }

    private void solicitarNomesJogadores() {
        nomeJogadorX = JOptionPane.showInputDialog("Digite o nome do jogador X:");
        nomeJogadorO = JOptionPane.showInputDialog("Digite o nome do jogador O:");

        // Garante que os nomes dos jogadores sejam diferentes
        while (nomeJogadorX.equals(nomeJogadorO)) {
            JOptionPane.showMessageDialog(this, "Os nomes dos jogadores devem ser diferentes.");
            nomeJogadorO = JOptionPane.showInputDialog("Digite o nome do jogador O:");
        }
    }
