/*
   The most helpful key combinations for the SuperCollider IDE.

   Shift-Cmd-B
   ===========
   Position your cursor to the right of the open bracket '(' below.
   Now press Shift-Cmd-B. Notice how all the code inside the brackets
   is highlighted?

   Shift-Enter
   ===========
   Once you have a codeblock selected, use Shift-Enter to evaluate
   the selected code. You should hear sound playing, OR see some
   response in the Post window.

   Note that you can also place your cursor anywhere on a single line
   of code and press Shift-Enter to execute only that line of code.

   Cmd-.
   =====
   Stop all playback.

   Cmd-D
   =====
   With your cursor on some evaluable code element, like SinOsc or
   scope, using Cmd-D will display the relevant help file in the
   Help Browser window.

   Cmd -/+
   =======
   Adjust text size in the code editor or Post window. Note that you
   can default text size in Preferences > Editor > Font & Colors

*/

/* 1. Place your cursor at the end of the code below, after play.
      Press Shift-Enter. This should make sound.
      - ALWAYS start with the volume LOW, then start the sound, then
        creep the volume up.
      - If you can't hear anything, check your speakers and your
        audio configuration. */
{ SinOsc.ar(440)!2 }.play

/* 2. To visualize any sound function block like the one above,
      switch play for plot.
      - The argument is the number of seconds of playback to plot.
        When you evaluate these lines you have to wait that number
        of seconds before the results appear in the window. */
{ SinOsc.ar(440)!2 }.plot(0.01)
{ SinOsc.ar(440)!2 }.plot(2)

/* 3. Start your engines!
      The codeblock below will give you an FFT window and an
      Oscilloscope window.
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