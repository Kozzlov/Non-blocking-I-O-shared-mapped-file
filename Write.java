import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Write {
	// random access file behaves like a large array of bytes
	RandomAccessFile file;
	File fileToWrite = new File("D:\\Рабочий стол\\file.txt");
	Random random = new Random();
	int size = 16;

	public Write() {
		try {
			file = new RandomAccessFile(fileToWrite, "rw");
			// w - write
			// rw - read,write
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void write() {
		// writing values
		// The position of the returned channel will always be equal to this object's
		// file-pointer
		FileChannel fc = file.getChannel();
		try {
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, size);
			while (true) {
				mbb.rewind();
				int tmp = mbb.getInt();
				if (tmp == Flag.READ.FLAG) {
					mbb.rewind();
					mbb.putInt(Flag.WRITE.FLAG);
					mbb.putInt(random.nextInt(25));
					mbb.putInt(random.nextInt(25));
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex1) {
					ex1.printStackTrace();
				}
			}
		} catch (IOException ex2) {
			ex2.printStackTrace();
		}
	}
}
