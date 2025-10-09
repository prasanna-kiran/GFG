'''
# Node Class:
class Node:
    def init(self,val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
    #Function to check whether all nodes of a tree have the value 
    #equal to the sum of their child nodes.
    def isSumProperty(self, root):
        # code here
        
        def dfs(root):
            if not root or (root.left == None and root.right==None):
                return 1
                
            if root.left:
                leftVal = root.left.data
            else:
                leftVal = 0
            
            if root.right:
                rightVal = root.right.data
            else:
                rightVal = 0
            
            if root.data != leftVal+rightVal:
                return 0
                
            return dfs(root.left) and dfs(root.right)
        
        return dfs(root)
