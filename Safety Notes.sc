/*
   Safety Notes
   ============
   This issue cost my speakers and my ears a jolt. Nothing dangerous in
   the long run, just a loud spike in sound. But still you want to know
   about this issue to avoid it. So learn from my mistake!

   What's the problem?
   ==================
   SuperCollider gives you low-level access to sound objects (UGens).
   This means you have lots of power, you are playing with the nuts and
   bolts. It also means there are no safety systems to protect you from
   doing something crazy.

   Sometimes we want to use the values from one UGen as inputs to some
   other UGen: */
   { SinOsc.ar(MouseX.kr(0, 1000)) !2 }.play;

/* We need to be 100% sure of the possible range of values we pass into
   a UGen. Some UGens will respond really badly to the wrong values.

   For example, the 'rq' argument to the BPF UGen works happily with
   positive arguments. But any negative value causes the amplitude to
   shoot up to ridiculous levels: */

   /* === WARNING! NEVER PLAY THIS, ONLY PLOT IT ==== */
   { BPF.ar(WhiteNoise.ar(0.4), rq: -1) }.plot(0.05);

/* How to avoid it
   ===============
   1) Whenever you are working with a new UGen or a new parameter for a
      UGen that you don't understand, PLOT IT BEFORE YOU PLAY IT!

   2) Be aware of the values you are passing around. Some of them are
      are known and cannot extend beyond certain bounds, and so are
      safe. However, some can surprise you, for example, the mouse /
      dual screen problem described below.

   Using dual monitors with MouseX and MouseY
   ==========================================
   When we use MouseX and MouseY, we specify the range of values we
   expect. In the example from earlier, the range is (0 - 1000): */
   { SinOsc.ar(MouseX.kr(0, 1000)) !2 }.play;

/* Most operating systems allow you to use multiple displays, and to
   choose whichever display you like to be the primary display.

   The problem is, SC's MouseX and MouseY will map the given range
   to the boundaries of the primary display, so that if you have a
   display configuration like this...

             X             X
   -1000 <------> 0  0 <-------> 1000
     -------------    -------------
    |             |  |             |
    |  Secondary  |  |  Primary    |
    |  display    |  |  display    |
    |             |  |             |
     -------------    -------------

   ...your mouse cursor can easily venture into negative numbers by
   moving into the secondary display. Negative numbers drive some UGens
   crazy - like BPF in the example above.

   How to avoid it
   ===============
   Know the possible range of values that you can get from MouseX and
   MouseY given your display configuration and the value ranges you
   specify. Use the code below.

   Also, don't forget to make sure that the value range you specify
   when testing - i.e. (1, 1000) below - is the same range you specify
   in your UGens for real.
*/
{ MouseX.kr(0, 1000).poll(label: \MouseX) }.play;
{ MouseY.kr(0, 1000).poll(label: \MouseY) }.play;