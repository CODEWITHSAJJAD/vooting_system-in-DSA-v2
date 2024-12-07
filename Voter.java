import java.util.Scanner;
import java.util.HashSet;

class Voter {
    private static HashSet votedVoterIds = new HashSet();

    Object voterId;
    String name;
    String cnic;
    boolean hasVoted;

    public Voter(Object voterId, String name, String cnic) {
        this.voterId = voterId;
        this.name = name;
        this.cnic = cnic;
        this.hasVoted = false;
    }

    public void vote(CandidateBST candidateBST, VoteQueue voteQueue) {
        if (hasVoted) {
            System.out.println("You have already cast your vote. Cannot vote again.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Our CANDIDATES are!");
        CandidateBST candidateBSTCopy = new CandidateBST();
        candidateBSTCopy.insert(1, "Candidate1", new Candidate(1, "IMRAN KHAN", "PTI", "President"));
        candidateBSTCopy.insert(2, "Candidate2", new Candidate(2, "BILAVAL", "PPP", "Vice President"));

       
        Node rootCopy = candidateBSTCopy.getRoot();
        inOrderTraversal(rootCopy);

        System.out.println("Enter the candidate number you want to vote for:");
        int candidateNumber = scanner.nextInt();

        if (!votedVoterIds.contains(voterId)) {
            Node candidateNode = candidateBST.searchByNumber(candidateNumber);
            if (candidateNode != null) {
                ((Candidate) candidateNode.value).votes++;
                hasVoted = true;
                votedVoterIds.add(voterId);
                voteQueue.enqueue(this);
                System.out.println("Vote cast successfully!");
            } else {
                System.out.println("Invalid candidate number. Vote not cast.");
            }
        } else {
            System.out.println("You have already cast your vote. Cannot vote again.");
        }
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            ((Candidate) root.value).display();
            inOrderTraversal(root.right);
        }
    }
}
