function getHint(secret: string, guess: string): string {
    const secretMap = new Map()
    const guessMap = new Map()
    let A = 0, B = 0;
    for (let i = 0;i<secret.length;i++) {
        if (secret[i] === guess[i]) {
            A++
        } else {
            secretMap.set(secret[i], (secretMap.get(secret[i]) || 0) + 1)
            guessMap.set(guess[i], (guessMap.get(guess[i]) || 0) + 1)
        }
    }

    for (let [key, value] of secretMap) {
        B += Math.min(value, guessMap.get(key) || 0)
    }

    return `${A}A${B}B`
}