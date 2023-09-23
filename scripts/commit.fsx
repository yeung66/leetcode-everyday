#!/usr/bin/env dotnet fsi
open System.IO

let mutable count = 0
let PATH = "/Users/scott/codes/leetcode-everyday"
Directory.SetCurrentDirectory(PATH)


// read files of current directory
Directory.GetFiles(Directory.GetCurrentDirectory())
|> Array.filter (fun f -> 
    // filter out files that are not directories
    not (File.GetAttributes(f).HasFlag(FileAttributes.Directory))
)
|> Array.filter (fun f -> not (f.EndsWith(".idea") || f.EndsWith(".gitignore") || f.EndsWith(".iml")))
|> Array.iter (fun f -> 
    // fetch the file extension
    let ext = Path.GetExtension(f)
    
    // if not directory called ext exists, create it
    if not (Directory.Exists(ext)) then
        Directory.CreateDirectory(ext) |> ignore

    // move the file to the directory
    File.Move(f, Path.Combine(ext, Path.GetFileName(f)))

    count <- count + 1
    printfn ""
) 

if count = 0 then
    printfn "No file to commit"
    exit 0

printfn "Commit %d files" count

// run external command
let run cmd args =
    let psi = new System.Diagnostics.ProcessStartInfo(cmd, args)
    psi.RedirectStandardOutput <- true
    psi.UseShellExecute <- false
    let p = System.Diagnostics.Process.Start(psi)
    p.StandardOutput.ReadToEnd()

let now = System.DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss")

run "git" "add ."
run "git" $"commit -m \"commit\" -m \"solve {count} problem at {now}\""
run "git" "push origin master"
