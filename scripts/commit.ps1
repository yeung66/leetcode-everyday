
Set-Location C:\codes\py\leetcode-everyday

git pull origin master

pwsh .\scripts\classify.ps1

git add .

$count = 0

git diff head | ForEach-Object {
    [string]$row = $_
    if ($row.StartsWith("+++")) {
        $count = $count + 1
    }
}

if ($count -gt 0) {
    git commit -m "solve $count problems at $(Get-Date)"
    git push origin master
}

