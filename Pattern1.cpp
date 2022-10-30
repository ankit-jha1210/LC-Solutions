// * * * * *
// * * * *
// * * *
// * *
// *

#include <iostream>
using namespace std;
// for(int i = n; i >= 1; i--) {
// 	        for(int j = 1; j <= i; j++) cout<<"*"<<" ";          // Ankit's logic
// 	        cout<<endl;
// 	    }
int main()
{
    int n;
    cout << "Enter n " << endl;
    cin >> n;
    for(int i = 1; i <= n;i++)
    {
        for(int j = n; j >= i; j--) cout <<"*"<<" ";
        cout << endl;
    }
}
