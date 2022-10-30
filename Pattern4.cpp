//    1
//   121
//  12321
// 1234321      
using namespace std;
#include<iostream>
using namespace std;
int main(){
    int n;
    cout<<"Enter the value of n:"<<endl;
    cin>>n;
    for(int i =1; i<=n;i++){
        for( int space = n-i; space > 0; space--) cout<<" ";
        for(int j = 1; j<=i;j++){
            cout<<j; 
        }
        if(i>=2){
            for(int j = 1; j<=i-1;j++){
            cout<<i-j; 
        }
        }
        cout<<endl;
    }

    return 0;
}

