/*
   Cmd-D : Display help
   Cmd-. : Stop playback
   Shift-Enter: Start playback (with code selected)
*/

//Cookbook likes FFT!
//Quit existing server(s) and boot again attached to an FFT graph
//Switch FrcScl in the GUI to lin to match cookbook
Server.quitAll;
s = FreqScope.server.boot;
FreqScope.new(800, 400, 0);

{SinOsc.ar(440)!2}.play