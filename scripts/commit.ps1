
Set-Location C:\codes\py\leetcode-everyday

pwsh .\scripts\classify.ps1

git add .

$count = 0

git diff head | ForEach-Object {
    [string]$row = $_
    if ($row.StartsWith("+++")) {
        $count = $count + 1
    }
}

git commit -m "solve $count problems at $(Get-Date)"
git push origin master