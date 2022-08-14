We cannot apply bfs here cause if we do we will get tle as in graph there is exponential path and using dfs won't work it works in tree cause it has has unique path and in graph a path from src to dest can be exponential
Now coming back to question we will apply bfs here come to think of it. We will increase the length in each level as we have different possibilities on each level and whenver we get the endWord we return the level or length
**All words are nodes and transformation b/w each them is a edge it's a graph problem**
​
`beginWord = "hit", endWord = "ppp", wordList = ["hot","dot","dog","lot","log","ppp"]`
We return 0 bcs what if we have end word as ppp and it was in wordlist but we could not make it so we return 0
​