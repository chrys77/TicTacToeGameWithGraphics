import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;
    int counterSigns = 0;

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setTitle("Tic-Tac-Toe, by Dobro");
        frame.setVisible(true);

        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.GREEN);
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setLayout(new BorderLayout());
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(Color.GRAY);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        player1Turn = random.nextInt(2) == 0;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        firstTurn();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (buttons[i].getText().isEmpty()) {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O turn");
                        counterSigns++;
                        check();
                    }
                } else {
                    if (buttons[i].getText().isEmpty()) {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X turn");
                        counterSigns++;
                        check();
                    }
                }
            }
        }
    }


    public void firstTurn() {

        textField.setText(player1Turn ? "X turn" : "O turn");
    }

    public void check() {

        //check X win conditions
        if ((buttons[0].getText().equals(("X"))) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(2, 4, 6);
        }

        //check O win conditions
        if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(2, 4, 6);
        }

        if (counterSigns == 9) {
            draw();
        }

    }

    public void xWins(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins !!!");
        playAgain();
    }

    public void oWins(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins !!!");
        playAgain();
    }

    public void draw() {
        textField.setText("Game draw!");
        playAgain();
    }

    public void playAgain() {

        int response = JOptionPane.showConfirmDialog(null, "Play again?", null, JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {

            for (int i = 0; i < 9; i++) {
                buttons[i].setBackground(Color.BLACK);
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                counterSigns = 0;
            }
            player1Turn = random.nextInt(2) == 0;
            firstTurn();
        } else {

            frame.dispose();
        }


    }

}
