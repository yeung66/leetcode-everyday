function getFolderNames(names: string[]): string[] {
    const namesUsed = new Map()
    const result: string[] = []
    
    for (let name of names) {
        if (namesUsed.has(name)) {
            let no = namesUsed.get(name) + 1
            while (namesUsed.has(`${name}(${no})`)) {
                no++
            }

            let newName = `${name}(${no})`
            namesUsed.set(name, no)
            namesUsed.set(newName, 0)
            result.push(newName)
        } else {
            namesUsed.set(name, 0)
            result.push(name)
        }
    }

    return result
};