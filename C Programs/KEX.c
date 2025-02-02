#include<stdio.h>

int n, i, j, cost[20][20], u, v, a, b, parent[20], ne = 1, min, mincost;

int find(int i) {
    while (parent[i])
        i = parent[i];
    return i;
}

int uni(int i, int j) {
    if (i != j) {   
        parent[j] = i;
        return 1;
    }
    return 0;
}

void main() {
    printf("Enter number of vertices:");
    scanf("%d", &n);
    printf("Enter the cost adjacency matrix:\n"); 
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            printf("%d%d:",i,j);
            scanf("%d", &cost[i][j]);
            if (cost[i][j] == 0)
                cost[i][j] = 999; // Large value for no connection
        }
    }

    while (ne < n) {
        for (i = 1, min = 999; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                if (cost[i][j] < min) {
                    min = cost[i][j];
                    a = u = i;
                    b = v = j;
                }
            }
        }

        u = find(u);
        v = find(v);

        if (uni(u, v)) {
            printf("%d edge is (%d, %d) = %d\n", ne, a, b, min);
            ne++;
            mincost += min;
        }
        cost[a][b] = cost[b][a] = 999; // Mark edge as processed
    }
    printf("Minimum cost is %d\n", mincost);
}