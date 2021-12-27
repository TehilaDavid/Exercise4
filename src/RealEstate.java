import java.util.Scanner;

public class RealEstate {
    public final static int SIZE_PHONE_NUMBER = 10;
    private User[] users;
    private Property[] properties;
    private Address[] addresses;


public RealEstate (){
    this.users = new User[0];
    this.properties = new Property[0];

    Address address1 = new Address("TelAviv","HaGibor-HaAlmoni");
    Address address2 = new Address("TelAviv","Rothschild");
    Address address3 = new Address("TelAviv","Dizengoff");
    Address address4 = new Address("Herzelia","Hatzedef");
    Address address5 = new Address("Ashkelon","Kadesh");
    Address address6 = new Address("Ashkelon","Dvor-HaNevi'a");
    Address address7 = new Address("Ashkelon","Shai-Agnon");
    Address address8 = new Address("Ramat-Gan","Ha-Yarden");
    Address address9 = new Address("Jerusalem","Jaffa");
    Address address10 = new Address("Qiryat Shemona","HaBanim");

    Address[] addressArray = {address1,address2,address3,address4,address5,address6,address7,address8,address9,address10};

    this.addresses = addressArray;





}
    //RealEstate – המייצגת את המערכת עצמה. שדות: משתמשים, נכסים, כתובות.
    //בנוסף, תהיה מחלקה ראשית שתהיה אחראית על הצגת התפריט הראשי, כפי שיפורט בהמשך.


    public void createUser (){
        Scanner scanner = new Scanner(System.in);
        String userName;
        String password;
        String phoneNumber;
        int userChoiceIfAgent;

        boolean isStrongPassword;
        boolean userNameExist;
        boolean isValidPhoneNumber;
        boolean isEstateBroker = false;

        do {
            System.out.println("Please enter a user name: ");
            userName = scanner.nextLine();
            userNameExist = isUserNameExist(userName);
            if (userNameExist) {
                System.out.println("Username is already taken");
            }

        }while (userNameExist);


        do {
            System.out.println("Please enter a valid password: ");
            password = scanner.nextLine();
            isStrongPassword = isStrongPassword(password);
            if (!isStrongPassword) {
                System.out.println("The password is not strong");
            }

        }while (!isStrongPassword);


        do {
            System.out.println("Please enter a valid phone number: ");
            phoneNumber = scanner.nextLine();
            isValidPhoneNumber = isValidPhoneNumber(phoneNumber);
            if (!isValidPhoneNumber){
                System.out.println("The phone number is incorrect");
            }

        }while (!isValidPhoneNumber);

        do {
            System.out.println("Are you an Estate Broker  or a regular user?" + "\n" + "if you are an Estate Broker enter 1 else enter 2");
            userChoiceIfAgent = scanner.nextInt();
        }while (userChoiceIfAgent != 1 && userChoiceIfAgent != 2);

        if (userChoiceIfAgent == 1){
            isEstateBroker = true;
        }

        addUserToArray(userName,password,phoneNumber,isEstateBroker);

    }

    public User userLogIn (){
        System.out.println("--Logging in--");
        Scanner scanner = new Scanner(System.in);
        String userNameToCheck;
        String passwordToCheck;


        System.out.println("Enter your username: ");
        userNameToCheck = scanner.nextLine();
        System.out.println("Enter your password: ");
        passwordToCheck = scanner.nextLine();


        for (int i = 0; i < this.users.length; i++) {
            User currentUser = this.users[i];
            if (currentUser.getUserName().equals(userNameToCheck) &&
                    currentUser.getPassword().equals(passwordToCheck)){
                return currentUser;
            }
        }

        return null;

    }



    public boolean postNewProperty(User user) {
        Scanner scanner = new Scanner(System.in);

        //boolean isPosted = false;
        String city;
        String street;
        String type;
        int floor;
        int rooms;
        int propertyNumber;
        boolean forRent;
        int price;
        int userTypeChoice;


        if (mayPostMoreProperties(user)){

            //רשימת ערים + בחירה
            System.out.println("you can post a new property"+"\n"+"please choose a city:");
            printCities(this.addresses);
            city = scanner.nextLine();
            if (!isCityMatches(this.addresses,city)){
                System.out.println("this city isn't exists in our data");
                return false;
            }

            // רשימת רחובות בעיר + בחירה (לא מצליחה להדפיס נורמלי. זה מתחרטש לייי
            System.out.println("streets list:");
            printStreets(city);
            System.out.println("Please Enter the street name:");
            street = scanner.nextLine();
            if (!isStreetMatches(this.addresses,street,city)){
                System.out.println("this street isn't exists in our data");
                return false;
            }

            // יצירת אובייקט מסוג כתובת לשימוש ביצירת נכס. האם כדאי לחפש פשוט במערך את המיקום של הרחוב והעיר במקום ליצור חדש?
            Address addressForPost = new Address(city,street);


            //הכנסת סוג הנכס- דירה בבניין/פנטאהוז/בית פרטי
            do {
                System.out.println("What is the Property type?");
                System.out.println("1- house building -regular apartment");
                System.out.println("2- house building -penthouse");
                System.out.println("3- Private house");
                userTypeChoice = scanner.nextInt();
            }while (userTypeChoice < 1 || userTypeChoice > 3);


            switch (userTypeChoice){
                case 1 :
                    type = "house building -regular apartment";
                    break;
                case 2:
                    type = "house building -penthouse";
                    break;

                default:
                    type = "Private house";
            }

            if (userTypeChoice == 1 || userTypeChoice == 2){
                System.out.println("Please enter the Floor number:");
                floor = scanner.nextInt();
            }else {
                floor = 0;
            }


            //מספר חדרים
            System.out.println("Please enter the Rooms number:");
            rooms = scanner.nextInt();

            //מספר הנכס, אלוהים יודע מה זה אומר
            System.out.println("What is the property number?");
            propertyNumber = scanner.nextInt();


            //   ניראלי צריך לעשות בו ולידציה למספר
            //   האם הנכס למכירה או השכרה?
            int answer;

                System.out.println("is the property for rent or sale?");
                System.out.println("type 1 - forRent" + "\n" + "type 2 -for sale");
                answer = scanner.nextInt();

                if (answer == 2){
                    forRent = false;
                }else{
                    forRent = true;
                }




            // מחיר הנכס
            System.out.println("What is the price?");
            price = scanner.nextInt();

            // העלאת מספר הפוסטים של היוזר באחד כי עד כה התבצעה העלאה מוצלחת
            user.setPosts();

            //הוספת הנכס למערך
            addPropertyToArray(addressForPost,type,floor,rooms,propertyNumber,forRent,price,user);


            System.out.println("the property has successfully posted!");
            return true;


        }else {
            System.out.println("You have reached the limit of properties that you can post");
        }

        return false;
    }

