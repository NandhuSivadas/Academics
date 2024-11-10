// binary search
#include <stdio.h>

int main() {
    int low = 0, high, mid, item, flag = 0, i, n,a[20];

    printf("Enter the number of elements:\n");
    scanf("%d", &n);

    // int a[n];
    printf("Enter %d elements in sorted order:\n", n);
    for(i = 0; i < n; i++)
        scanf("%d", &a[i]);

    printf("Enter the item to search:\n");
    scanf("%d", &item);

    high = n - 1;

    while(low <= high) {
        mid = (low + high) / 2;

        if(a[mid] == item) {
            flag = 1;
            printf("%d is found at position %d\n", item, mid + 1);
            break;
        } else if(a[mid] < item) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    if(flag == 0) {
        printf("%d is not found\n", item);
    }
}


