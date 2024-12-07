class CandidateBST {
    private Node root;

    public CandidateBST() {
        this.root = null;
    }

    public void insert(int candidateNumber, String key, Object value) {
        root = insertRec(root, candidateNumber, key, value);
    }

    private Node insertRec(Node root, int candidateNumber, String key, Object value) {
        if (root == null) {
            root = new Node(key, value, candidateNumber);
            return root;
        }

        if (candidateNumber < ((Candidate) root.value).candidateNumber) {
            root.left = insertRec(root.left, candidateNumber, key, value);
        } else if (candidateNumber > ((Candidate) root.value).candidateNumber) {
            root.right = insertRec(root.right, candidateNumber, key, value);
        }

        return root;
    }

    public Node searchByNumber(int candidateNumber) {
        return searchByNumberRec(root, candidateNumber);
    }

    private Node searchByNumberRec(Node root, int candidateNumber) {
        if (root == null || ((Candidate) root.value).candidateNumber == candidateNumber) {
            return root;
        }

        if (candidateNumber < ((Candidate) root.value).candidateNumber) {
            return searchByNumberRec(root.left, candidateNumber);
        } else {
            return searchByNumberRec(root.right, candidateNumber);
        }
    }

    public Node getRoot() {
        return root;
    }
}