    public void printCities (Address [] addresses){
        int length = addresses.length;

        for (int i = 0; i < length; i++) {
            for (int j = i+1 ; j < length; j++) {
                if (addresses[i].getCity().equals((addresses[j].getCity()))){
                    addresses[j] = addresses[length -1];
                    length--;
                }


            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(addresses[i].getCity());
        }
    }
    public void printStreets (String cityName){
        for (int i = 0; i < this.addresses.length; i++) {
            Address currentAddress = addresses[i];
            if (currentAddress.getCity().equals(cityName)){
                System.out.println(currentAddress.getStreet());
            }

        }
    }

    private boolean isCityMatches (Address[] addresses , String textCity){
        boolean isMatches = false;
        for (int i = 0; i < addresses.length; i++) {
            String currentCity = addresses[i].getCity();
           if (textCity.equals(currentCity)){
               isMatches = true;
           }

        }
        return isMatches;
    }

    private boolean isStreetMatches (Address[] addresses , String street, String city){
        boolean isMatches = false;

        for (int i = 0; i < addresses.length; i++) {
            Address currentAddress = addresses[i];
            if (currentAddress.getCity().equals(city) && currentAddress.getStreet().equals(street)){
                isMatches = true;
            }

        }
        return isMatches;
    }


    private boolean mayPostMoreProperties (User user) {
        boolean isAllowed = false;

        if (user.isEstateBroker() && user.getPosts() <=10){
            isAllowed = true;

        } else if (!user.isEstateBroker() && user.getPosts() <=3) {
            isAllowed = true;
        }

        return isAllowed;

    }

    private boolean isUserNameExist (String userName){
        boolean exist = false;
        for (int i = 0; i < this.users.length; i++) {
            User currentUser = this.users[i];
            if (currentUser.getUserName().equals(userName)){
                exist = true;
            }

        }
        return exist;
    }

    private boolean isStrongPassword (String password){
        boolean strong = false;
        boolean hasChars = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++){
            if (Character.isDigit(password.charAt(i))){
                hasDigit = true;
            }else if (password.charAt(i) == '$' || password.charAt(i)== '%' || password.charAt(i)== '_'){
                hasChars = true;
            }

            if (hasChars && hasDigit){
                strong = true;
                break;
            }
        }
        return strong;
    }

    private boolean isValidPhoneNumber (String phoneNumberToCheck) {
        boolean isCorrect = false;
        boolean validLength = false;
        boolean hasDigits = false;
        boolean isAreaCodeCorrect = false;

        if (phoneNumberToCheck.length() == SIZE_PHONE_NUMBER) {
            validLength = true;
        }

        for (int i = 0; i < phoneNumberToCheck.length(); i++) {
            char currentChar = phoneNumberToCheck.charAt(i);
            if (Character.isDigit(currentChar)){
                hasDigits = true;
            }else {
                hasDigits = false;
                break;
            }
        }

        if (phoneNumberToCheck.charAt(0) == '0' && phoneNumberToCheck.charAt(1) == '5') {
            isAreaCodeCorrect = true;
        }

        if (validLength && hasDigits && isAreaCodeCorrect) {
            isCorrect = true;
        }

        return isCorrect;
    }


    private void addUserToArray (String userName, String password,String phoneNumber, boolean isEstateBroker){
        User[] newArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newArray [i] = this.users[i];
        }
        User userToAdd = new User(userName,password,phoneNumber,isEstateBroker);
        newArray [this.users.length] = userToAdd;
        this.users = newArray;

    }

    private void addPropertyToArray (Address addressForPost, String type, int floor, int rooms, int propertyNumber, boolean forRent, int price,User user){
        Property[] newArray = new Property[this.properties.length +1];
        for (int i = 0; i < this.properties.length; i++) {
            newArray [i] = this.properties[i];
        }
        Property newProperty = new Property(addressForPost,type,floor,rooms,propertyNumber,forRent,price,user);
        newArray [this.properties.length] = newProperty;
        this.properties = newArray;

        System.out.println(newProperty);

    }













}
