/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

 var ans []int

 func preorder(root *Node) []int {
	 ans = make([]int, 0)
	 visit(root)
	 return ans  
 }
 
 func visit(node *Node) {
	 if node != nil {
		 ans = append(ans, node.Val)
		 for _, c := range node.Children {
			 visit(c)
		 }
	 }
 }