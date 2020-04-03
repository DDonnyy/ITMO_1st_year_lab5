package Ticket;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Ticket {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //time.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) форматирование даты
    private Float price; //Поле может быть null, Значение поля должно быть больше 0
    private String comment; //Поле не может быть null
    private TicketType type; //Поле не может быть null
    private Person person; //Поле не может быть null
    private Long MapKey;
    private DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Long getMapKey() {
        return MapKey;
    }

    public void setMapKey(Long mapKey) {
        MapKey = mapKey;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate() {
        ZonedDateTime time = ZonedDateTime.now();
        this.creationDate = time;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }
    public class Coordinates {
    private Long x; //Максимальное значение поля: 297, Поле не может быть null
    private Integer y; //Поле не может быть null

        public Long getX() {
            return x;
        }

        public void setX(Long x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }
    }
public class Person {
    private String passportID; //Длина строки не должна быть больше 24, Значение этого поля должно быть уникальным, Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле не может быть null

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID() {
        this.passportID = String.valueOf(this.hashCode());
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
public class Location {
    private int x;
    private Double y; //Поле не может быть null
    private String name; //Поле не может быть null

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public enum TicketType {
    VIP,
    USUAL,
    BUDGETARY,
    CHEAP;
}
public enum Color {
    GREEN,
    BLACK,
    DARKBROWN,
    BLUE;
}
public enum Country {
    RUSSIA,
    UNITED_KINGDOM,
    FRANCE,
    NORTH_KOREA,
    JAPAN;
}
public String getTicket(){
    return ("Полная информация о билете №"+this.getMapKey()+"\nНазвание:"+this.getName()+"\nКоординаты Х и У:"+this.coordinates.getX()+" И "+this.coordinates.getY()+"\nВремя создания билета:"+this.getCreationDate().format(formatter)+"\nЦена:"+this.getPrice()+"\nКомментарий:"+this.getComment()+"\nТип билета:"+this.getType()+"\nИнформация о человеке:\n   Паспорт номер:"+this.person.getPassportID()+"\n   Цвет волос:"+this.person.getHairColor()+"\n   Национальность:"+this.person.getNationality()+"\n   Родной город:"+this.person.location.getName()+"\n   Координаты города Х и У:"+this.person.location.getX()+" и "+this.person.location.getY());
}
public String getCsvTicket(){
        return(this.getName()+","+this.getCoordinates().getX()+","+this.getCoordinates().getY()+","+this.getPrice()+","+this.getComment()+","+this.getType()+","+this.getPerson().getHairColor()+","+this.getPerson().getNationality()+","+this.getPerson().getLocation().getX()+","+this.getPerson().getLocation().getY()+","+this.getPerson().getLocation().getName());
}
}