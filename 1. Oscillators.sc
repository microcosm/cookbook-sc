//Figure 2. A 440Hz sine wave
(
    x = {
        SinOsc.ar(freq: 440) !2
    };
    x.plot(0.005);
    x.play;
)

//Figure 3. A 440Hz sine wave added to an 880Hz sine wave
//Note the change in phase to position the two waves relative to each other
(
    x = {
        SinOsc.ar(440, phase: pi,  mul: 2/3) +
        SinOsc.ar(880, phase: -pi, mul: 1/3) !2
    };
    x.plot(0.005);
    x.play;
)

//Figure 3 can be written another way by modifying the multiplier only
//instead of the phase
//Notice the use of a negative value for the 880Hz SinOsc
(
    ~peak = 0.75;
    x = {
        SinOsc.ar(440, mul: 1  * (~peak/1)) +
        SinOsc.ar(880, mul: -1 * (~peak/2)) !2
    };
    x.plot(0.005);
    x.play;
)

//Figure 4. Three sine waves of frequency 440Hz, 880Hz, and 1320Hz
//Notice we had to adjust the peak, and a pattern is starting to emerge
//for multiplying by positive and negative numbers
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