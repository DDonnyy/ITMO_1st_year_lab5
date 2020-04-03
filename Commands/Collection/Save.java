package Commands.Collection;

import Commands.Command;
import Utility.FileRead;
import Utility.Invoker;
import Utility.SaveInFile;

import java.io.IOException;
import java.util.Scanner;

public class Save implements Command {
    public Save(){
        Invoker.regist("save",this);
    }
    @Override
    public void execute(String par1) throws IOException {
        SaveInFile saveInFile = new SaveInFile();
            Scanner scanner = new Scanner(System.in);
            String answer;
            System.out.println("Желаете сохранить коллекцию в новый файл? (Да/Нет Yes/No)");
            System.out.print("$ ");
            answer = scanner.nextLine();
            if (answer.toUpperCase().equals("ДА")||answer.toUpperCase().equals("YES")) {
                System.out.println("Введите имя файла.");
                System.out.print("$ ");
                answer = scanner.nextLine();
                saveInFile.Saving(answer);
            } else if (answer.toUpperCase().equals("НЕТ")||answer.toUpperCase().equals("NO")){
                if(new FileRead().getFilePath()==null){
                    System.out.println("Изначально не было файла с коллекцией.");
                    System.out.print("$ ");
                } else {
                    saveInFile.Saving(new FileRead().getFilePath());
                    System.out.println("Коллекция сохранена в изначальный файл");
                    System.out.print("$ ");
                }

        }
    }

    @Override
    public String getInfo() {
        return "---> Сохранить коллекцию в исходный файл.";
    }
}
