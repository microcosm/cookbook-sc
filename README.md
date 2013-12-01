# Welsh's Synthesizer Cookbook in SuperCollider

## What is this repo?

This repo is designed to help you learn **synthesizer fundamentals** at the same time as learning **SuperCollider**. Inside you will find runnable code examples for all the figures from the foundational synthesis chapters of **Welsh's Synthesizer Cookbook**.

The code is labelled with figure numbers and explanatory notes to make it easy to cross-reference, and to hear how the figures sound in the SuperCollider synthesis environment.

- Note: Newbies check out the section below:  
**I'm new to computer music, what should I do?**

- Note: All accompanying notes in code comments are based on or inspired by the book, unless otherwise quoted.

## What is SuperCollider?

SuperCollider is a software audio synthesis engine and [domain-specific language](http://en.wikipedia.org/wiki/Domain-specific_language) for sound artists, musicians, programmers and academics. It allows you to program (code) sound and music.

Read more [here](http://jahya.net/blog/?2012-05-getting-started-with-supercollider) and [here](http://en.wikipedia.org/wiki/SuperCollider).

## What is Welsh's Synthesizer Cookbook?

The first few chapters are a quick, hands-on introduction to synthesis fundamentals. The rest of the book is a catalog of ingredient recipes for using what you have learned to build snythesizers.

[ ![Welsh's Synthesizer Cookbook](http://3.bp.blogspot.com/-Kllf8JcKhcM/UpLsxkKci6I/AAAAAAAAC64/oFjvvJr74is/s400/cookbook.jpg) ](http://www.amazon.com/Welshs-Synthesizer-Cookbook-Programming-Universal/dp/B000ERHA4S)

## What topics are covered?

There is an introductory code file that will get you off the ground with SuperCollider, to make sure you can hear sound, and see the oscilloscope and frequency analysis views. It also provides keyboard shortcuts and advice.

Then, the meat:

1. Additive synthesis
 - Sine, sawtooth, square and triangle waves
 - White, pink and brown noise
2. Subtractive synthesis
 - Low-pass & high-pass filters
 - Band-pass & band-reject/notch filters
 - Slopes & poles
 - Resonant filters
3. Envelopes
 - Attack, decay, sustain and release

Finally there is a safety file to make sure you don't blow your speakers, or your ears in the process! SuperCollider will let you pipe literally anything to your sound card. Make sure you know about common mistakes!

## OK, got it, can I get started?

Sure, dive in. The code is all sclang ready.

Be sure to get back to me with comments and improvements. Better still, fork the repo and submit pull requests with your contributions!

## I'm new to computer music, what should I do?

When I was new to computer music I was already familiar with programming. That's one reason that SuperCollider was an appealing option for me. It is about code + sound, and so I get all the benefits of being able to program, for example being able to hook up my sounds to ad-hoc [sensors](https://www.adafruit.com/), or other [custom software environments](http://www.openframeworks.cc/) and so on.

If you are not familiar with programming, SuperCollider may not be the option for you. I would suggest you go and check out some of the many awesome GUI-driven synthesis engines out there.

However, if you are still interested, I left a trail behind me while I learned. Some blog posts and references really helped, others I wrote because I wanted them and they weren't there. This is the route that worked for me:

1. **To get a grounding in what SuperCollider is and if it will work for you**, check out my article: [Getting Started with SuperCollider](http://jahya.net/blog/?2012-05-getting-started-with-supercollider)

2. **To plough ahead and learn the SuperCollider environment hands-on**, read [Scott Wilson's tutorial](http://supercollider.svn.sourceforge.net/viewvc/supercollider/trunk/common/build/Help/Tutorials/Getting-Started/Getting%20Started%20With%20SC.html). This will give you an understanding of the tools and building blocks SuperCollider puts at your fingertips.

3. **As you go forward and start making sounds**, use my one-page [Quick Reference for SuperCollider](http://jahya.net/blog/?2012-06-quickref-for-supercollider) to refresh your memory. It gives you concise versions of all the examples you learned from Scott Wilson's tutorial (above), and saves you having to dig back through to find what you were looking for.

4. Now that you understand the SuperCollider environment and how to create synths, you need a **crash course in audio synthesis** - that's what this repo is for. Grab your copy of [the cookbook](http://www.amazon.com/Welshs-Synthesizer-Cookbook-Programming-Universal/dp/B000ERHA4S) and dig in!

P.S. For ad-hoc help along the way, check out this amazing array of quick tutorial videos by WickieMedia, [here](http://www.youtube.com/user/wickiemedia) or [here](http://www.wickiemedia.net/audio-tutorials.html).

Also, drop me a message to tell how you got on. Better still, fork the repo and submit pull requests with your contributions!

## Why did you create this repo?

I wanted a hands-on guide that would give me whirlwind explanation of synthesis at a basic level. I wanted a reference that did this in the context of SuperCollider, but I couldn't find one. So I read the book and wrote the best SuperCollider examples I could think of at the time.