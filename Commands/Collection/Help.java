package Commands.Collection;

import Commands.Command;
import Utility.Invoker;

import java.io.IOException;
import java.util.Map;

public class Help implements Command {
public Help(){
    Invoker.regist("help",this);
}
    @Override
    public void execute(String par1) throws IOException {
        Map<String,Command> commands = Invoker.getCommandCollection();
        for (Map.Entry<String,Command> entry:commands.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue().getInfo());
        }
        System.out.print("$ ");
    }

    @Override
    public String getInfo() {
        return "---> Вывести справку по доступным командам.";
    }

}

