#include <bits/stdc++.h>
#define MAX 1000001
#define ll long long int
using namespace std;

struct PrimeNum
{
    bool primes[MAX];
    vector <int> p;
    PrimeNum()
    {
        for (int i = 3; i < MAX; i += 2) {
            primes[i] = 1;
        }

        primes[2] = 1;

        for (int i = 4; i < MAX; i += 2) {
            primes[i] = 0;
        }

        primes[0] = primes[1] = 0;

        for (int i = 3; i * i < MAX; i += 2)
        {
            if (primes[i]) {
                for (int j = i * i; j < MAX; j += 2 * i) {
                    primes[j] = 0;
                }
            }
        }

        p.push_back(2);

        for (int i = 3; i < MAX; i += 2) {
            if (primes[i]) {
                p.push_back(i);
            }
        }
    }

    bool isPrime(int x)
    {
        return primes[x];
    }

    vector<int> getPrimes()
    {
        return p;
    }
};

int pre[MAX];

int main()
{
    PrimeNum px;
    pre[0] = pre[1] = 0;
    int i;
    for (i = 2; i < MAX; i++)
    {
        pre[i] = pre[i - 1];
        if (px.isPrime(i)) {
            pre[i] = pre[i] + 1;
        }
    }
    int t, a, b, k, lo, mid, hi, ans;
    cin >> t;
    while (t--)
    {
        cin >> a >> b >> k;
        lo = a; hi = b; ans = -1;
        while (lo <= hi)
        {
            mid = (lo + hi) >> 1;
            if (pre[mid] - pre[a - 1] >= k)
            {
                ans = mid;
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        cout << ans << endl;
    }
}