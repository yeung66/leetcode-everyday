
# If you need to import additional packages or classes, please import here.

def func():

    # please define the python3 input here. For example: a,b = map(int, input().strip().split())
    sentence = input()
    words = input().split()
    # please finish the function body here.
    terms = filter(None, sentence.split(' '))
    quoted = False
    ans = []
    mapping = {}
    for i, w in enumerate(words):
        mapping[w.lower()] = i

    for i in terms:
        if i == "\"":
            quoted = not quoted

            ans.append(i)
        elif quoted:
            ans.append(i)
        else:
            if i[-1] == '.' or i[-1] == ',':
                dot = i[-1]
                i = i[:-1]
                if i.lower() in mapping:
                    ans.append(str(mapping[i.lower()]) + dot)
                else:
                    ans.append(i+dot)
            else:
                if i.lower() in mapping:
                    ans.append(str(mapping[i.lower()]))
                else:
                    ans.append(i)

    # please define the python3 output here. For example: print().
    print(' '.join(ans))

if __name__ == "__main__":
    func()
