package Commands.Collection;

import Commands.Command;
import Ticket.TicketCollection;
import Utility.Invoker;

import java.io.IOException;

public class Clear implements Command {
    public Clear(){
        Invoker.regist("clear",this);
    }
    TicketCollection ticketCollection = new TicketCollection();
    @Override
    public void execute(String par1) throws IOException {
        if (ticketCollection.getTickets().size()>0){
            ticketCollection.getTickets().clear();
            System.out.println("Коллекция очищена.");
            ticketCollection.setDateOFCreation(null);
        }
        else System.out.println("Коллекция уже пуста.");
        System.out.print("$ ");
    }

    @Override
    public String getInfo() {
        return "---> Очистить коллекцию.";
    }
}
