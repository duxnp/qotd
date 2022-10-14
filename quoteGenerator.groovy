def authors = [
    "Peter Ledbrook",
    "Glen Smith"
]

def quoteParts = [
    ["Time", "waits", "for no man"],
    ["The roundhouse kick", "solves", "all problems"],
    ["Groovy", "is", "the bees knees"]
]

// Adding our own method to the built in List class
List.metaClass.random = {-> delegate[new Random().nextInt(delegate.size())] }

for (int i in 0..<10) {
    def quote = createQuote(quoteParts, authors) 
    println quote
    
//    def pigLatinWords = []
//    for (String word in quote.split(/\s+/)) {
//        pigLatinWords << pigLatinize(word)
//    }
//
//    println pigLatinWords.join(' ')

    // The above 5 lines (excluding empty lines) can be done in one go:
        println quote
            .split(/\s+/)
            .collect { pigLatinize(it) }
            .join(' ')
    // That line does the following:
    //     1. calls the String split method on the quote string which returns an array of strings
    //     2. calls the List collect method on the returned array (like JS .map method)
    //     3. calls the Iterable join method on the return array which returns a string
}

String createQuote(List quoteParts, List authors) {
    return quoteParts.random()[0] + ' ' +
        quoteParts.random()[1] + ' ' +
        quoteParts.random()[2] + ' by ' +
        authors.random()
}

def pigLatinize(String word) {
    if (isVowel(word[0])) {
        return word + "way"
    }
    else {
        def pos = firstVowel(word)
        return word[pos..-1] + word[0..<pos] + "ay"
    }
}

def firstVowel(String word) {
    for (int i in 0..<word.size()) {
        if (isVowel(word[i])) return i
    }

    return -1
}

boolean isVowel(String ch) { return ch.toLowerCase() in ["a", "e", "i", "o", "u"] }