package compositions;

/**
 * Represents a general music composition.
 */
public abstract class MusicComposition {
    private final String title;
    private final int duration; // Duration in seconds
    private final String style;

    /**
     * Constructs a MusicComposition with the specified title, duration, and style.
     *
     * @param title    The title of the composition.
     * @param duration The duration of the composition in seconds.
     * @param style    The musical style of the composition.
     * @throws IllegalArgumentException If title or style is null, or if duration is not positive.
     */
    public MusicComposition(String title, int duration, String style) {
        if (title == null || style == null) {
            throw new IllegalArgumentException("Title and style cannot be null.");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.title = title;
        this.duration = duration;
        this.style = style;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getStyle() {
        return style;
    }

    /**
     * Abstract method to play the composition.
     */
    public abstract void play();
}
