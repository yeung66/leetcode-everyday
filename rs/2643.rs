impl Solution {
    pub fn row_and_maximum_ones(mat: Vec<Vec<i32>>) -> Vec<i32> {

        mat.iter().enumerate()
        .map(|(i, row)| (i, row.iter().filter(|&x| *x == 1).count()))
        .rev()
        .max_by_key(|&(_, ones)| ones)
        .map(|(i, ones)| vec![i as i32, ones as i32]).unwrap()
        
        // let mut max_ones = 0;
        // let mut row = 0;
        // for i in 0..mat.len() {
        //     let ones = mat[i].iter().filter(|&x| *x == 1).count();
        //     if ones > max_ones {
        //         max_ones = ones;
        //         row = i;
        //     }
        // }
        // vec![row as i32, max_ones as i32]
    }
}