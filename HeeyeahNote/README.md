## Summary
알고리즘 푼 문제 소스 및 생각정리 & 풀이법
<br/>
<br/>

- Baekjoon
  * [2156. 포도주 시식](#포도주-시식)
  * [13023. ABCDE](#ABCDE)
  * [11053. 가장 긴 증가하는 부분 수열](#가장-긴-증가하는-부분-수열)
  * [9461. 파도반 수열](#파도반-수열)
  * [11726. 2xn 타일링](#2xn-타일링)
  * [2011. 암호코드](#암호코드)
  * [2294. 코인2](#코인2)
  * [9996. 한국이 그리울 땐 서버에 접속하지](#한국이-그리울-땐-서버에-접속하지)
  * [1927. 최소힙](#최소힙)
<br/>

- [Programmers](#Programmers)
  * [연습-해시 Part](#해시-Part)
  * [연습-스택/큐 Part](#스택_큐-Part)
  * [연습-힙(Heap) Part](#힙(Heap)-Part)
  * [연습-정렬 Part](#정렬-Part)
  * [연습-완전탐색 Part](#완전탐색-Part)
  * [연습-탐욕법(Greedy) Part](#탐욕법-Part)
  * [연습-다이나믹프로그래밍 Part](#다이나믹프로그래밍-Part)

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

* 1차 시도

  수열의 처음 값 부터 보면서 max를 저장 후, 수열 인자 값과 비교해서

	max > A(i)이면 dp[i] = dp[i-1]
	max < A(i)이면 dp[i] = dp[i-1] + 1

  와 같이 문제를 풀었다.
  이렇게 풀면 2 1 2 와 같은 수열의 정답이 2가 아니라 1이 나온다😅

* 2차 시도

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


<br/>
<br/>




### 암호코드
##### 소스
[암호코드](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/programmers/dp/TileOrnaments.java) - DP

##### 풀이법

한번에 못풀어서 아주 고생. 몇번이나 고쳤다.
반례는 수도 없이 많다.
011110
10203040
abcdefl
10000001
203141
231030
12031
...

 * 0을 간과한 사실. 첫글자나 끝글자 말고도 중간에 들어갔을 때 처리를 해줘야 함
 * 0이 있을 때는 하다보면 dp값이 작아지기도 한다... ( 12031 )
 * dp배열은 i 인덱스를 봤을 때, 그 시점에 구할 수 있는 암호의 최대 개수

 * 이거 한자리씩 본 것 말고, 2자리씩 끊어서 케이스 나누면 더 쉬운듯!

<br/>
<br/>

### 코인2
##### 소스
[코인2](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P2294_coin2.java) - dp

##### 풀이법

1, 3, 5 로 10을 만드는 예제를 생각해보기. dp[n] : n을 만드는 (k까지 도달하는) 동전의 최소 개수
어려웠다. 주의해야 할 게 6, 7, 8로 11을 만드는 건 불가능한데, 단순히 dp[n] = min(dp(n-cost) ... ) + 1 은 아니라는 것.
1, 3, 5를 10으로 만들 때 dp[3] = min( dp[3-1]+1, dp[3-3] +1, dp[3-5] +1 ) = min ( dp[2] +1, dp[0] +1 ) = min ( 2+1, 1) = 1 이라지만 다른 경우에선 반드시 n-cost의 dp가 존재하는 것이 아니며, 그 값이 0일 경우도 생각해야하고 하여튼 복잡시럽다 :)
<br/>
<br/>


### 한국이 그리울 땐 서버에 접속하지
##### 소스
[한국이 그리울 땐 서버에 접속하지](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P9996_missKorea.java) - 문자열

##### 풀이법

문자열 문제. 반례는 시작이 abcd 이고 끝이 cdef 인데 abcdef 일 때의 결과.

<br/>
<br/>

### 최소힙
##### 소스
[최소힙](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/baekjoon/P1927_MinHeap.java) - heap


<br/>
<br/>

## Programmers

### 해시 Part

##### 소스
[hash-part](https://github.com/heeyeah/AlgorithmPractice/tree/master/HeeyeahNote/src/programmers/hash)

##### 풀이법

문제는 총 4갠데, 해시라서 map을 사용하면 대부분 풀린다. <br/>
+ 위장<br/>
이건 어떻게 풀지 감이 안와서 이것저것 뒤져서 참고한 결과.. 수학 문제라는 느낌 :) 알아두면 좋을 방법이긴 하다.<br/>
같은 분류의 것이 a,b / c, d, e 라고 하면(0, a, b) = 선택안함, a선택, b선택 총 3가지의 경우가 있고 마찬가지로 하면 두번째 집단은 4가지이다.<br/>
여기서 아무것도 선택안하는 경우는 없으니 3*4 -1 = 11 이 된다는 말! <br/>

+ 베스트앨범<br/>
내가 푼 것보다 간단할 수 있을 것 같은데, 일단 map도 쓰고 treemap도 쓰고 comparable override해서 풀었다. <br/>
장르를 나누는 건 hashmap으로 나누고, 장르에 속한 노래들은 list에 저장했다. 저장할 때 장르합이라는 맵을 하나 더 생성해서 장르의 총 재생 수도 같이 저장.<br/>
장르합이라는 맵은 key-value를 바꿔서 (조건에 장르의 합은 중복되지 않는다는 조건이 있어서! ) treemap으로 key sort해서, 큰 값부터 iterator.<br/>
장르 hashmap에서 꺼낸 list들을 song의 재생 수가 큰 순서, 재생 수가 같으면 인덱스가 작은 순서대로 출력해야 하는데 이 때는 Song 라는 클래스(구조체)를 만들어서 comparable을 implement한 뒤 compareTo메소드를  override 했다. 라이브러리를 되게 많이 쓴 것 같다.<br/>

+ 완주하지 못한 선수<br/>


<br/>
<br/>

### 스택_큐 Part

##### 소스
[stack/queue-part](https://github.com/heeyeah/AlgorithmPractice/tree/master/HeeyeahNote/src/programmers/stackqueue)

##### 풀이기록

+ 쇠막대기<br/>
문제를 어떻게 풀 지만 생각하면 스택을 사용해서 구현하긴 쉽다. <br/>
나같은 경우엔 아래와 같이 풀었다. <br/>
1. 레이저를 구분하기 위해 * 로 치환<br/>
2. 괄호 짝짓기 문제처럼 스택에 push, pop 반복하면서 괄호 사이에 있는 레이저 개수 체크<br/>
3. 괄호는 쇠막대기고 그 사이에 레이저가 자르 것이기 때문에 레이저 개수+1개는 자른 쇠막대기의 개수<br/><br/>
+ 다리를 지나는 트럭<br/>
스택/큐로 분류되는데 난 그냥 푼 듯. 그래서 다 풀고 나서 다른 사람 풀이도 보고 첨부한다. <br/>
난 이 문제 풀 때, 트럭마다 check 배열을 두고 다리 위에 몇 초 후에 없어지는 지를 체크했다. 만약 다리 길이가 2이면 처음에 2를 체크 배열에 설정하고 시간이 지날 때마다 1을 빼면서 0이 될 떄까지 체크.
1. 시간이 지날 때마다 check 배열의 값들을 -1 해주고, -1한 뒤의 값이 0이면 limit에서 다시 트럭무게만큼 더함.
2. 그리고 idx를 따로 둬서 커서처럼 트럭이 다리 위를 지날 때 값을 check에 기록
3. 마지막 트럭이 지나갔을 때 (check의 마지막 배열이 0 일 때) 종료<br/><br/>
+ 기능개발<br/>
일수 계산할 때 double값을 얻으려면 인자에 double값이 있어야 하는 것과 올림 함수 ceil 기억.<br/>
queue를 잘 다루려면 while queue.isEmpty가 아닐때까지 프로세싱을 잘해야 하는데, 여기서 그냥 while문 두번 돌리면 되는 걸, 두번 돌릴 생각을 해서 어렵게 풀려고 했다는 것!<br/><br/>
+ 주식가격<br/>
queue와 stack 사용!<br/>
1. queue에 다 넣고 하나씩 뽑으면서 걸리는 시간 측정
2. 한 element 를 기준으로 시간 측정 후 다음 element 계산하기 위해 뽑았던 거 Stack에 넣어놓고 다시 queue에 삽

+ 프린터<br/>
Queue를 이용. priority 는 unique하지 않기 때문에 원래 배열된 index를 key로 사용. ( 주어진 location으로 get value 해서 답 도출해야 하므로 )

<br/><br/>

### 힙(Heap) Part
<br/><br/>
### 정렬 Part
<br/><br/>
### 완전탐색 Part
<br/><br/>
### 탐욕법 Part

##### 개념
탐욕 알고리즘은 두 가지 기본적인 속성을 가진다.
- 탐욕 선택 특성(Greedy choice property)
- 최적의 하부 구조(Optimal substructure)

탐욕 선택은 주어진 시점에 있어서 최선택을 선택하고, 문제 전체의 해답을 지역 최적의 답을 구함으로써 얻을 수 있다는 개념이다.

##### 소스
[greedy-part](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/programmers/greedy)

##### 풀이기록
+ 체육복<br/>
문제가 불친절해서 그냥 skip 하기로:O <br/><br/>
+ 단속카메라<br/>
카메라가 어느 위치에 있을 때가 최소값을 갖게 할 수 있는 지를 생각해야 한다. 겹치는 구간이 있을 때, 그 겹치는 구간의 어디에 단속카메라가 있어도 상관없지만 설치 대수의 최소값을 갖기 위해선 차가 고속도로를 나가는 시점인 제일 오른쪽에 설치해야 한다. <br/>
풀이와는 별개로 java로 알고리즘 문제를 풀면서 stream을 많이 사용하지 않았었는데, stream을 자주 사용해야겠다. **stream을 사용하면 collection이나 간단한 filter, comparator을 사용할 때 코드를 짧고 가독성 좋게 만드는 것 같다.** ~~그 외에도 stream의 장점이 있지만!~~

<br/><br/>


### 다이나믹프로그래밍 Part

##### 소스
[dynamic-part](https://github.com/heeyeah/AlgorithmPractice/blob/master/HeeyeahNote/src/programmers/dp)

##### 풀이기록
+ 타일 장식물<br/>
2xn 타일링과 유사한데, 직사각형의 둘레를 구해야 한다는 차이점. <br/><br/>

+ 정수 삼각형<br/>
Tree + dfs로 풀어야하나 잠깐 고민했는데, 그렇게 풀면 너무 복잡해질 것 같아서 포기했다. **DP를 풀 땐, 항상 DP를 무엇으로 정의할 것인가? 를 생각하고 문제를 풀어야** 한다.<br/>
이 문제에서 DP는 N만큼의 배열로 메모리를 잡고, 한 층씩 내려가면서 그 전의 값 2개 중 max값에 더해가면서 최대sum을 저장하는 것으로 생각했다.

<br/><br/>
