#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Artificial Intelligence for Block-2048

Students: Work in this file for the Final Project

author: CSC 1300 Professors and Aidan Jimenez  <-- Your name here
last updated: April 19 2022
"""

import random

# Part 1: Helper Functions ###################################################

'''
Function: is_full
Uses the given column to check if that column is full yet only needs to check the first row 
'''
def is_full(board, col):
    if board[0][col] > 0:
        return True
    return False

'''
Function: random_column
Finds a random column that has an empty block at the top of it
'''
def random_column(board):
    found = False
    while found is False:
        rand_col = random.randint(0,len(board[0])-1)
        if board[0][rand_col] == 0: # If the top row of the random column is empty than it can exit the while loop
            found = True
    return rand_col

'''
Function: top_block
Uses the given column to return what the top block is of that column
'''
def top_block(board, col):
    for row in range(len(board)):
        if board[0][col] > 0: 
            return -1
        elif board[row][col] > 0:
            return int(board[row][col])
        elif board[len(board)-1][col] == 0:
            return 0

'''
Function: all_top_blocks
Goes through the given board and gets the values of all top blocks in each column
'''
def all_top_blocks(board):
    row = 0
    col = 0
    top_row = []
    while col < len(board[0]): 
        if board[0][col] > 0: #Checks the first column in the board 
            top_row.append(-1)
            col += 1
        elif board[-1][col] == 0: #Checks the last column in the board
            top_row.append(0)
            col += 1
        else:
            if board[row][col] == 0: #Checks all columns in between 
                row += 1
            elif board[row][col] > 0:
                top_row.append(int(board[row][col]))
                col += 1
                row = 0
    return top_row

'''
Function: find_shortest
After each if statement the amount of blocks are addded to a dictionary with the corresponding column index and 
amount of blocks in each column
'''
def find_shortest(board):
    row = 0
    col = 0
    shortest = {}
    while col < len(board[0]): 
        if board[0][col] > 0: #Checks if there is a number in the top row
            shortest[col] = 7
            col += 1
        elif board[-1][col] == 0: #Checks if there is a number in the bottom row
            shortest[col] = 0
            col += 1
        else:
            if board[row][col] == 0:  
                row += 1
            elif board[row][col] > 0: #Checks for every block inbetween the top and bottom has a block
                shortest[col] = len(board) - row 
                col += 1
                row = 0
    return min(shortest, key=shortest.get)

'''
Function: is_increasing
Compares the original list to a sorted version to test if it is increasing order
'''
def is_increasing(board, col):
    col_list = []
    for row in range(len(board)):
        col_list.append(int(board[row][col]))
    if sorted(col_list) == col_list: 
        return True
    return False




# Part 2: AI Functions #######################################################


def play_vertical_matcher(block, board):
    row = 0
    col = 0
    top_row = {}
    while col < len(board[0]): 
        if board[0][col] > 0: #Checks the first column in the board 
            top_row[col] = -1
            col += 1
        elif board[-1][col] == 0: #Checks the last column in the board
            top_row[col] = 0
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
            
def play_better_vertical_matcher(block, board):
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


def play_my_awesome_logic(block, next_block, board):
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
        if block * 2 == next_block and top_row[i] == block:
            return i
        if top_row[i] == block or top_row[i] >= block:   
            return i 
        else:
            rand_col = len(top_row)
            return random.randint(0, rand_col - 1)
        


# Given Functions ##############################################

# play interactively -- this code is complete -- no changes needed
# def play_console_control(block, board):
#     num_cols = len(board[0])
#     col = int(input("Drop " + str(block) + " in which column: "))

#     # ask again if given an invalid column
#     while col < 0 or col >= num_cols:
#         col = int(input("Drop " + str(block) + " in which column: "))

#     return col


# uncomment one line -- this is the strategy used to play the game
def strategy(block, next_block, board):
    #input()  # uncomment to pause the loop between every board update
    #return play_console_control(block, board)    # interactive
    #return play_vertical_matcher(block, board)
    #return play_better_vertical_matcher(block, board)
    return play_my_awesome_logic(block, next_block, board)


if __name__ == "__main__":
    import block_2048
    block_2048.main()
