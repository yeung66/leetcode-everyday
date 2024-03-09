/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function closestNodes(root: TreeNode | null, queries: number[]): number[][] {
    const sortedArray: number[] = [];
    const inOrderVisit = (node: TreeNode | null) => {
        if (!node) return
        inOrderVisit(node.left)
        sortedArray.push(node.val)
        inOrderVisit(node.right)
    };
    inOrderVisit(root);
    
    const findLessMaxAndMoreMinInSortedArray = (num: number) => {
        let start = 0, end = sortedArray.length - 1;
        let mid;
    
        while (start <= end) {
            mid = Math.floor((start + end) / 2);
    
            if (sortedArray[mid] === num) {
                break;
            } else if (sortedArray[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    
        // If the number is not found in the array, mid will be the index where the number should be inserted.
        // If the number is found in the array, mid will be the index of the number.
        let lessMax = mid > 0 ? sortedArray[mid - 1] : -1; // Check if there is a number less than num
        let moreMin = mid < sortedArray.length - 1 ? sortedArray[mid + 1] : -1; // Check if there is a number greater than num
    
        // If the number is found in the array, adjust the lessMax and moreMin
        if (sortedArray[mid] === num) {
            lessMax = moreMin = num;
        } else {
            // If the number is not found in the array, adjust the lessMax and moreMin
            if (sortedArray[mid] < num) {
                lessMax = sortedArray[mid];
                moreMin = mid < sortedArray.length - 1 ? sortedArray[mid + 1] : -1;
            } else {
                lessMax = mid > 0 ? sortedArray[mid - 1] : -1;
                moreMin = sortedArray[mid];
            }
        }
    
        return [lessMax, moreMin];
    } 
    
    return queries.map(query => findLessMaxAndMoreMinInSortedArray(query));
}