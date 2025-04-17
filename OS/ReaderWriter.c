#include <stdio.h>
#include <unistd.h>  
int mutex = 1; 


void reader(int id) {
    while (mutex <= 0);  
    mutex--;  

  
    printf("Reader %d is reading data\n", id);

    mutex++;  


void writer(int id) {
    while (mutex <= 0); 
    mutex--;  

  
    printf("Writer %d is writing data\n", id);

    mutex++;  
}

int main() {
    printf("Reader-Writer Problem Simulation\n\n");

    
    for (int i = 1; i <= 3; i++) {  
        reader(i);  
        sleep(1);  
    }

    for (int i = 1; i <= 2; i++) { 
        writer(i);  
        sleep(1); 
    }

    for (int i = 4; i <= 5; i++) { 
        reader(i);  
        sleep(1);  
    }

    return 0;
}
