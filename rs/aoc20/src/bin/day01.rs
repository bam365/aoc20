use std::io;
use std::io::prelude::*;

fn main() {
    let numbers = read_numbers();
    match find_pair_with_sum(&numbers, 2020) {
        Some((n1, n2)) => print!("{}", n1 * n2),
        None => panic!("No matching pair")
    }
}

fn read_numbers() -> Vec<i32> {
    return io::stdin().lock().lines().map(|l| { l.unwrap().parse::<i32>().unwrap() }).collect()
}

fn find_pair_with_sum(v: &Vec<i32>, sum: i32) -> Option<(i32, i32)> {
    for i in 0..v.len() {
        for j in i+1..v.len() {
            if v[i] + v[j] == sum {
                return Some((v[i], v[j]))
            }
        }
    }
    return None
}