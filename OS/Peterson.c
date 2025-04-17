#include <stdio.h>
#include <unistd.h>


int turn;
int flag[2] = {0, 0}; 

void process(int i) {
    int other = 1 - i;

    flag[i] = 1;       
    turn = other;       

    while (flag[other] == 1 && turn == other) {
       
    }

    
    printf("Process %d is in the critical section\n", i);
    sleep(2); 

    
    flag[i] = 0;         
}

int main() {
    printf("Peterson's Solution\n");
    printf(" ------------------\n");

    for (int i = 0; i < 5; i++) {  
        process(0);  
        process(1); 
    }

    return 0;
}