from dataclasses import dataclass
from typing import List, Dict
import bisect

@dataclass(order=True)
class Food:
    rating: int
    food: str
    cuisine: str

        

class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.allFoods: Dict[str, Food] = {}
        self.cuisinesRating: Dict[str, List[Food]] = {}
        for i in range(len(foods)):
            food = Food(ratings[i], foods[i], cuisines[i])
            self.allFoods[foods[i]] = food
            if cuisines[i] not in self.cuisinesRating:
                self.cuisinesRating[cuisines[i]] = []
            self.cuisinesRating[cuisines[i]].append(food)

        for k, v in self.cuisinesRating.items():
            v.sort()


        

    def changeRating(self, food: str, newRating: int) -> None:
        target = self.allFoods[food]
        cuisine = target.cuisine
        idx = bisect.bisect_left(self.cuisinesRating[cuisine], target)
        del(self.cuisinesRating[cuisine][idx])
        target.rating = newRating
        bisect.insort_left(self.cuisinesRating[cuisine], target)



    def highestRated(self, cuisine: str) -> str:
        rating = self.cuisinesRating[cuisine][-1].rating
        ans = ''
        for f in self.cuisinesRating[cuisine][::-1]:
            if f.rating == rating:
                ans = f.food
            else:
                break
        return ans


# Your FoodRatings object will be instantiated and called as such:
# obj = FoodRatings(foods, cuisines, ratings)
# obj.changeRating(food,newRating)
# param_2 = obj.highestRated(cuisine)