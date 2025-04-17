#include <stdio.h>

int buffer[5];
int count = 0;
int mutex = 1;
int empty = 5;
int full = 0;

void producer() {
    while (empty <= 0);
    empty--;
    
    while (mutex <= 0);
    mutex--;
    
    buffer[count] = count + 1;
    printf("Produced: %d\n", buffer[count]);
    count++;
    
    mutex++;
    full++;
}

void consumer() {
    while (full <= 0);
    full--;
    
    while (mutex <= 0);
    mutex--;
    
    count--;
    printf("Consumed: %d\n", buffer[count]);
    
    mutex++;
    empty++;
}

int main() {
    printf("Producer-Consumer Simulation\n\n");
    
    producer();
    producer();
    consumer();
    producer();
    consumer();
    producer();
    producer();
    consumer();
    consumer();
    consumer();
    
    return 0;
}