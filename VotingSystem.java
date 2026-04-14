import java.util.Scanner;

public class VotingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Candidate names
        String[] candidates = {"Alice", "Bob"};

        // Vote count array
        int[] votes = new int[2];

        // Voter IDs (max 100 voters)
        int[] voterIds = new int[100];
        int voterCount = 0;

        int choice;

        do {
            System.out.println("\n===== Online Voting System =====");
            System.out.println("1. Vote");
            System.out.println("2. View Results");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Voter ID: ");
                int voterId = sc.nextInt();

                // Check duplicate voting
                boolean alreadyVoted = false;
                for (int i = 0; i < voterCount; i++) {
                    if (voterIds[i] == voterId) {
                        alreadyVoted = true;
                        break;
                    }
                }

                if (alreadyVoted) {
                    System.out.println("You have already voted!");
                } else {

                    // Show candidates
                    System.out.println("Choose Candidate:");
                    for (int i = 0; i < candidates.length; i++) {
                        System.out.println((i + 1) + ". " + candidates[i]);
                    }

                    System.out.print("Enter choice: ");
                    int voteChoice = sc.nextInt();

                    if (voteChoice >= 1 && voteChoice <= candidates.length) {
                        votes[voteChoice - 1]++;   // vote count increase
                        voterIds[voterCount] = voterId; // store voter ID
                        voterCount++;

                        System.out.println("Vote Cast Successfully!");
                    } else {
                        System.out.println("Invalid Choice!");
                    }
                }

            } else if (choice == 2) {

                System.out.println("\n===== Final Results =====");

                int maxVotes = votes[0];
                int winnerIndex = 0;

                for (int i = 0; i < candidates.length; i++) {
                    System.out.println(candidates[i] + ": " + votes[i] + " votes");

                    if (votes[i] > maxVotes) {
                        maxVotes = votes[i];
                        winnerIndex = i;
                    }
                }

                System.out.println("Winner: " + candidates[winnerIndex]);

            } else if (choice == 3) {
                System.out.println("Thank You!");
            } else {
                System.out.println("Invalid Choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
