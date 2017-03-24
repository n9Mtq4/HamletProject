/*
 * NOTE: This is added by intellij IDE. Disregard this copyright if there is another copyright later in the file.
 * Copyright (C) 2015  Will (n9Mtq4) Bresnahan
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.willjake.hamlet.sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

@SuppressWarnings("unchecked")
public class SoundManager {
	
	private Vector afs;
	private Vector sizes;
	private Vector infos;
	private Vector audios;
	private int num = 0;
	
	public SoundManager() {
		afs = new Vector();
		sizes = new Vector();
		infos = new Vector();
		audios = new Vector();
	}
	
	public int addClip(String s)
			throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		InputStream in = getClass().getResourceAsStream(s);
		//InputStream inputstream = url.openStream();
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(loadStream(in));
		AudioFormat af = audioInputStream.getFormat();
		int size = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
		byte[] audio = new byte[size];
		DataLine.Info info = new DataLine.Info(Clip.class, af, size);
		audioInputStream.read(audio, 0, size);
		
		afs.add(af);
		sizes.add(size);
		infos.add(info);
		audios.add(audio);
		
		num++;
		return num - 1;
		
	}
	
	private ByteArrayInputStream loadStream(InputStream inputstream)
			throws IOException {
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		byte data[] = new byte[1024];
		for (int i = inputstream.read(data); i != -1; i = inputstream.read(data))
			bytearrayoutputstream.write(data, 0, i);
		
		inputstream.close();
		bytearrayoutputstream.close();
		data = bytearrayoutputstream.toByteArray();
		return new ByteArrayInputStream(data);
	}
	
	public Clip playSound(int x)
			throws UnsupportedAudioFileException, LineUnavailableException {
		if (x > num) {
			System.out.println("playSound: sample nr[" + x + "] is not available");
		}else {
			Clip clip = (Clip) AudioSystem.getLine((DataLine.Info) infos.elementAt(x));
			clip.open((AudioFormat) afs.elementAt(x), (byte[]) audios.elementAt(x), 0, ((Integer) sizes.elementAt(x)).intValue());
			clip.start();
			return clip;
		}
		return null;
	}
	
}
