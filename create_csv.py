import numpy as np
import os
from collections import namedtuple

firstnames = []
lastnames = []
students = []

Student = namedtuple('Student', ['name', 'id'])

def generate_name():
    """Random combination of a name."""
    first = np.random.choice(firstnames, 1)
    last = np.random.choice(lastnames, 1)
    return  str(*first) + " " + str(*last)


def generate_id():
    """Random ten-digit id for a student."""
    id = ""
    for i in range(10):
        digit = np.random.randint(0, 10)
        id += str(digit)

    return id


def generate_grade():
    """Random grade from 0 to 100."""
    score = np.random.randint(0, 101, 1)
    return score[0]


if __name__ == '__main__':
    with open('l3-names/firstnames.txt') as firstname_file:
        with open('l3-names/lastnames.txt') as lastname_file:
            firstnames = firstname_file.readlines()
            lastnames = lastname_file.readlines()
            firstnames = [str.strip(name) for name in firstnames]
            lastnames = [str.strip(name) for name in lastnames]

            for i in range(10):
                students.append(
                    Student(name = generate_name(), id = generate_id())
                )


    # Create CSV
    with open('input/grades.csv', 'w') as csv:
        iter_num = 100
        for i in range(0, iter_num):
            grade = generate_grade()
            idx = np.random.choice(len(students))
            csv.write(','.join([students[idx].name, students[idx].id, str(grade)]) + '\n')
