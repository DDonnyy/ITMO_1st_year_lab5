package Utility;

import Commands.Command;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Invoker {
    private static Map<String, Command> commands = new TreeMap<>();
    public static void regist(String name, Command command) {
        commands.put(name, command);
    }
    public static Map<String,Command> getCommandCollection(){
        return commands;
    }
    public static void execute(String s) throws IOException {

        String name[]=s.split(" ");
        Command command = commands.get(name[0]);
        if (s.equals("")){ System.out.print("$ "); }
       else if (command == null || name.length>2){
            System.out.println("Такой команды не существует,попробуйте другую. Для справки введите \"help\"");
            System.out.print("$ ");
       }
        else if (name.length == 1){
            command.execute(null); }
        else if (name.length ==2){
            command.execute(name[1]);
        }
        }

    }

