package corejava.designmodel.command;

public interface MacroCommand extends Command {
    void add(Command cmd);
    void remove(Command cmd);
}
