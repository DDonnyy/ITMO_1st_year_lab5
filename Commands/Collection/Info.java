package Commands.Collection;

import Commands.Command;
import Ticket.TicketCollection;
import Utility.Invoker;

import java.io.IOException;

public class Info implements Command {
    public Info(){
        Invoker.regist("info",this);

    }

    @Override
    public void execute(String par1) throws IOException {
        TicketCollection ticketCollection = new TicketCollection();
        ticketCollection.getInfo();
    }

    @Override
    public String getInfo() {
        return "---> Вывести информацию об коллекции.";
    }
}
