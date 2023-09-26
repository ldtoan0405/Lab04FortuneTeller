import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;
    private JTextArea fortuneTextArea;

    public FortuneTellerFrame() {
        // Set up frame properties
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 400);

        // Top panel
        JLabel titleLabel = new JLabel("Fortune Teller", SwingConstants.CENTER);
        ImageIcon fortuneTellerIcon = new ImageIcon("fortuneteller.png");
        titleLabel.setIcon(fortuneTellerIcon);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 48));

        // Middle panel
        fortuneTextArea = new JTextArea();
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        scrollPane.setPreferredSize(new Dimension(400, 200));
        fortuneTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

        // Bottom panel
        JButton fortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        fortuneButton.setFont(new Font("Arial", Font.BOLD, 20));
        quitButton.setFont(new Font("Arial", Font.BOLD, 20));

        // Arrange components using BorderLayout
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Create an ArrayList of fortunes
        fortunes = new ArrayList<>();
        fortunes.add("You will find a pot of gold at the end of a rainbow.");
        fortunes.add("An unexpected visitor will soon bring you good news.");
        fortunes.add("Never back down, never give up.");
        fortunes.add("Something you lost will turn up soon.");
        fortunes.add("A financial windfall is headed your way.");
        fortunes.add("The best is yet to come, keep your head up.");
        fortunes.add("A new friendship will enrich your life in unexpected ways.");
        fortunes.add("Good things come to those who wait, but better things come to those who take action.");
        fortunes.add("Trust your instincts, they will not lead you astray.");
        fortunes.add("The key to success is to believe in your abilities.");

        // ActionListener for the "Read My Fortune!" button
        fortuneButton.addActionListener(e -> {
            String fortune = getRandomFortune();
            fortuneTextArea.append(fortune + "\n");
        });

        // ActionListener for the "Quit" button
        quitButton.addActionListener(e -> System.exit(0));
    }

    private String getRandomFortune() {
        Random rand = new Random();
        int randomIndex;
        do {
            randomIndex = rand.nextInt(fortunes.size());
        } while (randomIndex == lastFortuneIndex);
        lastFortuneIndex = randomIndex;
        return fortunes.get(randomIndex);
    }
}
