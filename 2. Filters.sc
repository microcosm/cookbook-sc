/* The cookbook says...
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
x = {WhiteNoise.ar(0.4) !2}; x.plot(0.1); x.play;

/* Figures 21, 22. High-and-low pass filters.
   =========================================
   - White noise routed through a low-pass filter.
   - Note that a frequency argument has been added to shape the waveform
     similar to the cookbook. */
x = {LPF.ar(WhiteNoise.ar(0.4), 4000) !2}; x.plot(0.1); x.play;
x = {LPF.ar(WhiteNoise.ar(0.4), MouseY.kr(110, 16000)) !2}; x.plot(0.1); x.play;

/* - White noise routed through a high-pass filter. */
x = {HPF.ar(WhiteNoise.ar(0.4), 4000) !2}; x.plot(0.1); x.play;
x = {HPF.ar(WhiteNoise.ar(0.4), MouseY.kr(110, 16000)) !2}; x.plot(0.1); x.play;

/* Figures 23, 24. Bandpass and band-reject/notch filters.
   ======================================================
   - White noise routed through a bandpass filter.
   - Note that a frequency argument has been added to shape the waveform
     similar to the cookbook. */
x = {BPF.ar(WhiteNoise.ar(0.4), 4000, 0.01) !2}; x.plot(0.1); x.play;
x = {BPF.ar(WhiteNoise.ar(0.4), MouseY.kr(110, 23000), MouseX.kr(0.01, 0.99)) !2}; x.plot(0.1); x.play;

/* - White noise routed through a high-pass filter. */
x = {BRF.ar(WhiteNoise.ar(0.4), 4000, 0.99) !2}; x.plot(0.1); x.play;
x = {BRF.ar(WhiteNoise.ar(0.4), MouseY.kr(110, 23000), MouseX.kr(0.01, 0.99)) !2}; x.plot(0.1); x.play;