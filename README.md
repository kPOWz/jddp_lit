

# Coding Exercise
(2-3 hrs max)


## Deliverables
1) Download a file from:http://www.gutenberg.org/files/2701/2701-0.txt

2) Test drive cracking the file open, parse it and get a list of the top 50 words

3) Exclude a set of common words (case insensitive) (the,of,to,and,a,in,is,it,you,that,he,was,for,on,are,with,as,I,his,they,be,at,one,have,this,from,or,had,by,not,word,but,what,some,we,can,out,other,were,all,there,when,up,use,your,how,said,an,each,she)
Use Collections API in .NET or JAVA or any other language of your choice.
4) Deploy and run this on one of cloud platforms - AWS/Azure/GCP
5) Check the code into GitHub and Share the link

## Implementation Notes

This implementation satisfies the deliverables by reading the entire novel into memory. The WordFrequencyStreamReader constructor is the biggest expense.
The `WordFrequencyStreamReader` getter (at its core a formatter)

One possible alternative data structure for the basic deliverables is a sorted HashMap like TreeMap with a composite string key that included the count (ex: "the,22").  This would be dependent on the implicit behavior of "natural order" or some type of override of the tree's algo
Following that a `Stream` operator or two would be needed to get "top 50" - perhaps `limit`

Due to the nature of ISG data platform, this implementation also plays with the idea of having the need to limit memory consumption & maps out how these alternatives would be composed. Adding chunks of data (from any or multiple sources) becomes very sustainable after the constructor initialization.

### Results
In my opinion the best top 50 word from Moby Dick has to be _"ye"_

Full results (not sure what it does with ties & should add `str.isBlank` check...):
>"[long, man, him,, seemed, her, after, two, them, who, would, than, though, has, still, it,, ye, must, yet, very, old, no, these, been, about, now, its, then, over, most, will, do, upon, their, those, great, my, down, any, me, into, so, , whale, which, if, him, more, only, such, like]"

## Running the Moby Dick Top 50 Words App
Prereq: Java 11
1) open in IDE of choice
2) run "main" method
check out the tests as well!