import compositions.ClassicalPiece;
import compositions.JazzPiece;
import compositions.MusicComposition;
import compositions.RockSong;

import java.util.List;

/**
 * Demonstrates the functionality of the Album and MusicComposition classes.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Album album = new Album();

            // Adding compositions to the album
            album.addComposition(new RockSong("Rock Anthem", 300));
            album.addComposition(new JazzPiece("Smooth Jazz", 250));
            album.addComposition(new ClassicalPiece("Symphony No.5", 600));
            album.addComposition(new RockSong("Rock Ballad", 200));
            album.addComposition(new JazzPiece("Jazz Fusion", 400));

            // Calculate total duration of the album
            int totalDuration = album.calculateTotalDuration();
            System.out.println("Total album duration: " + totalDuration + " seconds.\n");

            // Sort compositions by style
            album.sortCompositionsByStyle();
            System.out.println("Compositions sorted by style:");
            for (MusicComposition comp : album.getCompositions()) {
                System.out.println(comp.getStyle() + ": " + comp.getTitle());
            }
            System.out.println();

            // Find compositions within a duration range
            int minDuration = 200;
            int maxDuration = 500;
            List<MusicComposition> foundCompositions = album.findCompositionsByDurationRange(minDuration, maxDuration);
            System.out.println("Compositions between " + minDuration + " and " + maxDuration + " seconds:");
            for (MusicComposition comp : foundCompositions) {
                System.out.println(comp.getTitle() + " - " + comp.getDuration() + " seconds (" + comp.getStyle() + ")");
            }
            System.out.println();

            // Playing all compositions
            System.out.println("Playing all compositions:");
            for (MusicComposition comp : album.getCompositions()) {
                comp.play();
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Catching any other unforeseen exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
