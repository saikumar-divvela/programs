package com.sss.patterns;

/*
 alternative to wrapper class or decorative pattern
	when needed
		This pattern allows two different interfaces work together. Interfaces may be incompatible but the inner
		 functionality should suit the need.
	how implemented
		using inheritance or using composition.
	example:
		American socket/plug are different from british socket/adapter. we can use adapter to work with american plug.
		Java api example:
		java.io.InputStreamReader(InputStream)
		java.io.OutputStreamWriter(OutputStream)
		card reader, connecting memory card in laptop
 */
public class AdapterPattern2 {
	public static void main(String args[]) throws Exception{
		AudioPlayer player = new AudioPlayer();
		player.play("mp3", "rahman.mp3");
		player.play("vlc", "roja");
		player.play("mp4", "saibaba.vlc");
	}
}

interface MediaPlayer {
	public void play(String type,String fileName);
}

interface AdvancedMediaPlayer {
	public void playVlc(String fileName);
	public void playMp4(String fileName);
}

class MediaAdapter implements MediaPlayer{
	AdvancedMediaPlayer player;
	
	MediaAdapter(String type){
		if(type.equalsIgnoreCase("vlc")){
			player = new VlcPlayer();
		} else if(type.equalsIgnoreCase("mp4")){
			player = new MP4Player();
		}
	}
	
	
	public void play(String type,String fileName){
		if(type.equalsIgnoreCase("vlc")){
			player.playVlc(fileName);
		} else if(type.equalsIgnoreCase("mp4")){
			player.playMp4(fileName);
		}
	}
	
}

class AudioPlayer implements MediaPlayer {
	MediaAdapter adapter;
	
	
	public void play(String type,String fileName){
		if(type.equalsIgnoreCase("mp3")){
			System.out.println("playing mp3 file ... "+fileName);
		} else {
			adapter = new MediaAdapter(type);
			adapter.play(type, fileName);
		}
	}

}

class VlcPlayer implements AdvancedMediaPlayer{
	
	public void playVlc(String fileName){
		System.out.println("Playing VLC audio file.. "+fileName);
	}
	
	
	public void playMp4(String fileName){
		// do nothing
	}
}

class MP4Player implements AdvancedMediaPlayer {
	
	public void playVlc(String fileName){
		// do nothing
	}
	
	public void playMp4(String fileName){
		System.out.println("Playing Mp4 audio file.. "+fileName);
	}
}