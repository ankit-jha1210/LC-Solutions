#include <iostream>
using namespace std;
int main()
{
    int n;
    cout << "Enter the value of n" << endl;
    cin >> n;
    int sum = 0;
    for (int i = 2; i <= n; i++)
    {
         int flag = 0;
        for (int j = 2; j < i; j++)
        {
            if (i % j == 0)
            {
                flag = 1;
                break;
            }
        }
        if (flag == 0)
        {
            sum += i;
        }
        
    }
cout<<"sum is: " << sum << endl;
return 0;
}
