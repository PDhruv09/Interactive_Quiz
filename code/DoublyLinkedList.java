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
    }

    add(data) {
        const newNode = new Node(data);
        if (!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    getNodeAt(index) {
        let current = this.head;
        let i = 0;
        while (current && i < index) {
            current = current.next;
            i++;
        }
        return current ? current.data : null;
    }

    size() {
        let current = this.head;
        let count = 0;
        while (current) {
            count++;
            current = current.next;
        }
        return count;
    }
}
