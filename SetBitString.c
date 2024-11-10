#include<stdio.h>
#include<stdlib.h>
int u[10]={9,5,11,56,72,34,65,33,90,99};
void display(int *array);
int main()
{
	int universal[10]={1,1,1,1,1,1,1,1,1,1};
	int a[10]={1,0,1,0,1,0,1,0,1,0};
	int b[10]={1,0,0,1,1,0,0,1,0,1};
	int aUb[10],anb[10],a_differ_b[10],b_differ_a[10];
	int i;
	printf("Universal Set :\n");
	display(universal);
	printf("\n");
	printf("Set A:\n");
	display(a);
	printf("Set B :\n");
	display(b);
	printf("A union B SET IS :\n");
	for(i=0;i<10;++i)
	{
		aUb[i]=a[i]||b[i];
	}
	display(aUb);
	printf("A intersection B:\n");
	for(i=0;i<10;++i)
	{
		anb[i]=a[i]&&b[i];
	}
	display(anb);
	printf("A-B is :\n");
	for(i=0;i<10;++i)
	{
		if(a[i]==1)
		{
			a_differ_b[i]=a[i]-b[i];
		}
		else
		{
			a_differ_b[i]=0;
		}
	}
	display(a_differ_b);
	printf("B-A is :\n");
	for(i=0;i<10;++i)
	{
		if(b[i]==1)
		{
			b_differ_a[i]=b[i]-a[i];
		}
		else
		{
			a_differ_b[i]=0;
		}
	}
	display(b_differ_a);
}

void display(int *array) 
{
    for (int i = 0; i < 10; ++i)
     {
        if (array[i] == 1)
         {
            printf("%d ", u[i]);
        }
    }
    printf("\n\n");
}