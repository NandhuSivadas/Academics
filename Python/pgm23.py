from collections import Counter


words = input("Enter comma-separated words: ")

wordcounts = Counter(word.strip() for word in words.split(','))


unique_words = sorted(word for word, count in wordcounts.items() if count == 1)


print("Unique words that appear only once in sorted order:")
for word in unique_words:
    print(word)
