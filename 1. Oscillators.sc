/*
   --------------
   1. OSCILLATORS
   --------------

   The cookbook says...
   ====================
   "The process of adding sine waves together to create sounds is known as
    additive synthesis. This method is used on a few digital synthesizers
    and has also been used by pipe organs for hundreds of years..."

   But the real aim of this chapter is to teach building blocks for later
   ======================================================================
   "Analog synthesizers use a process called subtractive synthesis which
    is simply additive synthesis in reverse. Here's some terminology for
    you: Sounds created by synthesizers are referred to as patches..."

   "Patches created using subtractive synthesis start with waveforms that
    are already rich in harmonics such as sawtooth, square, and triangle
    waves. These waveforms are then passed to a filter which removes
    harmonics from the waveforms in order to produce the desired sounds."

   "The harmonics are subtracted out, hence the process is known as
    subtractive synthesis."
*/

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
   - Notice the use of a negative value for the 880Hz SinOsc.
   - Ref: http://www.sussex.ac.uk/Users/nc81/modules/cm1/scfiles/2.1 Subtractive and Additive Synthesis.html */
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
     for multiplying by positive and negative numbers.
   - Ref: http://www.sussex.ac.uk/Users/nc81/modules/cm1/scfiles/2.1 Subtractive and Additive Synthesis.html */
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
     -1 ** 3 == -1 etc.
   - Ref: http://www.sussex.ac.uk/Users/nc81/modules/cm1/scfiles/2.1 Subtractive and Additive Synthesis.html */
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
     positive to negative multiplier values.
   - Ref: http://www.sussex.ac.uk/Users/nc81/modules/cm1/scfiles/2.1 Subtractive and Additive Synthesis.html */
(
    ~peak = 0.5;
    ~numPartials = 50;
    ~fundamental = 440;

    x = {
        Mix.fill(~numPartials, {|i|
            var j = (2 * i) + 1; //1, 3, 5 etc
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
     since we are still using only odd-numbered harmonics.
   - Ref: http://www.sussex.ac.uk/Users/nc81/modules/cm1/scfiles/2.1 Subtractive and Additive Synthesis.html */
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
   - This synthesis approximates a marimba
   - Ref: http://en.wikipedia.org/wiki/Piano_key_frequencies */
(
    x = {
        LFTri.ar(440, mul: 0.4) + LFTri.ar(1760, mul: 0.15) !2;
    };

    x.plot(0.005);
    x.play;
)

/* Figure 13. Narrower pulse widths on square waves.
   ================================================
   - Narrowing the width of the pulse means introducing even numbered
     partials alongside the odd ones.
   - Therefore, narrowing the pulse width creates a brighter, edgier
     sound similar to a sawtooth.
   - However, the harmonics don't die out as quickly or with the same
     uniformity as a sawtooth.
   - Narrow pulses have a crisp, metallic sound. Undulating pattern
     similar to many acoustic instruments.
   - Ref: http://en.wikipedia.org/wiki/Pulse_wave */
x = {Pulse.ar(440, width: 0.5) !2}; x.plot(0.01); x.play;
x = {Pulse.ar(440, width: 0.6) !2}; x.plot(0.01); x.play;
x = {Pulse.ar(440, width: 0.7) !2}; x.plot(0.01); x.play;
x = {Pulse.ar(440, width: 0.8) !2}; x.plot(0.01); x.play;
x = {Pulse.ar(440, width: 0.9) !2}; x.plot(0.01); x.play;

x = {Pulse.ar(440, width: MouseX.kr(0.1, 0.5)) !2}; x.plot(0.01); x.play;
x = {Pulse.ar(440, width: MouseX.kr(0.5, 0.9)) !2}; x.plot(0.01); x.play;

/* Figures 16, 17, 18. White, Pink and Brown noise.
   ===============================================
   - White noise: maintains uniform power over all frequencies
   - Pink noise:  diminishes in power by 3dB per octave
   - Brown noise: diminishes in power by 6dB per octave
   - White noise sounds brighter than pink noise, and pink noise sounds
     brighter than brown noise.*/
x = {WhiteNoise.ar(0.4) !2}; x.plot(0.1); x.play;
x = {PinkNoise.ar(0.4)  !2}; x.plot(0.1); x.play;
x = {BrownNoise.ar(0.4) !2}; x.plot(0.1); x.play;

/* Figure 19. Unison broadens the harmonics of a waveform.
   ======================================================
   - True analog oscillators cannot keep exactly the same tuning,
     varying by a few cents at a time. This means that when several
     are played in unision, a 'thick', harmonically rich sound is
     created.
   - With the 'perfectness' of the constituent tones in digital
     oscillators, we have several options for how to implement
     unison. A couple are sketched out below.
   - Ref: http://music.tutsplus.com/articles/the-low-down-on-chorus-and-unison-effects--audio-3628 */

/* - A saw on it's own, for reference. */
{Saw.ar(220) !2}.play;

/* - Multiple saws at slightly different frequencies. Because the
     frequencies are slightly different we get a phasing effect as
     the tones pass over each other. */
(
    ~numVoices = 5;
    ~offset = floor(~numVoices/2);
    ~freq = 220;
    ~distance = 0.3;

    x = {
        ~freq.post; "Hz in ".post; ~numVoices.post; " voices, distribued:".postln;

        m = Mix.fill(~numVoices, {|i|
            var detuneAmount = (i - ~offset) * ~distance;
            var thisFreq = ~freq + detuneAmount;
            thisFreq.post; " ".postln;
            LFSaw.ar(thisFreq);
        });
        m / ~numVoices !2;
    };
    x.plot(0.005);
    x.play;
)

/* - Multiple saws, this time at the same frequency but at slightly
     different phases. No phasing, and a thicker sound. */
(
    ~numVoices = 5;
    ~freq = 220;
    ~distance = pi * 0.05;

    x = {
        ~freq.post; "Hz in ".post; ~numVoices.post; " voices, distanced:".postln;

        m = Mix.fill(~numVoices, {|i|
            var thisDistance = i * ~distance;
            thisDistance.post; " ".postln;
            LFSaw.ar(~freq, thisDistance);
        });
        m / ~numVoices !2;
    };
    x.plot(0.005);
    x.play;
)