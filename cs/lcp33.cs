public class Solution
{
    public int StoreWater(int[] bucket, int[] vat)
    {
        bucket = bucket.Where((_, i) => vat[i] != 0).ToArray();
        vat = vat.Where(v => v != 0).ToArray();
        var n = bucket.Length;
        
        if (n == 0)
        {
            return 0;
        }
        
        var ans = Enumerable.Range(0, n).Where(i => vat[i] != 0).Select(i =>
            bucket[i] == 0 ? (vat[i] - 1) / (bucket[i] + 1) + 2 : (vat[i] - 1) / (bucket[i]) + 1).Max();

        return Enumerable.Range(1, ans).Select(k =>
        {
            return Enumerable.Range(0, n).Where(i => vat[i] != 0)
                .Select(i => Math.Max(0, (vat[i] + k - 1) / k - bucket[i])).Sum() + k;
        }).Min();
    }
}