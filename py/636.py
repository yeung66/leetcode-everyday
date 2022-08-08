class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        tasks = []
        ans = [0] * n
        for i, log in enumerate(logs):
            idx, action, time = log.split(':')
            idx, time = int(idx), int(time)
            if i == 0:
                tasks.append([idx, time])
                

            elif action == 'start':
                if tasks:
                    last_idx, last_time = tasks[-1]
                    ans[last_idx] += time - last_time
                tasks.append([idx, time])

            else:
                last_idx, last_time = tasks.pop()
                ans[last_idx] += time - last_time + 1
                if tasks:
                    tasks[-1][1] = time + 1

            print(tasks)

        return ans
