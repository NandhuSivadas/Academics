#include <stdio.h>
#include <unistd.h>

int semaphore = 1;

void wait() {
    while (semaphore == 0);
    semaphore = 0;
}

void signal() {
    semaphore = 1;
}

void process(int id) {
    printf("Process %d wants to enter\n", id);
    
    wait();
    
    printf("Process %d is in critical section\n", id);
    sleep(1);
    printf("Process %d is leaving\n", id);
    
    signal();
}

int main() {
    printf("Simple Semaphore Demo\n\n");
    
    process(1);
    process(2);
    process(1);
    process(2);
    
    return 0;
}