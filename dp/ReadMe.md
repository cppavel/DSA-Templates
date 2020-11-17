Basic dp problems + approximate solutions of some NP-complete problems

1. NP-complete - every problem in class NP can be reduced to it and there exists a non-deterministic algorithm
2. NP-hard - any problem in NP can be reduced to it. 
3. NP - polynomial time with non-deterministic algorithm
4. P - polynomial time with deterministic algorithm

Here is the submission by Mingwei Shi:
HI Pavel, i have seen your code about one dimension knapsack(every item could be seleted only once)
In this case we could use rolling array to optimize the space complexity from O(N^2) to O(N)
Here is code :I think  you could translate it into java or any high level language 

Firstly ,for any problem related to dymaic programming : we need to think about strategy,state,boundary,transfer eqation.
i) state array:state arry is norammly the what the question ask .If i use more mathmatically, the codomain of thie goal function.
Initlly,we use two dimension array f[i][j] It is expressed as the maximum profit of selecting several items in the first i, and the capacity already spent is j.
For example, f[3][5] means that among the first three items, we choose 0 or 1, 2 or 3, and then we have spent 5 points of the maximum profit.

Stage :
The decision or strategy  is obvious, which is to choose or not to choose 

Boundary conditions
Just empty the f array, because what we want is the maximum profit.

Transfer equation:
f[i][j]=max(f[i-1][j],f[i][j-v[i]]+w[i];

f[i−1][j] is the maximum profit of the first i-1 items, spending j capacity, here we can understand it as the maximum profit of not selecting the i-th item (that is, selecting the first i-1) .
f[i][j−v[i]]+w[i] is to select the i-th item and cost the maximum profit of j capacity, so why write it like this?
Because we want to put this item, we need at least v[i]v[i] capacity, so we can only push from j−v[i] this capacity, otherwise we can't put down this backpack.
+w[i] is obviously to select this item, of course, add the value of this item.

Scrolling or(Rolling) array optimization
First step optimization:
First, for the state array, we only use f[i][j] and f[i−1][j] as shown in the following example

1)When i is 1, we use f[0][j] and f[1][j]
2)When i is 2, we use f[1][j]] and f[2][j]
3)When i is 3, we use f[2][j] and f[3][j]


Second step optimization:
In fact, our j does not necessarily have to be from v[i],1+v[i],2+v[i]…m, but can be from m,m−1.m−2…v[i]] because In this case, we can go from f[2][n] to f[n]. Because when the second decision is not processed at the beginning, f[1][j] must be equal to f[0][j], Then we start from m to v[i]] and start making decisions from top to bottom, and we can ignore the dimension f[0].

Here is my code :
#include <bits/stdc++.h>
using namespace std;
const int N=1100;
const int M=2e5;
int n,m,i,j,k,a[N],f[M];
int main()
{
    ios::sync_with_stdio(false);
    cin>>m>>n;//reading max capacity and the number of item
    for(int i=1;i<=n;i++)
        cin>>a[i]; 
    memset(f,0xcf,sizeof(f));//This line ,i initialize as INF YOU could initilize as 0
    f[0]=0; // boundary 
    for(int i=1;i<=n;i++)//selecting i item (first loop)
        for(int j=m;j>=a[i];j--)//capacity ! remember is must for last to first since i use one dimension array
        // this loop only has relation to prvious step ,has nothing to do with the step before previous step
        // you could regard it as Markov chain or state machine 
            f[j]=max(f[j],f[j-a[i]]+a[i]);//transfer
    int ans=0;// anser
    // f[n]
    for(int i=0;i<=m;i++)//
        ans=max(ans,f[i]);
    cout<<ans;//The optimization answer
    return 0;
}

Time complxity is O(N*M) the n is for the number of item , M is the for Volmue
Space complexity is O(N)
If YOU HAVE time, please look at it and I am very welcome to talk with you soon 
