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

/* Figures 20, 21. Filtered white noise.
   ====================================
   - Unfiltered white noise, for reference. */
x = {WhiteNoise.ar(0.4) !2}; x.plot(0.1); x.play;

/* - White noise routed through a low-pass filter.
   - Note that a frequency argument has been added to shape the waveform
     similar to the cookbook. */
x = {LPF.ar(WhiteNoise.ar(0.4), 4000) !2}; x.plot(0.1); x.play;