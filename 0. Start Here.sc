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
   the slected code. You should hear sound playing, or see some
   response in the Post window.

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

/* 1. This should make sound. If it doesn't, check your speakers and
      your audio configuration. When working with sound, always
      start with the volume LOW, then start the sound, then creep
      the volume up. */
{ SinOsc.ar(440)!2 }.play

/* 2. Start your engines!
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