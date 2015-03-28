//Esteban Foronda Sierra
using namespace std;
#include <algorithm>
#include <iostream>
#include <iterator>
#include <numeric>
#include <sstream>
#include <fstream>
#include <cassert>
#include <climits>
#include <cstdlib>
#include <cstring>
#include <string>
#include <cstdio>
#include <vector>
#include <cmath>
#include <queue>
#include <deque>
#include <stack>
#include <list>
#include <map>
#include <set>

template <class T> string toStr(const T &x)
{ stringstream s; s << x; return s.str(); }
template <class T> int toInt(const T &x)
{ stringstream s; s << x; int r; s >> r; return r;}

#define D(x) cout << #x " is " << x << endl

int main(){
	int n, id, chair;
	string name, address;
	cin >> n;
	id = 0;
	chair = 20;
	name = "Edificio ";
	address = "Calle ";
	while(n--){
		printf("lugar\n");
		printf("%d\n", id++);
		name += toStr(id);
		address += toStr(id);
		printf("%s\n", name.c_str());
		printf("%d\n", chair++);
		printf("%s\n", address.c_str());
		printf("false\n");
	}
	return 0;
}




