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