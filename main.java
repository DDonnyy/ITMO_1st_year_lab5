import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.Decoder;
import Utility.FileRead;
import Utility.Invoker;
import Commands.Collection.*;

import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {
        Remove_lower remove_lower = new Remove_lower();
        RemoveGreater removeGreater = new RemoveGreater();
        KillKirill killKirill = new KillKirill();
        Exit exit = new Exit();
        Show show = new Show();
        Help help = new Help();
        Clear clear = new Clear();
        Info info = new Info();
        Save save = new Save();
        FilterByPrice filterByPrice = new FilterByPrice();
        AverageOfPrice averageOfPrice = new AverageOfPrice();
        RemoveByKey removeByKey = new RemoveByKey();
        InsertKey insertKey = new InsertKey();
        UpdateBykey updateBykey = new UpdateBykey();
        ExecuteScript executeScript = new ExecuteScript();
        TicketCollection tickets = new TicketCollection();
        tickets.setTickets(Decoder.decodeIntoCollection(FileRead.readFromFile(FileRead.getFilePath())));
        tickets.setDateOFCreation(java.time.ZonedDateTime.now());
        System.out.println("Введите комманду:");
        System.out.print("$ ");
       while(1==1) {
           try{
            String commandName = FileRead.readFromConsole();
               Invoker.execute(commandName);
           } catch (IOException e) {
               e.printStackTrace();
               System.exit(0);
           }
       }
    }
}
