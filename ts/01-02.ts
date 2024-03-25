function CheckPermutation(s1: string, s2: string): boolean {
    return s1.split('').sort().join('') === s2.split('').sort().join('');
};