import compositions.ClassicalPiece;
import compositions.JazzPiece;
import compositions.MusicComposition;
import compositions.RockSong;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the functionality of the MusicCompositionList and MusicComposition classes.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Create an empty MusicCompositionList
            MusicCompositionList compositionList = new MusicCompositionList();

            // Add compositions to the list using the add method
            compositionList.add(new RockSong("Rock Anthem", 300));
            compositionList.add(new JazzPiece("Smooth Jazz", 250));
            compositionList.add(new ClassicalPiece("Symphony No.5", 600));

            // Create a MusicCompositionList with a single composition
            MusicComposition singleComposition = new RockSong("Rock Ballad", 200);
            MusicCompositionList singleCompositionList = new MusicCompositionList(singleComposition);

            // Create a standard collection of compositions
            List<MusicComposition> standardList = new ArrayList<>();
            standardList.add(new JazzPiece("Jazz Fusion", 400));
            standardList.add(new ClassicalPiece("Piano Sonata No.16", 500));

            // Create a MusicCompositionList from a standard collection
            MusicCompositionList collectionCompositionList = new MusicCompositionList(standardList);

            // Combine all compositions into one list
            compositionList.addAll(singleCompositionList);
            compositionList.addAll(collectionCompositionList);

            // Display all compositions
            System.out.println("All compositions in the list:");
            for (MusicComposition comp : compositionList) {
                System.out.println(comp.getStyle() + ": " + comp.getTitle() + " (" + comp.getDuration() + " seconds)");
            }
            System.out.println();

            // Calculate total duration
            int totalDuration = 0;
            for (MusicComposition comp : compositionList) {
                totalDuration += comp.getDuration();
            }
            System.out.println("Total duration of compositions in the list: " + totalDuration + " seconds");

            System.out.println();

            // Remove a composition
            compositionList.remove(singleComposition);
            System.out.println("After removing " + singleComposition.getTitle() + ":");
            for (MusicComposition comp : compositionList) {
                System.out.println(comp.getStyle() + ": " + comp.getTitle());
            }
            System.out.println();

            // Check if the list contains a composition
            MusicComposition searchComposition = new ClassicalPiece("Symphony No.5", 600);
            boolean contains = compositionList.contains(searchComposition);
            System.out.println("List contains '" + searchComposition.getTitle() + "': " + contains);
            System.out.println();

            // Get composition at index
            int index = 2;
            MusicComposition compAtIndex = compositionList.get(index);
            System.out.println("Composition at index " + index + ": " + compAtIndex.getTitle());
            System.out.println();

            // Set composition at index
            compositionList.set(index, new RockSong("New Rock Song", 350));
            System.out.println("After setting a new composition at index " + index + ":");
            for (MusicComposition comp : compositionList) {
                System.out.println(comp.getStyle() + ": " + comp.getTitle());
            }
            System.out.println();

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index Error: " + e.getMessage());
        } catch (Exception e) {
            // Catching any other unforeseen exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
