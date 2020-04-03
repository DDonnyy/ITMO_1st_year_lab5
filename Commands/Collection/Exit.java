package Commands.Collection;

import Commands.Command;
import Utility.Invoker;

import java.io.IOException;

public class Exit implements Command {
    public Exit(){
        Invoker.regist("exit",this);
    }
    @Override
    public void execute(String par1) throws IOException {
        System.exit(0);
    }

    @Override
    public String getInfo() {
        return "---> Выход из программы(без сохранения в файл).";
    }
}
