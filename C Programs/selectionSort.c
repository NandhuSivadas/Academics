// selection sort
#include<stdio.h>

int main() {
    int a[20], n, i, t, loc, j, small;

    printf("Enter the limit: ");
    scanf("%d", &n);

    printf("Enter the elements:\n");
    for(i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    // Selection Sort Algorithm
    for(i = 0; i < n - 1; i++) {
        small = a[i];
        loc = i;

        for(j = i + 1; j < n; j++) {
            if(a[j] < small) {
                small = a[j];
                loc = j;
            }
        }

        // Swap the smallest element found with the current element
        t = a[loc];
        a[loc] = a[i];
        a[i] = t;
    }

    printf("Sorted array:\n");
    for(i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
