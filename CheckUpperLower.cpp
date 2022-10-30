#include<iostream>
using namespace std;

int main(){

     cout<<"Enter the value:"<<endl;
     char ch;
     cin>>ch;
     int as = int(ch);
     cout<<"Ascii value is :"<<as<<endl;
     if(as>=97 && as<=112){
        cout<<"Lower case"<<endl;
     }
     else if(as>=65 && as<=90){
        cout<<"Upper case"<<endl;
     }
     else if (as>=48 && as<=57){
        cout<<"Number"<<endl;
     }
     else{
        cout<<"special Character"<<endl;
     }
    return 0;

}
