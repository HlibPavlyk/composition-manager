package compositions;

/**
 * Represents a classical music composition.
 */
public class ClassicalPiece extends MusicComposition {

    /**
     * Constructs a ClassicalPiece with the specified title and duration.
     *
     * @param title    The title of the classical piece.
     * @param duration The duration of the classical piece in seconds.
     */
    public ClassicalPiece(String title, int duration) {
        super(title, duration, "Classical");
    }

    @Override
    public void play() {
        System.out.println("Playing classical piece: " + getTitle());
    }
}
