import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userChoice;
        Scanner scanner = new Scanner(System.in);

        RealEstate realEstate = new RealEstate();


        do {
            do {
                System.out.println("To sign up enter 1 to Log-in enter 2 and to Exit enter 3");
                userChoice = scanner.nextInt();

            }while (userChoice > 3 || userChoice <= 0);

            if (userChoice == 1) {
                realEstate.createUser();

            }if (userChoice == 2){
                User loggedUser = realEstate.userLogIn();

                if (loggedUser == null) {
                    System.out.println("Login failed, The username or password is incorrect");
                }else {
                    do {
                        System.out.println("Enter your choice: " +
                                "\n" + "1- Post a new property" +
                                "\n" + "2- Remove property posting" +
                                "\n" + "3- View all property in the system" +
                                "\n" + "4- View all properties posted by you" +
                                "\n" + "5- Search for properties by parameters" +
                                "\n" + "6- Disconnect and return to the main menu");
                        userChoice = scanner.nextInt();
                    }while (userChoice > 6 || userChoice < 1);


                    switch (userChoice) {
                        case 1:
                            realEstate.postNewProperty(loggedUser);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                    }
                }








            }
        }while (userChoice != 3);
    }

//    1 – ליצור חשבון
//2 – להתחבר לחשבון קיים
//3 – לסיים את התוכנית


//        1 – לפרסם נכס חדש
//        2 – להסיר פרסום על נכס
//        3 – להציג את כל הנכסים במערכת
//        4 – להציג את כל הנכסים שפורסמו על ידי המשתמש
//        5 – לחפש נכס לפי פרמטרים
//        6 – להתנתק ולחזור לתפריט הראשי






}






