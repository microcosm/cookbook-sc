//Figure 2. A 440Hz sine wave
(
    x = {
	    SinOsc.ar(freq: 440) !2
    };
    x.plot(0.005);
    x.play;
)

//Figure 3. A 440Hz sine wave added to an 880Hz sine wave
(
    x = {
	    SinOsc.ar(440, phase: pi,  mul: 2/3) +
	    SinOsc.ar(880, phase: -pi, mul: 1/3) !2
    };
    x.plot(0.005);
    x.play;
)