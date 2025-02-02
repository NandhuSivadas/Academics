#include <stdio.h>
#include <stdlib.h>

int main() {
    int u[20], a[20], b[20], n, i, j, item, found;

    // Input the universal set
    printf("Enter the size of the universal set: ");
    scanf("%d", &n);

    printf("Enter the elements of the universal set:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &u[i]);
    }

    // Initialize Set A and Set B arrays
    for (i = 0; i < n; i++) {
        a[i] = 0;  
        b[i] = 0;
    }

    // Input Set A
    printf("Enter the elements of Set A:\n");
    for (i = 0; i < n; i++) {
        printf("Enter element: ");
        scanf("%d", &item);

        // Check if the item exists in the universal set
        found = 0;
        for (j = 0; j < n; j++) {
            if (u[j] == item) {
                found = 1;
                break;
            }
        }

        // Update Set A
        if (found) {
            a[i] = 1;
        } else {
            a[i] = 0;
        }
    }

    // Input Set B
    printf("Enter the elements of Set B:\n");
    for (i = 0; i < n; i++) {
        printf("Enter element: ");
        scanf("%d", &item);

        // Check if the item exists in the universal set
        found = 0;
        for (j = 0; j < n; j++) {
            if (u[j] == item) {
                found = 1;
                break;
            }
        }

        // Update Set B
        if (found) {
            b[i] = 1;
        } else {
            b[i] = 0;
        }
    }

    // Display Universal Set
    printf("\nUniversal Set: ");
    for (i = 0; i < n; i++) {
        printf("%d \t", u[i]);
    }

    // Display Set A
    printf("\nSet A: ");
    for (i = 0; i < n; i++) {
        printf("%d \t", a[i]);
    }

    // Display Set B
    printf("\nSet B: ");
    for (i = 0; i < n; i++) {
        printf("%d \t", b[i]);
    }

      printf("\n  Set aub: ");
    for (i = 0; i < n; i++) {
      
        printf("%d \t", a[i]||b[i]);
    }

       printf("\n  Set anb: ");
    for (i = 0; i < n; i++) {
      
        printf("%d \t", a[i]&&b[i]);
    }




    return 0;
}
