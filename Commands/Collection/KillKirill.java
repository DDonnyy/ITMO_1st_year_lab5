package Commands.Collection;

import Commands.Command;
import Utility.Invoker;

import java.io.IOException;
public class KillKirill implements Command {
    public KillKirill(){
        Invoker.regist("kill_kirill",this);
    }
    @Override
    public void execute(String par1) throws IOException {
        System.out.println("Кирилл успешно уничтожен."+par1);
        System.out.print("$ ");
    }

    @Override
    public String getInfo() {
        return "уничтожение кирилла";
    }
}
