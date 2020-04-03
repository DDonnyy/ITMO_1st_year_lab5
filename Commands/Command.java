package Commands;

import java.io.IOException;

public interface Command {
    abstract public void execute(String par1) throws IOException;
    abstract public String getInfo();
    }

