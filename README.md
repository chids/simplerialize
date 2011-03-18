### About

#### Use case:
* API neutral streaming serialization of POJOs to XML and JSON
* Only serialization - _no deserialization_ ie no XML/JSON -> POJO) this is ONE WAY only
* Serialization specification in code (ie, no schema compilation)

#### This library DOES NOT:
* Allow customization of output formats
* Claim to be consistent for each and all use cases, it may _fail horribly_ for your particular case

#### This library offers:
* A naive implementation of a transparent API for serialization to JSON or XML
* A fairly compact output regardless of format
* Good performant streaming serialization (thanks to [Jackson](http://jackson.codehaus.org/) and [Woodstox](http://woodstox.codehaus.org/))

### Rationale

#### Our scenario
We have a lot of HTTP based API services. These are almost entirely accessed using GET with various path and query parameters. They produce a response in either XML or JSON depending on the clients accept header or file extension (.xml and .json). They need to serialize transparently to JSON and XML, they need to be efficient and they _never_ need to deserialize XML or JSON input to POJOs.

#### XML and JSON serialization in Java
There are lots of good and great Java libraries out there for serializing POJOs to XML or JSON. We're using, have used or have tried [Jaxb](http://jaxb.java.net/), [Jackson](http://jackson.codehaus.org/), [Woodstox](http://woodstox.codehaus.org/), [Simple](http://simple.sourceforge.net/), [XStream](http://xstream.codehaus.org/), [org.json](http://www.json.org/java/index.html) and [Gson](http://code.google.com/p/google-gson/).

#### The problem
We're not interested in de-serialization. Period. No, really. We're not. A few of our services accept small JSON inputs - we handle that input "manually", often with [Gson](http://code.google.com/p/google-gson/).
Not requiring deserialization makes the quirks in [insert-library-name-here] a much bigger _a pain_. For example we don't want to add private no-arg constructors to our immutable POJOs. Then when you've started to irritate yourself on that you can also choose to irritated yourself on the annotations, or the lack of annotations - whichever fuels your rage.

#### What we wanted
* Something that serializes to XML and JSON with the same API
* The serialization should be in code. Either in the object itself or in a adapter/mapper style object.

#### What we've found
Zip, zero, nada. So if you really want us too feel like idiots, please point us to an existing solution.