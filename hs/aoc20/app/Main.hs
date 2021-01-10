module Main where

import Data.Functor
import Data.List (find)
import Data.String (lines)
import Lib


main :: IO ()
main = do 
    numbers <- readNumbers
    let Just(n1, n2) = find sumIs2020 . pairs $ numbers
    print $ n1 * n2
  where sumIs2020 (n1, n2) = n1 + n2 == 2020

pairs :: [a] -> [(a, a)]
pairs []     = []
pairs (x:xs) = zip (repeat x) xs ++ pairs xs

readNumbers :: IO [Integer]
readNumbers = map read . lines <$> getContents
