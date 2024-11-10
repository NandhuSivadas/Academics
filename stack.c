

#include <stdio.h>
#define N 5
#include<stdlib.h>
int queue[N];
int rear=-1;
int front=-1;
void insert()
 {
     int x;
     printf("Enter the value:");
     scanf("%d",&x);
     if(rear==N-1)
       {
           printf("Queue overflow");
       }
      else if(rear==-1 && front==-1)
         {
            rear=front=1;
            queue[rear]=x;
            
         }
        else
          {
              rear++;
              queue[rear]=x;
          }
 }
 
 
void del()
  {
      if(rear==-1 && front==-1)
        {
            printf("underflow");
        }
    else if(rear==front)
       {
           rear=front=-1;
           
       }
       else
        {
            front++;
        }
  }
 void display()
   {
       int i;
       for(i=front;i<=rear;i++)
          {
              printf("%d\t",queue[i]);
          }
   }
int main()

{
    int n;
    while(1)
    {
    printf("\n  1.insert \n 2.del \n 3.display\n 4.exit \n");
    printf("Enter your choice:");
    scanf("%d",&n);
    switch(n)
      {
          case 1:
          insert();
          break;
          
          case 2:
          del();
          break;
          
          case 3:
          display();
          break;
          
          case 4:
          exit(0);
      }
    
    }
    
}
