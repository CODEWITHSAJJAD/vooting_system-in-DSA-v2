class Candidate {
	int candidateNumber;
    String name;
    String party;
    String post;
    int votes;

    public Candidate(int candidateNumber, String name, String party, String post) {
        this.candidateNumber = candidateNumber;
        this.name = name;
        this.party = party;
        this.post = post;
        this.votes = 0;
    }

    public void display() {
        System.out.println(candidateNumber + ". " + this.name + "\t" + this.party + "\t" + this.post);
    }
}

