/**
 * Created by Dell on 26-Jan-16.
 */
import javax.sound.midi.*;

public class MiniMusicCmdLine {

    public void play(int instrument, int note) {
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);
            ShortMessage b = new ShortMessage();
            a.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(sequence);
            player.start();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
