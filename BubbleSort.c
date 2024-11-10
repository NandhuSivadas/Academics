#include <stdio.h>

int main()
{
    int a[40], i, n = 4, j, temp;
    
    printf("Enter the numbers:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }
    
    printf("The numbers are:\n");
    for (i = 0; i < n; i++) {
        printf("%d \t", a[i]);
    }
    
    for(i=0;i<n-1;i++)
       {
            for(j=i+1;j<n;j++)
                {
                    if(a[i]>a[j])
                       {
                           temp=a[i];
                           a[i]=a[j];
                           a[j]=temp;
                       }
                }
       }
    
    printf("\nSorted Array:\n");
    for (i = 0; i < n; i++) {
        printf("%d \t", a[i]);
    }
    
    return 0;
}
