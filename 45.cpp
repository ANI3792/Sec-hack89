#include<bits/stdc++.h>
using namespace std;

int main()
{
	int che[288]={0};
	string st="opposite";
	for(int i=0;i<st.size();i++)
	che[st[i]]++;
	for(int i=0;i<st.size();i++)
	cout<<che[st[i]]<<endl;
	
	cout<<che['p']<<endl;
	return 0;
}
