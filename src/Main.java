/**
 * Created by Dell on 26-Jan-16.
 */
public class Main {
    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        if(args.length < 2){
            System.out.println("Don't forget the instrument and note args");
        }else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
    }
}
