<h2><a href="https://www.geeksforgeeks.org/problems/meeting-rooms-iii/1">Meeting Rooms III</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO" style="user-select: auto;"><p style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">You are given an integer <strong style="user-select: auto;">n</strong> representing the number of rooms numbered from <strong style="user-select: auto;">0</strong> to <strong style="user-select: auto;">n - 1</strong>. Additionally, you are given a 2D integer array <strong style="user-select: auto;">meetings[][]</strong> where <strong style="user-select: auto;">meetings[i]</strong> = <strong style="user-select: auto;">[start<sub style="user-select: auto;">i</sub>, end<sub style="user-select: auto;">i</sub>]</strong> indicates that a meeting is scheduled during the half-closed time interval <strong style="user-select: auto;">[start<sub style="user-select: auto;">i</sub>, end<sub style="user-select: auto;">i</sub>)</strong>. All start<sub style="user-select: auto;">i</sub> values are unique.</span></p>
<p style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">Meeting Allocation</span><strong style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;"> Rules:</span></strong></p>
<ul style="user-select: auto;">
<li style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">When a meeting starts, assign it to the available room with the smallest number.</span></li>
<li style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">If no rooms are free, delay the meeting until the earliest room becomes available. The delayed meeting retains its original duration.</span></li>
<li style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">When a room becomes free, assign it to the delayed meeting with the earliest original start time.</span></li>
</ul>
<p style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">Determine the <strong style="user-select: auto;">room number</strong> that hosts the most meetings. If multiple rooms have the same highest number of meetings, return the smallest room number among them.</span></p>
<p style="user-select: auto;"><strong style="user-select: auto;">Examples:</strong></p>
<pre style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;"><strong style="user-select: auto;">Input: </strong>n = 2, meetings[][] = [[0, 6], [2, 3], [3, 7], [4, 8], [6, 8]]<strong style="user-select: auto;">
Output:</strong> 1<strong style="user-select: auto;">
Explanation: </strong>Time 0: Both rooms available. [0,6] starts in room 0.
Time 2: Room 0 busy until 6. Room 1 available. [2,3] starts in room 1.
Time 3: Room 1 frees up. [3,7] starts in room 1.
Time 4: Both rooms busy. [4,8] is delayed.
Time 6: Room 0 frees up. Delayed [4,8] starts in room 0 [6,10).
Time 6: [6,8] arrives but both rooms busy. It’s delayed.
Time 7: Room 1 frees up. Delayed [6,8] starts in room 1 [7,9).</span><br style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">Meeting counts: [2, 3]</span></pre>
<pre style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;"><strong style="user-select: auto;">Input: </strong>n = 4, meetings[][] = [[0, 8], [1, 4], [3, 4], [2, 3]<strong style="user-select: auto;">
Output: </strong>2<strong style="user-select: auto;">
Explanation: </strong>Time 0: All rooms available. [0,8] starts in room 0.
Time 1: Room 0 busy until 8. Rooms 1, 2, 3 available. [1,4] starts in room 1.
Time 2: Rooms 0 and 1 busy. Rooms 2, 3 available. [2,3] starts in room 2.
Time 3: Room 2 frees up. [3,4] starts in room 2.</span><span style="font-size: 14pt; user-select: auto;">
Meeting counts: [1, 1, 2, 0]</span></pre>
<p style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></span></p>
<ul style="user-select: auto;">
<li style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">1&nbsp;<span style="color: rgb(30, 34, 41); font-family: Nunito; font-size: 17px; background-color: rgb(255, 255, 255); user-select: auto;">≤</span>&nbsp;n&nbsp;<span style="color: rgb(30, 34, 41); font-family: Nunito; font-size: 17px; background-color: rgb(255, 255, 255); user-select: auto;">≤</span>&nbsp;10<sup style="user-select: auto;">4</sup></span></li>
<li style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">1&nbsp;<span style="color: rgb(30, 34, 41); font-family: Nunito; font-size: 17px; background-color: rgb(255, 255, 255); user-select: auto;">≤</span>&nbsp;meetings.size()&nbsp;<span style="color: rgb(30, 34, 41); font-family: Nunito; font-size: 17px; background-color: rgb(255, 255, 255); user-select: auto;">≤ </span>10<sup style="user-select: auto;">4</sup></span></li>
<li style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">meetings[i].size() == 2</span></li>
<li style="user-select: auto;"><span style="font-size: 14pt; user-select: auto;">0&nbsp;<span style="color: rgb(30, 34, 41); font-family: Nunito; font-size: 17px; background-color: rgb(255, 255, 255); user-select: auto;">≤</span>&nbsp;start<sub style="user-select: auto;">i&nbsp;</sub>&lt; end<sub style="user-select: auto;">i&nbsp;</sub><span style="color: rgb(30, 34, 41); font-family: Nunito; font-size: 17px; background-color: rgb(255, 255, 255); user-select: auto;">≤</span>&nbsp;10<sup style="user-select: auto;">4</sup></span></li>
</ul></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Heap</code>&nbsp;<code>Data Structures</code>&nbsp;<code>priority-queue</code>&nbsp;