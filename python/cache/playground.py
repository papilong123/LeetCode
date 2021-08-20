import os


def f():
    base = r'C:\Users\a\IdeaProjects\LeetCode\cpp'
    # li = ['BFS', 'Binary Search', 'Bit Manuputation']
    li = [os.path.basename(d) for d in os.listdir(base) if os.path.basename(d) != 'cmake-build-debug']
    li = [i for i in li if i != '.idea' and i != 'CMakeLists.txt']
    li = li[20:23]
    tmp = [base + '\\' + i for i in li]
    for dirs in tmp:
        filelist = os.listdir(dirs)
        for file in filelist:
            if not file.startswith('$') and not file.endswith('.cpp'):
                old = base + '\\' + os.path.basename(dirs) + '\\' + file
                new = (base + '\\' + os.path.basename(dirs) + '\\' + '$' + file).replace('.', '_').replace(' ',
                                                                                                           '').replace(
                    'C++', '')
                new += '.cpp'
                os.rename(old, new)


if __name__ == '__main__':
    f()
