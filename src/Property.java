public class Property {

    private Address address;
    private int rooms;
    private int price;
    private String type;
    private boolean isForRent;
    private String rentOrSale;
    private int propertyNumber;
    private int floorNumber;
    private User advertiserUser;

    // כתובת
    //מספר חדרים,
    // מחיר
    //סוג,
    // האם להשכרה,
    //מספר הבית,
    //מספר הקומה,
    //המשתמש שפרסם את הנכס

    public Property (Address address, String type , int floorNumber, int rooms, int propertyNumber, boolean isForRent, int price,User advertiserUser){
        this.address = address;
        this.type = type;
        this.floorNumber = floorNumber;
        this.rooms = rooms;
        this.propertyNumber = propertyNumber;
        this.isForRent = isForRent;
        this.price = price;
        this.advertiserUser =advertiserUser;

        if (isForRent){
            this.rentOrSale = "for rent";
        }else {
            this.rentOrSale = "for sale";
        }

    }

    public User getAdvertiserUser (){
        return this.advertiserUser;
    }

    public Address getAddress () {
        return this.address;
    }

    public String toString (){

        return this.address + "\n"+
                "Number of rooms: " + this.rooms +"\n"+
                "Status:" + rentOrSale +"\n" + "type:" +this.type + "\n" +"price: " + this.price + "\n" + advertiserUser;

    }



}
