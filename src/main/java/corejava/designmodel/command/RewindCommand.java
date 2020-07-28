package corejava.designmodel.command;

public class RewindCommand implements Command {

    AudioPlayer audioPlayer;

    public RewindCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        audioPlayer.rewind();
    }
}
