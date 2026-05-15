package hust.soict.dsai.aims.media;

public class Track implements Playable {

    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

@Override
public void play() {

    if (this.length > 0) {

        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length);

    } else {

        System.out.println("ERROR: Track length is non-positive");
    }
}

@Override
public boolean equals(Object obj) {

    if (this == obj) {
        return true;
    }

    if (!(obj instanceof Track)) {
        return false;
    }

    Track other = (Track) obj;

    return this.title.equals(other.title)
            && this.length == other.length;
}

public static void main(String[] args) {

    Track t1 = new Track("Song", 200);
    Track t2 = new Track("Song", 200);

    CompactDisc cd = new CompactDisc(
            1,
            "Best Hits",
            "Music",
            20f,
            0,
            "Director",
            "Artist"
    );

    cd.addTrack(t1);
    cd.addTrack(t2);

    cd.play();
    System.out.println(t1.equals(t2));
}
}