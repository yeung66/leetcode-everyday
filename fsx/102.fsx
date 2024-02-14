type TreeNode =
    { value: int
      left: TreeNode option
      right: TreeNode option }

let levelOrder (root: TreeNode option) =
    match root with
    | None -> []
    | Some root ->
        let rec loop nodes acc =
            let filterNodes = nodes |> List.choose id
            match filterNodes with
            | [] -> acc
            | _ ->
                let nextNodes =
                    filterNodes
                    |> List.collect (fun node -> [ node.left; node.right ])

                loop nextNodes (acc @ [ filterNodes |> List.map (fun n -> n.value)])

        loop [ Some root ] []

let test =
    let tree =
        Some
            { value = 3
              left = Some { value = 9; left = None; right = None }
              right =
                Some
                    { value = 20
                      left =
                        Some
                            { value = 15
                              left = None
                              right = None }
                      right = Some { value = 7; left = None; right = None } } }

    levelOrder tree
    |> printfn "%A" // [[3]; [9; 20]; [15; 7]]


