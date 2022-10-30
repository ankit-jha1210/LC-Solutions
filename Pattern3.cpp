// 1
// 2 3
// 3 4 5
// 4 5 6 7
#include<iostream>
using namespace std;
 int main(){
    int n;
    cout<<"ENter n:"<<endl;
    cin>>n;
    cout<<endl;
    for(int i =1;i<=n;i++){
        int count = i;
        for(int j =1;j<=i;j++){

            cout<<i+j-1<<" ";      // or print count
            count++;
        }
        cout<<endl;
    }
      return 0;
 }
