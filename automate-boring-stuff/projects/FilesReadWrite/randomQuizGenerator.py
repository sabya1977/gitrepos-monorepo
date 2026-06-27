#!/usr/bin/env -S uv run
""" Project Name: Random Quiz Generator

 Here is what the program does:
 • Creates 35 different quizzes
 • Creates 50 multiple-choice questions for each quiz, in random order
 • Provides the correct answer and three random wrong answers for each 
   question, in random order
 • Writes the quizzes to 35 text files
 • Writes the answer keys to 35 text files

 This means the code will need to do the following:
 • Store the states and their capitals in a dictionary.
 • Call open(), write(), and close() for the quiz and answer key text files.
 • Use random.shuffle() to randomize the order of the questions and multiple-choice options.
"""

"""
    load required modules
"""
import random
from pathlib import Path
import os
import sys
"""
    define capital constant
"""
capitals = {'Alabama': 'Montgomery', 'Alaska': 'Juneau', 'Arizona':
        'Phoenix', 'Arkansas': 'Little Rock', 'California': 'Sacramento', 'Colorado':
        'Denver', 'Connecticut': 'Hartford', 'Delaware': 'Dover', 'Florida':
        'Tallahassee', 'Georgia': 'Atlanta', 'Hawaii': 'Honolulu', 'Idaho': 'Boise',
        'Illinois': 'Springfield', 'Indiana': 'Indianapolis', 'Iowa': 'Des Moines',
        'Kansas': 'Topeka', 'Kentucky': 'Frankfort', 'Louisiana': 'Baton Rouge',
        'Maine': 'Augusta', 'Maryland': 'Annapolis', 'Massachusetts': 'Boston',
        'Michigan': 'Lansing', 'Minnesota': 'Saint Paul', 'Mississippi': 'Jackson',
        'Missouri': 'Jefferson City', 'Montana': 'Helena', 'Nebraska': 'Lincoln',
        'Nevada': 'Carson City', 'New Hampshire': 'Concord', 'New Jersey': 'Trenton',
        'New Mexico': 'Santa Fe', 'New York': 'Albany', 'North Carolina': 'Raleigh',
        'North Dakota': 'Bismarck', 'Ohio': 'Columbus', 'Oklahoma': 'Oklahoma City',
        'Oregon': 'Salem', 'Pennsylvania': 'Harrisburg', 'Rhode Island': 'Providence',
        'South Carolina': 'Columbia', 'South Dakota': 'Pierre', 'Tennessee':
        'Nashville', 'Texas': 'Austin', 'Utah': 'Salt Lake City', 'Vermont':
        'Montpelier', 'Virginia': 'Richmond', 'Washington': 'Olympia', 'West Virginia':
        'Charleston', 'Wisconsin': 'Madison', 'Wyoming': 'Cheyenne'}

quiz_dir_path = Path(Path.cwd() / 'quiz_dir')
answer_dir_path = Path(Path.cwd() / 'answer_dir')

def checkEnvironment():
    # sys.prefix is the path to the current Python 'home'
    # sys.base_prefix is the path to the original system Python
    is_venv = sys.prefix != sys.base_prefix

    print(f"--- Environment Check ---")
    print(f"Python Executable: {sys.executable}")
    print(f"Is Virtual Env?    {is_venv}")

    if is_venv:
        print(f"Venv Path:         {sys.prefix}")
    else:
        print("Running in GLOBAL environment.")
    print(f"-------------------------")

def createQuizdir():
    """
        create quiz files directory under the current directory
    """
    if quiz_dir_path.is_dir():
        pass
    else:
        os.makedirs(quiz_dir_path)

def createAnswerdir():
    """
        create answer files directory under the current directory
    """
    if answer_dir_path.is_dir():
        pass
    else:
        os.makedirs(answer_dir_path)

def delQuizfile():
    """
        delete quiz files. If file does not exists prints message and move on
    """
    for quiz_num in range(35):
        try:
            quiz_file_path  = Path(quiz_dir_path / f'capitalsquiz{quiz_num + 1}.txt')
            os.remove(quiz_file_path)
            # print (f'capitalquiz{quiz_num + 1}.txt' + ' successfully deleted')
        except FileNotFoundError:
            # print((f'capitalquiz{quiz_num + 1}.txt' + ' Not Found!'))

def delAnswerfile():
    """
        delete answer files if exists
    """
    for quiz_num in range(35):
        answer_file_path = Path (answer_dir_path / f'capitalsquiz_answers{quiz_num + 1}.txt')
        if answer_file_path.exists():
            answer_file_path.unlink()
            print(f'capitalsquiz_answers{quiz_num + 1}.txt' + ' file successfully removed')
        else:
            print(f'capitalsquiz_answers{quiz_num + 1}.txt' + ' file does not exists')

def main():
    """
        main logic to generate quiz and answer files
    """    
    checkEnvironment()
    createQuizdir()
    createAnswerdir()

    delQuizfile()
    delAnswerfile()

    for quiz_num in range(35):
        
        # Create the quiz and answer key files.
        quiz_file_path  = Path(quiz_dir_path / f'capitalsquiz{quiz_num + 1}.txt')
        answer_file_path = Path (answer_dir_path / f'capitalsquiz_answers{quiz_num + 1}.txt')
        quiz_file = open(quiz_file_path, 'w', encoding='UTF-8') 
        answer_file = open(answer_file_path, 'w', encoding='UTF-8')

        # Write out the header for the quiz.
        quiz_file.write('Name:\n\nDate:\n\nPeriod:\n\n')
        quiz_file.write((' ' * 20) + f'State Capitals Quiz (Form{quiz_num + 1})')
        quiz_file.write('\n\n')

        states = list(capitals.keys()) # get the capital city of each state and store in a list
        random.shuffle(states) # shuffle the capital cties stored in the list

        # Loop through all 50 states, making a question for each.
        for num in range(50):
            correct_answer = capitals[states[num]] # for each state, get its capital city
            wrong_answers = list(capitals.values()) # get capital cities of all states
            # get position of the correct capital of the state and delete it from wrong answer
            del wrong_answers[wrong_answers.index(correct_answer)]
            wrong_answers = random.sample(wrong_answers, 3) # take 3 random values to make wrong answers
            answer_options = wrong_answers + [correct_answer] # wrong + correct = all answer options
            random.shuffle(answer_options) # shuffle the answer options

            # Wrtting content to the file
            # Write the question and the answer options to the quiz file.
            quiz_file.write(f'{num + 1}. Capital of {states[num]}:\n') # quiz file Question
            
            # four answer options for each question
            for i in range(4):
                # When i is 0 pick A, when i is 1 pick and so on till i = 3
                # answer_options[i] - right and wrong answers from answer_options list for a state
                quiz_file.write(f" {'ABCD'[i]}. { answer_options[i]}\n")
            quiz_file.write('\n')

            # Write the answer key to a file
            # Index function get the index of the correct answer from answer_options list
            # The index option becomes the index of ABCD options and correct option is picked
            answer_file.write(f"{num + 1}.{'ABCD'[answer_options.index(correct_answer)]}\n")
        quiz_file.close()
        answer_file.close()

if __name__ == "__main__":
    main()