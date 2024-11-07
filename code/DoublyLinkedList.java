class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0; // Track the number of nodes
    }

    // Add a new question node to the list
    add(data) {
        const newNode = new Node(data);
        if (!this.head) {
            // Set both head and tail to the new node if the list is empty
            this.head = newNode;
            this.tail = newNode;
        } else {
            // Link the new node to the end of the list
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++; // Increment size with each addition
    }

    // Get node data at a specific index
    getNodeAt(index) {
        if (index < 0 || index >= this.size) return null; // Bounds check

        let current = this.head;
        let i = 0;
        while (current && i < index) {
            current = current.next;
            i++;
        }
        return current ? current.data : null;
    }

    // Get the head of the list (used to start the quiz)
    getHead() {
        return this.head;
    }

    // Return the size of the list (total number of questions)
    getSize() {
        return this.size;
    }
}
