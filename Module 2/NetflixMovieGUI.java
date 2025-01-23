import javax.swing.*;
import java.awt.*;


public class NetflixMovieGUI {
    private JFrame frame;
    private JTextField titleField, genreField, yearField, directorField, actorField, actressField, languageField, durationField, ratingField, ageRestrictionField;
    private JTextField seasonsField, episodesField;
    private JTextArea outputArea;
    private JComboBox<String> contentTypeBox;
    private JButton submitButton, clearButton;
    
    public NetflixMovieGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        frame = new JFrame("Netflix Movie Management");
        frame.setSize(650, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Enter Movie Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        String[] labels = {"Content Type:", "Title:", "Genre:", "Release Year:", "Director:", "Main Actor:", "Main Actress:", "Language:", "Duration (min):", "IMDb Rating:", "Viewer Restriction:", "Number of Seasons:", "Number of Episodes:"};
        JComponent[] components = {
            contentTypeBox = new JComboBox<>(new String[]{"Movie", "Series"}),
            titleField = new JTextField(),
            genreField = new JTextField(),
            yearField = new JTextField(),
            directorField = new JTextField(),
            actorField = new JTextField(),
            actressField = new JTextField(),
            languageField = new JTextField(),
            durationField = new JTextField(),
            ratingField = new JTextField(),
            ageRestrictionField = new JTextField(),
            seasonsField = new JTextField(),
            episodesField = new JTextField()
        };
        
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(new JLabel(labels[i]), gbc);
            
            gbc.gridx = 1;
            components[i].setPreferredSize(new Dimension(300, 25));
            panel.add(components[i], gbc);
        }
        
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.EAST);
        
        contentTypeBox.addActionListener(e -> toggleSeriesFields());
        submitButton.addActionListener(e -> handleSubmit());
        clearButton.addActionListener(e -> clearFields());
        
        frame.setVisible(true);
    }
    
    private void toggleSeriesFields() {
        boolean isSeries = contentTypeBox.getSelectedItem().equals("Series");
        seasonsField.setEnabled(isSeries);
        episodesField.setEnabled(isSeries);
    }
    
    private void handleSubmit() {
        try {
            String title = titleField.getText().trim();
            String genre = genreField.getText().trim();
            int releaseYear = Integer.parseInt(yearField.getText().trim());
            String director = directorField.getText().trim();
            String actor = actorField.getText().trim();
            String actress = actressField.getText().trim();
            String language = languageField.getText().trim();
            int duration = Integer.parseInt(durationField.getText().trim());
            double rating = Double.parseDouble(ratingField.getText().trim());
            int ageRestriction = Integer.parseInt(ageRestrictionField.getText().trim());
            
            if (title.isEmpty() || genre.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Title and Genre cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (rating < 0.0 || rating > 10.0) {
                JOptionPane.showMessageDialog(frame, "IMDb Rating must be between 0.0 and 10.0.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            StringBuilder output = new StringBuilder("Movie Details:\n");
            output.append("Title: ").append(title).append("\n");
            output.append("Genre: ").append(genre).append("\n");
            output.append("Release Year: ").append(releaseYear).append("\n");
            output.append("Director: ").append(director).append("\n");
            output.append("Main Actor: ").append(actor).append("\n");
            output.append("Main Actress: ").append(actress).append("\n");
            output.append("Language: ").append(language).append("\n");
            output.append("Duration: ").append(duration).append(" minutes\n");
            output.append("IMDb Rating: ").append(rating).append("\n");
            output.append("Viewer Restriction: ").append(ageRestriction).append("+");
            
            if (contentTypeBox.getSelectedItem().equals("Series")) {
                int seasons = Integer.parseInt(seasonsField.getText().trim());
                int episodes = Integer.parseInt(episodesField.getText().trim());
                output.append("\nNumber of Seasons: ").append(seasons);
                output.append("\nNumber of Episodes: ").append(episodes);
            }
            
            outputArea.setText(output.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Ensure numbers are used where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearFields() {
        titleField.setText("");
        genreField.setText("");
        yearField.setText("");
        directorField.setText("");
        actorField.setText("");
        actressField.setText("");
        languageField.setText("");
        durationField.setText("");
        ratingField.setText("");
        ageRestrictionField.setText("");
        seasonsField.setText("");
        episodesField.setText("");
        outputArea.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(NetflixMovieGUI::new);
    }
}
