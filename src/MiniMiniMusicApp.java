/**
 * Created by Dell on 26-Jan-16.
 */
import javax.sound.midi.*;

public class MiniMiniMusicApp {
    public void play() {
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, 102, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 0);
            track.add(changeInstrument);
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);
            ShortMessage b = new ShortMessage();
            a.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(sequence);
            player.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
