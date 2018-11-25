## Summary
알고리즘 푼 문제 소스 및 생각정리 & 풀이법
<br/>
<br/>

- Baekjoon
  * [2156. 포도주 시식](#포도주-시식)
  * [13023. ABCDE](#ABCDE)
  * [11053. 가장 긴 증가하는 부분 수열](#가장-긴-증가하는-부분-수열)
  * [9461. 파도반 수열](#파도반-수열)
  * [11726. ](#2xn-타일링)
  
<br/>
<br/>
<br/>

### 포도주 시식

##### 소스
[포도주 시식](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P2156_drinkWine.java) - Dynamic Programming

##### 풀이법
* 시작점
  
  DP 문제에서 답 도출할 때, i번째 (혹은 i, j번째) 일 때 최적의 답을 구하고 저장해서 그 값을 쓰는 방식인 것 같아서
  
  1. Result 배열 만듦
  2. 1차원 배열인지 (i), 2차원 배열인지(i, j) 더 필요한 지 고민
  3. 잘 모르겠음
  4. 1차원으로 잡아보고 값이 더 필요하다 싶으면 2차원으로 잡기로 함

* 1차시도
  
  기준 점이 되는 i ( i=0일 때, 1번째 잔)를 선택했을 때, 이전 잔을 선택한 값, 아닌 값 두 개를 비교해 MAX 값 저장
	
  예제는 답이 잘 나와서 제출했는데, 오답…………


* 2차시도

	기준 점이 되는 i를 선택했을 때의 MAX 값은 맞는데, 이 값을 i-1의 MAX 값과 비교해야 함 ( R[i-1]값보다 R[i]이 작으면, i를 선택하지 않는 게 최선의 선택)
  
  통과

##### 참고
- http://new93helloworld.tistory.com/220
- https://www.zerocho.com/category/Algorithm/post/584b979a580277001862f182


<br/><br/>


### ABCDE

##### 소스
[ABCDE](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P13023_ABCDE.java) - Graph, DFS

##### 풀이법
* 시작점

  Graph 문제에 ABCDE 로 이어진 length를 찾는 문제니까 DFS로 풀어야겠다고 생각했다.
  
* 1차시도

  1. 시작점(root)을 모든 노드에 대해 생각해야 한다. 1에서 시작하는 경우와 6에서 시작하는 깊이가 다르게 나올 수 있음.
  2. stack을 하나 두고, 시작점부터 push. 연결된 노드 값을 visit하지 않았을 때 visit체크 후 stack에 push하고 그 값을 기준으로 반복.
  3. stack is empty 할 때까지 못찾으면 return 0. 그 전에 stack의 길이가 5가 되면 return 1.
  
  이렇게 했더니 시간 초과가 난다..😭
  stack을 돌면 어떤 element들이 length가 5인지까지 알 수 있지만 이 문제는 그냥 return 1 아니면 0이니까 사실 좀 불필요한 것 같기도하고
  게다가 stack으로 돌았을 때 더이상 visit 할 곳이 없으면 pop해줘야 하는 타이밍도 flag로 체크해줘야 하고.... 하여튼 복잡시럽다 (해당 소스의 printABCDERel 메소드)

* 2차시도

  검색해봄. 시간초과 어떻게 안나는지. DFS는 스택과 재귀로 사용할 수 있는데, 재귀를 사용하면 깔끔하게 풀 수 있는 것 같다.
  
  1. 재귀는 들어갈 곳이 없으면 그냥 알아서 위로 나오니까 end flag같은게 필요 없어서 좋은 듯.
  2. curr 노드를 받고, curr는 바로 visit 체크.
  3. rel이 있는 노드 중 visit 되지 않은 노드로 재귀, curr을 next노드로 지정.
  4. length가 5면 return 1. dfs 탐색 해도 답이 안나오면 return 0.

  dfs 방법은 아래 블로그를 참고했다😄 다음엔 혼자 힘으로도 시간초과 안나게 풀 수 있기를.
  
##### 참고
- http://wookje.dance/2017/04/18/boj-13023-ABCDE/

<br/><br/>



### 가장 긴 증가하는 부분 수열

##### 소스
[가장 긴 증가하는 부분 수열](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P11053_LongSequence.java) - Dynamic Programming

##### 풀이법
* 시작점
  
  (bad👎) '증가'하는 수열을 max 값을 저장한 후 max값보다 커야 한다고 생각해서 풀었더니 답이 안나온다. DP 분류라는 것을 알고 풀었다.
  
*1차 시도

  수열의 처음 값 부터 보면서 max를 저장 후, 수열 인자 값과 비교해서 
  
	max > A(i)이면 dp[i] = dp[i-1]
	max < A(i)이면 dp[i] = dp[i-1] + 1
	  
  와 같이 문제를 풀었다.
  이렇게 풀면 2 1 2 와 같은 수열의 정답이 2가 아니라 1이 나온다😅
  
*2차 시도

  '증가'하는 수열의 조건과, dp 돌면서 이전의 값 중 현재와 비교했을 때의 max값 저장
  
  이 두가지를 기억하니 풀렸다.
  
 
##### 참고
- http://suriisurii.tistory.com/39

<br/><br/>

### 파도반 수열

##### 소스
[파도반 수열](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P9461_WaveSequence.java) - Dynamic Programming


##### 풀이법

* 시작점

  수열의 규칙을 보니
  
	P[i] = P[i-2] + P[i-3] ( i >= 3)
	P[i] = 1 					 ( i < 3)
	
  이어서 점화식을 사용해 풀었다.
  
* 시도
  
  점화식이 분명 맞는데 틀렸다고 나와서 보니, 1 <= N <= 100인 범위에서, 100을 넣으면 int 범위를 넘어서 답이 제대로 출력되지 않는다. DP 배열을 long으로 두고 해야 함!
  
 <br/><br/>
 
 
### 2xn 타일링

##### 소스
[2xn 타일링](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P11726_2xnTiling.java) - Dynamic Programming

##### 풀이법

공책에 그리면서 n=5 까지 패턴을 보니, 1 2 3 5 8 ... 수열이 나왔는데 피보나치 수열이라서 피보나치 점화식대로 풀었다.

다만, 1000까지의 돌렸을 때 long 값도 거뜬히 넘기 때문에, 점화식으로 더해나갈 때 10007로 나누면서 더해가야 한다.
