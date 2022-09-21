class Solution
{
    int solve(vector<int> &val, int n, bool includeFirst, vector<int> &dp)
    {
        if (n == 0)
        {
            if (includeFirst) return val[n];
            else return 0;
        }
        if (n == 1)
        {
            if (includeFirst) return max(val[n], val[n - 1]);
            else return val[n];
        }
        if (dp[n] != -1) return dp[n];
        return dp[n] = max(solve(val, n - 1, includeFirst, dp), solve(val, n - 2, includeFirst, dp) + val[n]);
    }
    public:
        int rob(vector<int> &val)
        {
            int n = val.size();
            if (n == 1) return val[0];
            vector<int> dp1(n, -1), dp2(n, -1);
            return max(solve(val, n - 2, true, dp1), solve(val, n - 1, false, dp2));
        }
};