#include <bits/stdc++.h>
#include <cinttypes>
using namespace std;
class Node
{
    public:
    int data;
    Node* npx; // xor of previous and next node
};

// returns xor of two nodes
Node* XOR (Node *a, Node *b)
{
    return reinterpret_cast<Node *>((reinterpret_cast<uintptr_t>(a))^(reinterpret_cast<uintptr_t>(b)));
}

void add(Node **head_ref, int data)
{
    //new node to be inserted is created and data is added
    Node *newnode = new Node();
    newnode->data = data;
    // As next node is null, npx of this node is address of previous node
    newnode->npx = *head_ref;
    // npx of head node needs to be modified
    if (*head_ref != NULL)
    {
        (*head_ref)->npx = XOR(newnode, (*head_ref)->npx);
    }
    // newnode becomes the new head
    *head_ref = newnode;
}
// get function
Node* get(int index,Node **head)
  {
    Node *curr = *head;  
    Node *prev = NULL;  
    Node *next = NULL;  

    for(int i = 0; i < index; i++) 
    {  
        next = XOR(prev, curr->npx);  
  
        prev = curr;  
        curr = next;  
    }  
    return curr;
  }

// prints the numbers
void printList (Node **head)
{
    Node *curr_node = *head;
    Node *prev_node = NULL;
    Node *next_node;
 
    cout << "The values stored in Linked List are: \n";
 
    while (curr_node != NULL)
    {
        cout<<curr_node->data<<" ";
        next_node = XOR (prev_node, curr_node->npx);
        // uodating prev and curr nodes
        prev_node = curr_node;
        curr_node = next_node;
    }
}


int main ()
{
    Node *head = NULL;
    add(&head, 1);
    add(&head, 2);
    add(&head, 3);
    add(&head, 4);
    add(&head, 5);
    printList (&head);
    Node *n = get(1,&head);
    return 0;
}
