import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;


public class MP3 {
private String filename = null;

// constructor that takes the name of an MP3 file
public MP3(String filename) {
this.filename = filename;
}

// play the MP3 file to the sound card
public void play() {
try {
FileInputStream fis = new FileInputStream(filename);
BufferedInputStream bis = new BufferedInputStream(fis);
Player player = new Player(bis);
player.play();
}
catch (Exception e) {
System.out.println("Problem playing file " + filename);
System.out.println(e);
}
}


// test client
public static void main(String[] args) {
// String filename = args[0];
String filename = "sample-12s.mp3";
MP3 mp3 = new MP3(filename);
mp3.play();
}

}