type TreeNode =
    { mutable value: int
      left: TreeNode option
      right: TreeNode option }

let recoverTree root = 
    let inorder node = 
        let rec loop node acc = 
            match node with
            | None -> acc
            | Some node -> 
                let mutable acc = loop node.left acc
                loop node.right (acc @ [ node.value ])
        loop node []

    let inorderList = inorder root
    let inorderListSorted = List.sort inorderList
    let first, second = 
        List.zip inorderList inorderListSorted
        |> List.filter (fun (a, b) -> a <> b)
        |> List.head

    let rec loop node first second =
        match node with
        | None -> ()
        | Some node ->
            if node.value = first then
                node.value <- second
            else if node.value = second then
                node.value <- first
            loop node.left first second
            loop node.right first second
    loop root first second