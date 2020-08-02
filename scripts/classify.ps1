
$files = Get-ChildItem

foreach($f in $files){
    $ex = $f.Extension
    if($ex){
        $ex = $ex.Substring(1)
        if(!(Test-Path $ex)) {New-Item $ex -ItemType Directory}
        $name = $f.Name
        Move-Item $f -Destination "$ex\$name"
    }
}