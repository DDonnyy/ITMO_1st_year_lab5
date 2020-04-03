package Ticket;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

public class TicketCollection {
    private static TreeMap<Long, Ticket> tickets = new TreeMap<>();
    private static java.time.ZonedDateTime DateOFCreation;

    public static void setDateOFCreation(ZonedDateTime dateOFCreation) {
        DateOFCreation = dateOFCreation;
    }

    public TreeMap<Long, Ticket> getTickets(){
        return tickets;
    }
    public void setTickets(TreeMap<Long,Ticket> collection){
        tickets = collection;
    }
    public void putTicket(Long key,Ticket ticket){
        tickets.put(key, ticket);
    }
    public void replaceMovie(Long key, Ticket ticket) {
        tickets.replace(key, ticket);
    }
    public void removeTicket(Long key){
        tickets.remove(key);
    }
    public java.util.Set<Long> getKeySet(){
    return tickets.keySet();
    }
    public void getValue(Long key){
        tickets.get(key);
    }
    public Integer getSize(){return tickets.size();}
    public void putAllInCollection(TreeMap<Long,Ticket> collection){ tickets.putAll(collection); }
    public void getInfo() {
        System.out.println("Тип коллекции: TreeMap");
        System.out.println("Количество элементов коллекции: " + tickets.size());
        if (DateOFCreation==null||tickets.size()==0){
            System.out.print("");
        }
            else System.out.println("Дата создания колекции: " + DateOFCreation.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        System.out.print("$ ");
    }

    public Ticket getTicket (Long key){
        return tickets.get(key);
    }
}
