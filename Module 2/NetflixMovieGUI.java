import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NetflixMovieGUI {
    private JFrame frame;
    private JTextField titleField, genreField, yearField, directorField, actorField, actressField, languageField, durationField, ratingField, ageRestrictionField;
    private JTextField seasonsField, episodesField;
    private JTextArea outputArea;
    private JComboBox<String> contentTypeBox;
    private JButton submitButton, clearButton;
    
    public NetflixMovieGUI() {
        frame = new JFrame("Netflix Movie Management");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(14, 2));
        
        frame.add(new JLabel("Content Type:"));
        contentTypeBox = new JComboBox<>(new String[]{"Movie", "Series"});
        frame.add(contentTypeBox);
        
        frame.add(new JLabel("Title:"));
        titleField = new JTextField();
        frame.add(titleField);
        
        frame.add(new JLabel("Genre:"));
        genreField = new JTextField();
        frame.add(genreField);
        
        frame.add(new JLabel("Release Year:"));
        yearField = new JTextField();
        frame.add(yearField);
        
        frame.add(new JLabel("Director:"));
        directorField = new JTextField();
        frame.add(directorField);
        
        frame.add(new JLabel("Main Actor:"));
        actorField = new JTextField();
        frame.add(actorField);
        
        frame.add(new JLabel("Main Actress:"));
        actressField = new JTextField();
        frame.add(actressField);
        
        frame.add(new JLabel("Language:"));
        languageField = new JTextField();
        frame.add(languageField);
        
        frame.add(new JLabel("Duration (min):"));
        durationField = new JTextField();
        frame.add(durationField);
        
        frame.add(new JLabel("IMDb Rating:"));
        ratingField = new JTextField();
        frame.add(ratingField);
        
        frame.add(new JLabel("Viewer Restriction:"));
        ageRestrictionField = new JTextField();
        frame.add(ageRestrictionField);
        
        frame.add(new JLabel("Number of Seasons:"));
        seasonsField = new JTextField();
        seasonsField.setEnabled(false);
        frame.add(seasonsField);
        
        frame.add(new JLabel("Number of Episodes:"));
        episodesField = new JTextField();
        episodesField.setEnabled(false);
        frame.add(episodesField);
        
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        frame.add(submitButton);
        frame.add(clearButton);
        
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea));
        
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
