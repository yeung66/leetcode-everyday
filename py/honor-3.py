
def compute_hash(token:str):
    return sum(ord(i) for i in token) % 999


def run():
    cmd, content = input().split(':')
    if int(cmd) == 1:
        server_no = content.split('_')[1]
        print((int(server_no) - 1) * 50)
    elif int(cmd) == 2:
        h = compute_hash(content)
        if h % 50 == 0:
            print(h)
        else:           
            server_no = h // 50 + 1
            print(server_no * 50 if server_no * 50 < 1000 else 0)

    elif int(cmd) == 3:
        brokens, content = content.split(';')
        brokens = set((int(i.split('_')[1]) - 1) * 50 for i in brokens.split(','))
        h = compute_hash(content)
        for i in list(range(h,1000)) + list(range(h)):
            if i % 50 == 0 and i not in brokens:
                print(i)
                return

    elif int(cmd) == 4:
        no = int(content.split('_')[-1])
        if no % 2 == 1:
            print(50 * (no // 2) + 25)
        else:
            print(50 * (no // 2 - 1) + 525)

    elif int(cmd) == 5:
        add, token = content.split(';')
        add_no = int(add.split('_')[-1])
        nodes = set(i * 50 for i in range(20))
        for i in range(1, add_no+1):
            if i % 2 == 1:
                nodes.add(50 * (i // 2) + 25)
            else:
                nodes.add(50 * (i // 2 - 1) + 525)

        h = compute_hash(token)
        for i in list(range(h,1000)) + list(range(h)):
            if i in nodes:
                print(i)
                return

    

run()