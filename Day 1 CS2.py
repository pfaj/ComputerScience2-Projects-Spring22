def split(nums):
    num_list = nums.split()
    return num_list


def average(num_list):
    return sum(num_list) / len(num_list)

def find_indicies_above(num_list,target_number):
    indicies = []
    for num in num_list:
        if num_list[i] > target_number:
            indicies.append(num_list)
    return indicies


if __name__ == "__main__":
    nums = input()
    num_list = split(nums)
    avg = average(num_list)
    print("Average:", avg)
    print(find_indicies_above(num_list, target_number))