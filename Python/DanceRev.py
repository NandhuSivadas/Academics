from collections import defaultdict


direction_map = {'up': 0, 'right': 1, 'down': 2, 'left': 3}


def manhattan_distance(a, b):
    return abs(a % 2 - b % 2) + abs(a // 2 - b // 2)

def minimum_moves(n, instructions):
   
    instructions = [direction_map[inst] for inst in instructions]
    
    dp = defaultdict(lambda: float('inf'))
    
    for left in range(4):
        for right in range(4):
            if left != right:
                dp[(left, right)] = 0
    
    for inst in instructions:
        new_dp = defaultdict(lambda: float('inf'))
        for (left, right), moves in dp.items():
       
            new_dp[(inst, right)] = min(new_dp[(inst, right)], moves + manhattan_distance(left, inst))
           
            new_dp[(left, inst)] = min(new_dp[(left, inst)], moves + manhattan_distance(right, inst))
        dp = new_dp
    

    return min(dp.values())


n = 6
instructions = ['down', 'right', 'down', 'up', 'right', 'down']
print(minimum_moves(n, instructions)) 

