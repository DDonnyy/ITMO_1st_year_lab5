package Commands.Collection;

import Commands.Command;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.Decoder;
import Utility.Invoker;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class AverageOfPrice implements Command {
    public AverageOfPrice(){
        Invoker.regist("average_of_price",this);
    }

    @Override
    public void execute(String par1) throws IOException {
        double price = 0;
        TicketCollection ticketCollection = new TicketCollection();
        Iterator it = ticketCollection.getTickets().entrySet().iterator();
        if (ticketCollection.getSize()>0) {
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                price += ((Ticket) pair.getValue()).getPrice();
            }
            System.out.println("Средняя цена за билет = " + (price / ticketCollection.getSize()));
            System.out.print("$ ");
        } else{
            System.out.println("Коллекция пуста,средней цены нет :(");System.out.print("$ ");
        }

    }

    @Override
    public String getInfo() {
        return "---> Возвращает среднюю цену всех билетов";
    }
}
