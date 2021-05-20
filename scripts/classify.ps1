
$files = Get-ChildItem

foreach($f in $files){
    $ex = $f.Extension
    if($ex){
        $ex = $ex.Substring(1)
        if(!(Test-Path $ex)) {New-Item $ex -ItemType Directory}
        $name = $f.Name
        
        if(Test-Path "$ex\$name") {
            $basename = $f.BaseName
            $name = "$basename-1.$ex"
        }
        Move-Item $f -Destination "$ex\$name"
    }
}