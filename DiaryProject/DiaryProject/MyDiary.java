package DiaryProject;

import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyDiary {
    private static final int TOTAL_WEEKS = 53;
    private static final int TOTAL_DAYS_IN_WEEK = 7;
    private static final int MAX_EVENTS_PER_DAY = 10;

    public static void main(String[] args) {
        Event[][][] myDiary = new Event[TOTAL_WEEKS][TOTAL_DAYS_IN_WEEK][MAX_EVENTS_PER_DAY];
        boolean allOK = true, finishProgram = false;
        String userFinishProgram;
        do {
            try {
                Scanner scan = new Scanner(System.in);
                do {
                    MenuUtils.showMenu();
                    int menuAnswer = scan.nextInt();
                    scan.nextLine(); // clean buffer
                    allOK = MenuUtils.useMenu(menuAnswer, scan, myDiary); //checks if answer is correct, and controls the main menu options
                    if(allOK){
                        userFinishProgram = StringUtils.askForString(StringUtils.RETURN_MAIN_MENU, scan);
                        if (userFinishProgram.toLowerCase().charAt(0) == StringUtils.NO.charAt(0)) {
                            finishProgram = true;
                        }
                    }
                } while (!finishProgram);
                System.out.println(StringUtils.FINISH_PROGRAM);
                //Exceptions
            } catch (DateTimeException e) {
                System.out.println(StringUtils.ERROR + StringUtils.DATE_HOUR_FAILS);
                allOK = false;
            } catch (InputMismatchException e) {
                System.out.println(StringUtils.ERROR + " " + e);
                allOK = false;
            } catch (NoSuchElementException e) {
                System.out.println(StringUtils.ERROR + " " + e);
                allOK = false;
            } catch (IllegalStateException e) {
                System.out.println(StringUtils.ERROR + " " + e);
                allOK = false;
            }
        } while (!allOK);
    }
}
