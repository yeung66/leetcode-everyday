type TreeNode =
    { value: int
      left: TreeNode option
      right: TreeNode option }
      
let minDepth node = 
    let rec loop node =
        match node with
        | None -> 0
        | Some node ->
            let left = loop node.left
            let right = loop node.right
            match left, right with
            | 0, 0 -> 1
            | 0, _ -> 1 + right
            | _, 0 -> 1 + left
            | _, _ -> 1 + min left right
    loop node