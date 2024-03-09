/**
 * @param {number[]} salary
 * @return {number}
 */
var average = function(salary) {
    let min = 10000000, max = 0, sum = 0;
    for (let i of salary) {
        if (i < min) min = i;
        if (i > max) max = i;
        sum += i;
    }

    return (sum - min - max) / (salary.length - 2);
};