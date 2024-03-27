import sun.lwawt.macosx.CSystemTray;

import java.util.Scanner;

public class SchedulingSlots {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String p = "p";
        String s = "s";
        String f = "f";
        String i = "i";
        String g = "g";
        String q = "q";
        printMenu();

        String myArr1[][] = {
                {"11-12", "-", "-", "-", "-"},
                {"12-1", "-", "-", "-", "-"},
                {"1-2", "-", "-", "-", "-"},
                {"2-3", "-", "-", "-", "-"}
        };
        String myArr2[][] = {
                {"11-12", "-", "-", "-", "-"},
                {"12-1", "-", "-", "-", "-"},
                {"1-2", "-", "-", "-", "-"},
                {"2-3", "-", "-", "-", "-"}
        };
        String myArr3[][] = {
                {"11-12", "-", "-", "-", "-"},
                {"12-1", "-", "-", "-", "-"},
                {"1-2", "-", "-", "-", "-"},
                {"2-3", "-", "-", "-", "-"}
        };

        String myArr4[][] = {
                {"11-12", "-", "-", "-", "-"},
                {"12-1", "-", "-", "-", "-"},
                {"1-2", "-", "-", "-", "-"},
                {"2-3", "-", "-", "-", "-"}
        };

        String[][] arr1 = scheduleSlot(myArr1, 0, 0); //I assigned the return variables to a new array
        String[][] arr2 = scheduleSlot(myArr2, 0, 0);
        while(true) {
            String option = input.nextLine();
            if (option.equals(p)) {
                printSchedule(arr1, arr2);
                printMenu();
            }
            else if(option.equals(s)){
                int instructor ;
                int day;
                int time;
                System.out.print("Select instructor(1- Jeff, 2- Anna): ");
                instructor = input.nextInt();
                System.out.print("Select Day(1- Mon, 2- Tue, 3- Wed, 4- Thur): ");
                day = input.nextInt();
                System.out.print("Select Slot(1 - 11-12, 2 - 12-1, 3 - 1-2, 4 - 2-3): ");
                time = input.nextInt();
                if(instructor == 1){
                    scheduleSlot(myArr1, day, time);
                    printMenu();
                }
                else if(instructor == 2){
                    scheduleSlot(myArr2, day, time);
                    printMenu();
                }

            }
            else if(option.equals(f)){
                int instructor1;
                int day1;
                int time1;
                System.out.print("Select instructor(1- Jeff, 2- Anna): ");
                instructor1 = input.nextInt();
                System.out.print("Select Day(1- Mon, 2- Tue, 3- Wed, 4- Thur): ");
                day1 = input.nextInt();
                System.out.print("Select Slot(1 - 11-12, 2 - 12-1, 3 - 1-2, 4 - 2-3): ");
                time1 = input.nextInt();
                if(instructor1 == 1){
                    freeSlot(myArr1, day1, time1);
                    printMenu();
                }
                else if(instructor1 == 2){
                    freeSlot(myArr2, day1, time1);
                    printMenu();
                }
            }
            else if(option.equals(i)){
                printIndv(myArr1, myArr2, myArr3);
                printMenu();
            }
            else if(option.equals(g)){
                printGroup(myArr1, myArr2, myArr4);
                printMenu();
            }
            else if(option.equals(q)){
                break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("Enter one of the following commands: ");
        System.out.println("p - Print schedules");
        System.out.println("s - Schedule a slot ");
        System.out.println("f - Free a slot ");
        System.out.println("i - Show slots available for individual lessons ");
        System.out.println("g - Show slots available for group lessons ");
        System.out.println("q - Quit ");
        System.out.print("Command: ");
        System.out.println();

    }

    public static void printSchedule(String[][] array1, String[][] array2){
        System.out.println("Jeff: ");
        System.out.printf("%12s%10s%10s%10s", "Mon", "Tue", "Wed", "Thu");
        System.out.println();
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array1[i].length; j++){
                System.out.printf("%-10s",array1[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Anna: ");
        System.out.printf("%12s%10s%10s%10s", "Mon", "Tue", "Wed", "Thu");
        System.out.println();
        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < array2[i].length; j++){
                System.out.printf("%-10s",array2[i][j]);
            }
            System.out.println();
        }
    }

    public static String[][] scheduleSlot(String[][] array, int day, int time){
        if(day != 0 & time != 0) {
            array[time - 1][day] = "X";
        }
        return array;
    }
    public static String[][] freeSlot(String[][] array, int day, int time){
        if(day != 0 & time != 0) {
            array[time - 1][day] = "-";
        }
        return array;
    }

    public static void printGroup(String[][] arr1, String[][] arr2 , String[][] arr3){
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length; j++){
                if(arr1[i][j] == "X" && arr2[i][j] == "X"){
                    arr3[i][j] = "G";
                }
            }
        }
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length; j++){
                System.out.printf("%-10s",arr3[i][j]);
            }
            System.out.println();
        }
    }
    public static void printIndv(String[][] arr1, String[][] arr2 , String[][] arr4){
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length; j++){
                if(arr1[i][j].equals("-") && arr2[i][j].equals("X")){
                    arr4[i][j] = "I";
                }
                if(arr1[i][j].equals("X") && arr2[i][j].equals("-")){
                    arr4[i][j] = "I";
                }
                if(arr1[i][j].equals("-") || arr2[i][j].equals("-")){
                    arr4[i][j] = "I";
                }
            }
        }
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length; j++){
                System.out.printf("%-10s",arr4[i][j]);
            }
            System.out.println();
        }
    }

}
