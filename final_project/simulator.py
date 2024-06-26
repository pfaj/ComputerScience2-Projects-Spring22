#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Block-2048 Simulator (run lots of games)

Students: No changes are necessary in this file.

author: J. Hollingsworth
last updated: Nov 09 2020
"""

import block_2048

how_many = int(input('How many simulations? '))

sum_scores = 0
sum_moves = 0
best_score = 0
best_moves = 0
for x in range(how_many):
    block_2048.main(True)
    sum_scores += block_2048.score
    sum_moves += block_2048.moves
    if block_2048.score > best_score:
        best_score = block_2048.score
    if block_2048.moves > best_moves:
        best_moves = block_2048.moves
    block_2048.reset_game()
    
print('-'*30)
print('avg score: {:,.2f}'.format(sum_scores / how_many))
print('avg moves: {:,.2f}'.format(sum_moves / how_many))
print('best score: {:,}'.format(best_score))
print('best moves: {:,}'.format(best_moves))
