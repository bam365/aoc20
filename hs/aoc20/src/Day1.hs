import Data.List (find, (\\))


day1 :: IO ()
day1 = do 
    numbers <- readNumbers
    let Just(n1, n2) = find (\(n1, n2) -> n1 + n2 == 2020) . pairs $ numbers
    print $ n1 * n2

pairs :: Eq a => [a] -> [(a, a)]
pairs l = do 
    x <- l
    y <- l \\ [x]
    return (x, y)

readNumbers :: IO [Integer]
readNumbers = map read . lines <$> getContents