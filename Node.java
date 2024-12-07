class Node {
    String key;
    Object value;
    int candidateNumber; 
    Node left, right;

    public Node(String key, Object value, int candidateNumber) {
        this.key = key;
        this.value = value;
        this.candidateNumber = candidateNumber;
        left = right = null;
    }
}