// Joseph Doan

package Main;

import java.util.ArrayList;
import java.util.StringTokenizer;

import static Main.Database.searchByYear;
import static Main.Database.*;

public class Main {

    public static void main(String[] args) {

        String primaryUser;
        String myFileName = "../JavaMovieDatabase/src/Main/db.txt";
        boolean isMenuOn = true;

        ArrayList<Movie> myMovieList = new ArrayList<Movie>();
        fileRead myReadFile = new fileRead(myFileName);
        ArrayList<String> myLines = myReadFile.getLines();
        intiateMovieList(myMovieList, myLines);
        keyboardInput primaryUserInput = new keyboardInput();

        while (isMenuOn) {
            primaryMenu();
            enterCommand();
            primaryUser = primaryUserInput.getKeyboardLine().toLowerCase();

            if (primaryUser.equals("a")) {
                // p("a is chosen");
                addEntry(myLines, myFileName);

            } else if (primaryUser.equals("b")) {
                // p("b is chosen");
                pi("Enter actor > ");
                String actor = primaryUserInput.getKeyboardLine();
                searchByActor(actor, myMovieList);

            } else if (primaryUser.equals("c")) {
                // p("c is chosen");
                boolean yearInputIsInt = false;
                int year = 0;
                do {
                    System.out.print("Enter Year > ");
                    try {
                        String yearString = primaryUserInput.getKeyboardLine();
                        year = Integer.parseInt(yearString);
                        yearInputIsInt = true;
                    } catch (NumberFormatException e) {
                        p("Invalid year. Please enter a number. Try Again");
                    }
                } while (!yearInputIsInt);
                searchByYear(year, myMovieList);

            } else if (primaryUser.equals("d")) {
                // p("d is chosen");
                boolean runtimeInputIsInt = false;
                int runtime = 0;
                do {
                    System.out.print("Enter runtime (minutes) > ");
                    try {
                        String yearString = primaryUserInput.getKeyboardLine();
                        runtime = Integer.parseInt(yearString);
                        runtimeInputIsInt = true;
                    } catch (NumberFormatException e) {
                        p("Invalid runtime. Please enter a number. Try Again");
                    }
                } while (!runtimeInputIsInt);

                searchByRuntime(runtime, myMovieList);

            } else if (primaryUser.equals("e")) {
                // p("e is chosen");
                pi("Enter Director > ");
                String director = primaryUserInput.getKeyboardLine();
                searchByDirector(director, myMovieList);

            } else if (primaryUser.equals("f")) {
                // p("f is chosen");
                pi("Enter Title > ");
                String title = primaryUserInput.getKeyboardLine();
                searchByTitle(title, myMovieList);

            } else if (primaryUser.equals("g")) {
                // p("g is chosen");
                pi("Enter title to delete > ");
                String deleteTitle = primaryUserInput.getKeyboardLine();
                deleteEntry(deleteTitle, myLines, myMovieList);
                clearMovieList();
                intiateMovieList(myMovieList, myLines);
                // p(myMovieList);

            } else if (primaryUser.equals("h")) {
                p("Closing Program.");
                isMenuOn = false;
                primaryUserInput.closeKeyboard();

            } else {
                p("Please Try again");
                p("");

            }
        }
    }

    private static void clearMovieList() {
    }


    private static void primaryMenu() {
        p("a.) New Entry ");
        p("b.) Search by Actor ");
        p("c.) Search by Year ");
        p("d.) Search by Runtime (in minutes)");
        p("e.) Search by Director");
        p("f.) Search by Title");
        p("g.) Delete Entry");
        p("h.) Quit");
    }

    private static void enterCommand() {
        pi("Enter Command > ");
    }

    public static void intiateMovieList(ArrayList<Movie> moviesList, ArrayList<String> lines) {
        moviesList.clear();
        for (int i = 0; i < lines.size(); i++) {
            String raw = lines.get(i);
            if (raw.equals("")) {
                p("Error extra line(s) in txt file");
            } else {
                StringTokenizer st = new StringTokenizer(raw, "*");
                while (st.hasMoreTokens()) {
                    Movie currentMovie = new Movie(st.nextToken().trim(), Integer.parseInt(st.nextToken().trim()),
                            Integer.parseInt(st.nextToken().trim()), st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim());
                    moviesList.add(currentMovie);
                }
            }
        }
    }

    public static <E> void p(E item){
        System.out.println(item);
    }

    public static <E> void pi(E item){
        System.out.print(item);
    }
}
