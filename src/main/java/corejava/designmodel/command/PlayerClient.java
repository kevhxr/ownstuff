package corejava.designmodel.command;

public class PlayerClient {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);

        KeyPadRequestor keypad = new KeyPadRequestor();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);

        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();

        System.out.println();
        System.out.println();

        MacroCommand marco = new AudioMacroCommand();
        marco.add(playCommand);
        marco.add(rewindCommand);
        marco.add(stopCommand);
        marco.execute();
    }
}
