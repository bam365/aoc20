module Lib
    ( readNumbers
    ) where

readNumbers :: IO [Integer]
readNumbers = map read . lines <$> getContents
