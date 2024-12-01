#include <stdio.h>
#include <conio.h>
void main()
{
	int n,cost[10][10],i,j,k,l,mincost,t[10][2],nearr[10],c,min,p,v1,m;
	clrscr();
	printf("Enter number of vertices\n");
	scanf("%d",&n);
	printf("Enter cost adjacency matrix\n");
for(i=1; i<=n; ++i)
{
    for(j=i+1; j<=n; ++j) // Start from j = i+1 to skip self-loops
    {
        printf("Enter cost of edge(%d,%d): ", i, j);
        scanf("%d", &cost[i][j]);
        if(cost[i][j] == 0)
            cost[i][j] = 999; // Replace 0 with a large number for non-existent edges
        cost[j][i] = cost[i][j]; // Make the matrix symmetric
    }
}

	printf("Cost Adjacency Matrix \n");
	for(i=1;i<=n;++i)
	{
		for(j=1;j<=n;++j)
		{
			printf("%d  ",cost[i][j]);
		}
		printf("\n");
	}
	printf("Enter the starting vertex\n");
	scanf("%d",&v1);
	k=v1;
	m=999;
	for(i=1;i<=n;++i)
	{
		if(cost[k][i]<m)
		{
			l=i;
			m=cost[k][i];
		}
	}
	mincost=cost[k][l];
	t[1][1]=k;
	t[1][2]=l;
	printf("EDGE %d %d\n",k,l);
/*	//setting mincost
	k=1;
	l=2;
	mincost=cost[1][2];
	t[1][1]=k;
	t[1][2]=l;
	for(i=1;i<=n;++i)
	{
		for(j=1;j<=n;++j)
		{
			if(cost[i][j]<mincost)
			{
				mincost=cost[i][j];
				k=i;
				l=j;
				t[1][1]=k;
				t[1][2]=l;
			}
		}
	}
*/
//setting near
	for(i=1;i<=n;++i)
	{
		if(cost[i][k]<cost[i][l])
			nearr[i]=k;
		else
			nearr[i]=l;
	}
nearr[k]=0;
nearr[l]=0;

//n-2 additional edge
for(i=2;i<=n-1;++i)
{
	c=1;
	for(j=1;j<=n;++j)
	{
		if(nearr[j]!=0 && c==1)
		{
			min=cost[j][nearr[j]];
			p=j;
			c++;
		}
		else if(nearr[j]!=0 && c>1)
		{
			min=cost[j][nearr[j]];
			p=j;
		}
	}
	t[i][1]=p;
	t[i][2]=nearr[p];
	mincost=mincost+cost[p][nearr[p]];
	nearr[p]=0;
	//update near
	for(k=1;k<=n;++k)
	{
		if(nearr[k]!=0 && cost[k][nearr[k]]>cost[k][p])
			nearr[k]=p;
	}
}

printf("The spanning tree\n");
for(i=1;i<=n-1;++i)
{
	printf("(%d %d) - %d\n",t[i][1],t[i][2],cost[t[i][1]][t[i][2]]);
}
printf("Mincost : %d",mincost);
	getch();
}