package Commands.Collection;

import Commands.Command;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.Invoker;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FilterByPrice implements Command {
   public FilterByPrice(){
        Invoker.regist("filter_by_price",this);
    }

    @Override
    public void execute(String par1) throws IOException {
        try { if(par1==null&&ExecuteScript.inExecution){
            System.out.println("Цена для усреднения не была указана,выполнение команды невозможно.");
        }
          else  if (par1 == null){
                Scanner scanner = new Scanner(System.in);
                String key;
                System.out.println("Введите цену для фильтрации.");
                System.out.print("$ ");
                key = scanner.nextLine();
                if (key.equals("") || key == null) {System.out.println("Цена не может быть null");this.execute(par1);}
                else this.execute(key);
            }
            else {
                TicketCollection ticketCollection = new TicketCollection();
                Double key = Double.parseDouble(par1);
                Iterator it = ticketCollection.getTickets().entrySet().iterator();
                int count=0;
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    Ticket ticket = (Ticket) pair.getValue();
                    Double currentPrice = Double.valueOf(ticket.getPrice());
                    if (currentPrice.equals(key)) {
                        count++;
                        System.out.println("Билет №"+((Ticket) pair.getValue()).getMapKey()+" иммет цену "+key);
                    }
                    }
                if (count==0){
                    System.out.println("Билетов с ценой "+key+ " нету в коллекции.");

                }
                System.out.print("$ ");
            }
        } catch (NumberFormatException|NullPointerException e){
            System.out.println("Цена указана некорректно,попробуйте ещё раз");
            System.out.print("$ ");
        }
    }

    @Override
    public String getInfo() {
        return "---> Вывод билетов с заданной ценой";
    }
}
