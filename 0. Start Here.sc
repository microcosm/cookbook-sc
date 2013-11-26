/*
   -------------
   0. START HERE
   -------------

   This file is intended to help you get started! You will probably
   want to read this file before you start the first chapter, but
   you will also probably want to refer back here each time you
   start a new SuperCollider session.

   If anything in this file doesn't make sense, or if you don't know
   what 'the cookbook' is, go check out the README.

   In this file:
   ============
   1. The most helpful key combinations for the SuperCollider IDE
   2. A test tone to ensure your sound is working
   3. A test plot to get you used to visualizing waveforms
   4. A codeblock and instructions to launch Oscilloscope and
      Frequency Analysis windows, to match the cookbook
*/

/* ==============================================================
   1. The most helpful key combinations for the SuperCollider IDE
   ==============================================================

   -----------
   Shift-Cmd-B
   -----------
   Position your cursor to the right of the open bracket '(' in the
   last codeblock below. Now press Shift-Cmd-B. Notice how all the
   code inside the brackets is highlighted?

   -----------
   Shift-Enter
   -----------
   Once you have a codeblock selected, use Shift-Enter to evaluate
   the selected code. You should hear sound playing, OR see some
   response in the Post window.

   Note that you can also place your cursor anywhere on a single line
   of code and press Shift-Enter to execute only that line of code.

   -----
   Cmd-.
   -----
   Stop all playback.

   -----
   Cmd-D
   -----
   With your cursor on some evaluable code element, like SinOsc or
   scope, using Cmd-D will display the relevant help file in the
   Help Browser window.

   -------
   Cmd -/+
   -------
   Adjust text size in the code editor or Post window. Note that you
   can default text size in Preferences > Editor > Font & Colors

*/

/* ==============================================
   2. A test tone to ensure your sound is working
   ==============================================
   Place your cursor at the end of the line of code below, after
   play. Press Shift-Enter. This should make sound.
    - ALWAYS start with the volume LOW, then start the sound, then
      creep the volume up.
    - If you can't hear anything, check your speakers and your
      audio configuration. */
{ SinOsc.ar(440)!2 }.play

/* =======================================================
   3. A test plot to get you used to visualizing waveforms
   =======================================================
   To visualize any sound function block like the one above,
   switch play for plot.
    - The argument is the number of seconds of playback to plot.
      When you evaluate these lines you have to wait that number
      of seconds before the results appear in the window. */
{ SinOsc.ar(440)!2 }.plot(0.01)
{ SinOsc.ar(440)!2 }.plot(2)

/* ==========================================================
   4. A codeblock and instructions to launch Oscilloscope and
      Frequency Analysis windows, to match the cookbook
   ==========================================================
   Position your cursor to the right of the open bracket '(' below,
   and use Shift-Cmd-B and Shift-Enter to execute the codeblock as
   described above.
    - Once you run the codeblock the Oscilloscope window will jump
      to the front. Press Cmd-Tab twice to bring the FFT window to
      the front too.
    - Arrange the windows on your screen so that you can see both
      these windows while you work.
    - To make the FFT window match the cookbook, switch the FrcScl
      drop-down to 'lin' for linear. If you do this after you have
      sounds playing, you will need to stop the playback and
      restart the sound to see the change. */
(
    /* FFT Window */
    Server.quitAll;
    s = FreqScope.server.boot;
    FreqScope.new(800, 400, 0);

    /* Oscilloscope window */
    w = Window.new("cookbook", Rect(20, 20, 262, 262));
    w.view.decorator = FlowLayout(w.view.bounds);
    c = Stethoscope.new(s, view:w.view, zoom:8);
    w.onClose = { c.free }; //don't forget this
    w.front;
)