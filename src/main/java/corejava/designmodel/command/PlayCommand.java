package corejava.designmodel.command;

public class PlayCommand implements Command {

    AudioPlayer audioPlayer;

    public PlayCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        audioPlayer.play();
    }
}
