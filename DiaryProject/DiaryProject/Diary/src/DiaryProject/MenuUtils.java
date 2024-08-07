package DiaryProject;

import java.util.Scanner;

/**
 * Utility class for handling menu operations in the Diary Project.
 */
public class MenuUtils {
    private static int MAX_OPTION = 3;
    private static int MIN_OPTION = 1;
    private static int MAX_SUBMENU_OPTION = 5;
    private static int MIN_SUBMENU_OPTION = 1;

    /**
     * Shows main menu.
     */
    public static void showMenu() {
        System.out.println(StringUtils.HEADER);
        System.out.println(StringUtils.MENU_OPTIONS);
        System.out.println(StringUtils.HEADER);
    }

    /**
     * Manages the main menu options. It loops until a correct option is chosen.
     * @param option The user's choice.
     * @param myDiary The array that keeps events.
     * @param scan The Scanner object to read user input.
     * @return true if the option is valid, false otherwise.
     * @see MenuOne#menuOne(Scanner, Event[][][])
     * @see MenuUtils#showSubMenu()
     */
    public static boolean useMenu(int option, Scanner scan, Event[][][] myDiary) {
        boolean correctOption, subMenuOK;
        if (option > MAX_OPTION || option < MIN_OPTION) {
            System.out.println(StringUtils.ERROR + StringUtils.OPTION_INVALID);
            correctOption = false;
        } else {
            correctOption = true;
            switch (option) {
                case 1:
                    System.out.println(StringUtils.HEADER);
                    System.out.println(StringUtils.MENU_ONE);
                    System.out.println(StringUtils.HEADER);
                    MenuOne.menuOne(scan, myDiary);
                    break;
                case 2:
                    do {
                        System.out.println(StringUtils.HEADER);
                        System.out.println(StringUtils.MENU_TWO);
                        System.out.println(StringUtils.HEADER);
                        showSubMenu();
                        option = scan.nextInt();
                        scan.nextLine(); // clean buffer
                        subMenuOK = useSubMenu(option, myDiary, scan);
                        if(!subMenuOK){
                            System.out.println(StringUtils.ERROR);
                        }
                    } while (!subMenuOK && option != MAX_SUBMENU_OPTION);
                    break;
                case 3:
                    System.out.println(StringUtils.FINISH_PROGRAM);
                    System.exit(0);
                    break;
            }
        }
        return correctOption;
    }

    /**
     * Shows the submenu.
     */
    private static void showSubMenu() {
        System.out.println(StringUtils.HEADER);
        System.out.println(StringUtils.SUBMENU_OPTIONS);
        System.out.println(StringUtils.HEADER);
    }

    /**
     * Manage the submenu options. It loops until a correct option is chosen.
     * @param option The user's choice.
     * @param myDiary The array that keeps events.
     * @param scan The Scanner object to read user input.
     * @return true if the option is valid, false otherwise.
     * @see MenuTwo#subMenuOne(Event[][][])
     * @see MenuTwo#subMenuTwo(Event[][][])
     * @see MenuTwo#subMenuThree(Event[][][])
     * @see MenuTwo#subMenuFour(Event[][][], Scanner)
     */

    private static boolean useSubMenu(int option, Event[][][] myDiary, Scanner scan) {
        boolean correctOption;
        if (option < MIN_SUBMENU_OPTION || option > MAX_SUBMENU_OPTION) {
            System.out.println(StringUtils.ERROR + StringUtils.OPTION_INVALID);
            correctOption = false;
        } else {
            correctOption = true;
            switch (option) {
                case 1:
                    MenuTwo.subMenuOne(myDiary);
                    break;
                case 2:
                    MenuTwo.subMenuTwo(myDiary);
                    break;
                case 3:
                    MenuTwo.subMenuThree(myDiary);
                    break;
                case 4:
                    MenuTwo.subMenuFour(myDiary, scan);
                    break;
                case 5:
                    break;
            }
        }
        return correctOption;
    }
}
