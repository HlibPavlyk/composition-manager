package compositions;

/**
 * Represents a rock music composition.
 */
public class RockSong extends MusicComposition {

    /**
     * Constructs a RockSong with the specified title and duration.
     *
     * @param title    The title of the rock song.
     * @param duration The duration of the rock song in seconds.
     */
    public RockSong(String title, int duration) {
        super(title, duration, "Rock");
    }

    @Override
    public void play() {
        System.out.println("Playing rock song: " + getTitle());
    }
}
