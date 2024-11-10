#include <stdio.h>
#include <stdlib.h>
#define N 5

int front = -1, rear = -1;
int queue[N];

void insert();
void delete();
void display();

int main()
{
    int choice;
    while (1)
    {
        printf("1. Insertion\n2. Deletion\n3. Display\n4. Exit\n");
        printf("Enter your choice:\n");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            insert();
            break;
        case 2:
            delete ();
            break;
        case 3:
            display();
            break;
        case 4:
            exit(0);
        default:
            printf("Invalid choice\n");
        }
    }
}

void insert()
{
    int item;
    printf("Enter the item to be inserted: ");
    scanf("%d", &item);

    // Check if the queue is full
    if (((rear + 1) % N) == front)
    {
        printf("The Queue is Full\n");
    }
    else if (front == -1 && rear == -1) // condition for the insertion of the first element
    {
        front = rear = 0;
        queue[rear] = item;
    }
    else
    {
        rear = (rear + 1) % N;
        queue[rear] = item;
    }
}

void delete()
{
    if (front == -1 && rear == -1) // condition if no element is present
    {
        printf("The Queue is Empty\n");
    }
    else if (front == rear) // the condition if it is the last element to be deleted
    {
        printf("The deleted element is %d\n", queue[front]);
        front = rear = -1;
    }
    else
    {
        printf("The deleted element is %d\n", queue[front]);
        front = (front + 1) % N;
    }
}

void display()
{
    int i = front;
    if (front == -1 && rear == -1)
    {
        printf("The Queue is Empty\n");
    }
    else
    {
        printf("The Queue is: ");
        while (i != rear)
        {
            printf("%d\t", queue[i]);
            i = (i + 1) % N;
        }
        printf("%d\n", queue[i]); // Print the last element
    }
}
