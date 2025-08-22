<h2><a href="https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1">Median in a row-wise sorted Matrix</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO" style="user-select: auto;"><p style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">Given a <strong style="user-select: auto;">row-wise sorted</strong> matrix&nbsp;</span><strong style="font-size: 18.6667px; user-select: auto;">mat[][]</strong><span style="font-size: 14pt; user-select: auto;"> of size n*m, where the number of rows and columns is always </span><strong style="font-size: 14pt; user-select: auto;">odd</strong><span style="font-size: 14pt; user-select: auto;">.&nbsp;Return the <strong style="user-select: auto;">median</strong> of the matrix.</span></p>
<p style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;"><strong style="user-select: auto;">Examples:</strong></span></p>
<pre style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;"><strong style="user-select: auto;">Input</strong>: mat[][] = [[1, 3, 5], <br style="user-select: auto;">                [2, 6, 9], <br style="user-select: auto;">                [3, 6, 9]]
<strong style="user-select: auto;">Output:</strong>&nbsp;5
<strong style="user-select: auto;">Explanation</strong>: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.
</span></pre>
<pre style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;"><strong style="user-select: auto;">Input: </strong>mat[][] = [[2, 4, 9],
                [3, 6, 7],
                [4, 7, 10]]
<strong style="user-select: auto;">Output: </strong>6
<strong style="user-select: auto;">Explanation</strong>: Sorting matrix elements gives us [2, 3, 4, 4, 6, 7, 7, 9, 10]. Hence, 6 is median.</span></pre>
<pre style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;"><strong style="user-select: auto;">Input: </strong>mat = [[3], [4], [8]]
<strong style="user-select: auto;">Output: </strong>4
<strong style="user-select: auto;">Explanation</strong>: Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.<br style="user-select: auto;"></span></pre>
<p style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;"><strong style="user-select: auto;">Constraints:</strong><br style="user-select: auto;">1 ≤ n, m ≤ 400<br style="user-select: auto;">1 ≤ mat[i][j] ≤ 2000</span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Matrix</code>&nbsp;<code>Binary Search</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;