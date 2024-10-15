import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DealOrNoDeal {
    public static void main(String[] args) {
        int total_cases = 26; // create int variable for 26 cases
        List<Integer> cases = new ArrayList<>(); // create a list named cases for the values
        List<Integer> selected_cases = new ArrayList<>(); // created another list for the selected cases that the player picks
        Scanner sc = new Scanner(System.in);  // make the scanner
        int player_case; // made int variable for the case that the player chooses
        int player_case_value = 0; // variable to hold the value of the selected case

   
        for (int i = 1; i <= total_cases; i++) { //adds values to cases 
            cases.add(i * 100); 
        }
        Collections.shuffle(cases); //shuffle the values in the cases

        System.out.println("Welcome to Deal or No Deal");
        
        System.out.println("Select a case (1 through 26): ");
        player_case = sc.nextInt(); //get players case
        player_case_value = cases.get(player_case - 1); //store player case value
        selected_cases.add(player_case); // add the player case to the selected cases list
        System.out.println("You selected case #" + player_case);
        
        while (selected_cases.size() < total_cases - 1) { // while loop that will go until there is one case remaining
            System.out.println("Cases remaining: ");
            for (int i = 1; i <= total_cases; i++) {
                if (!selected_cases.contains(i)) { // shows the remaining cases
                    System.out.print(i + " ");
                }
            }
            System.out.println(); //spaces it out

            System.out.println("Choose a case to open: ");
            int case_to_open = sc.nextInt(); // get the case the player wants to open
            if (!selected_cases.contains(case_to_open)) {
                selected_cases.add(case_to_open); // check if case has already been picked
                int index = case_to_open - 1;
                if (index >= 0 && index < cases.size()) { // googled how to make an index to check cases and to set an index to a case
                    System.out.println("You opened case " + case_to_open + " Which had $" + cases.get(index));
                    cases.remove(index); // remove case value from the list
                }

               
                Integer total_value = 0;
                for (int value : cases) { //for each value in the cases it will be added to the total
                    total_value += value;
                }
                Integer offer = total_value / cases.size(); //avergaes for the offer
                System.out.println("The banker offers you: $" + (int) offer);
                System.out.print("Do you accept the offer? (yes/no): ");
                String response = sc.next();
                
                if (response.equalsIgnoreCase("yes")) {
                    System.out.println("You accepted the offer of $" + (int) offer + "!");
                    break; // exits if the player accepts the offer
                }
            } else {
                System.out.println("Choose another already been opened");
            }
        }

        
        if (selected_cases.size() == total_cases - 1) {// use the -1 so it works when theres one case left
            System.out.println("You have opened all but your case.");
            System.out.println("You will keep case #" + player_case);
            System.out.println("You found: $" + player_case_value);
            
        }

  
    }
}

