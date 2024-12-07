class Admin {
    String username;
    String password;
    boolean votingStarted;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.votingStarted = false;
    }

    public boolean login(String Username, String Password) {
        return username.equals(Username) && password.equals(Password);
    }

    public void startVoting() {
        if (!votingStarted) {
            votingStarted = true;
            System.out.println("Voting has started.");
        } else {
            System.out.println("Voting is already in progress.");
        }
    }

    public void stopVoting() {
        if (votingStarted) {
            votingStarted = false;
            System.out.println("Voting has stopped.");
        } else {
            System.out.println("Voting is not currently active.");
        }
    }

    private Candidate findWinner(Node root) {
        if (root == null) {
            return null;
        }

        Candidate currentCandidate = (Candidate) root.value;
        Candidate leftWinner = findWinner(root.left);
        Candidate rightWinner = findWinner(root.right);

        Candidate maxVotesCandidate = currentCandidate;

        if (leftWinner != null && leftWinner.votes > maxVotesCandidate.votes) {
            maxVotesCandidate = leftWinner;
        }

        if (rightWinner != null && rightWinner.votes > maxVotesCandidate.votes) {
            maxVotesCandidate = rightWinner;
        }

        return maxVotesCandidate;
    }

    public void declareWinner(CandidateBST candidateBST) {
        if (!votingStarted) {
            System.out.println("Voting has not started yet.");
            return;
        }

        Candidate winner = findWinner(candidateBST.getRoot());

        if (winner != null) {
            System.out.println("The winner is: " + winner.name + " from " + winner.party + " with " + winner.votes + " votes.");
        } else {
            System.out.println("No winner declared. No votes cast.");
        }
    }
}
