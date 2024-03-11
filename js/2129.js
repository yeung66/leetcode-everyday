/**
 * @param {string} title
 * @return {string}
 */
var capitalizeTitle = function(title) {
    return title.split(' ').map(word => {
        if (word.length < 3) return word.toLowerCase()
        return word[0].toUpperCase() + word.slice(1).toLowerCase()
    }).join(' ')
};