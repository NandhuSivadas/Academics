// Linear search

#include <stdio.h>

int main()
{
    int item,n,a[20],loc=-1,i;
    printf("Enter the limit:");
    scanf("%d",&n);
    for(i=0;i<n;i++)
     {
       printf("Enter the Element:");
       scanf("%d",&a[i]);
       
     }
    printf("Enter the item to be searched:");
    scanf("%d",&item);
    for(i=0;i<n;i++)
      {
          if(item==a[i])
            {
                loc=i;
                break;
            }
      }
      if(loc!=-1)
        {
            printf("item found at the location:%d",loc);
        }
    else
      {
          printf("item not found");
      }
    
}