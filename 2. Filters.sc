/*
   ----------
   2. FILTERS
   ----------

   The cookbook says...
   ====================
   "The incorporation of filters was the first great revolution in early
    electronic music after the oscillator. There are only a few distinct
    sounds that can be created using unfiltered waveforms. Synthesizers
    were born with the introduction of the filter. Of all the components
    on a synthesizer it is the most responsible for shaping sound.
    Filters are used to change the timbre or tone color of these basic
    waveforms."
*/

/* Figure 20. Unfiltered white noise, for reference.
   ================================================ */
x = { WhiteNoise.ar(0.4) !2 }; x.plot(0.1); x.play;

/* Figure 21. White noise routed through a low-pass filter.
   =======================================================
   - The argument 'freq' represents the cutoff frequency.
   - Frequencies above the cutoff are attenuated. */
(
    //with a fixed cutoff frequency
    x = {
        LPF.ar(
            in: WhiteNoise.ar(0.4),
            freq: 4000
        )!2};
    x.plot(0.1);
    x.play;
)
(
    //the same but you can vary the cutoff with your mouse
    x = {
        LPF.ar(
            in: WhiteNoise.ar(0.4),
            freq: MouseY.kr(110, 16000)
        )!2};
    x.plot(0.1);
    x.play;
)

/* Figure 22. White noise routed through a high-pass filter.
   ========================================================
   - The argument 'freq' represents the cutoff frequency.
   - Frequencies below the cutoff are attenuated. */
(
    //with a fixed cutoff frequency
    x = {
        HPF.ar(
            in: WhiteNoise.ar(0.4),
            freq: 4000
        )!2};
    x.plot(0.1);
    x.play;
)
(
    //the same but you can vary the cutoff with your mouse
    x = {
        HPF.ar(
            in: WhiteNoise.ar(0.4),
            freq: MouseY.kr(110, 16000)
        )!2};
    x.plot(0.1);
    x.play;
)

/* Figure 23. White noise routed through a band-pass filter.
   ========================================================
   - The argument 'freq' represents the center frequency.
   - Frequencies either side of the center are attenuated.
   - The argument 'rq' just describes the slopes either side of the center
     frequency. Higher values amplify the slopes, lower values attenuate
     them. */
(
    //with a fixed center frequency and rq
    x = {
        BPF.ar(
            in: WhiteNoise.ar(0.4),
            freq: 4000,
            rq: 0.01
        )!2};
    x.plot(0.1);
    x.play;
)
(
    /* === WARNING - READ THE SAFETY NOTES === */
    //with a mouse-adjustable center frequency and rq...
    x = {
        BPF.ar(
            in: WhiteNoise.ar(0.4),
            freq: MouseY.kr(110, 23000),
            rq: MouseX.kr(0.01, 0.99)
        )!2};
    x.plot(0.1);
    x.play;
)

/* Figure 24. White noise routed through a band-reject/notch filter.
   ================================================================
   - The argument 'freq' represents the center frequency.
   - Frequencies close to the center are attenuated.
   - The argument 'rq' just describes the slopes either side of the center
     frequency. Higher values attenuate the slopes, lower values amplify
     them. */
(
    //with a fixed center frequency and rq
    x = {
        BRF.ar(
            in: WhiteNoise.ar(0.4),
            freq: 4000,
            rq: 0.99
        )!2};
    x.plot(0.1);
    x.play;
)
(
    /* === WARNING - READ THE SAFETY NOTES === */
    //with a mouse-adjustable center frequency and rq...
    x = {
        BRF.ar(
            in: WhiteNoise.ar(0.4),
            freq: MouseY.kr(110, 23000),
            rq: MouseX.kr(0.01, 0.99)
        )!2};
    x.plot(0.1);
    x.play;
)

/* Figure 25. White noise through an LPF with a 6kHz cutoff frequency.
   ================================================================== */
(
    x = {
        LPF.ar(
            in: WhiteNoise.ar(0.4),
            freq: 6000
        )!2};
    x.plot(0.1);
    x.play;
)

/* Figure 26. Slope of a 4-pole filter.
   ===================================
   - A 4-pole filter is one that gives 24dB of attenuation per octave.
   - 'Octave' is a relative term, and when we talk about filters, by
     convention our first octave is at 4kHz.
   - So as the cookbook says:
     "Material at 8kHz is attenuated 24dB more than material at 4kHz
      since these frequencies are one octave apart."
   - You can check this in the frequency analyzer! */
(
    x = {
        LPF.ar(
            in: WhiteNoise.ar(0.4),
            freq: 4000
        )!2};
    x.plot(0.1);
    x.play;
)

/* Figure 27. Slope of a 2-pole filter.
   ===================================
   - A 2-pole filter is one that gives 12dB of attenuation per octave. */
(
    x = {
        TwoPole.ar(
            in: WhiteNoise.ar(0.4),
            freq: 4000
        )!2};
    x.plot(0.1);
    x.play;
)

/* Figure 29. A resonant LPF.
   ========================= */
(
    //with a fixed cutoff frequency...
    x = {
        RLPF.ar(
            in: WhiteNoise.ar(0.4),
            freq: 4000,
            rq: 0.05
        )!2};
    x.plot(0.1);
    x.play;
)
(
    //with a mouse-adjustable cutoff frequency...
    x = {
        RLPF.ar(
            in: WhiteNoise.ar(0.1),
            freq: MouseX.kr(0,1600),
            rq: 0.005
        )!2};
    x.plot(0.5);
    x.play;
)
(
    //using Resonz, a stronger RLPF
    /* Ref: "http://danielnouri.org/docs/SuperColliderHelp/Tutorials/Mark_Polishook_tutorial/Synthesis/10_Subtractive_synthesis.html"
       Note that 'bwr' appears to be equivalent to 'rq'. But with
       explanation:
       "The reciprocal of Q is used rather than Q because it saves a
        divide operation inside the unit generator." */
    x = {
        Resonz.ar(
            in: WhiteNoise.ar(1),
            freq: MouseX.kr(0,1600),
            bwr: 0.005
        )!2};
    x.plot(0.1);
    x.play;
)

/* A first stab at the acid track synthesizer example cited at the end
   of the Filters chapter. */
(
    SynthDef(\acid, { |freq = 440, sustain = 1, amp = 0.5|
        var sig;

        //lead line
        sig = LFSaw.ar(freq, 0, amp) *
            EnvGen.kr(Env.linen(0.1, sustain, 0.1), doneAction: 2);

        //bass line
        sig = sig + LFSaw.ar(freq * 0.25, 0, amp) *
            EnvGen.kr(Env.linen(0.01, sustain, 0.01), doneAction: 2);

        //resonant filter over each note
        sig = RLPF.ar(sig, Line.kr(freq, freq * 2.5, sustain * 0.8), 0.25);

        //resonant filter over whole thing
        sig = RLPF.ar(sig, MouseX.kr(100, 1600), 0.25);

        //out
        Out.ar(0, sig!2)
    }).add;

    p = Pbind(
        \instrument, \acid,
        \midinote, Pseq([50,  62,  61,  57,  62,   62,   57],  inf),
        \dur,      Pseq([0.5, 0.5, 0.1, 0.1, 0.45, 0.25, 0.1], inf)
    ).play;
)