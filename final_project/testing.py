import random

def play_vertical_matcher(block, next_block, board):
    row = 0
    col = 0
    top_row = {}
    while col < len(board[0]): 
        if board[0][col] > 0: #Checks the first column in the board 
            top_row[col] = -1
            col += 1
        elif board[-1][col] == 0: #Checks the last column in the board
            top_row[col] = -1
            col += 1
        else:
            if board[row][col] == 0: #Checks all columns in between 
                row += 1
            elif board[row][col] > 0:
                top_row[col] = int(board[row][col])
                col += 1
                row = 0
    for i in top_row:
        if top_row[i] == block:
            return i
        elif max(top_row) != min(top_row):
            return max(top_row, key=top_row.get)
        else:
            rand_col = len(top_row)
            i = random.randint(0, rand_col - 1)
            return i


board = [
        [0, 0, 0, 0, 0, 0],
        [2, 4, 8, 16, 32, 64],
        [4, 32, 4, 32, 8, 32],
        [2, 16, 2, 16, 4, 16],
        [4, 8, 16, 8, 2, 8],
        [2, 4, 8, 4, 16, 4],
        [4, 2, 4, 2, 32, 2]
    ]



blocks = 16

print(play_vertical_matcher(blocks, board))