package compositions;

/**
 * Represents a jazz music composition.
 */
public class JazzPiece extends MusicComposition {

    /**
     * Constructs a JazzPiece with the specified title and duration.
     *
     * @param title    The title of the jazz piece.
     * @param duration The duration of the jazz piece in seconds.
     */
    public JazzPiece(String title, int duration) {
        super(title, duration, "Jazz");
    }

    @Override
    public void play() {
        System.out.println("Playing jazz piece: " + getTitle());
    }
}
