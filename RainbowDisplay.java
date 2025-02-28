import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class RainbowDisplay extends JFrame {
    private static final int SIZE = 8; // 8x8 grid
    private JPanel[][] squares = new JPanel[SIZE][SIZE];

    public RainbowDisplay() {
        setTitle("Rainbow Board");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

        initializeBoard();
    }

    private void initializeBoard() {
        // Rainbow colors
        Color[] rainbowColors = {
            new Color(255, 0, 0),      // Red
            new Color(255, 165, 0),    // Orange
            new Color(255, 255, 0),    // Yellow
            new Color(0, 255, 0),      // Green
            new Color(0, 0, 255),      // Blue
            new Color(128, 0, 128)     // Purple
        };

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                squares[row][col] = new JPanel(new BorderLayout());

                // Default row assignment
                int colorRow = row;

                // **Move column 0 & 7 down by 2 rows**
                if (col == 0 || col == 7) {
                    colorRow = (row - 2 + SIZE) % SIZE; // Wrap-around
                }
                // **Move column 1 & 6 down by 1 row**
                else if (col == 1 || col == 6) {
                    colorRow = (row - 1 + SIZE) % SIZE; // Wrap-around
                }

                // Assign background colors
                if (colorRow < rainbowColors.length) {
                    squares[row][col].setBackground(rainbowColors[colorRow]);
                } else {
                    squares[row][col].setBackground(Color.WHITE); // Fill empty areas with white
                }

                // Add a black border for separation
                squares[row][col].setBorder(new LineBorder(Color.BLACK, 2));

                add(squares[row][col]);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RainbowDisplay().setVisible(true);
        });
    }
}
