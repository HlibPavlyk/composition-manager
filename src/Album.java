import compositions.MusicComposition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Represents an album consisting of multiple music compositions.
 */
public class Album {
    private final List<MusicComposition> compositions;

    /**
     * Constructs an empty album.
     */
    public Album() {
        compositions = new ArrayList<>();
    }

    /**
     * Adds a composition to the album.
     *
     * @param composition The music composition to add.
     * @throws IllegalArgumentException If the composition is null.
     */
    public void addComposition(MusicComposition composition) {
        if (composition == null) {
            throw new IllegalArgumentException("Composition cannot be null.");
        }
        compositions.add(composition);
    }

    /**
     * Calculates the total duration of the album.
     *
     * @return The total duration in seconds.
     */
    public int calculateTotalDuration() {
        int totalDuration = 0;
        for (MusicComposition composition : compositions) {
            totalDuration += composition.getDuration();
        }
        return totalDuration;
    }

    /**
     * Sorts the compositions in the album by their style.
     */
    public void sortCompositionsByStyle() {
        compositions.sort(Comparator.comparing(MusicComposition::getStyle));
    }

    /**
     * Finds compositions within a specified duration range.
     *
     * @param minDuration The minimum duration in seconds.
     * @param maxDuration The maximum duration in seconds.
     * @return A list of compositions within the duration range.
     * @throws IllegalArgumentException If minDuration or maxDuration is negative, or minDuration > maxDuration.
     */
    public List<MusicComposition> findCompositionsByDurationRange(int minDuration, int maxDuration) {
        if (minDuration < 0 || maxDuration < 0) {
            throw new IllegalArgumentException("Duration values must be non-negative.");
        }
        if (minDuration > maxDuration) {
            throw new IllegalArgumentException("Minimum duration cannot be greater than maximum duration.");
        }
        List<MusicComposition> result = new ArrayList<>();
        for (MusicComposition composition : compositions) {
            int duration = composition.getDuration();
            if (duration >= minDuration && duration <= maxDuration) {
                result.add(composition);
            }
        }
        return result;
    }

    /**
     * Retrieves the list of compositions in the album.
     *
     * @return The list of compositions.
     */
    public List<MusicComposition> getCompositions() {
        return compositions;
    }
}
