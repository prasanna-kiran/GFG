<h2><a href="https://www.geeksforgeeks.org/problems/next-greater-element/1">Next Greater Element in Circular Array</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="user-select: auto;"><p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Given a circular integer array <strong style="user-select: auto;">arr[]</strong>, the task is to determine the next greater element <strong style="user-select: auto;">(NGE)</strong> for each element in the array.</span></p>
<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">The next greater element of an element <strong style="user-select: auto;">arr[i]</strong> is the first element that is greater than <strong style="user-select: auto;">arr[i]</strong> when traversing circularly. If no such element exists, return <strong style="user-select: auto;">-1</strong> for that position.</span></p>
<p style="user-select: auto;"><strong style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Note: </span></strong><span style="font-size: 18px; user-select: auto;">Since the array is circular, after reaching the last element, the search continues from the beginning until we have looked at all elements once.</span></p>
<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Examples:&nbsp;</strong></span></p>
<pre style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Input</strong>: arr[] = [1, 3, 2, 4]
<strong style="user-select: auto;">Output</strong>: [3, 4, 4, -1]
<strong style="user-select: auto;">Explanation</strong>:<br style="user-select: auto;"></span><span style="font-size: 18px; user-select: auto;">The next greater element for 1 is 3.
The next greater element for 3 is 4.
The next greater element for 2 is 4.
The next greater element for 4 does not exist, so return -1.</span></pre>
<pre style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="font-size: 18px; user-select: auto;">Input</strong><span style="font-size: 18px; user-select: auto;">: arr[] = [0, 2, 3, 1, 1]
</span><strong style="font-size: 18px; user-select: auto;">Output</strong><span style="font-size: 18px; user-select: auto;">: [2, 3, -1, 2, 2]
<strong style="user-select: auto;">Explanation:
</strong>The next greater element for 0 is 2.
The next greater element for 2 is 3.
The next greater element for 3 does not exist, so return -1.
The next greater element for 1 is 2 (from circular traversal).
The next greater element for 1 is 2 (from circular traversal).</span></span></pre>
<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Constraints:</strong><br style="user-select: auto;">1 ≤ arr.size() ≤ 10<sup style="user-select: auto;">5</sup><sup style="user-select: auto;"><br style="user-select: auto;"></sup></span></span><span style="font-size: 18px; user-select: auto;"><span style="font-size: 18px; user-select: auto;">0 ≤ arr[i] ≤ 10<sup style="user-select: auto;">6</sup></span></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Flipkart</code>&nbsp;<code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Stack</code>&nbsp;<code>Data Structures</code>&nbsp;