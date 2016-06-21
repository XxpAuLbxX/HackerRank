#define INF 2147483647
#define FUNCTION(name,operator) inline void name(int &current, int next) {(current operator next) ? false : current = next;}
#define io(v) cin >> v
#define toStr(str) #str
#define foreach(v, i) for (int i = 0; i < v.size(); ++i)