/*
   Cmd-D : Display help
   Cmd-. : Stop playback
   Shift-Enter : Start playback (with code selected)
   Shift-Cmd-B : Select code block inside parentheses
*/

//Start your engines!
(
    //Cookbook likes FFT!
    //Quit existing servers and boot again attached to an FFT graph
    //Switch FrcScl (before playing) in the GUI to 'lin' to match
    // views in the book
    Server.quitAll;
    s = FreqScope.server.boot;
    FreqScope.new(800, 400, 0);

    //Cookbook likes Oscilloscopes!
    w = Window.new("cookbook", Rect(20, 20, 262, 262));
    w.view.decorator = FlowLayout(w.view.bounds);
    c = Stethoscope.new(s, view:w.view, zoom:8);
    w.onClose = { c.free }; //don't forget this
    w.front;

    //Cmd-tab if they open in the background!
)

{SinOsc.ar(440)!2}.play;