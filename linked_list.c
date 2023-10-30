/**
 * @file
 * @brief Linked list implementation.
 * 
 * File contains a Node struct for a Linked List struct and includes standard
 * functions for creation of a linked list, adding Nodes to the Linked List,
 * removing Nodes, and displaying contents of the Linked List.
*/

#include <stdio.h>
#include <stdlib.h>

/**
 * @struct Node
 * @brief Represents a node in a linked list.
*/
typedef struct Node {
    int data;
    struct Node* next;
} Node;

/**
 * @struct LinkedList
 * @brief Represents a linked list.
*/
typedef struct LinkedList {
    Node* head;
} LinkedList;

/**
 * @brief Creates a new node with the given data.
 * 
 * @param data The data to be stored in the new node.
 * @return A pointer to the newly created node.
*/
Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

/**
 * @brief Creates a new empty linked link.
 * 
 * @return A pointer to the newly created linked list.
*/
LinkedList* createLinkedList() {
    LinkedList* list = (LinkedList*)malloc(sizeof(LinkedList));
    list->head = NULL;
    return list;
}

/**
 * @brief Adds a new node with the given data to the end of the linked list.
 *
 * @param list A pointer to the linked list.
 * @param data The data to be added to the list.
 */
void add(LinkedList* list, int data) {
    Node* newNode = createNode(data);
    if (list->head == NULL) {
        list->head = newNode;
    } else {
        Node* current = list->head;
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = newNode;
    }
}

/**
 * @brief Removes the first occurrence of a node with the given data from the
 * linked list.
 *
 * @param list A pointer to the linked list.
 * @param data The data to be removed from the list.
 */
void removeElement(LinkedList* list, int data) {
    Node* current = list->head;
    Node* prev = NULL;

    while (current != NULL && current->data != data) {
        prev = current;
        current = current->next;
    }

    if (current == NULL) {
        printf("Element %d not found in the list.\n", data);
        return;
    }

    if (prev == NULL) {
        list->head = current->next;
    } else {
        prev->next = current->next;
    }

    free(current);
}

/**
 * @brief Displays the elements of the linked list.
 *
 * @param list A pointer to the linked list.
 */
void display(LinkedList* list) {
    Node* current = list->head;
    while (current != NULL) {
        printf("%d -> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}

int main() {
    LinkedList* list = createLinkedList();

    add(list, 1);
    add(list, 2);
    add(list, 3);
    add(list, 4);
    add(list, 5);

    printf("Linked List: ");
    display(list);

    removeElement(list, 3);

    printf("After removing 3: ");
    display(list);

    removeElement(list, 1);

    printf("After removing 1: ");
    display(list);

    removeElement(list, 5);

    printf("After removing 5: ");
    display(list);

    return 0;
}
