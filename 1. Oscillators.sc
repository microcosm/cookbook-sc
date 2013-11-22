/* Figure 2. A 440Hz sine wave.
   =========================== */
(
    x = {
        SinOsc.ar(freq: 440) !2
    };
    x.plot(0.005);
    x.play;
)

/* Figure 3. A 440Hz sine wave added to an 880Hz sine wave.
   =======================================================
   - Notice the change in phase to position the two waves relative to each
     other. */
(
    x = {
        SinOsc.ar(440, phase: pi,  mul: 2/3) +
        SinOsc.ar(880, phase: -pi, mul: 1/3) !2
    };
    x.plot(0.005);
    x.play;
)

/* Figure 3 rewritten.
   ==================
   - Figure 3 can be written another way by modifying the multiplier only
     instead of the phase.
   - Notice the use of a negative value for the 880Hz SinOsc. */
(
    ~peak = 0.75;
    x = {
        SinOsc.ar(440, mul: 1  * (~peak/1)) +
        SinOsc.ar(880, mul: -1 * (~peak/2)) !2
    };
    x.plot(0.005);
    x.play;
)

/* Figure 4. Three sine waves of frequency 440Hz, 880Hz, and 1320Hz.
   ================================================================
   - Notice we had to adjust the peak, and a pattern is starting to emerge
     for multiplying by positive and negative numbers. */
(
    ~peak = 0.65;
    x = {
        SinOsc.ar(440,  mul: 1  * (~peak/1)) +
        SinOsc.ar(880,  mul: -1 * (~peak/2)) +
        SinOsc.ar(1320, mul: 1  * (~peak/3)) !2
        //if we had another SinOsc here it would need a negative multiplier
    };
    x.plot(0.005);
    x.play;
)

/* Figure 5. A sawtooth.
   ====================
   - Similar to brass and string instruments.
   - Now we are using Mix.fill to automate the process of extending the
     pattern above. Try adjusting ~numPartials to 50.
   - Note that ** is an exponent operator. The code '-1 ** i' produces
     the following pattern:
     -1 ** 0 == 1
     -1 ** 1 == -1
     -1 ** 2 == 1
     -1 ** 3 == -1 etc. */
(
    ~peak = 0.5;
    ~numPartials = 15;
    ~fundamental = 440;

    x = {
        Mix.fill(~numPartials, {|i|
            var j = i + 1;
            var mul = (-1 ** i) * (~peak / j);
            SinOsc.ar(~fundamental * j, mul: mul);
        }) !2;
    };
    x.plot(0.005);
    x.play;
)

/* Figure 7. A square wave.
   =======================
   - Similar to woodwind instruments.
   - Only odd numbered partials.
   - Since we are now only dealing with every other partial, and dropping
     the in-between partials, we no longer have to keep switching from
     positive to negative multiplier values. */
(
    ~peak = 0.5;
    ~numPartials = 50;
    ~fundamental = 440;

    x = {
        Mix.fill(~numPartials, {|i|
            var j = (2 * i) + 1;
            var mul = ~peak / j;
            SinOsc.ar(~fundamental * j, mul: mul);
        }) !2;
    };
    x.plot(0.005);
    x.play;
)

/* Figure 8. A triangle wave.
   =========================
   - With their diminished higher harmonics, triangle waves are good for
     mixing together to produce inharmonic sounds (bells, chimes etc) as
     well as adding the occasional rogue harmonic to saw and pulse forms.
   - Only odd numbered partials.
   - We are back to alternating between -1 and 1 which I don't really get
     since we are still using only odd-numbered harmonics */
(
    ~peak = 0.8;
    ~numPartials = 20;
    ~fundamental = 440;

    x = {
        Mix.fill(~numPartials, {|i|
            var j = (2 * i) + 1;
            var mul = (-1 ** i) * (~peak / (j ** 2));
            SinOsc.ar(~fundamental * j, mul: mul);
        }) !2;
    };

    x.plot(0.005);
    x.play;
)

/* Figure 12. Two triangle waves make a more harmonically rich sound.
   =================================================================
   - This (poorly) approximates a marimba */
(
    x = {
	    (
		    (LFTri.ar(440, 0.7) + LFTri.ar(1046.50, mul: 0.2)
	    ) * 0.8) !2;
    };

    x.plot(0.005);
    x.play;
)

/* References
   ==========
   1. Additive Synthesis examples
      http://www.sussex.ac.uk/Users/nc81/modules/cm1/scfiles/2.1 Subtractive and Additive Synthesis.html
   2. Octave frequency tables
      http://altered-states.net/barry/frequencies/octavefrequencytable.htm */