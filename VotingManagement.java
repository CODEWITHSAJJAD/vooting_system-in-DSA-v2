import java.util.*;
public class VotingManagement {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String ad, pass;
	        System.out.println("\t\t  !Welcome to Voting Management System!");
	        System.out.println("\t!To start the system, please provide the following details!\n");
	        System.out.println("\t\t------------------------------------------\n");

	        System.out.println("Enter the USER NAME:");
	        ad = sc.next();
	        System.out.println("Enter the PASSWORD:");
	        pass = sc.next();
	        Admin admin = new Admin(ad, pass);

	        if (admin.login("sajjad", "4176")) {
	            System.out.println("\t\t\t !Admin login successful.!\n");
	            System.out.println("\t\t\t -------------------------\n\n");
	            CandidateBST candidateBST = new CandidateBST();
	            candidateBST.insert(1, "Candidate1", new Candidate(1, "Candidate1", "Party1", "President"));
	            candidateBST.insert(2, "Candidate2", new Candidate(2, "Candidate2", "Party2", "Vice President"));

	            VoteQueue voteQueue = new VoteQueue(100);

	            int choice;
	            do {
	                System.out.println("\t\nStart our Module:");
	                System.out.println("\t1. Start Voting");
	                System.out.println("\t2. Stop Voting");
	                System.out.println("\t3. Vote");
	                System.out.println("\t4. Declare Winner");
	                System.out.println("\t5. Exit");
	                System.out.println("Enter your choice:");

	                choice = sc.nextInt();

	                switch (choice) {
	                    case 1:
	                        admin.startVoting();
	                        break;
	                    case 2:
	                        admin.stopVoting();
	                        break;
	                    case 3:
	                        if (admin.votingStarted) {
	                            sc.nextLine();
	                            System.out.println("Enter your voter ID:");
	                            String voterId = sc.nextLine();
	                            System.out.println("Enter your name:");
	                            String voterName = sc.nextLine();
	                            System.out.println("Enter your CNIC:");
	                            String voterCnic = sc.nextLine();

	                            Voter voter = new Voter(voterId, voterName, voterCnic);
	                            voter.vote(candidateBST, voteQueue);
	                        } else {
	                            System.out.println("Voting is not currently active.");
	                        }
	                        break;
	                    case 4:
	                        admin.declareWinner(candidateBST);
	                        break;
	                    case 5:
	                        System.out.println("Exiting the system.");
	                        break;
	                    default:
	                        System.out.println("Invalid choice. Please enter a valid option.");
	                }
	            } while (choice != 5);
	        } else {
	            System.out.println("Admin login failed. Exiting the system.");
	        }
	    }
}