#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
struct compare {
    inline bool operator()(const std::string& first,
            const std::string& second) const
    {
        return first.size() < second.size();
    }
};
bool isPalindrome(string S)
{
    
    for (int i = 0; i < S.length() / 2; i++) {
 
        if (S[i] != S[S.length() - i - 1]) {
           
            return false;
        }
    }
    return true;
}
int solve(string s,int co)
{
	int n = s.size();
	
	vector<vector<bool> > dp(n, vector<bool>(n, false));
	for (int i = 0; i < n; i++) {
		dp[i][i] = 1;
		if (i < n && s[i] == s[i + 1]) {
			dp[i][i + 1] = 1;
		}
	}
	for (int len = 3; len <= n; len++) {
		for (int i = 0; i + len - 1 < n; i++) {
			if (s[i] == s[i + (len - 1)]
				&& dp[i + 1][i + (len - 1) - 1]) {
				dp[i][i + (len - 1)] = true;
			}
		}
	}
	vector<int> kmp(n, 0);
	for (int i = 0; i < n; i++) {
		int j = 0, k = 1;
		while (k + i < n) {
			if (s[j + i] == s[k + i]) {
				
				dp[k + i - j][k + i] = false;
				kmp[k++] = ++j;
			}
			else if (j > 0) {
				j = kmp[j - 1];
			}
			else {
				kmp[k++] = 0;
			}
		}
	}
	int count = 0;
	vector<string> ans;
	for (int i = 0; i < n; i++) {
		string str;
		for (int j = i; j < n; j++) {
			str += s[j];
			if (dp[i][j]) {
				
				count++;
				ans.insert( ans.end(), str);

				
			}
		}
	}
	
    compare c;
    sort(ans.begin(), ans.end(), c);
	for(int k=0;k<count;k++){
	    if(isPalindrome(s+ans[k])){
	        cout<<"Case #"<<co<<": "<<ans[k]<<"\n";
	        break;
	    }
	}
	return 0;
}

int main()
{
    int n;
    cin>>n;
    int co=1;
	for(int i=0;i<n;i++){
	    int n1;
	    cin>>n1;
	    string s;
	    cin>>s;
	    solve(s,co);
	    co++;
	}
	
	return 0;
}

