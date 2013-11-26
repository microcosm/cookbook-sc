/*
   ------------
   3. ENVELOPES
   ------------

   The cookbook says...
   ====================
   "If we want a patch to start loud and die out slowly like a cymbal or
    start out quiet and slowly become louder like a violin an envelope
    could be used to control the amplitude."

   Not just amplitude
   ==================
   Note that although amplitude is the most obvious application of
   envelopes, you can really control anything with them. For example in
   this chapter there are some great examples using ADSR envelopes to
   control a filter's cutoff frequency.
*/

/* Figure 32. An ADSR envelope controlling amplitude.
   =================================================
   - I'm not sure why the plot doesn't release correctly
   - Ref: http://www.youtube.com/watch?v=-wDAPo9hpCg */
(
    x = { |gate = 1|

        var sig, env;
        sig = SinOsc.ar(220);
        env = EnvGen.kr(
            Env.adsr(1.5, 1.5, 0.5, 4),
            gate: gate,
            doneAction: 2
        );
        sig * env !2;
    };

    y = x.play;
    x.plot(10);
    SystemClock.sched(6, { y.set(\gate, 0); });
)

/* An ADSR envelope controlling filter cutoff frequency.
   ====================================================
   - I'm not sure why the plot doesn't release correctly
   - I'm not sure why the whole sound cuts out
   - Ref: http://www.youtube.com/watch?v=-wDAPo9hpCg */
(
    x = { |gate = 1|
        var sig, env;
        env = EnvGen.kr(
            Env.adsr(0.3, 0.3, 0.9, 1.2),
            gate: gate
        );

        sig = RLPF.ar(
            in: LFSaw.ar(220),
            freq: 220 + (220 * env),
            rq: 0.005
        );
        sig * env !2;
    };

    y = x.play;
    x.plot(10);
    SystemClock.sched(6, { y.set(\gate, 0); });
)

/* Note: there is a final example on this page that is
   worth adding once the above two examples are fixed! */