# message = """It was a bright cold day in April, and the clocks were striking thirteen.
#             I am laying on my chair and reading a book on Literature."""
message = 'It was a bright cold day in April, and the clocks were striking thirteen.'
text = []
text.append('It was a bright cold day in April, and the clocks were striking thirteen.')
text.append('I am laying on my chair and reading a book on Literature.')
# print(text[0])
stringList = []
i = 0
for ch in message:
    if ch == '.':
        stringList.append(ch)
        break
    else:
        stringList.append(ch)
    i = i+1
print(stringList)